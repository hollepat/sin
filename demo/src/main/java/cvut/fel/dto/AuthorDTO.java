package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AuthorDTO extends AbstractDTO{

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private List<Long> bookIds;

    private List<Long> publisherIds;

    public AuthorDTO() {
    }

}
