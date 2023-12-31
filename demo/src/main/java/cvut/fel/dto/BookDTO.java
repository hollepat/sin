package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BookDTO extends AbstractDTO{

    private String ISBN;
    private String dateOfPublishing;
    private Integer genre;
    private Long publisher;
    private List<Long> authorsIds;

    public BookDTO() {
    }

}
