package projetos.artesanatoerpapi.application.entradaestoque.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedidaDto;
import projetos.artesanatoerpapi.genericclasses.ListedItemDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class EntradaEstoqueListingDto extends ListedItemDto {
    private Float quantidadeEntrada;
    private UnidadeMedidaDto unidadeMedida;
    private Float equivalencia;
    private String linkCompra;
    private String idProduto;
}
