package projetos.artesanatoerpapi.genericclasses;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseOrm {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Column(nullable = false)
    private Date updatedAt = new Date();
}
