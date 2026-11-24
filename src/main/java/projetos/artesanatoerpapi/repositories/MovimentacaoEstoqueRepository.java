package projetos.artesanatoerpapi.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.movimentacaoestoque.entities.MovimentacaoEstoque;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovimentacaoEstoqueRepository extends GenericRepository<MovimentacaoEstoque> {
    @Query("SELECT e FROM MovimentacaoEstoque e WHERE e.produto.id = :produtoId")
    List<MovimentacaoEstoque> findAllByProduto_Id(UUID produtoId);

    @Query("SELECT e FROM MovimentacaoEstoque e WHERE e.produto.id IN :produtoIds")
    List<MovimentacaoEstoque> findAllByProduto_IdIn(List<UUID> produtoIds);
}
