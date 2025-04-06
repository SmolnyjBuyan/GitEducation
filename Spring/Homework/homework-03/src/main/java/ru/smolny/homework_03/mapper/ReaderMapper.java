package ru.smolny.homework_03.mapper;

import org.mapstruct.Mapper;
import ru.smolny.homework_03.dto.ReaderRequest;
import ru.smolny.homework_03.dto.ReaderResponse;
import ru.smolny.homework_03.model.Reader;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ReaderMapper {
    ReaderResponse toReaderResponse(Reader reader);
    Reader toEntity(ReaderRequest request);
    List<ReaderResponse> toReaderResponseList(List<Reader> readers);
}
