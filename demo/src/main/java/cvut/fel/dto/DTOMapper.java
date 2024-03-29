package cvut.fel.dto;

import cvut.fel.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    BookDTO bookToDto(Book book);

    @Mapping(source="contracts", target = "contractsIds")
    @Mapping(source="publishedBooks", target = "publishedBooksIds")
    PublisherDTO publisherToDto(Publisher publisher);

    static List<Long> mapBooks(List<Book> books) {
        return books.stream().map(Book::getId).collect(Collectors.toList());
    }

    static List<Long> mapAuthors(List<Author> authors) {
        if (authors == null) {
            return null;
        }
        return authors.stream().map(Author::getId).collect(Collectors.toList());
    }

    static Long mapPublisher(Publisher value) {
        if (value == null) {
            return null;
        }
        return value.getId();
    }

    Library libraryDtoToLibrary(LibraryDTO libraryDTO);
}
