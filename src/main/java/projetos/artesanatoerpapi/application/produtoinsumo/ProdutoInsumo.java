package projetos.artesanatoerpapi.application.produtoinsumo;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.insumo.Insumo;
import projetos.artesanatoerpapi.application.produto.Produto;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "produto_insumo")
public class ProdutoInsumo extends BaseOrm {
    @JoinColumn(referencedColumnName = "id", name = "produto_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @JoinColumn(referencedColumnName = "id", name = "insumo_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Insumo insumo;
}
