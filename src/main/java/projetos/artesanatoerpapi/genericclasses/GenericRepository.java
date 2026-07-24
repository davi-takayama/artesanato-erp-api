package projetos.artesanatoerpapi.genericclasses;

import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface GenericRepository<Orm extends BaseOrm> extends JpaRepository<Orm, UUID> {
    @Override
    @Query("SELECT o FROM #{#entityName} o WHERE o.id = ?1 AND (o.deleted IS NULL OR o.deleted = false)")
    @NullMarked
    Optional<Orm> findById(UUID uuid);
}
