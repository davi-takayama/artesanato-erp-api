package projetos.artesanatoerpapi.application.movimentacaoestoque.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedidaDto;
import projetos.artesanatoerpapi.genericclasses.ListedItemDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class MovimentacaoEstoqueListingDto extends ListedItemDto {
    private Float quantidadeEntrada;
    private UnidadeMedidaDto unidadeMedida;
    private String linkCompra;
    private String idProduto;
}
