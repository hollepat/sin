package cvut.fel.dto;

import cvut.fel.entity.Address;
import cvut.fel.entity.Author;
import cvut.fel.entity.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PublisherDTO extends AbstractDTO {

        private Address address;
        private List<Long> publishedBooksIds;
        private List<Long> contractsIds;       // Authors Ids

        public PublisherDTO() {
        }

}
