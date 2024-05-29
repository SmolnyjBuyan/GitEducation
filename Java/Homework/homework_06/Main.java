import phonebook.PhoneBook;

public class Main {

    public static void main(String[] args) {

        PhoneBook pb = new PhoneBook();

        System.out.println("\nДобавление контактов: ");
        pb.addPhonenumber("СеРгей", "кожевин", 89116755034L);
        pb.addPhonenumber("СергеЙ", "Кожевин", 89779994455L);
        pb.addPhonenumber("СергеЙ", "Кожевин", 65577);
        pb.addPhonenumber("СергеЙ", "Кожевин", 46677);
        pb.addPhonenumber("Michael", "Owen", 8887776655L);
        pb.addPhonenumber("Сармат", "Котов", 786547);

        pb.printSortedContacts();

        System.out.println("\nДобавление контакта с некорректным аргументом: ");
        pb.addPhonenumber("Ваня", "", 34);

        System.out.println("\nУдаление номера 89779994455 У Сергея: ");
        pb.deletePhonenumber("Сергей", "Кожевин", 89779994455L);
        pb.printSortedContacts();

        System.out.println("\nУдаление номера 65577 У Сергея с вводом данных в неэквивалентных регистрах: ");
        pb.deletePhonenumber("сергей", "КожЕвин", 65577);
        pb.printSortedContacts();

        System.out.println("\nУдаление номера 89116755034 У Сергея с вводом неверных данных: ");
        pb.deletePhonenumber("сей", "КожЕвин", 89116755034L);
        pb.printSortedContacts();

        System.out.println("\nУдаление контакта Michael: ");
        pb.deleteContact("Michael", "Owen");
        pb.printSortedContacts();

        System.out.println("\nУвелечение книги для проверки сортировки по количеству номеров: ");
        pb.addPhonenumber("СергеЙ", "Кожевин", 89776755034L);
        pb.addPhonenumber("СергеЙ", "Кожевин", 89994445544L);

        pb.addPhonenumber("Леонид", "Слуцкий", 89665554477L);
        pb.addPhonenumber("Леонид", "Слуцкий", 678745);

        pb.addPhonenumber("Олег", "Белак", 994477);
        pb.addPhonenumber("Олег", "Белак", 89356667733L);
        pb.addPhonenumber("Олег", "Белак", 89542223344L);

        pb.printSortedContacts();
    }
}