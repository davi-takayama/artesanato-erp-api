package projetos.artesanatoerpapi.application.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "produto_produto",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"produto_pai", "produto_filho"})
        }
)
public class ProdutoProduto extends BaseOrm {
    @JoinColumn(name = "produto_pai", referencedColumnName = "id")
    @ManyToOne
    private Produto produtoPai;

    @JoinColumn(name = "produto_filho", referencedColumnName = "id")
    @ManyToOne
    private Produto produtoFilho;
}
