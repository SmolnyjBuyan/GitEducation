package util;

public enum Gender {
    MALE("Мужской"), FEMALE("Женский");
    private final String translation;

    Gender(String translation) {
        this.translation = translation;
    }

    public String getGender() {
        return translation;
    }
}
