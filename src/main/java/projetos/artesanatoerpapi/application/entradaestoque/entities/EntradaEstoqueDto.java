package projetos.artesanatoerpapi.application.entradaestoque.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedidaDto;
import projetos.artesanatoerpapi.genericclasses.BaseDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class EntradaEstoqueDto extends BaseDto {
    private Float quantidadeEntrada;
    private UnidadeMedidaDto unidadeMedida;
}
