package exercise.controller;

import java.util.List;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import java.net.URI;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping
    public ResponseEntity<List<BookDTO>> index() {
        List<BookDTO> books = bookService.getAll();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(books.size()))
                .body(books);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BookDTO> show(@PathVariable long id) {
        BookDTO bookDTO = bookService.findById(id);
        return ResponseEntity.ok()
                .body(bookDTO);
    }

    @PostMapping
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookCreateDTO bookData) {
        BookDTO bookDTO = bookService.create(bookData);
        URI location = URI.create("/books");
        return ResponseEntity.created(location)
                .body(bookDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BookDTO> update(@Valid @RequestBody BookUpdateDTO bookData,
                                            @PathVariable long id) {
        BookDTO bookDTO = bookService.update(bookData, id);
        return ResponseEntity.ok()
                .body(bookDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        bookService.delete(id);
    }
    // END
}
