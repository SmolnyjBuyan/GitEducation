import phonebook.PhoneBook;

public class Main {

    public static void main(String[] args) {

        PhoneBook pb = new PhoneBook();
        pb.addPhonenumber("СеРгей", "кожевин", 89116755034L);
        pb.addPhonenumber("СергеЙ", "Кожевин", 89776755034L);
        pb.addPhonenumber("СергеЙ", "Кожевин", 46677);
        pb.addPhonenumber("Michael", "Owen", 8887776655L);
        pb.addPhonenumber("Ваня", "", 34);

        pb.printAll();

        pb.deletePhonenumber("Сергей", "Кожевин", 89776755034L);
        pb.printAll();

        pb.deletePhonenumber("сергей", "КожЕвин", 343);
        pb.printAll();

        pb.deletePhonenumber("сей", "КожЕвин", 343);
        pb.printAll();

        pb.deleteContact("Michael", "Owen");
        pb.printAll();
    }
}