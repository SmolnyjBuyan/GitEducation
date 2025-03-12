package org.example;

public class Main {
    public static void main(String[] args) {
        EmployeeHandbook employeeHandbook = new EmployeeHandbook();
        employeeHandbook.add(new Employee(1, "89997776655", "Артем", 4));
        employeeHandbook.add(new Employee(2, "89997774433", "Николай", 4));
        employeeHandbook.add(new Employee(3, "89191274633", "Андрей", 2));
        employeeHandbook.add(new Employee(4, "89216274622", "Николай", 1));

        System.out.println("Сотрудники со стажем более трех лет: " +
                employeeHandbook.getByExperienceMoreThan(3));
        System.out.println("Сотрудники со стажем менее трех лет: " +
                employeeHandbook.getByExperienceLessThan(3));
        System.out.println("Сотрудники со стажем два года: " +
                employeeHandbook.getByExperienceEqualTo(2));

        System.out.println("Номера телефонов сотрудников с именем Николай: " +
                employeeHandbook.getPhoneNumbers("Николай"));

        System.out.println("Сотрудник с табельным номером 2: " +
                employeeHandbook.get(2));
    }
}