package projetos.artesanatoerpapi.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.models.ProdutoProduto;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProdutoProdutoRepository extends GenericRepository<ProdutoProduto> {
    @Query("SELECT pp.produtoFilho FROM ProdutoProduto pp WHERE pp.produtoPai.id = :produtoPaiId")
    List<ProdutoProduto> findByProdutoPai_Id(UUID produtoPaiId);

    @Query("SELECT pp.produtoPai FROM ProdutoProduto pp WHERE pp.produtoFilho.id = :produtoFilhoId")
    List<ProdutoProduto> findByProdutoFilho_Id(UUID produtoFilhoId);

    @Modifying
    @Query("DELETE ProdutoProduto pp WHERE pp.produtoPai.id = :produtoPai AND pp.produtoFilho.id NOT IN :idList")
    void deleteAllNotPresentInIdList(UUID produtoPai, List<UUID> idList);

    @Modifying
    @Query("INSERT INTO ProdutoProduto (produtoPai, produtoFilho) VALUES (:idPai, :proodutoFilhoId) ON CONFLICT (produtoPai, produtoFilho) DO NOTHING")
    void persistIfNotPresentInList(UUID idPai, List<UUID> proodutoFilhoIdList);

    @Modifying
    @Query("DELETE FROM ProdutoProduto WHERE produtoPai.id = :id")
    void deleteAllByProdutoPai_Id(UUID id);
}
