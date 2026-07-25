package projetos.artesanatoerpapi.application.categoriaproduto.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import projetos.artesanatoerpapi.genericclasses.BaseDto;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoriaProdutoDto extends BaseDto {
    private String nome;
}
