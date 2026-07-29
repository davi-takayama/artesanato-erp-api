package projetos.artesanatoerpapi.application.produtoinsumo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.produto.models.ProdutoDto;
import projetos.artesanatoerpapi.genericclasses.BaseDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProdutoInsumoDto extends BaseDto {
    private String produtoPaiId;
    private ProdutoDto produtoFilho;
    private float quantidadeUsada;
}
