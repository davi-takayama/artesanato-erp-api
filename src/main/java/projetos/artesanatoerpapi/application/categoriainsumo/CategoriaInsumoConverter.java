package projetos.artesanatoerpapi.application.categoriainsumo;

import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumo;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumoDto;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumoListingDto;
import projetos.artesanatoerpapi.genericclasses.ConverterInterface;

import java.util.List;
import java.util.UUID;

public class CategoriaInsumoConverter implements ConverterInterface<CategoriaInsumo, CategoriaInsumoDto, CategoriaInsumoListingDto> {
    @Override
    public CategoriaInsumo dtoToOrm(CategoriaInsumoDto dto, CategoriaInsumo orm) {
        orm.setNome(dto.getNome());
        if (dto.getId() != null) {
            orm.setId(UUID.fromString(dto.getId()));
        }
        return orm;
    }

    @Override
    public CategoriaInsumo dtoToOrm(CategoriaInsumoDto dto) {
        return dtoToOrm(dto, new CategoriaInsumo());
    }

    @Override
    public CategoriaInsumoDto ormToDto(CategoriaInsumo orm, CategoriaInsumoDto dto) {
        dto.setNome(orm.getNome());
        dto.setId(orm.getId().toString());
        return dto;
    }

    @Override
    public CategoriaInsumoDto ormToDto(CategoriaInsumo orm) {
        return ormToDto(orm, new CategoriaInsumoDto());
    }

    @Override
    public CategoriaInsumoListingDto ormToListedItem(CategoriaInsumo orm) {
        CategoriaInsumoListingDto dto = new CategoriaInsumoListingDto();
        dto.setId(orm.getId().toString());
        dto.setNome(orm.getNome());
        return dto;
    }

    @Override
    public List<CategoriaInsumo> dtoListToOrmList(List<CategoriaInsumoDto> categoriaEventoDtos) {
        if (categoriaEventoDtos == null) return List.of();
        return categoriaEventoDtos.stream().map(this::dtoToOrm).toList();
    }

    @Override
    public List<CategoriaInsumoDto> ormListToDtoList(List<CategoriaInsumo> categoriaEventos) {
        if (categoriaEventos == null) return List.of();
        return categoriaEventos.stream().map(this::ormToDto).toList();
    }

    @Override
    public List<CategoriaInsumoListingDto> ormListToListedItemm(List<CategoriaInsumo> categoriaEventos) {
        if (categoriaEventos == null) return List.of();
        return categoriaEventos.stream().map(this::ormToListedItem).toList();
    }
}
