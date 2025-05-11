import Categories.Good;

import java.util.HashMap;
import java.util.Map;

public class Basket implements GoodTaker {
    public Client client;
    public Map<Good, Integer> basketList = new HashMap<>();
    public double basketSum;
    public final double TAX_RATE = 0.2;

    public Basket (Client client) {
        this.client = client;
    }

    public Basket addGood (int quantity, String category, int id, GoodList goodList) {
        Good good = goodList.takeGoodById(id, category);
        if (good != null) {
            if (basketList.containsKey(good)) {
                basketList.put(good, (basketList.get(good) + quantity));
            } else {
                basketList.put(good, quantity);
            }
            System.out.println("Товар " + good + " добавлен в корзину в количестве: " + quantity);
        }
        return this;
    }

    public Basket deleteGood (Good good, int quantity) {
        if (good != null) {
            if (basketList.containsKey(good)) {
                int newQuantity = basketList.get(good) - quantity;
                if (newQuantity > 0) {
                    basketList.replace(good, basketList.get(good), newQuantity);
                }
                if (newQuantity <= 0) {
                    basketList.remove(good);
                    printBasketList();
                }
            }
        }
        return this;
    }

    public Basket clearAll(){
        basketList.clear();
        basketSum = 0;
        return this;
    }

    public void printBasketList() {
        basketSum = 0;
        if (basketList.isEmpty()) {
            System.out.println("Ваша корзина пуста");
        } else {
            System.out.println("В вашей корзине:");
            for (Map.Entry <Good, Integer> kv : basketList.entrySet()) {
                System.out.println("Товар: " + kv.getKey());
                System.out.println("Количество: " + kv.getValue());
            }
            System.out.println("Общая сумма товаров в корзине с учетом НДС: " + countBasket());
        }
    }

    @Override
    public Good takeGoodById(int takeID, String category) {
        for (Map.Entry <Good, Integer> kv : basketList.entrySet()) {
           if (kv.getKey().getGoodID() == takeID) {
               return kv.getKey();
           }
        }
        return null;
    }

    public Map<Good, Integer> getBasketList() {
        return basketList;
    }

    public double countBasket() {
        for (Map.Entry <Good, Integer> kv : basketList.entrySet()) {
            double countedTax = kv.getKey().getPrice() * TAX_RATE;
            basketSum += (kv.getKey().getPrice() * kv.getValue()) + countedTax;
        }
        return basketSum;
    }
}

