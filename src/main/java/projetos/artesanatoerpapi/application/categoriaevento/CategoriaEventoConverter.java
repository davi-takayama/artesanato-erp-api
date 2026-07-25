package projetos.artesanatoerpapi.application.categoriaevento;

import projetos.artesanatoerpapi.application.categoriaevento.entities.CategoriaEvento;
import projetos.artesanatoerpapi.application.categoriaevento.entities.CategoriaEventoDto;
import projetos.artesanatoerpapi.application.categoriaevento.entities.CategoriaEventoListingDto;
import projetos.artesanatoerpapi.genericclasses.ConverterInterface;

import java.util.List;
import java.util.UUID;

public class CategoriaEventoConverter implements ConverterInterface<CategoriaEvento, CategoriaEventoDto, CategoriaEventoListingDto> {
    @Override
    public CategoriaEvento dtoToOrm(CategoriaEventoDto dto, CategoriaEvento orm) {
        orm.setNome(dto.getNome());
        if (dto.getId() != null) {
            orm.setId(UUID.fromString(dto.getId()));
        }
        return orm;
    }

    @Override
    public CategoriaEvento dtoToOrm(CategoriaEventoDto dto) {
        return dtoToOrm(dto, new CategoriaEvento());
    }

    @Override
    public CategoriaEventoDto ormToDto(CategoriaEvento orm, CategoriaEventoDto dto) {
        dto.setNome(orm.getNome());
        dto.setId(orm.getId().toString());
        return dto;
    }

    @Override
    public CategoriaEventoDto ormToDto(CategoriaEvento orm) {
        return ormToDto(orm, new CategoriaEventoDto());
    }

    @Override
    public CategoriaEventoListingDto ormToListedItem(CategoriaEvento orm) {
        CategoriaEventoListingDto dto = new CategoriaEventoListingDto();
        dto.setId(orm.getId().toString());
        dto.setNome(orm.getNome());
        return dto;
    }

    @Override
    public List<CategoriaEvento> dtoListToOrmList(List<CategoriaEventoDto> categoriaEventoDtos) {
        if (categoriaEventoDtos == null) return List.of();
        return categoriaEventoDtos.stream().map(this::dtoToOrm).toList();
    }

    @Override
    public List<CategoriaEventoDto> ormListToDtoList(List<CategoriaEvento> categoriaEventos) {
        if (categoriaEventos == null) return List.of();
        return categoriaEventos.stream().map(this::ormToDto).toList();
    }

    @Override
    public List<CategoriaEventoListingDto> ormListToListedItemm(List<CategoriaEvento> categoriaEventos) {
        if (categoriaEventos == null) return List.of();
        return categoriaEventos.stream().map(this::ormToListedItem).toList();
    }
}
