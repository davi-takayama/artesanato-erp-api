package projetos.artesanatoerpapi.application.produto.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumoDto;
import projetos.artesanatoerpapi.genericclasses.ListedItemDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProdutoListingDto extends ListedItemDto {
    private String nome;
    private String imagemmBase64;
    private Float precoVenda;
    private CategoriaProdutoInsumoDto categoriaProduto;
    private Integer produtoTipo;
    private float qtdEmEstoque;
}
