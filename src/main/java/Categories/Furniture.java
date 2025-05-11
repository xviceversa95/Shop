package Categories;

public class Furniture extends Good {
    public String name;
    public String category;
    public double price;
    public int goodID;
    public int weight;
    public String color;
    public String material;

    public Furniture() {}


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

    public int getWeight() {
        return weight;
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
