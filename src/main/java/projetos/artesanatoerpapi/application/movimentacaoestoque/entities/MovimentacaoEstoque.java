package projetos.artesanatoerpapi.application.movimentacaoestoque.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedida;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "movimentacao_estoque")
public class MovimentacaoEstoque extends BaseOrm {
    @JoinColumn(referencedColumnName = "id", name = "produto_id", nullable = false)
    @ManyToOne
    private Produto produto;

    @Column(name = "quantidade_movimentada", nullable = false)
    private Float quantidadeMovimentada;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "unidade_medida_id", nullable = false)
    private UnidadeMedida unidadeMedida;

    @Column(name = "link_compra")
    private String linkCompra;
}
