package projetos.artesanatoerpapi.application.categoriainsumo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumo;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumoDto;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumoListingDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;
import projetos.artesanatoerpapi.repositories.CategoriaInsumoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaInsumoService extends GenericService<CategoriaInsumo, CategoriaInsumoDto, CategoriaInsumoListingDto> {

    @Autowired
    public CategoriaInsumoService(CategoriaInsumoRepository categoriaEventoRepository, CategoriaInsumoConverter categoriaInsumoConverter) {
        super.repository = categoriaEventoRepository;
        this.entityClass = CategoriaInsumo.class;
        this.converter = categoriaInsumoConverter;
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

    public CategoriaInsumo findOrmById(UUID id) {
        return super.findOrmById(id);
    }

    public ApiResponseDto<CategoriaInsumoDto> retrieveDtoById(UUID id) {
        return super.retrieveById(id, null);
    }
}
