package projetos.artesanatoerpapi.application.entradaestoque;

import org.springframework.stereotype.Service;
import projetos.artesanatoerpapi.application.entradaestoque.entities.EntradaEstoque;
import projetos.artesanatoerpapi.application.entradaestoque.entities.EntradaEstoqueDto;
import projetos.artesanatoerpapi.application.entradaestoque.entities.EntradaEstoqueListingDto;
import projetos.artesanatoerpapi.application.produto.ProdutoService;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.application.unidademedida.UnidadeMedidaService;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedida;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;
import projetos.artesanatoerpapi.repositories.EntradaEstoqueRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EntradaEstoqueService extends GenericService<EntradaEstoque, EntradaEstoqueDto, EntradaEstoqueListingDto> {
    private final UnidadeMedidaService unidadeMedidaService;
    private final ProdutoService produtoService;
    private final EntradaEstoqueRepository entradaEstoqueRepository;

    public EntradaEstoqueService(EntradaEstooqueConverter entradaEstooqueConverter, UnidadeMedidaService unidadeMedidaService, ProdutoService produtoService, EntradaEstoqueRepository entradaEstoqueRepository) {
        super.entityClass = EntradaEstoque.class;
        super.converter = entradaEstooqueConverter;
        this.entradaEstoqueRepository = entradaEstoqueRepository;
        super.repository = entradaEstoqueRepository;
        this.unidadeMedidaService = unidadeMedidaService;
        this.produtoService = produtoService;
    }

    public ApiResponseDto<EntradaEstoqueDto> create(EntradaEstoqueDto entradaEstoqueDto) {
        return super.create(entradaEstoqueDto, entradaEstoque -> {
            getEstoqueRelations(entradaEstoqueDto, entradaEstoque);
            return null;
        }, null);
    }

    public ApiResponseDto<EntradaEstoqueDto> update(EntradaEstoqueDto entradaEstoqueDto) {
        return super.update(entradaEstoqueDto, entradaEstoque -> {
            getEstoqueRelations(entradaEstoqueDto, entradaEstoque);
            return null;
        }, null);
    }

    private void getEstoqueRelations(EntradaEstoqueDto entradaEstoqueDto, EntradaEstoque entradaEstoque) {
        UnidadeMedida unidademedida = unidadeMedidaService.findOrmById(UUID.fromString(entradaEstoqueDto.getUnidadeMedida().getId()));
        Produto produto = produtoService.findOrmById(UUID.fromString((entradaEstoqueDto.getIdProduto())));
        entradaEstoque.setUnidadeMedida(unidademedida);
        entradaEstoque.setProduto(produto);
    }

    public List<EntradaEstoque> getAllByProdutoId(UUID produtoId) {
        return entradaEstoqueRepository.findAllByProduto_Id(produtoId);
    }
}
