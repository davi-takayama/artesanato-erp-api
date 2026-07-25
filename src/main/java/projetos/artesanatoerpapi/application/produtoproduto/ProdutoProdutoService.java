package projetos.artesanatoerpapi.application.produtoproduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetos.artesanatoerpapi.application.models.ProdutoProduto;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.application.repositories.ProdutoProdutoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoProdutoService {

    private final ProdutoProdutoRepository produtoProdutoRepository;

    @Autowired
    public ProdutoProdutoService(ProdutoProdutoRepository produtoProdutoRepository) {
        this.produtoProdutoRepository = produtoProdutoRepository;
    }

    public List<Produto> findByProdutoPaiId(UUID produtoPaiId) {
        return produtoProdutoRepository.findByProdutoPai_Id(produtoPaiId).stream().map(ProdutoProduto::getProdutoFilho).toList();
    }

    public List<Produto> findByProdutoFilhoId(UUID produtoFilhoId) {
        return produtoProdutoRepository.findByProdutoFilho_Id(produtoFilhoId).stream().map(ProdutoProduto::getProdutoPai).toList();
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
