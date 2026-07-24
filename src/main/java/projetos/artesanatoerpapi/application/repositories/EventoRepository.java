package projetos.artesanatoerpapi.application.repositories;


import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.evento.Evento;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

@Repository
public interface EventoRepository extends GenericRepository<Evento> {
}
