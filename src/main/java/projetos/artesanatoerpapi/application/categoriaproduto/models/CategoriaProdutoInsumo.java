package projetos.artesanatoerpapi.application.categoriaproduto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "categoria_produto_insumo")
public class CategoriaProdutoInsumo extends BaseOrm {
    private String nome;
}
