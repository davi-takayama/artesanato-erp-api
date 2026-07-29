package projetos.artesanatoerpapi.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.produtoinsumo.models.ProdutoInsumo;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProdutoProdutoRepository extends GenericRepository<ProdutoInsumo> {
    @Query("SELECT pi.produtoFilho FROM ProdutoInsumo pi WHERE pi.produtoPai.id = :produtoPaiId")
    List<ProdutoInsumo> findByProdutoPai_Id(UUID produtoPaiId);

    @Query("SELECT pi.produtoPai FROM ProdutoInsumo pi WHERE pi.produtoFilho.id = :produtoFilhoId")
    List<ProdutoInsumo> findByProdutoFilho_Id(UUID produtoFilhoId);

    @Modifying
    @Query("DELETE ProdutoInsumo pi WHERE pi.produtoPai.id = :produtoPai AND pi.produtoFilho.id NOT IN :idList")
    void deleteAllNotPresentInIdList(UUID produtoPai, List<UUID> idList);

    @Modifying
    @Query("INSERT INTO ProdutoInsumo (produtoPai, produtoFilho) VALUES (:idPai, :proodutoFilhoId) ON CONFLICT (produtoPai, produtoFilho) DO NOTHING")
    void persistIfNotPresentInList(UUID idPai, List<UUID> proodutoFilhoIdList);

    @Modifying
    @Query("DELETE FROM ProdutoInsumo WHERE produtoPai.id = :id")
    void deleteAllByProdutoPai_Id(UUID id);
}
