package projetos.artesanatoerpapi.application.produtoinsumo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "produto_insumo",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"produto_pai", "produto_filho"}, options = "produto_pai_produto_filho_unique"
                )
        }
)
public class ProdutoInsumo extends BaseOrm {
    @JoinColumn(name = "produto_pai", referencedColumnName = "id")
    @ManyToOne
    private Produto produtoPai;

    @JoinColumn(name = "produto_filho", referencedColumnName = "id")
    @ManyToOne
    private Produto produtoFilho;

    @Column(name = "quantidade_usada", nullable = false)
    private float quantidadeUsada;
}
