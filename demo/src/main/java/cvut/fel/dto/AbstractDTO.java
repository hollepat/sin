package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public abstract class AbstractDTO {

    protected Long id;
    protected String name;

    public AbstractDTO() {
    }

}
