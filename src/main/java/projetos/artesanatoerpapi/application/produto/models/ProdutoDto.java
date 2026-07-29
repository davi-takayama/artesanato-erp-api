package projetos.artesanatoerpapi.application.produto.models;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoDto;
import projetos.artesanatoerpapi.application.entradaestoque.entities.EntradaEstoqueDto;
import projetos.artesanatoerpapi.application.produtoinsumo.models.ProdutoInsumoDto;
import projetos.artesanatoerpapi.genericclasses.BaseDto;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProdutoDto extends BaseDto {
    @Column(nullable = false)
    private String nome;
    private String imagemmBase64;
    private Float precoVenda;
    private Float precoCusto;
    private CategoriaProdutoDto categoriaProduto;
    private Integer produtoTipo;
    private Float quantidadeInicial;
    private Float custoInsumos;

    private List<EntradaEstoqueDto> entradaEstoqueList;
    private List<ProdutoInsumoDto> insumoList;
    private List<ProdutoDto> usadoEmList;
}
