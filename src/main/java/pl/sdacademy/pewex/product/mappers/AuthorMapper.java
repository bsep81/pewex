package pl.sdacademy.pewex.product.mappers;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.product.db.AuthorEntity;
import pl.sdacademy.pewex.product.model.Author;

import java.util.Optional;

@Component
public class AuthorMapper {

    public Optional<Author> mapEntityToAuthor(AuthorEntity entity) {

        if (entity == null) {
            return Optional.empty();
        }

        Author author = Author.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .build();

        return Optional.of(author);
        }

    public AuthorEntity mapAuthorToEntity(Author author) {

        return AuthorEntity.builder()
                .name(author.getName())
                .surname(author.getSurname())
                .build();
    }
}