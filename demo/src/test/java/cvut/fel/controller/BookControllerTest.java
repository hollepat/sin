package cvut.fel.controller;

import cvut.fel.dto.BookDTO;
import cvut.fel.dto.DTOMapper;
import cvut.fel.entity.Author;
import cvut.fel.entity.Book;
import cvut.fel.service.BookServiceImp;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

// https://www.baeldung.com/mockito-annotations

@ExtendWith(MockitoExtension.class)
public class BookControllerTest extends BaseControllerTestRunner {

    @MockBean
    private BookServiceImp bookServiceMock;

    @SpyBean
    private DTOMapper dtoMapper;

    @Autowired
    private BookController sut;

    @Test
    public void getByIdReturnsMatchingBook() throws Exception {
        final Book book = new Book("name");
        book.setId(1L);
        book.setISBN("1234567890");

        /* The bookServiceMock.findById method is stubbed to return this Book
         object when called with the given ID.*/
        when(bookServiceMock.findById(book.getId())).thenReturn(book);

        // The response is captured in MvcResult.
        final MvcResult mvcResult = mockMvc.perform(get("/book/" + book.getId())).andReturn();

        // The response is converted to a BookDTO object.
        final BookDTO result = readValue(mvcResult, BookDTO.class);

        /* verify(dtoMapper).bookToDto(book) checks if dtoMapper's
        bookToDto method was called with the correct Book object.
         */
        verify(dtoMapper).bookToDto(book);

        System.out.println(result);
        assertNotNull(result);
        assertEquals(book.getId(), result.getId());
        assertEquals(book.getName(), result.getName());
    }

    @Test
    public void createNewBook() throws Exception{
        // Arrange
        final Book newBook = new Book("The Great Gatsby");
        newBook.setISBN("1234567890");

        final Long newBookId = 2L;
        newBook.setId(newBookId);

        BookDTO newBookDTO = dtoMapper.bookToDto(newBook);

        when(bookServiceMock.createBook(newBookDTO)).thenReturn(true);

        // Act
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform(post("/new-book")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(newBookDTO)))
                    .andReturn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Assert
        Boolean result = readValue(mvcResult, Boolean.class);
        verify(dtoMapper).bookToDto(newBook);
        verify(bookServiceMock).createBook(newBookDTO);

        assertNotNull(result);
        assertEquals(true, result);


    }
}
