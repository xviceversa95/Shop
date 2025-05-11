import Categories.Good;

import java.util.Map;

public class Order {
    public Map<Good, Integer> basketList;
    public int orderId;
    public Client client;
    public double orderSum;
    public String address;


    public Order(Basket basket) {
        this.client = basket.client;
        this.orderSum = basket.basketSum;
        this.orderId = client.clientID;
        this.basketList = basket.basketList;
        this.address = client.address;
    }

    public void printOrder(){
        for (Map.Entry <Good, Integer> kv : basketList.entrySet()) {
            System.out.println("Товар: " + kv.getKey());
            System.out.println("Количество: " + kv.getValue());
        }
        System.out.println("Сумма заказа составила: " + orderSum);
        System.out.println("Адрес доставки: " + address);
    }
}


