package projetos.artesanatoerpapi.application.unidademedida;

import org.springframework.web.bind.annotation.*;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedidaDto;
import projetos.artesanatoerpapi.application.unidademedida.models.UnidadeMedidaListingDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/unidade-medida")
public class UnidadeMedidaController {
    private final UnidadeMedidaService service;

    public UnidadeMedidaController(UnidadeMedidaService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponseDto<List<UnidadeMedidaListingDto>> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ApiResponseDto<UnidadeMedidaDto> create(@RequestBody UnidadeMedidaDto produtoDto) {
        return service.create(produtoDto);
    }

    @PutMapping
    public ApiResponseDto<UnidadeMedidaDto> update(@RequestBody UnidadeMedidaDto produtoDto) {
        return service.update(produtoDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<String> delete(@PathVariable String id) {
        return service.delete(UUID.fromString(id));
    }
}
