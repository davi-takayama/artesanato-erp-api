package projetos.artesanatoerpapi.application.categoriainsumo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.genericclasses.ListedItemDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoriaInsumoListingDto extends ListedItemDto {
    private String nome;
}
