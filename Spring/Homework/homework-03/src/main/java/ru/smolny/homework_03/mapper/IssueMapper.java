package ru.smolny.homework_03.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.smolny.homework_03.dto.IssueResponse;
import ru.smolny.homework_03.model.Issue;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IssueMapper {

    @Mapping(source = "book.title", target = "bookTitle")
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "user.username", target = "userName")
    @Mapping(source = "user.id", target = "userId")
    IssueResponse toIssueResponse(Issue issue);
    List<IssueResponse> toIssueResponseList(List<Issue> issues);
}
