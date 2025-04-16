package ru.smolny.homework_03.exception;

import ru.smolny.homework_03.model.RoleType;

public class RoleNotFoundException extends ResourceNotFoundException{
    public RoleNotFoundException(RoleType roleType) {
        super("Не найдена роль " + roleType);
    }
}
