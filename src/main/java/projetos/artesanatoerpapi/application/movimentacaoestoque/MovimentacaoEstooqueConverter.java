package projetos.artesanatoerpapi.application.movimentacaoestoque;

import org.springframework.stereotype.Component;
import projetos.artesanatoerpapi.application.movimentacaoestoque.entities.MovimentacaoEstoque;
import projetos.artesanatoerpapi.application.movimentacaoestoque.entities.MovimentacaoEstoqueDto;
import projetos.artesanatoerpapi.application.movimentacaoestoque.entities.MovimentacaoEstoqueListingDto;
import projetos.artesanatoerpapi.application.unidademedida.UnidadeMedidaConverter;
import projetos.artesanatoerpapi.genericclasses.ConverterInterface;

import java.util.List;
import java.util.UUID;

@Component
public class MovimentacaoEstooqueConverter implements ConverterInterface<MovimentacaoEstoque, MovimentacaoEstoqueDto, MovimentacaoEstoqueListingDto> {
    private final UnidadeMedidaConverter unidadeMedidaConverter;

    public MovimentacaoEstooqueConverter(UnidadeMedidaConverter unidadeMedidaConverter) {
        this.unidadeMedidaConverter = unidadeMedidaConverter;
    }

    @Override
    public MovimentacaoEstoque dtoToOrm(MovimentacaoEstoqueDto dto, MovimentacaoEstoque orm) {
        if (dto.getId() != null)
            orm.setId(UUID.fromString(dto.getId()));
        orm.setQuantidadeMovimentada(dto.getQuantidadeEntrada());
        orm.setLinkCompra(dto.getLinkCompra());
        return orm;
    }

    @Override
    public MovimentacaoEstoque dtoToOrm(MovimentacaoEstoqueDto dto) {
        return dtoToOrm(dto, new MovimentacaoEstoque());
    }

    @Override
    public MovimentacaoEstoqueDto ormToDto(MovimentacaoEstoque orm, MovimentacaoEstoqueDto dto) {
        dto.setId(orm.getId().toString());
        dto.setQuantidadeEntrada(orm.getQuantidadeMovimentada());
        dto.setLinkCompra(orm.getLinkCompra());
        dto.setIdProduto(orm.getProduto().getId().toString());
        dto.setUnidadeMedida(unidadeMedidaConverter.ormToDto(orm.getUnidadeMedida()));
        return dto;
    }

    @Override
    public MovimentacaoEstoqueDto ormToDto(MovimentacaoEstoque orm) {
        return ormToDto(orm, new MovimentacaoEstoqueDto());
    }

    @Override
    public MovimentacaoEstoqueListingDto ormToListedItem(MovimentacaoEstoque orm) {
        MovimentacaoEstoqueListingDto dto = new MovimentacaoEstoqueListingDto();
        dto.setId(orm.getId().toString());
        dto.setQuantidadeEntrada(orm.getQuantidadeMovimentada());
        dto.setLinkCompra(orm.getLinkCompra());
        dto.setIdProduto(orm.getProduto().getId().toString());
        dto.setUnidadeMedida(unidadeMedidaConverter.ormToDto(orm.getUnidadeMedida()));
        return dto;
    }

    @Override
    public List<MovimentacaoEstoque> dtoListToOrmList(List<MovimentacaoEstoqueDto> movimentacaoEstoqueDtos) {
        if (movimentacaoEstoqueDtos == null || movimentacaoEstoqueDtos.isEmpty()) return List.of();
        return movimentacaoEstoqueDtos.stream().map(this::dtoToOrm).toList();
    }

    @Override
    public List<MovimentacaoEstoqueDto> ormListToDtoList(List<MovimentacaoEstoque> movimentacaoEstoques) {
        if (movimentacaoEstoques == null || movimentacaoEstoques.isEmpty()) return List.of();
        return movimentacaoEstoques.stream().map(this::ormToDto).toList();
    }

    @Override
    public List<MovimentacaoEstoqueListingDto> ormListToListedItemm(List<MovimentacaoEstoque> movimentacaoEstoques) {
        if (movimentacaoEstoques == null || movimentacaoEstoques.isEmpty()) return List.of();
        return movimentacaoEstoques.stream().map(this::ormToListedItem).toList();
    }
}
