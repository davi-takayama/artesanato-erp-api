package projetos.artesanatoerpapi.application.categoriaproduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoDto;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoListingDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categoria-produto")
public class CategoriaProdutoController {
    private final CategoriaProdutoService categoriaProdutoService;

    @Autowired
    public CategoriaProdutoController(CategoriaProdutoService categoriaProdutoService) {
        this.categoriaProdutoService = categoriaProdutoService;
    }

    @GetMapping
    public ApiResponseDto<List<CategoriaProdutoListingDto>> findAll() {
        return categoriaProdutoService.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponseDto<CategoriaProdutoDto> findById(@PathVariable String id) {
        return categoriaProdutoService.retrieveDtoById(UUID.fromString(id));
    }

    @PostMapping
    public ApiResponseDto<CategoriaProdutoDto> create(@RequestBody CategoriaProdutoDto categoriaEventoDto) {
        return categoriaProdutoService.create(categoriaEventoDto);
    }

    @PutMapping
    public ApiResponseDto<CategoriaProdutoDto> update(@RequestBody CategoriaProdutoDto categoriaEventoDto) {
        return categoriaProdutoService.update(categoriaEventoDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<String> delete(@PathVariable String id) {
        return categoriaProdutoService.delete(id);
    }
}
