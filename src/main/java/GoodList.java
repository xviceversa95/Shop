import Categories.Category;
import Categories.Dishes;
import Categories.Furniture;
import Categories.Good;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class GoodList implements GoodTaker {
    List<Furniture> furnitureList;
    List<Dishes> dishesList;

    // Получаем список товаров:
    public List<Furniture> getFurnitureList(Category category) {
        if (category == Category.FURNITURE) {
            try {
                File file = new File(Category.FURNITURE.getPath());
                ObjectMapper objectMapper = new ObjectMapper();
                furnitureList = objectMapper.readValue(file, new TypeReference<>() {
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return furnitureList;
    }

    public List<Dishes> getDishesList(Category category) {
        if (category == Category.DISHES) {
            try {
                File file = new File(Category.DISHES.getPath());
                ObjectMapper objectMapper = new ObjectMapper();
                dishesList = objectMapper.readValue(file, new TypeReference<>() {
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return dishesList;
    }

    public void printGoodList(List<? extends Good> goodList) {
        if (goodList == null) {
            System.out.println("Нет доступных для покупки товаров");
        } else {
            for (Good good : goodList) {
                System.out.println(good);
            }
        }
    }
    @Override
    public Good takeGoodById(int takeID, String category) {
        Good goodTest = null;
        if (category.equals("посуда")) {
            for (Dishes good : dishesList) {
                if (good.goodID == takeID) {
                    goodTest = good;
                }
            }
        }
        if (category.equals("мебель")) {
            for (Furniture good : furnitureList) {
                if (good.goodID == takeID) {
                    goodTest = good;
                }
            }
        }
        return goodTest;
    }
}






