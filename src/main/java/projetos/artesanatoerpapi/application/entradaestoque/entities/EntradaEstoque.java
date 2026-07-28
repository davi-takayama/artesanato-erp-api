package projetos.artesanatoerpapi.application.entradaestoque.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedida;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "estoque")
public class EntradaEstoque extends BaseOrm {
    @JoinColumn(referencedColumnName = "id", name = "produto_id", nullable = false)
    @ManyToOne
    private Produto produto;

    @Column(name = "quantidade_entrada", nullable = false)
    private Float quantidadeEntrada;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "unidade_medida_id", nullable = false)
private UnidadeMedida unidadeMedida;

    @Column(name = "equivalencia", nullable = false, comment = "Equivalência da unidade de medida em relação à unidade base do produto")
    private Float equivalencia;

    @Column(name = "link_compra")
    private String linkCompra;
}
