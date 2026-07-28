package projetos.artesanatoerpapi.application.unidademedida.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.genericclasses.BaseDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class UnidadeMedidaDto extends BaseDto {
    private String nome;
    private String sigla;
}
