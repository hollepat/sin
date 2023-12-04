package cvut.fel.dto;

public class AuthorDTO extends AbstractDTO{

    public AuthorDTO() {
    }

    public AuthorDTO(AbstractDTO dto) {
        super(dto);
    }

    @Override
    public AbstractDTO clone() {
        return new AuthorDTO(this);
    }
}
