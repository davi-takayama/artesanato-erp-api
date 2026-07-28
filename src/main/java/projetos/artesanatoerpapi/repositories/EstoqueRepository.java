package projetos.artesanatoerpapi.repositories;


import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.entradaestoque.entities.EntradaEstoque;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

@Repository
public interface EstoqueRepository extends GenericRepository<EntradaEstoque> {
}
