package projetos.artesanatoerpapi.application.vendaevento;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.application.evento.Evento;
import projetos.artesanatoerpapi.application.produto.Produto;
import projetos.artesanatoerpapi.enumeration.FormaPagamentoEnum;
import projetos.artesanatoerpapi.genericclasses.BaseOrm;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "venda_evento")
public class VendaEvento extends BaseOrm {
    @JoinColumn(referencedColumnName = "id", name = "evento_id")
    @ManyToOne
    private Evento evento;

    @JoinColumn(referencedColumnName = "id", name = "produto_id")
    @ManyToOne
    private Produto produto;

    @Enumerated(EnumType.ORDINAL)
    private FormaPagamentoEnum formaPagamento;
}
