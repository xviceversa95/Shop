package Categories;

public class Dishes extends Good {
    public String name;
    public String category;
    public double price;
    public int goodID;
    public String color;
    public String material;

    public Dishes() {}

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getGoodID() {
        return goodID;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Наименование товара: " + name + ","
                + " Цена: " + price + ","
                + " ID для заказа: " + goodID;
    }
}

