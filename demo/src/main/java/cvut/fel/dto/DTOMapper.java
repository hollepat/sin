package cvut.fel.dto;

import cvut.fel.entity.*;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DTOMapper {
    BookDTO bookToDto(Book book);

    Book dtoToBook(BookDTO bookDTO);

    PublisherDTO publisherToDto(Publisher publisher);

    static Integer mapGenre(Genre genre) {
        if (genre == null) {
            return -1;
        }
        return genre.ordinal();
    }

    static Genre mapGenre(Integer genre) {
        return Genre.values()[genre];
    }

    static List<Long> mapBooks(List<Book> books) {
        return books.stream().map(Book::getId).collect(Collectors.toList());
    }

    static List<Long> mapAuthors(List<Author> authors) {
        return authors.stream().map(Author::getId).collect(Collectors.toList());
    }

    static Long mapPublisher(Publisher value) {
        if (value == null) {
            return null;
        }
        return value.getId();
    }

    static Publisher mapPublisher(Long value) {
        Publisher publisher = new Publisher();
        publisher.setId(value);
        return publisher;
    }

}
