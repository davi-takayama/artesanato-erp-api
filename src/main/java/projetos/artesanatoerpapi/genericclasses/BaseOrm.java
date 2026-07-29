package projetos.artesanatoerpapi.genericclasses;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseOrm {
    @Getter
    @Setter
    @Id
    @GeneratedValue
    private UUID id;

    @Getter
    @Column(nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Getter
    @Setter
    @Column(nullable = false)
    private Date updatedAt = new Date();

}
