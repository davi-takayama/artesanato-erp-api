package projetos.artesanatoerpapi.application.entradaestoque;

import org.springframework.stereotype.Component;
import projetos.artesanatoerpapi.application.entradaestoque.entities.EntradaEstoque;
import projetos.artesanatoerpapi.application.entradaestoque.entities.EntradaEstoqueDto;
import projetos.artesanatoerpapi.application.entradaestoque.entities.EntradaEstoqueListingDto;
import projetos.artesanatoerpapi.application.unidademedida.UnidadeMedidaConverter;
import projetos.artesanatoerpapi.genericclasses.ConverterInterface;

import java.util.List;
import java.util.UUID;

@Component
public class EntradaEstooqueConverter implements ConverterInterface<EntradaEstoque, EntradaEstoqueDto, EntradaEstoqueListingDto> {
    private final UnidadeMedidaConverter unidadeMedidaConverter;

    public EntradaEstooqueConverter(UnidadeMedidaConverter unidadeMedidaConverter) {
        this.unidadeMedidaConverter = unidadeMedidaConverter;
    }

    @Override
    public EntradaEstoque dtoToOrm(EntradaEstoqueDto dto, EntradaEstoque orm) {
        if (dto.getId() != null)
            orm.setId(UUID.fromString(dto.getId()));
        orm.setQuantidadeEntrada(dto.getQuantidadeEntrada());
        orm.setEquivalencia(dto.getEquivalencia());
        orm.setLinkCompra(dto.getLinkCompra());
        return orm;
    }

    @Override
    public EntradaEstoque dtoToOrm(EntradaEstoqueDto dto) {
        return dtoToOrm(dto, new EntradaEstoque());
    }

    @Override
    public EntradaEstoqueDto ormToDto(EntradaEstoque orm, EntradaEstoqueDto dto) {
        dto.setId(orm.getId().toString());
        dto.setQuantidadeEntrada(orm.getQuantidadeEntrada());
        dto.setEquivalencia(orm.getEquivalencia());
        dto.setLinkCompra(orm.getLinkCompra());
        dto.setIdProduto(orm.getProduto().getId().toString());
        dto.setUnidadeMedida(unidadeMedidaConverter.ormToDto(orm.getUnidadeMedida()));
        return dto;
    }

    @Override
    public EntradaEstoqueDto ormToDto(EntradaEstoque orm) {
        return ormToDto(orm, new EntradaEstoqueDto());
    }

    @Override
    public EntradaEstoqueListingDto ormToListedItem(EntradaEstoque orm) {
        EntradaEstoqueListingDto dto = new EntradaEstoqueListingDto();
        dto.setId(orm.getId().toString());
        dto.setQuantidadeEntrada(orm.getQuantidadeEntrada());
        dto.setEquivalencia(orm.getEquivalencia());
        dto.setLinkCompra(orm.getLinkCompra());
        dto.setIdProduto(orm.getProduto().getId().toString());
        dto.setUnidadeMedida(unidadeMedidaConverter.ormToDto(orm.getUnidadeMedida()));
        return dto;
    }

    @Override
    public List<EntradaEstoque> dtoListToOrmList(List<EntradaEstoqueDto> entradaEstoqueDtos) {
        if (entradaEstoqueDtos == null || entradaEstoqueDtos.isEmpty()) return List.of();
        return entradaEstoqueDtos.stream().map(this::dtoToOrm).toList();
    }

    @Override
    public List<EntradaEstoqueDto> ormListToDtoList(List<EntradaEstoque> entradaEstoques) {
        if (entradaEstoques == null || entradaEstoques.isEmpty()) return List.of();
        return entradaEstoques.stream().map(this::ormToDto).toList();
    }

    @Override
    public List<EntradaEstoqueListingDto> ormListToListedItemm(List<EntradaEstoque> entradaEstoques) {
        if (entradaEstoques == null || entradaEstoques.isEmpty()) return List.of();
        return entradaEstoques.stream().map(this::ormToListedItem).toList();
    }
}
