package projetos.artesanatoerpapi.application.produto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProduto;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "produto")
public class Produto extends BaseOrm {
    @Column(nullable = false)
    private String nome;
    @Column
    private String idImagem;
    @Column
    private Float precoVenda;

    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ManyToOne
    private CategoriaProduto categoriaProduto;

    @Transient
    private Float precoCusto;
    @Transient
    private Float margemLucro;
}
