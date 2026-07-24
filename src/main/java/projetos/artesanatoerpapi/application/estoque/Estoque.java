package projetos.artesanatoerpapi.application.estoque;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.insumo.Insumo;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "estoque")
public class Estoque extends BaseOrm {
    @JoinColumn(referencedColumnName = "id", name = "insumo_id")
    @ManyToOne
    private Insumo insumo;

    private Float quantidadeAdicionada;
}
