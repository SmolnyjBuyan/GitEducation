import phonebook.PhoneBook;

public class Main {

    public static void main(String[] args) {

        PhoneBook pb = new PhoneBook();
        pb.addPhonenumber("Мама", 89115620517L);
        pb.addPhonenumber("Мама", 89225620517L);
        pb.addPhonenumber("Мама", 4543654);
        // pb.addPhonenumber("мама", 4544534554L);

        // Contact a = new Contact("Андрей");
        // Contact b = new Contact("андрей");
        // System.out.println(a.equals(b));

        System.out.println(pb.getPhoneBook());

        pb.deletePhonenumber("Мама", 4543654);
        System.out.println(pb.getPhoneBook());

        pb.deletePhonenumber("Николай", 666777);

        pb.addPhonenumber("Сергей", 99944455522L);
        pb.printAll();


        pb.deleteContact("Сергей");
        pb.printAll();

        pb.isKey("мама");
    }
}