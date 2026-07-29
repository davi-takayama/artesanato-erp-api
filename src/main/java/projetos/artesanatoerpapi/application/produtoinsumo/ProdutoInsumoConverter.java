package projetos.artesanatoerpapi.application.produtoinsumo;

import org.springframework.stereotype.Component;
import projetos.artesanatoerpapi.application.produto.ProdutoConverter;
import projetos.artesanatoerpapi.application.produtoinsumo.models.ProdutoInsumo;
import projetos.artesanatoerpapi.application.produtoinsumo.models.ProdutoInsumoDto;
import projetos.artesanatoerpapi.application.produtoinsumo.models.ProdutoInsumoListedDto;
import projetos.artesanatoerpapi.genericclasses.ConverterInterface;

import java.util.List;
import java.util.UUID;

@Component
public class ProdutoInsumoConverter implements ConverterInterface<ProdutoInsumo, ProdutoInsumoDto, ProdutoInsumoListedDto> {

    private final ProdutoConverter produtoConverter;

    public ProdutoInsumoConverter(ProdutoConverter produtoConverter) {
        this.produtoConverter = produtoConverter;
    }

    @Override
    public ProdutoInsumo dtoToOrm(ProdutoInsumoDto dto, ProdutoInsumo orm) {
        if (dto.getId() != null)
            orm.setId(UUID.fromString(dto.getId()));
        dto.setProdutoPaiId(dto.getProdutoPaiId());
        dto.setProdutoFilho(dto.getProdutoFilho());
        dto.setQuantidadeUsada(dto.getQuantidadeUsada());
        return orm;
    }

    @Override
    public ProdutoInsumo dtoToOrm(ProdutoInsumoDto dto) {
        return dtoToOrm(dto, new ProdutoInsumo());
    }

    @Override
    public ProdutoInsumoDto ormToDto(ProdutoInsumo orm, ProdutoInsumoDto dto) {
        dto.setId(orm.getId().toString());
        dto.setProdutoPaiId(orm.getProdutoPai().getId().toString());
        dto.setProdutoFilho(produtoConverter.ormToDto(orm.getProdutoFilho()));
        dto.setQuantidadeUsada(orm.getQuantidadeUsada());
        return dto;
    }

    @Override
    public ProdutoInsumoDto ormToDto(ProdutoInsumo orm) {
        return ormToDto(orm, new ProdutoInsumoDto());
    }

    @Override
    public ProdutoInsumoListedDto ormToListedItem(ProdutoInsumo orm) {
        return null;
    }

    @Override
    public List<ProdutoInsumo> dtoListToOrmList(List<ProdutoInsumoDto> produtoInsumoDtos) {
        if (produtoInsumoDtos == null || produtoInsumoDtos.isEmpty()) return List.of();
        return produtoInsumoDtos.stream().map(this::dtoToOrm).toList();
    }

    @Override
    public List<ProdutoInsumoDto> ormListToDtoList(List<ProdutoInsumo> produtoInsumos) {
        if (produtoInsumos == null || produtoInsumos.isEmpty()) return List.of();
        return produtoInsumos.stream().map(this::ormToDto).toList();
    }

    @Override
    public List<ProdutoInsumoListedDto> ormListToListedItemm(List<ProdutoInsumo> produtoInsumos) {
        if (produtoInsumos == null || produtoInsumos.isEmpty()) return List.of();
        return produtoInsumos.stream().map(this::ormToListedItem).toList();
    }
}
