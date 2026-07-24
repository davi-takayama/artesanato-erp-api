package projetos.artesanatoerpapi.application.categoriaevento.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "categoria_evento")
public class CategoriaEvento extends BaseOrm {
    private String nome;
}
