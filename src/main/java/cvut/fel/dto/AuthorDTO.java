package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class AuthorDTO {

    private Long id;

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

    public AuthorDTO(AuthorDTO dto) {
        super();
        id = dto.getId();
        bookIds = dto.getBookIds();
        email = dto.getEmail();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        publisherIds = dto.getPublisherIds();
    }

    @Override
    public AuthorDTO clone() {
        return new AuthorDTO(this);
    }
}
