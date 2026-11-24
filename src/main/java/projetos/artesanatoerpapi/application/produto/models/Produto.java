package projetos.artesanatoerpapi.application.produto.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumo;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "produto")
public class Produto extends BaseOrm {
    @Column(nullable = false)
    private String nome;
    @Column(name = "preco_venda")
    private Float precoVenda;
    @Column(name = "preco_custo", nullable = false)
    private Float precoCusto;
    @Column(name = "quantidade_inicial", nullable = false)
    private Float quantidadeInicial;

    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ManyToOne
    private CategoriaProdutoInsumo categoriaProdutoInsumo;

    public void setPrecoCusto(float value) {
        this.precoCusto = value;
    }
}
