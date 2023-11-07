package cvut.fel.service;

import cvut.fel.model.Book;

public interface BookService {
    Book findById(Long id);
}
