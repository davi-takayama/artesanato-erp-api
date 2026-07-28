package projetos.artesanatoerpapi.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.entradaestoque.entities.EntradaEstoque;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EntradaEstoqueRepository extends GenericRepository<EntradaEstoque> {
    @Query("SELECT e FROM EntradaEstoque e WHERE e.produto.id = :produtoId")
    List<EntradaEstoque> findAllByProduto_Id(UUID produtoId);


    List<EntradaEstoque> findAllByProduto(Produto produto);
}
