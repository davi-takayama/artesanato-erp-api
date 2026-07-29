package projetos.artesanatoerpapi.application.produtoinsumo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.application.produtoinsumo.models.ProdutoInsumo;
import projetos.artesanatoerpapi.application.produtoinsumo.models.ProdutoInsumoDto;
import projetos.artesanatoerpapi.application.produtoinsumo.models.ProdutoInsumoListedDto;
import projetos.artesanatoerpapi.genericclasses.GenericService;
import projetos.artesanatoerpapi.repositories.ProdutoProdutoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoInsumoService extends GenericService<ProdutoInsumo, ProdutoInsumoDto, ProdutoInsumoListedDto> {

    private final ProdutoProdutoRepository produtoProdutoRepository;

    @Autowired
    public ProdutoInsumoService(ProdutoProdutoRepository produtoProdutoRepository, ProdutoInsumoConverter produtoInsumoConverter) {
        this.produtoProdutoRepository = produtoProdutoRepository;
        super.repository = produtoProdutoRepository;
        super.converter = produtoInsumoConverter;
        super.entityClass = ProdutoInsumo.class;
    }

    public List<ProdutoInsumo> findByProdutoPaiId(UUID produtoPaiId) {
        return produtoProdutoRepository.findByProdutoPai_Id(produtoPaiId);
    }

    public List<Produto> findByProdutoFilhoId(UUID produtoFilhoId) {
        return produtoProdutoRepository.findByProdutoFilho_Id(produtoFilhoId).stream().map(ProdutoInsumo::getProdutoPai).toList();
    }

    public void linkProdutoPaiWithFilhos(Produto produtoPai, List<Produto> produtosFilhos) {
        List<UUID> proodutoFilhoIdList = produtosFilhos.stream().map(Produto::getId).toList();
        produtoProdutoRepository.deleteAllNotPresentInIdList(produtoPai.getId(), proodutoFilhoIdList);
        produtoProdutoRepository.persistIfNotPresentInList(produtoPai.getId(), proodutoFilhoIdList);
    }

    public void unlinkProdutoPaiFromFilhos(Produto produto) {
        produtoProdutoRepository.deleteAllByProdutoPai_Id(produto.getId());
    }
}
