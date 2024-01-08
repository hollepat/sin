package cvut.fel.service;

import cvut.fel.dto.LibraryDTO;

public interface LibraryService {

    boolean addBookToLibrary(Long bookId, Long libraryId);

    boolean createLibrary(LibraryDTO libraryDTO);
}
