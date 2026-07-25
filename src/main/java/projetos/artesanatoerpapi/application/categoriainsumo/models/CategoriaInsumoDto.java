package projetos.artesanatoerpapi.application.categoriainsumo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.genericclasses.BaseDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoriaInsumoDto extends BaseDto {
    private String nome;
}
