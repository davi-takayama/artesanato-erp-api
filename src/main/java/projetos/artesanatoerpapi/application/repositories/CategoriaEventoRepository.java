package projetos.artesanatoerpapi.application.repositories;


import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.categoriaevento.entities.CategoriaEvento;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

@Repository
public interface CategoriaEventoRepository extends GenericRepository<CategoriaEvento> {
}
