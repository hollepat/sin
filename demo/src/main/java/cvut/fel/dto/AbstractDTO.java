package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractDTO {

    private Long id;
    private String name;

    public AbstractDTO() {
    }

}
