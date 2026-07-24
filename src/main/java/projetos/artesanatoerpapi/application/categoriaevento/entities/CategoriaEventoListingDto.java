package projetos.artesanatoerpapi.application.categoriaevento.entities;

import lombok.Data;
import projetos.artesanatoerpapi.genericclasses.ListedItemDto;

@Data
public class CategoriaEventoListingDto extends ListedItemDto {
    private String nome;
}
