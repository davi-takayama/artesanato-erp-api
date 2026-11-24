package projetos.artesanatoerpapi.application.categoriaproduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumo;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumoDto;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumoListingDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;
import projetos.artesanatoerpapi.repositories.CategoriaProdutoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaProdutoInsumoService extends GenericService<CategoriaProdutoInsumo, CategoriaProdutoInsumoDto, CategoriaProdutoInsumoListingDto> {
    @Autowired
    public CategoriaProdutoInsumoService(CategoriaProdutoRepository categoriaEventoRepository, CategoriaProdutoInsumoConverter categoriaProdutoInsumoConverter) {
        super.repository = categoriaEventoRepository;
        this.entityClass = CategoriaProdutoInsumo.class;
        super.converter = categoriaProdutoInsumoConverter;
    }

    @Transactional
    public ApiResponseDto<CategoriaProdutoInsumoDto> create(CategoriaProdutoInsumoDto dto) {
        return super.create(dto, null, null);
    }

    @Transactional
    public ApiResponseDto<CategoriaProdutoInsumoDto> update(CategoriaProdutoInsumoDto dto) {
        return super.update(dto, null, null);
    }

    @Transactional
    public ApiResponseDto<String> delete(String id) {
        return super.delete(UUID.fromString(id), null);
    }

    public ApiResponseDto<List<CategoriaProdutoInsumoListingDto>> findAll() {
        return super.retrieveAll();
    }

    public CategoriaProdutoInsumo findOrmById(UUID id) {
        return super.findOrmById(id);
    }

    public ApiResponseDto<CategoriaProdutoInsumoDto> retrieveDtoById(UUID id) {
        return super.retrieveById(id, null);
    }
}
