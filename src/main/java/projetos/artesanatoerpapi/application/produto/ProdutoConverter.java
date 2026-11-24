package projetos.artesanatoerpapi.application.produto;

import org.springframework.stereotype.Component;
import projetos.artesanatoerpapi.application.categoriaproduto.CategoriaProdutoInsumoConverter;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.application.produto.models.ProdutoDto;
import projetos.artesanatoerpapi.application.produto.models.ProdutoListingDto;
import projetos.artesanatoerpapi.genericclasses.ConverterInterface;

import java.util.List;
import java.util.UUID;

@Component
public class ProdutoConverter implements ConverterInterface<Produto, ProdutoDto, ProdutoListingDto> {

    CategoriaProdutoInsumoConverter categoriaProdutoInsumoConverter;

    public ProdutoConverter(CategoriaProdutoInsumoConverter categoriaProdutoInsumoConverter) {
        this.categoriaProdutoInsumoConverter = categoriaProdutoInsumoConverter;
    }

    @Override
    public Produto dtoToOrm(ProdutoDto dto, Produto orm) {
        if (dto.getId() != null) {
            orm.setId(UUID.fromString(dto.getId()));
        }

        orm.setNome(dto.getNome());
        orm.setPrecoCusto(dto.getPrecoCusto());
        orm.setPrecoVenda(dto.getPrecoVenda());
        orm.setQuantidadeInicial(dto.getQuantidadeInicial());

        return orm;
    }

    @Override
    public Produto dtoToOrm(ProdutoDto dto) {
        return dtoToOrm(dto, new Produto());
    }

    @Override
    public ProdutoDto ormToDto(Produto orm, ProdutoDto dto) {
        dto.setId(orm.getId().toString());
        dto.setNome(orm.getNome());
        dto.setPrecoCusto(orm.getPrecoCusto());
        dto.setPrecoVenda(orm.getPrecoVenda());
        dto.setCategoriaProduto(categoriaProdutoInsumoConverter.ormToDto(orm.getCategoriaProdutoInsumo()));
        dto.setQuantidadeInicial(orm.getQuantidadeInicial());
        return dto;
    }

    @Override
    public ProdutoDto ormToDto(Produto orm) {
        return ormToDto(orm, new ProdutoDto());
    }

    @Override
    public ProdutoListingDto ormToListedItem(Produto orm) {
        ProdutoListingDto dto = new ProdutoListingDto();
        dto.setId(orm.getId().toString());
        dto.setNome(orm.getNome());
        dto.setPrecoVenda(orm.getPrecoVenda());
        dto.setCategoriaProduto(categoriaProdutoInsumoConverter.ormToDto(orm.getCategoriaProdutoInsumo()));
        return dto;

    }

    @Override
    public List<Produto> dtoListToOrmList(List<ProdutoDto> produtoDtos) {
        if (produtoDtos == null) return List.of();
        return produtoDtos.stream().map(this::dtoToOrm).toList();
    }

    @Override
    public List<ProdutoDto> ormListToDtoList(List<Produto> produtos) {
        if (produtos == null) return List.of();
        return produtos.stream().map(this::ormToDto).toList();
    }

    @Override
    public List<ProdutoListingDto> ormListToListedItemm(List<Produto> produtos) {
        if (produtos == null) return List.of();
        return produtos.stream().map(this::ormToListedItem).toList();
    }
}
