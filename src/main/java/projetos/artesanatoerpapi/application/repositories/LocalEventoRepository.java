package projetos.artesanatoerpapi.application.repositories;

import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.localevento.entities.LocalEvento;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

@Repository
public interface LocalEventoRepository extends GenericRepository<LocalEvento> {
}
