package ru.smolny.homework_03.mapper;

import org.mapstruct.Mapper;
import ru.smolny.homework_03.dto.BookRequest;
import ru.smolny.homework_03.dto.BookResponse;
import ru.smolny.homework_03.model.Book;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponse toBookResponse(Book book);
    Book toEntity(BookRequest request);
    List<BookResponse> toReaderResponseList(List<Book> books);
}
