package projetos.artesanatoerpapi.application.produto;

import org.springframework.stereotype.Service;
import projetos.artesanatoerpapi.application.categoriaproduto.CategoriaProdutoInsumoService;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumo;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.application.produto.models.ProdutoDto;
import projetos.artesanatoerpapi.application.produtoinsumo.ProdutoInsumoService;
import projetos.artesanatoerpapi.application.produtoinsumo.models.ProdutoInsumoDto;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoServiceHelper {
    private final ProdutoInsumoService produtoInsumoService;
    private final CategoriaProdutoInsumoService categoriaProdutoInsumoService;
    private final ProdutoConverter produtoConverter;

    public ProdutoServiceHelper(
            ProdutoInsumoService produtoInsumoService,
            CategoriaProdutoInsumoService categoriaProdutoInsumoService,
            ProdutoConverter produtoConverter) {
        this.produtoInsumoService = produtoInsumoService;
        this.categoriaProdutoInsumoService = categoriaProdutoInsumoService;
        this.produtoConverter = produtoConverter;
    }

    public void prepareForPersist(Produto produto, ProdutoDto produtoDto) {
        float precoCusto = 0;
        for (ProdutoInsumoDto insumo : produtoDto.getInsumoList()) {
            precoCusto += insumo.getQuantidadeUsada() * insumo.getProdutoFilho().getPrecoCusto();
        }

        produto.setPrecoCusto(precoCusto);
        CategoriaProdutoInsumo categoriaProdutoInsumo = categoriaProdutoInsumoService.findOrmById(UUID.fromString(produtoDto.getId()));
        produto.setCategoriaProdutoInsumo(categoriaProdutoInsumo);
    }

    public void linkIngredients(Produto produto, List<Produto> produtosFilhos) {
        produtoInsumoService.linkProdutoPaiWithFilhos(produto, produtosFilhos);
    }

    public void unlinkIngredients(Produto produto) {
        produtoInsumoService.unlinkProdutoPaiFromFilhos(produto);
    }

    public ProdutoDto addIngredientDetails(ProdutoDto produtoDto, UUID produtoId) {
        List<ProdutoInsumoDto> insumoList =
                produtoInsumoService.ormListToDtoList(produtoInsumoService.findByProdutoPaiId(produtoId));
        produtoDto.setInsumoList(insumoList);

        List<ProdutoDto> usadoEmList = produtoInsumoService.findByProdutoFilhoId(produtoId).stream()
                .map(produtoConverter::ormToDto)
                .toList();
        produtoDto.setUsadoEmList(usadoEmList);
        return produtoDto;
    }
}
