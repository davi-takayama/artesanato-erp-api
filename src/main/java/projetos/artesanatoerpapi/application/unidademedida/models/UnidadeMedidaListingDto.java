package projetos.artesanatoerpapi.application.unidademedida.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.genericclasses.ListedItemDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class UnidadeMedidaListingDto extends ListedItemDto {
    private String nome;
    private String sigla;
}
