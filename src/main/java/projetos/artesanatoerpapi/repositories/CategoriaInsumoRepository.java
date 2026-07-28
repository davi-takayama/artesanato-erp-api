package projetos.artesanatoerpapi.repositories;


import org.springframework.stereotype.Repository;
import projetos.artesanatoerpapi.application.categoriainsumo.models.CategoriaInsumo;
import projetos.artesanatoerpapi.genericclasses.GenericRepository;

@Repository
public interface CategoriaInsumoRepository extends GenericRepository<CategoriaInsumo> {
}
