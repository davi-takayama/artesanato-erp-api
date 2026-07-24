package projetos.artesanatoerpapi.application.localevento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@Data
@Entity
@Table(name = "local_evento")
public class LocalEvento extends BaseOrm {
    @Column
    private String nome;
}
