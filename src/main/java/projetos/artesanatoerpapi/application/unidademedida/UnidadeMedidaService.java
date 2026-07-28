package projetos.artesanatoerpapi.application.unidademedida;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedida;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedidaDto;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedidaListingDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;
import projetos.artesanatoerpapi.repositories.UnidadeMedidaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UnidadeMedidaService extends GenericService<UnidadeMedida, UnidadeMedidaDto, UnidadeMedidaListingDto> {
    public UnidadeMedidaService(UnidadeMedidaRepository unidadeMedidaRepository, UnidadeMedidaConverter unidadeMedidaConverter) {
        super.converter = unidadeMedidaConverter;
        super.repository = unidadeMedidaRepository;
        super.entityClass = UnidadeMedida.class;
    }

    @Transactional
    public ApiResponseDto<UnidadeMedidaDto> create (UnidadeMedidaDto unidadeMedidaDto) {
        return super.create(unidadeMedidaDto, null, null);
    }

    @Transactional
    public ApiResponseDto<UnidadeMedidaDto> update (UnidadeMedidaDto unidadeMedidaDto) {
        return super.update(unidadeMedidaDto, null, null);
    }

    @Transactional
    public ApiResponseDto<String> delete (UUID id) {
        return super.delete(id, null);
    }

    public ApiResponseDto<List<UnidadeMedidaListingDto>> findAll() {
        return super.retrieveAll();
    }
}
