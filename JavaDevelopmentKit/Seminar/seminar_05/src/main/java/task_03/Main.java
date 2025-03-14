package task_03;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        race.add(new Runner("Андрей"));
        race.add(new Runner("Сергей"));
        race.add(new Runner("Дмитрий"));
        race.start();
    }
}
