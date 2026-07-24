package projetos.artesanatoerpapi.application.categoriaevento.entities;

import lombok.Data;
import projetos.artesanatoerpapi.genericclasses.BaseDto;

@Data
public class CategoriaEventoDto extends BaseDto {
    private String nome;
}
