package Categories;

public enum Category {
    DISHES("посуда", "C://Users/Anna/IdeaProjects/Shoptest/src/main/resources/dishes.json" ),
    FURNITURE("мебель", "C://Users/Anna/IdeaProjects/Shoptest/src/main/resources/furniture.json");

    private String title;
    private String path;


    Category(String title, String path) {
        this.title = title;
        this.path = path;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }
}
