package menus;

import navigation.Menu;
import navigation.MenuOption;
import orderable.*;

import java.util.ArrayList;

public class ChooseSignatureOrCustomMenu extends Menu {
    FoodBaseType foodBaseType;

    ChooseSignatureOrCustomMenu(FoodBaseType foodBaseType) {
        super();
        this.foodBaseType = foodBaseType;
    }

    @Override
    protected String getPrompt() {
        return "Choose a signature or build your own";
    }

    @Override
    protected ArrayList<MenuOption> getOptions() {
        ArrayList<MenuOption> options = new ArrayList<>();

        options.add(new MenuOption(
                "Bada Beef Bada Boom",
                "steak, lettuce, corn, guac",
                () -> {
                    FoodBase food = getFood(foodBaseType, FoodDirectory.STEAK);
                    food = new ToppingDecorator(food, FoodDirectory.LETTUCE);
                    food = new ToppingDecorator(food, FoodDirectory.CORN);
                    food = new ToppingDecorator(food, FoodDirectory.GUAC);
                }
        ));

        options.add(new MenuOption(
                "The Big Bean",
                "beans, lettuce, salsa, corn",
                () -> {
                    FoodBase food = getFood(foodBaseType, FoodDirectory.BEANS);
                    food = new ToppingDecorator(food, FoodDirectory.LETTUCE);
                    food = new ToppingDecorator(food, FoodDirectory.SALSA);
                    food = new ToppingDecorator(food, FoodDirectory.CORN);
                }
        ));

        options.add(new MenuOption(
                "The Shrimp Shack",
                "shrimp, chili sauce, red onion",
                () -> {
                    FoodBase food = getFood(foodBaseType, FoodDirectory.SHRIMP);
                    food = new ToppingDecorator(food, FoodDirectory.CHILI_SAUCE);
                    food = new ToppingDecorator(food, FoodDirectory.RED_ONION);
                }
        ));

        options.add(new MenuOption(
                "Build your own",
                () -> {

                }
        ));

        return options;
    }

    private FoodBase getFood(FoodBaseType foodBaseType, Protein protein) {
        return switch (foodBaseType) {
            case TACO -> new Taco(protein);
            case BURRITO -> new Burrito(protein);
            case BOWL -> new Bowl(protein);
        };
    }

    @Override
    public boolean isPopBackStackInclusive() {
        return false;
    }

    /**
     * FoodBase types supported by this menu
     */
    enum FoodBaseType {
        TACO,
        BURRITO,
        BOWL
    }
}
