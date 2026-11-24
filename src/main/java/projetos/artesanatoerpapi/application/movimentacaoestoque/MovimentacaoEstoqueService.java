package projetos.artesanatoerpapi.application.movimentacaoestoque;

import org.springframework.stereotype.Service;
import projetos.artesanatoerpapi.application.movimentacaoestoque.entities.MovimentacaoEstoque;
import projetos.artesanatoerpapi.application.movimentacaoestoque.entities.MovimentacaoEstoqueDto;
import projetos.artesanatoerpapi.application.movimentacaoestoque.entities.MovimentacaoEstoqueListingDto;
import projetos.artesanatoerpapi.application.produto.ProdutoService;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.application.unidademedida.UnidadeMedidaService;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedida;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;
import projetos.artesanatoerpapi.repositories.MovimentacaoEstoqueRepository;

import java.util.List;
import java.util.UUID;

@Service
public class MovimentacaoEstoqueService extends GenericService<MovimentacaoEstoque, MovimentacaoEstoqueDto, MovimentacaoEstoqueListingDto> {
    private final UnidadeMedidaService unidadeMedidaService;
    private final MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;
    private final ProdutoService produtoService;

    public MovimentacaoEstoqueService(MovimentacaoEstooqueConverter movimentacaoEstooqueConverter, UnidadeMedidaService unidadeMedidaService, MovimentacaoEstoqueRepository movimentacaoEstoqueRepository, ProdutoService produtoService) {
        super.entityClass = MovimentacaoEstoque.class;
        super.converter = movimentacaoEstooqueConverter;
        this.movimentacaoEstoqueRepository = movimentacaoEstoqueRepository;
        super.repository = movimentacaoEstoqueRepository;
        this.unidadeMedidaService = unidadeMedidaService;
        this.produtoService = produtoService;
    }

    public ApiResponseDto<MovimentacaoEstoqueDto> create(MovimentacaoEstoqueDto movimentacaoEstoqueDto) {
        return super.create(movimentacaoEstoqueDto, movimentacaoEstoque -> {
            getEstoqueRelations(movimentacaoEstoqueDto, movimentacaoEstoque);
            return null;
        }, null);
    }

    public ApiResponseDto<MovimentacaoEstoqueDto> update(MovimentacaoEstoqueDto movimentacaoEstoqueDto) {
        return super.update(movimentacaoEstoqueDto, movimentacaoEstoque -> {
            getEstoqueRelations(movimentacaoEstoqueDto, movimentacaoEstoque);
            return null;
        }, null);
    }

    private void getEstoqueRelations(MovimentacaoEstoqueDto movimentacaoEstoqueDto, MovimentacaoEstoque movimentacaoEstoque) {
        UnidadeMedida unidademedida = unidadeMedidaService.findOrmById(UUID.fromString(movimentacaoEstoqueDto.getUnidadeMedida().getId()));
        Produto produto = produtoService.findOrmById(UUID.fromString(movimentacaoEstoqueDto.getIdProduto()));
        movimentacaoEstoque.setProduto(produto);
    }

    public List<MovimentacaoEstoqueDto> getAllByProdutoId(UUID produtoId) {
        return ormListToDtoList(movimentacaoEstoqueRepository.findAllByProduto_Id(produtoId));
    }

}
