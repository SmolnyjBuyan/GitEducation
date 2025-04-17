package ru.smolny.homework_03.mapper;

import org.mapstruct.Mapper;
import ru.smolny.homework_03.dto.UserRequest;
import ru.smolny.homework_03.dto.ReaderResponse;
import ru.smolny.homework_03.model.User;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ReaderMapper {
    ReaderResponse toReaderResponse(User reader);
    User toEntity(UserRequest request);
    List<ReaderResponse> toReaderResponseList(List<User> readers);
}
