package projetos.artesanatoerpapi.application.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.artesanatoerpapi.application.categoriaproduto.CategoriaProdutoService;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProduto;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.application.produto.models.ProdutoDto;
import projetos.artesanatoerpapi.application.produto.models.ProdutoListingDto;
import projetos.artesanatoerpapi.application.produtoproduto.ProdutoProdutoService;
import projetos.artesanatoerpapi.repositories.ProdutoRepository;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService extends GenericService<Produto, ProdutoDto, ProdutoListingDto> {
    private final ProdutoProdutoService produtoProdutoService;
    private final CategoriaProdutoService categoriaProdutoService;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, ProdutoConverter produtoConverter, ProdutoProdutoService produtoProdutoService, CategoriaProdutoService categoriaProdutoService) {
        super.entityClass = Produto.class;
        super.repository = produtoRepository;
        super.converter = produtoConverter;
        this.produtoProdutoService = produtoProdutoService;
        this.categoriaProdutoService = categoriaProdutoService;
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
        produtoProdutoService.linkProdutoPaiWithFilhos(produto, produtosFilhos);
    }

    private void beforePersist(Produto produto, ProdutoDto produtoDto) {
        CategoriaProduto categoriaProduto = categoriaProdutoService.retrieveOrmById(UUID.fromString(produtoDto.getId()));
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
            produtoProdutoService.unlinkProdutoPaiFromFilhos(produto);
            return true;
        });
    }

    public ApiResponseDto<ProdutoDto> findById(UUID id) {
        return super.retrieveById(id, produtoDto -> {
            List<ProdutoDto> insumoList = produtoProdutoService.findByProdutoPaiId(id).stream().map(produto -> converter.ormToDto(produto)).toList();
            produtoDto.setInsumoList(insumoList);

            List<ProdutoDto> usadoEmList = produtoProdutoService.findByProdutoFilhoId(id).stream().map(produto -> converter.ormToDto(produto)).toList();
            produtoDto.setUsadoEmList(usadoEmList);
            return null;
        });
    }

    public ApiResponseDto<List<ProdutoListingDto>> findAll() {
        return super.retrieveAll();
    }
}
