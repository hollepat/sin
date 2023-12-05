package cvut.fel.dto;

import cvut.fel.model.Address;
import cvut.fel.model.Author;
import cvut.fel.model.Book;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class PublisherDTO extends AbstractDTO {

        private Long id;
        private String name;
        private Address address;
        private List<Book> publishedBooks;
        private List<Author> contracts;

        public PublisherDTO() {
        }

        public PublisherDTO(PublisherDTO dto) {
            super();
            id = dto.getId();
            name = dto.getName();
            address = dto.getAddress().clone();
            publishedBooks = dto.getPublishedBooks();
            contracts = dto.getContracts();
        }


        @Override
        public PublisherDTO clone() {
            return new PublisherDTO(this);
        }
}
