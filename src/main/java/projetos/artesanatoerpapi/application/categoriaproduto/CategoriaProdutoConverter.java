package projetos.artesanatoerpapi.application.categoriaproduto;

import org.springframework.stereotype.Component;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProduto;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoDto;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoListingDto;
import projetos.artesanatoerpapi.genericclasses.ConverterInterface;

import java.util.List;
import java.util.UUID;

@Component
public class CategoriaProdutoConverter implements ConverterInterface<CategoriaProduto, CategoriaProdutoDto, CategoriaProdutoListingDto> {
    @Override
    public CategoriaProduto dtoToOrm(CategoriaProdutoDto dto, CategoriaProduto orm) {
        orm.setNome(dto.getNome());
        if (dto.getId() != null) {
            orm.setId(UUID.fromString(dto.getId()));
        }
        return orm;
    }

    @Override
    public CategoriaProduto dtoToOrm(CategoriaProdutoDto dto) {
        return dtoToOrm(dto, new CategoriaProduto());
    }

    @Override
    public CategoriaProdutoDto ormToDto(CategoriaProduto orm, CategoriaProdutoDto dto) {
        dto.setNome(orm.getNome());
        dto.setId(orm.getId().toString());
        return dto;
    }

    @Override
    public CategoriaProdutoDto ormToDto(CategoriaProduto orm) {
        return ormToDto(orm, new CategoriaProdutoDto());
    }

    @Override
    public CategoriaProdutoListingDto ormToListedItem(CategoriaProduto orm) {
        CategoriaProdutoListingDto dto = new CategoriaProdutoListingDto();
        dto.setId(orm.getId().toString());
        dto.setNome(orm.getNome());
        return dto;
    }

    @Override
    public List<CategoriaProduto> dtoListToOrmList(List<CategoriaProdutoDto> categoriaEventoDtos) {
        if (categoriaEventoDtos == null) return List.of();
        return categoriaEventoDtos.stream().map(this::dtoToOrm).toList();
    }

    @Override
    public List<CategoriaProdutoDto> ormListToDtoList(List<CategoriaProduto> categoriaEventos) {
        if (categoriaEventos == null) return List.of();
        return categoriaEventos.stream().map(this::ormToDto).toList();
    }

    @Override
    public List<CategoriaProdutoListingDto> ormListToListedItemm(List<CategoriaProduto> categoriaEventos) {
        if (categoriaEventos == null) return List.of();
        return categoriaEventos.stream().map(this::ormToListedItem).toList();
    }
}
