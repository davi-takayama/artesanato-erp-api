package projetos.artesanatoerpapi.application.categoriaproduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProduto;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoDto;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoListingDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;
import projetos.artesanatoerpapi.repositories.CategoriaProdutoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaProdutoService extends GenericService<CategoriaProduto, CategoriaProdutoDto, CategoriaProdutoListingDto> {
    @Autowired
    public CategoriaProdutoService(CategoriaProdutoRepository categoriaEventoRepository, CategoriaProdutoConverter categoriaProdutoConverter) {
        super.repository = categoriaEventoRepository;
        this.entityClass = CategoriaProduto.class;
        super.converter = categoriaProdutoConverter;
    }

    @Transactional
    public ApiResponseDto<CategoriaProdutoDto> create(CategoriaProdutoDto dto) {
        return super.create(dto, null, null);
    }

    @Transactional
    public ApiResponseDto<CategoriaProdutoDto> update(CategoriaProdutoDto dto) {
        return super.update(dto, null, null);
    }

    @Transactional
    public ApiResponseDto<String> delete(String id) {
        return super.delete(UUID.fromString(id), null);
    }

    public ApiResponseDto<List<CategoriaProdutoListingDto>> findAll() {
        return super.retrieveAll();
    }

    public CategoriaProduto findOrmById(UUID id) {
        return super.findOrmById(id);
    }

    public ApiResponseDto<CategoriaProdutoDto> retrieveDtoById(UUID id) {
        return super.retrieveById(id, null);
    }
}
