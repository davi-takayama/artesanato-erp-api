package projetos.artesanatoerpapi.application.repositories;


import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.estoque.Estoque;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

@Repository
public interface EstoqueRepository extends GenericRepository<Estoque> {
}
