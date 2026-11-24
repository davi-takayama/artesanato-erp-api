package projetos.artesanatoerpapi.application.categoriaproduto;

import org.springframework.stereotype.Component;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumo;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumoDto;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumoListingDto;
import projetos.artesanatoerpapi.genericclasses.ConverterInterface;

import java.util.List;
import java.util.UUID;

@Component
public class CategoriaProdutoInsumoConverter implements ConverterInterface<CategoriaProdutoInsumo, CategoriaProdutoInsumoDto, CategoriaProdutoInsumoListingDto> {
    @Override
    public CategoriaProdutoInsumo dtoToOrm(CategoriaProdutoInsumoDto dto, CategoriaProdutoInsumo orm) {
        orm.setNome(dto.getNome());
        if (dto.getId() != null) {
            orm.setId(UUID.fromString(dto.getId()));
        }
        return orm;
    }

    @Override
    public CategoriaProdutoInsumo dtoToOrm(CategoriaProdutoInsumoDto dto) {
        return dtoToOrm(dto, new CategoriaProdutoInsumo());
    }

    @Override
    public CategoriaProdutoInsumoDto ormToDto(CategoriaProdutoInsumo orm, CategoriaProdutoInsumoDto dto) {
        dto.setNome(orm.getNome());
        dto.setId(orm.getId().toString());
        return dto;
    }

    @Override
    public CategoriaProdutoInsumoDto ormToDto(CategoriaProdutoInsumo orm) {
        return ormToDto(orm, new CategoriaProdutoInsumoDto());
    }

    @Override
    public CategoriaProdutoInsumoListingDto ormToListedItem(CategoriaProdutoInsumo orm) {
        CategoriaProdutoInsumoListingDto dto = new CategoriaProdutoInsumoListingDto();
        dto.setId(orm.getId().toString());
        dto.setNome(orm.getNome());
        return dto;
    }

    @Override
    public List<CategoriaProdutoInsumo> dtoListToOrmList(List<CategoriaProdutoInsumoDto> categoriaEventoDtos) {
        if (categoriaEventoDtos == null) return List.of();
        return categoriaEventoDtos.stream().map(this::dtoToOrm).toList();
    }

    @Override
    public List<CategoriaProdutoInsumoDto> ormListToDtoList(List<CategoriaProdutoInsumo> categoriaEventos) {
        if (categoriaEventos == null) return List.of();
        return categoriaEventos.stream().map(this::ormToDto).toList();
    }

    @Override
    public List<CategoriaProdutoInsumoListingDto> ormListToListedItemm(List<CategoriaProdutoInsumo> categoriaEventos) {
        if (categoriaEventos == null) return List.of();
        return categoriaEventos.stream().map(this::ormToListedItem).toList();
    }
}
