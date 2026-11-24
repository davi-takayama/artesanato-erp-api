package projetos.artesanatoerpapi.repositories;


import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProdutoInsumo;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

@Repository
public interface CategoriaProdutoRepository extends GenericRepository<CategoriaProdutoInsumo> {
}
