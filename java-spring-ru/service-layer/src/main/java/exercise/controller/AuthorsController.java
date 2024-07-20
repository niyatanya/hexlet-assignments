package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

import org.springframework.http.ResponseEntity;
import java.net.URI;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping
    public ResponseEntity<List<AuthorDTO>> index() {
        List<AuthorDTO> authors = authorService.getAll();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(authors.size()))
                .body(authors);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AuthorDTO> show(@PathVariable long id) {
        AuthorDTO authorDTO = authorService.findById(id);
        return ResponseEntity.ok()
                .body(authorDTO);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> create(@Valid @RequestBody AuthorCreateDTO authorData) {
        AuthorDTO authorDTO = authorService.create(authorData);
        URI location = URI.create("/authors");
        return ResponseEntity.created(location)
                .body(authorDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AuthorDTO> update(@Valid @RequestBody AuthorUpdateDTO authorData,
                                            @PathVariable long id) {
        AuthorDTO authorDTO = authorService.update(authorData, id);
        return ResponseEntity.ok()
                 .body(authorDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        authorService.delete(id);
    }
        // END
}
