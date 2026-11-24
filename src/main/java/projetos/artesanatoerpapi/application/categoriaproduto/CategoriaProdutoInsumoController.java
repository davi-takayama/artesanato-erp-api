package projetos.artesanatoerpapi.application.categoriaproduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumoDto;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumoListingDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categoria-produto")
public class CategoriaProdutoInsumoController {
    private final CategoriaProdutoInsumoService categoriaProdutoInsumoService;

    @Autowired
    public CategoriaProdutoInsumoController(CategoriaProdutoInsumoService categoriaProdutoInsumoService) {
        this.categoriaProdutoInsumoService = categoriaProdutoInsumoService;
    }

    @GetMapping
    public ApiResponseDto<List<CategoriaProdutoInsumoListingDto>> findAll() {
        return categoriaProdutoInsumoService.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponseDto<CategoriaProdutoInsumoDto> findById(@PathVariable String id) {
        return categoriaProdutoInsumoService.retrieveDtoById(UUID.fromString(id));
    }

    @PostMapping
    public ApiResponseDto<CategoriaProdutoInsumoDto> create(@RequestBody CategoriaProdutoInsumoDto categoriaEventoDto) {
        return categoriaProdutoInsumoService.create(categoriaEventoDto);
    }

    @PutMapping
    public ApiResponseDto<CategoriaProdutoInsumoDto> update(@RequestBody CategoriaProdutoInsumoDto categoriaEventoDto) {
        return categoriaProdutoInsumoService.update(categoriaEventoDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<String> delete(@PathVariable String id) {
        return categoriaProdutoInsumoService.delete(id);
    }
}
