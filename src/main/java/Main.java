import Categories.Category;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //менюшка общее
        String[] commandList = {
                "---------------------",
                "0. Выход из программы",
                "1. Отобразить список товаров",
                "2. Перейти в корзину",
                "---------------------"
        };
        //меню в корзине
        String[] basketCommands = {
                "---------------------",
                "0. Выход из программы",
                "1. Выбрать товары для удаления",
                "2. Сформировать заказ",
                "---------------------"
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Для того чтобы начать работу с программой необходимо создать пользователя");
        System.out.println("Введите ваше имя");
        String inputName = scanner.nextLine();
        System.out.println("Введите ваш адрес");
        String inputAddress = scanner.nextLine();
        Client client = new Client(inputName, inputAddress);
        Basket basket = new Basket(client);
        GoodList actualList = new GoodList();
        String category = null;

        while (true) {

            System.out.println("Приветствуем, " + client.name);
            for (String command : commandList) {
                System.out.println(command);
            }
            String inputNumber = scanner.nextLine();
            int commandNumber = Integer.parseInt(inputNumber);
            System.out.println("Ваш выбор: " + commandNumber);

            if (commandNumber == 0) {
                System.out.println("Программа завершена");
                break;
            }

            if (commandNumber == 1) {
                System.out.println("Список категорий:");
                System.out.println(Arrays.toString(Category.values()));
                String inputCategory = scanner.nextLine();

                if (inputCategory.equals(Category.DISHES.getTitle())) {
                    actualList.getDishesList(Category.DISHES);
                    actualList.printGoodList(actualList.dishesList);
                    category = Category.DISHES.getTitle();
                }
                if (inputCategory.equals(Category.FURNITURE.getTitle())) {
                    actualList.getFurnitureList(Category.FURNITURE);
                    actualList.printGoodList(actualList.furnitureList);
                    category = Category.FURNITURE.getTitle();
                }

                System.out.println("-----------------------------------");
                System.out.println("Введите id товара из списка для добавления в корзину");
                String inputID = scanner.nextLine();
                int gId = Integer.parseInt(inputID);
                System.out.println("Введите количество товара из списка для добавления в корзину");
                String inputQuantity = scanner.nextLine();
                int quantity = Integer.parseInt(inputQuantity);
                basket.addGood(quantity, category, gId, actualList);
            }
            if (commandNumber == 2) {
                basket.printBasketList();
                for (String command : basketCommands) {
                    System.out.println(command);
                }
                String inputCommand = scanner.nextLine();
                int command = Integer.parseInt(inputCommand);
                if (command == 0) {
                    break;
                }
                if (command == 1) {
                    System.out.println("Введите ID товара для удаления");
                    String input = scanner.nextLine();
                    int deleteID = Integer.parseInt(input);
                    System.out.println("Введите количество единиц товара для удаления");
                    String inputQuantity = scanner.nextLine();
                    int quantity = Integer.parseInt(inputQuantity);
                    basket.deleteGood(basket.takeGoodById(deleteID, category), quantity);
                }
                if (command == 2) {
                    Order order = new Order(basket);
                    order.printOrder();
                    basket.clearAll();
                }
            }
        }
    }
}

