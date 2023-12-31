package cvut.fel.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Builder
public class BookCreate {

    @NotEmpty
    @Size(max = 2000)
    private String name;
    @NotEmpty
    private String isbn;
    @NotNull
    private Long genre;
    @NotEmpty
    private List<Long> authors;

}
