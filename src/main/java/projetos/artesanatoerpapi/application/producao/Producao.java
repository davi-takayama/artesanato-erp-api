package projetos.artesanatoerpapi.application.producao;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "producao")
public class Producao extends BaseOrm {
    @JoinColumn(referencedColumnName = "id", name = "produto_id", nullable = false)
    @ManyToOne
    private Produto produto;

    @Column(name = "quantidade_producao", nullable = false)
    private float quantidadeProducao;

    @Column(name = "data_producao", nullable = false)
    private LocalDate dataProducao;
}
