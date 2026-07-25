package projetos.artesanatoerpapi.application.produto.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProduto;
import projetos.artesanatoerpapi.application.produto.enumeration.ProdutoTipo;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "produto")
public class Produto extends BaseOrm {
    @Column(nullable = false)
    private String nome;
    @Column(name = "id_imagem")
    private String idImagem;
    @Transient
    private String imagemmBase64;
    @Column(name = "preco_venda")
    private Float precoVenda;
    @Column(name = "preco_custo")
    private Float precoCusto;
    @Column(name = "produto_tipo",  nullable = false)
    private ProdutoTipo produtoTipo;

    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ManyToOne
    private CategoriaProduto categoriaProduto;
}
