//Абстрактный класс clients.Actor,
//который хранит в себе
//параметры актора, включая
//состояние готовности сделать
//заказ и факт получения
//заказа.

//Интерфейс ActorBehavoir,
//который будет содержать
//описание возможных
//действий актора в
//очереди/магазине


//Интерфейс marketplace.QueueBehaviour, который описывает
//логику очереди – помещение в/освобождение из
//очереди, принятие/отдача заказа

//Интерфейс marketplace.MarketBehaviour, который описывает
//логику магазина – приход/уход покупателей,
//обновление состояния магазина

import clients.Human;
import marketplace.Market;
import products.Product;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Human first = new Human("Николай", 5455);
        Human second = new Human("Владимир", 5000);


        Product milk = new Product("Молоко", 200);
        Product water = new Product("Вода", 50);
        Product pasta = new Product("Макароны", 100);
        Product bread = new Product("Хлеб", 60);


        market.addProduct(milk);
        market.addProducts(water, 2);
        market.addProducts(milk, 3);
        market.addProducts(pasta, 3);
        market.addProducts(bread, 4);
        System.out.println(market.getProducts());


        market.acceptToMarket(first);
        System.out.println("В магазин зашел " + first.getName());

        first.basket.addToBasket(milk, market);
        first.basket.addToBasket(milk, market);
        first.basket.addToBasket(bread, market);
        first.basket.addToBasket(pasta, market);

        System.out.println(first.getName() + " заполнил свою корзину:\n" + first.basket.getBasket());
        System.out.println("Оставшиеся товары в магазине: \n" + market.getProducts());

        System.out.println(first.getName() + " готов сделать зазаз");
        first.setReadyToOrder(true);
        market.getInQueue(first);
        System.out.println(first.getName() + " встал в очередь: \n" + market.getQueue());

        market.acceptToMarket(second);
        System.out.println("В магазин зашел " + second.getName());

        second.basket.addToBasket(pasta, market);
        second.basket.addToBasket(milk, market);
        second.basket.addToBasket(water, market);
        second.basket.addToBasket(water, market);
        second.basket.addToBasket(water, market);
        second.basket.addToBasket(bread, market);

        System.out.println(second.getName() + " заполнил свою корзину:\n" + second.basket.getBasket());
        System.out.println("Оставшиеся товары в магазине: \n" + market.getProducts());

        System.out.println(first.getName() + " готов сделать зазаз");
        second.setReadyToOrder(true);
        market.getInQueue(second);
        System.out.println(second.getName() + " встал в очередь: \n" + market.getQueue());

        market.update();
        System.out.println("\nОбслужили первого покупателя. Очередь: \n" + market.getQueue());
        System.out.println("\nОставшиеся товары: \n" + market.getProducts());

        market.update();
        System.out.println("\nОбслужили первого покупателя. Очередь: \n" + market.getQueue());
        System.out.println("\nОставшиеся товары: \n" + market.getProducts());

        System.out.println("Оставшиеся покупатели: \n" + market.getCustomers());
    }
}