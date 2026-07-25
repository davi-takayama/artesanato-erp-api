package projetos.artesanatoerpapi.application.produto;


import org.springframework.web.bind.annotation.*;
import projetos.artesanatoerpapi.application.produto.models.ProdutoDto;
import projetos.artesanatoerpapi.application.produto.models.ProdutoListingDto;
import projetos.artesanatoerpapi.genericclasses.ApiResponseDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ApiResponseDto<List<ProdutoListingDto>> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponseDto<ProdutoDto> findById(@PathVariable String id) {
        return produtoService.findById(UUID.fromString(id));
    }

    @PostMapping
    public ApiResponseDto<ProdutoDto> create(@RequestBody ProdutoDto produtoDto) {
        return produtoService.create(produtoDto);
    }

    @PutMapping
    public ApiResponseDto<ProdutoDto> update(@RequestBody ProdutoDto produtoDto) {
        return produtoService.update(produtoDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponseDto<String> delete(@PathVariable String id) {
        return produtoService.delete(UUID.fromString(id));
    }
}
