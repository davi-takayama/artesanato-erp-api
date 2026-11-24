package projetos.artesanatoerpapi.application.movimentacaoestoque.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedidaDto;
import projetos.artesanatoerpapi.genericclasses.BaseDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class MovimentacaoEstoqueDto extends BaseDto {
    private Float quantidadeEntrada;
    private UnidadeMedidaDto unidadeMedida;
    private String linkCompra;
    private String idProduto;
}
