package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class FoodRatings {

    Map<String, Food> highestRating = new HashMap<>();
    Map<String, Food> foodMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], ratings[i], i);
            foodMap.put(foods[i], food);
        }
    }

    public void changeRating(String food, int newRating) {

    }

    public String highestRated(String cuisine) {
        return highestRating.get(cuisine).name;
    }

    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};

        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);

//        // Вызов метода changeRating
//        foodRatings.changeRating("sushi", 16);

        // Вызов метода highestRated
        String highestRating = foodRatings.highestRated("japanese");
        System.out.println("Highest rated Japanese cuisine: " + highestRating);

//        // Еще вызов метода changeRating
//        foodRatings.changeRating("ramen", 16);
//
//        // Еще один вызов метода highestRated
//        highestRating = foodRatings.highestRated("japanese");
//        System.out.println("Updated highest rated Japanese cuisine: " + highestRating);

    }
}

class Food {

    String name;

    int rating;

    int index;

    public Food(String name, int rating, int index) {
        this.name = name;
        this.rating = rating;
        this.index = index;
    }
}
