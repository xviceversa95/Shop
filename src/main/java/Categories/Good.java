package Categories;

public abstract class Good {
    public String name;
    public String category;
    public double price;
    public int goodID;

    public double getPrice() {
        return price;
    }

    public int getGoodID() {
        return goodID;
    }

    @Override
    public String toString() {
        return "Name: " + name + ","
                + " Цена: " + price + ","
                + " ID для заказа: " + goodID;
    }

    //public abstract String printCharacteristics();
}


