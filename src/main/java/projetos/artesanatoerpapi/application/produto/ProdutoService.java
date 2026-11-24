package projetos.artesanatoerpapi.application.produto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.application.produto.models.ProdutoDto;
import projetos.artesanatoerpapi.application.produto.models.ProdutoListingDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;
import projetos.artesanatoerpapi.repositories.ProdutoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService extends GenericService<Produto, ProdutoDto, ProdutoListingDto> {
    private final ProdutoServiceHelper produtoServiceHelper;

    public ProdutoService(
            ProdutoRepository produtoRepository,
            ProdutoConverter produtoConverter,
            ProdutoServiceHelper produtoServiceHelper) {
        super.entityClass = Produto.class;
        super.repository = produtoRepository;
        super.converter = produtoConverter;
        this.produtoServiceHelper = produtoServiceHelper;
    }

    @Transactional
    public ApiResponseDto<ProdutoDto> create(ProdutoDto produtoDto) {
        return super.create(produtoDto, produto -> {
            produtoServiceHelper.prepareForPersist(produto, produtoDto);
            return null;
        }, produto -> {
            linkIngredients(produtoDto, produto);
            return null;
        });
    }

    @Transactional
    public ApiResponseDto<ProdutoDto> update(ProdutoDto produtoDto) {
        return super.update(produtoDto, produto -> {
            produtoServiceHelper.prepareForPersist(produto, produtoDto);
            return null;
        }, produto -> {
            linkIngredients(produtoDto, produto);
            return null;
        });
    }

    @Transactional
    public ApiResponseDto<String> delete(UUID id) {
        return super.delete(id, produto -> {
            produtoServiceHelper.unlinkIngredients(produto);
            return true;
        });
    }

    public ApiResponseDto<ProdutoDto> findById(UUID id) {
        return super.retrieveById(id, produtoDto -> produtoServiceHelper.addIngredientDetails(produtoDto, id));
    }

    public ApiResponseDto<List<ProdutoListingDto>> findAll() {
        return super.retrieveAll();
    }

    private void linkIngredients(ProdutoDto produtoDto, Produto produto) {
        List<UUID> produtoIds = produtoDto.getInsumoList().stream()
                .map(insumo -> UUID.fromString(insumo.getId()))
                .toList();
        List<Produto> produtosFilhos = repository.findAllById(produtoIds);
        produtoServiceHelper.linkIngredients(produto, produtosFilhos);
    }
}
