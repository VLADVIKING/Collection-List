import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shopList = new ArrayList<String>();

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1 - Добавить");
            System.out.println("2 - Показать");
            System.out.println("3 - Удалить");
            System.out.println("4 - Найти");
            System.out.println("или end");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            int reqOperation = Integer.parseInt(input);
            switch (reqOperation) {
                case 1:
                    addProduct(scanner, shopList);
                    break;
                case 2:
                    printShopList(shopList);
                    break;
                case 3:
                    printShopList(shopList);
                    if (removeProduct(scanner, shopList)) break;
                    printShopList(shopList);
                    break;
                case 4:
                    searchProduct(scanner, shopList);
            }
        }
    }

    private static void addProduct(Scanner scanner, List<String> shopList) {
        System.out.println("Какую покупку хотите добавить?");
        String input1 = scanner.nextLine();
        shopList.add(input1);
        int shopQuantity = shopList.indexOf(input1);
        System.out.println("Итого в списке покупок: " + (shopQuantity + 1));
    }

    public static void printShopList(List shopList) {
        System.out.println("Список покупок:");
        for (int i = 0; i < shopList.size(); i++) {
            System.out.println((i + 1) + ".  " + shopList.get(i));
        }
    }

    private static boolean removeProduct(Scanner scanner, List<String> shopList) {
        System.out.println("Какую покупку хотите удалить? Введите номер или название");
        String input2 = scanner.nextLine();
        boolean isExist = shopList.contains(input2);
        if (isExist) {
            shopList.remove(input2);
            System.out.println("Покупка " + input2 + " удалена,");
            printShopList(shopList);
            return true;
        } else {
            int numberRemove = Integer.parseInt(input2);
            for (int i = 0; i < shopList.size(); i++) {
                if ((numberRemove - 1) == i) {
                    System.out.println("Покупка " + shopList.remove(i) + " удалена,");
                    return true;
                }
            }
        }
        return false;
    }

    private static void searchProduct(Scanner scanner, List<String> shopList) {
        System.out.println("Введите текст для поиска:");
        String input3 = scanner.nextLine();
        String queryLower = input3.toLowerCase();
        System.out.println("Найдено:");
        for (int i = 0; i < shopList.size(); i++) {
            String itemLower = shopList.get(i).toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println((i + 1) + ".  " + shopList.get(i));
                break;
            }
        }
        System.out.println("Ничего не найдено!");
    }
}