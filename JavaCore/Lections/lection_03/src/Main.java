import models.Cat;
import models.Dog;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cat tom = new Cat("Tom", "Blue", LocalDate.of(2019, 10, 30));
        Cat kitty = new Cat("Kitty", "Brown", LocalDate.of(2018, 9, 24));
        Cat lebron = new Cat("Lebron", "White", LocalDate.of(2017, 8, 15));

        System.out.println(tom);
        System.out.println(kitty);
        System.out.println(lebron);

        System.out.println(tom.getName() + ": JumpHeight = " + tom.getJumpHeightInCentimeters());
        System.out.println("height = 250 -> " + tom.jump(250));
        System.out.println("height = 74 -> " + tom.jump(74));
        System.out.println("height = 100 -> " + tom.jump(100));

        Dog bob = new Dog("Bob", "Gray", LocalDate.of(2010, 5, 1));
        System.out.println(bob.getName() + ": RunDistance = " + bob.getRunDistanceInMeters());
        System.out.println("distance = 50000 -> " + bob.run(50000));
        System.out.println("distance = 25000 -> " + bob.run(25000));
        System.out.println("distance = 40000 -> " + bob.run(40000));
    }
}