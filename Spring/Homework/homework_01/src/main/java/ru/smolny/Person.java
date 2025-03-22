package ru.smolny;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Person {
    private final String firstName;
    private final String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("age", age)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person other = (Person) o;
        return new EqualsBuilder()
                .append(firstName.toLowerCase(), other.firstName.toLowerCase())
                .append(lastName.toLowerCase(), other.lastName.toLowerCase())
                .append(age, other.age)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName.toLowerCase())
                .append(lastName.toLowerCase())
                .append(age)
                .toHashCode();
    }
}
