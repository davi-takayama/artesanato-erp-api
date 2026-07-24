package projetos.artesanatoerpapi.application.categoriainsumo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "categoria_insumo")
@Data
public class CategoriaInsumo extends BaseOrm {
    private String nome;
}
