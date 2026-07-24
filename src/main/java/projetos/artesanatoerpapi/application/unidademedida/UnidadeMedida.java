package projetos.artesanatoerpapi.application.unidademedida;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "unidade_medida")
public class UnidadeMedida extends BaseOrm {
    private String nome;
    private String sigla;
}
