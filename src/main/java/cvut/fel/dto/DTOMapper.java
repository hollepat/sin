package cvut.fel.dto;

import cvut.fel.model.Book;
import cvut.fel.model.Library;
import cvut.fel.model.Publisher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    BookDTO bookToDto(Book book);
    PublisherDTO publisherToDto(Publisher publisher);
    Publisher dtoToPublisher(PublisherDTO publisherDTO);

    LibraryDTO libraryToDto(Library library);
    Library dtoToLibrary(LibraryDTO libraryDTO);



}
