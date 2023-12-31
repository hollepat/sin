package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

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
