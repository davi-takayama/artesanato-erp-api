package projetos.artesanatoerpapi.application.categoriaproduto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "categoria_produto")
public class CategoriaProduto extends BaseOrm {
    private String nome;
}
