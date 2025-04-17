package ru.smolny.homework_03.model;

public enum RoleType {
    READER, ADMIN;

    public String getAuthority() {
        return this.name();
    }
}
