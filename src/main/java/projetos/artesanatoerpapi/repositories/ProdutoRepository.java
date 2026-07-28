package projetos.artesanatoerpapi.repositories;


import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.produto.models.Produto;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

@Repository
public interface ProdutoRepository extends GenericRepository<Produto> {
}
