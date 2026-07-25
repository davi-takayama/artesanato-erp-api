package projetos.artesanatoerpapi.genericclasses;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponseDto<Dto> {
    private final String message;
    private final int status;
    private Dto data;
    private List<String> extraInfoList;

    public ApiResponseDto(Dto data) {
        this.data = data;
        this.status = 200;
        this.message = "Success";
    }
}
