package projetos.artesanatoerpapi.application.evento;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.categoriaevento.entities.CategoriaEvento;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "evento")
public class Evento extends BaseOrm {
    private String nome;
    private Float precoEntrada;
    private LocalDate dataEvento;

    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ManyToOne
    private CategoriaEvento categoria;
}
