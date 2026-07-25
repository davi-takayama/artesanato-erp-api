package projetos.artesanatoerpapi.application.categoriainsumo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumoDto;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumoListingDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categoria-insumo")
public class CategoriaInsumoController {
    private final CategoriaInsumoService categoriaInsumoService;

    @Autowired
    public CategoriaInsumoController(CategoriaInsumoService categoriaInsumoService) {
        this.categoriaInsumoService = categoriaInsumoService;
    }

    @GetMapping
    public ApiResponseDto<List<CategoriaInsumoListingDto>> findAll() {
        return categoriaInsumoService.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponseDto<CategoriaInsumoDto> findById(@PathVariable String id) {
        return categoriaInsumoService.retrieveDtoById(UUID.fromString(id));
    }

    @PostMapping
    public ApiResponseDto<CategoriaInsumoDto> create(@RequestBody CategoriaInsumoDto categoriaEventoDto) {
        return categoriaInsumoService.create(categoriaEventoDto);
    }

    @PutMapping
    public ApiResponseDto<CategoriaInsumoDto> update(@RequestBody CategoriaInsumoDto categoriaEventoDto) {
        return categoriaInsumoService.update(categoriaEventoDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<String> delete(@PathVariable String id) {
        return categoriaInsumoService.delete(id);
    }
}
