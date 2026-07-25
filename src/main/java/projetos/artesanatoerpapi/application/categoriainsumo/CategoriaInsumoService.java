package projetos.artesanatoerpapi.application.categoriainsumo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumo;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumoDto;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumoListingDto;
import projetos.artesanatoerpapi.application.repositories.CategoriaInsumoRepository;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaInsumoService extends GenericService<CategoriaInsumo, CategoriaInsumoDto, CategoriaInsumoListingDto> {

    private final CategoriaInsumoRepository categoriaEventoRepository;

    @Autowired
    public CategoriaInsumoService(CategoriaInsumoRepository categoriaEventoRepository) {
        this.categoriaEventoRepository = categoriaEventoRepository;
        this.entityClass = CategoriaInsumo.class;
        this.converter = new CategoriaInsumoConverter();
    }

    @PostConstruct
    void init() {
        super.repository = categoriaEventoRepository;
    }

    @Transactional
    public ApiResponseDto<CategoriaInsumoDto> create(CategoriaInsumoDto dto) {
        return super.create(dto, null, null);
    }

    @Transactional
    public ApiResponseDto<CategoriaInsumoDto> update(CategoriaInsumoDto dto) {
        return super.update(dto, null, null);
    }

    @Transactional
    public ApiResponseDto<String> delete(String id) {
        return super.delete(UUID.fromString(id), null);
    }

    public ApiResponseDto<List<CategoriaInsumoListingDto>> findAll() {
        return super.retrieveAll();
    }

    public CategoriaInsumo retrieveOrmById(UUID id) {
        return super.retrieveOrmById(id);
    }

    public ApiResponseDto<CategoriaInsumoDto> retrieveDtoById(UUID id) {
        return super.retrieveById(id, null);
    }
}
