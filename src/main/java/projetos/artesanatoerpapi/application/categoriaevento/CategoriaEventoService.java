package projetos.artesanatoerpapi.application.categoriaevento;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.artesanatoerpapi.application.categoriaevento.entities.CategoriaEvento;
import projetos.artesanatoerpapi.application.categoriaevento.entities.CategoriaEventoDto;
import projetos.artesanatoerpapi.application.categoriaevento.entities.CategoriaEventoListingDto;
import projetos.artesanatoerpapi.application.repositories.CategoriaEventoRepository;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaEventoService extends GenericService<CategoriaEvento, CategoriaEventoDto, CategoriaEventoListingDto> {

    private final CategoriaEventoRepository categoriaEventoRepository;

    @Autowired
    public CategoriaEventoService(CategoriaEventoRepository categoriaEventoRepository) {
        this.categoriaEventoRepository = categoriaEventoRepository;
        this.entityClass = CategoriaEvento.class;
        this.converter = new CategoriaEventoConverter();
    }

    @PostConstruct
    void init() {
        super.repository = categoriaEventoRepository;
    }

    @Transactional
    public ApiResponseDto<CategoriaEventoDto> create(CategoriaEventoDto dto) {
        return super.create(dto, null, null);
    }

    @Transactional
    public ApiResponseDto<CategoriaEventoDto> update(CategoriaEventoDto dto) {
        return super.update(dto, null, null);
    }

    @Transactional
    public ApiResponseDto<String> delete(String id) {
        return super.delete(UUID.fromString(id), null);
    }

    public ApiResponseDto<List<CategoriaEventoListingDto>> findAll() {
        return super.retrieveAll();
    }

    public CategoriaEvento retrieveOrmById(UUID id) {
        return super.retrieveOrmById(id);
    }

    public ApiResponseDto<CategoriaEventoDto> retrieveDtoById(UUID id) {
        return super.retrieveById(id, null);
    }
}
