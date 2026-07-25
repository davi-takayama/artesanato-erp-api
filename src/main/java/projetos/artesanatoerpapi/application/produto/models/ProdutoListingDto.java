package projetos.artesanatoerpapi.application.produto.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoDto;
import projetos.artesanatoerpapi.genericclasses.ListedItemDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProdutoListingDto extends ListedItemDto {
    private String nome;
    private String imagemmBase64;
    private Float precoVenda;
    private CategoriaProdutoDto categoriaProduto;
    private Integer produtoTipo;
    private int qtdEmEstoque;
}
