package projetos.artesanatoerpapi.application.insumo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumo;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "insumo")
@Data
public class Insumo extends BaseOrm {
    private String nome;
    private String descricao;
    private String linkCompra;
    private Float precoMedioCompra;

    @JoinColumn(referencedColumnName = "id", name = "categoria_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoriaInsumo categoria;
}
