package Util;

import orderable.Protein;
import orderable.Topping;

/**
 * Global directory for all foods.
 */
public final class FoodDirectory {
    // Prices
    private static final float EXPENSIVE_PROTEIN_PRICE = 3.49f;
    private static final float CHEAP_PROTEIN_PRICE = 3.00f;
    private static final float EXPENSIVE_TOPPING_PRICE = .5f;
    private static final float CHEAP_TOPPING_PRICE = .2f;

    // Expensive Proteins
    public static final Protein STEAK = new Protein("Steak", EXPENSIVE_PROTEIN_PRICE);
    public static final Protein SHRIMP =  new Protein("Shrimp", EXPENSIVE_PROTEIN_PRICE);
    // Cheap Proteins
    public static final Protein CHICKEN = new Protein("Chicken", CHEAP_PROTEIN_PRICE);
    public static final Protein PORK = new Protein("Pork", CHEAP_PROTEIN_PRICE);
    public static final Protein BEANS = new Protein("Beans", CHEAP_PROTEIN_PRICE);

    public static final Protein[] PROTEINS = { STEAK, SHRIMP, CHICKEN, PORK, BEANS };

    // Expensive Toppings
    public static final Topping GUAC = new Topping("Guac", EXPENSIVE_TOPPING_PRICE);
    public static final Topping SALSA = new Topping("Salsa", EXPENSIVE_TOPPING_PRICE);
    public static final Topping CHILI_SAUCE = new Topping("Chili Sauce", EXPENSIVE_TOPPING_PRICE);
    // Cheap Toppings
    public static final Topping LETTUCE = new Topping("Lettuce", CHEAP_TOPPING_PRICE);
    public static final Topping CORN = new Topping("Corn", CHEAP_TOPPING_PRICE);
    public static final Topping CABBAGE = new Topping("Cabbage", CHEAP_TOPPING_PRICE);
    public static final Topping RED_ONION = new Topping("Red Onion", CHEAP_TOPPING_PRICE);
    public static final Topping RICE = new Topping("Rice", CHEAP_TOPPING_PRICE);
    public static final Topping CHEESE = new Topping("Cheese", CHEAP_TOPPING_PRICE);

    public static final Topping[] TOPPINGS = { GUAC, SALSA, CHILI_SAUCE, LETTUCE, CORN, CABBAGE, RED_ONION, RICE, CHEESE };
}
