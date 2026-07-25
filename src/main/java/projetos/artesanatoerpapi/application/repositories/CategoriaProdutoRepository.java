package projetos.artesanatoerpapi.application.repositories;


import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.categoriaproduto.models.CategoriaProduto;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

@Repository
public interface CategoriaProdutoRepository extends GenericRepository<CategoriaProduto> {
}
