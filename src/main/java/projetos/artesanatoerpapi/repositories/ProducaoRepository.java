package projetos.artesanatoerpapi.repositories;


import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.producao.Producao;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

@Repository
public interface ProducaoRepository extends GenericRepository<Producao> {
}
