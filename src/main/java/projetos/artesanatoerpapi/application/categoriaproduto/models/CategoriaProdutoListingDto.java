package projetos.artesanatoerpapi.application.categoriaproduto.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.genericclasses.ListedItemDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoriaProdutoListingDto extends ListedItemDto {
    private String nome;
}
