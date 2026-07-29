package projetos.artesanatoerpapi.application.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.artesanatoerpapi.application.categoriaproduto.CategoriaProdutoService;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProduto;
import projetos.artesanatoerpapi.application.entradaestoque.EntradaEstoqueService;
import projetos.artesanatoerpapi.application.entradaestoque.entities.EntradaEstoqueDto;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.application.produto.models.ProdutoDto;
import projetos.artesanatoerpapi.application.produto.models.ProdutoListingDto;
import projetos.artesanatoerpapi.application.produtoinsumo.ProdutoInsumoService;
import projetos.artesanatoerpapi.application.produtoinsumo.models.ProdutoInsumoDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;
import projetos.artesanatoerpapi.repositories.ProdutoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService extends GenericService<Produto, ProdutoDto, ProdutoListingDto> {
    private final ProdutoInsumoService produtoInsumoService;
    private final CategoriaProdutoService categoriaProdutoService;
    private final EntradaEstoqueService entradaEstoqueService;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, ProdutoConverter produtoConverter, ProdutoInsumoService produtoInsumoService, CategoriaProdutoService categoriaProdutoService, EntradaEstoqueService entradaEstoqueService) {
        super.entityClass = Produto.class;
        super.repository = produtoRepository;
        super.converter = produtoConverter;
        this.produtoInsumoService = produtoInsumoService;
        this.categoriaProdutoService = categoriaProdutoService;
        this.entradaEstoqueService = entradaEstoqueService;
    }

    @Transactional
    public ApiResponseDto<ProdutoDto> create(ProdutoDto produtoDto) {
        return super.create(produtoDto, produto -> {
            beforePersist(produto, produtoDto);
            return null;
        }, produto -> {
            afterPersist(produtoDto, produto);
            return null;
        });
    }

    private void afterPersist(ProdutoDto produtoDto, Produto produto) {
        List<UUID> produtoIdList = produtoDto.getInsumoList().stream().map(p -> UUID.fromString(p.getId())).toList();
        List<Produto> produtosFilhos = repository.findAllById(produtoIdList);
        produtoInsumoService.linkProdutoPaiWithFilhos(produto, produtosFilhos);
    }

    private float getPrecoCusto(ProdutoDto produtoDto) {
        float precoCusto = 0;
        for (ProdutoInsumoDto insumo : produtoDto.getInsumoList()) {
            precoCusto += insumo.getQuantidadeUsada() * insumo.getProdutoFilho().getPrecoCusto();
        }
        return precoCusto;
    }

    private void beforePersist(Produto produto, ProdutoDto produtoDto) {
        produto.setPrecoCusto(getPrecoCusto(produtoDto));
        CategoriaProduto categoriaProduto = categoriaProdutoService.findOrmById(UUID.fromString(produtoDto.getId()));
        produto.setCategoriaProduto(categoriaProduto);
    }

    @Transactional
    public ApiResponseDto<ProdutoDto> update(ProdutoDto produtoDto) {
        return super.update(produtoDto, produto -> {
            beforePersist(produto, produtoDto);
            return null;
        }, produto -> {
            afterPersist(produtoDto, produto);
            return null;
        });
    }

    @Transactional
    public ApiResponseDto<String> delete(UUID id) {
        return super.delete(id, produto -> {
            produtoInsumoService.unlinkProdutoPaiFromFilhos(produto);
            return true;
        });
    }

    public ApiResponseDto<ProdutoDto> findById(UUID id) {
        return super.retrieveById(id, produtoDto -> {
            List<ProdutoInsumoDto> insumoList = produtoInsumoService.ormListToDtoList(produtoInsumoService.findByProdutoPaiId(id));
            produtoDto.setInsumoList(insumoList);

            List<ProdutoDto> usadoEmList = produtoInsumoService.findByProdutoFilhoId(id).stream().map(produto -> converter.ormToDto(produto)).toList();
            produtoDto.setUsadoEmList(usadoEmList);

            List<EntradaEstoqueDto> entradaEstoqueList = entradaEstoqueService.getAllByProdutoId(id);
            produtoDto.setEntradaEstoqueList(entradaEstoqueList);

            return null;
        });
    }

    public ApiResponseDto<List<ProdutoListingDto>> findAll() {
        return super.retrieveAll();
    }
}
