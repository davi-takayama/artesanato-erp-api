package projetos.artesanatoerpapi.application.categoriaevento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projetos.artesanatoerpapi.application.categoriaevento.entities.CategoriaEventoDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categoria-evento")
public class CategoriaEventoController {
    private final CategoriaEventoService categoriaEventoService;

    @Autowired
    public CategoriaEventoController(CategoriaEventoService categoriaEventoService) {
        this.categoriaEventoService = categoriaEventoService;
    }

    @GetMapping
    public ApiResponseDto<List<CategoriaEventoDto>> findAll() {
        return categoriaEventoService.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponseDto<CategoriaEventoDto> findById(@PathVariable String id) {
        return categoriaEventoService.retrieveDtoById(UUID.fromString(id));
    }

    @PostMapping
    public ApiResponseDto<CategoriaEventoDto> create(@RequestBody CategoriaEventoDto categoriaEventoDto) {
        return categoriaEventoService.create(categoriaEventoDto);
    }

    @PutMapping
    public ApiResponseDto<CategoriaEventoDto> update(@RequestBody CategoriaEventoDto categoriaEventoDto) {
        return categoriaEventoService.update(categoriaEventoDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<String> delete(@PathVariable String id) {
        return categoriaEventoService.delete(id);
    }
}
