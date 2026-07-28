package projetos.artesanatoerpapi.application.unidademedida;

import org.springframework.stereotype.Component;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedida;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedidaDto;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedidaListingDto;
import projetos.artesanatoerpapi.genericclasses.ConverterInterface;

import java.util.List;
import java.util.UUID;

@Component
public class UnidadeMedidaConverter implements ConverterInterface<UnidadeMedida, UnidadeMedidaDto, UnidadeMedidaListingDto> {
    @Override
    public UnidadeMedida dtoToOrm(UnidadeMedidaDto dto, UnidadeMedida orm) {
        if (dto.getId() != null)
            orm.setId(UUID.fromString(dto.getId()));
        orm.setSigla(dto.getSigla());
        orm.setNome(dto.getNome());
        return orm;
    }

    @Override
    public UnidadeMedida dtoToOrm(UnidadeMedidaDto dto) {
        return dtoToOrm(dto, new UnidadeMedida());
    }

    @Override
    public UnidadeMedidaDto ormToDto(UnidadeMedida orm, UnidadeMedidaDto dto) {
        dto.setId(orm.getId().toString());
        dto.setSigla(orm.getSigla());
        dto.setNome(orm.getNome());
        return dto;
    }

    @Override
    public UnidadeMedidaDto ormToDto(UnidadeMedida orm) {
        return ormToDto(orm, new UnidadeMedidaDto());
    }

    @Override
    public UnidadeMedidaListingDto ormToListedItem(UnidadeMedida orm) {
        UnidadeMedidaListingDto dto = new UnidadeMedidaListingDto();
        dto.setId(orm.getId().toString());
        dto.setSigla(orm.getSigla());
        dto.setNome(orm.getNome());
        return dto;
    }

    @Override
    public List<UnidadeMedida> dtoListToOrmList(List<UnidadeMedidaDto> unidadeMedidaDtos) {
        if (unidadeMedidaDtos == null  || unidadeMedidaDtos.isEmpty()) return List.of();
        return unidadeMedidaDtos.stream().map(this::dtoToOrm).toList();
    }

    @Override
    public List<UnidadeMedidaDto> ormListToDtoList(List<UnidadeMedida> unidadeMedidas) {
        if  (unidadeMedidas == null) return List.of();
        return unidadeMedidas.stream().map(this::ormToDto).toList();
    }

    @Override
    public List<UnidadeMedidaListingDto> ormListToListedItemm(List<UnidadeMedida> unidadeMedidas) {
        if  (unidadeMedidas == null) return List.of();
        return unidadeMedidas.stream().map(this::ormToListedItem).toList();
    }
}
