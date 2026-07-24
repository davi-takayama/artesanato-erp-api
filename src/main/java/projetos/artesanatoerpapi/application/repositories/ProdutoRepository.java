package projetos.artesanatoerpapi.application.repositories;


import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.produto.Produto;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

@Repository
public interface ProdutoRepository extends GenericRepository<Produto> {

}
