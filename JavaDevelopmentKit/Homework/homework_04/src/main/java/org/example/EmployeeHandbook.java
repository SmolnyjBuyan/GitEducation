package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeHandbook {
    private List<Employee> employees = new ArrayList<>();

    public void add(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getByExperienceMoreThan(int years) {
        return employees.stream().filter(e -> e.getExperienceInYears() > years).collect(Collectors.toList());
    }

    public List<Employee> getByExperienceLessThan(int years) {
        return employees.stream().filter(e -> e.getExperienceInYears() < years).collect(Collectors.toList());
    }

    public List<Employee> getByExperienceEqualTo(int years) {
        return employees.stream().filter(employee -> employee.getExperienceInYears() == years).collect(Collectors.toList());
    }

    public List<String> getPhoneNumbers(String name) {
        return employees.stream().filter(e -> e.getName().equalsIgnoreCase(name)).
                map(Employee::getPhoneNumber).collect(Collectors.toList());
    }

    public Employee get(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

}
