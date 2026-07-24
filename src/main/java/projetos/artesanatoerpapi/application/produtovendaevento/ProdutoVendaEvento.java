package projetos.artesanatoerpapi.application.produtovendaevento;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.produto.Produto;
import projetos.artesanatoerpapi.application.vendaevento.VendaEvento;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "produto_venda_evento")
public class ProdutoVendaEvento extends BaseOrm {
    @JoinColumn(referencedColumnName = "id", name = "produto_id")
    @ManyToOne
    private Produto produto;

    @JoinColumn
    @ManyToOne
    private VendaEvento vendaEvento;
}
