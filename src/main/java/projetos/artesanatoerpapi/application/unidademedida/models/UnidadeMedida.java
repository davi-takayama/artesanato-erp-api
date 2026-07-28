package projetos.artesanatoerpapi.application.unidademedida.models;

import jakarta.persistence.Column;
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
    @Column
    private String nome;
    @Column
    private String sigla;
}
