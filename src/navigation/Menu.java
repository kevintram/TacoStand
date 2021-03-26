package navigation;

import java.util.ArrayList;

/**
 * Class that represents a menu with a prompt and options.
 */
public abstract class Menu {
    protected ArrayList<MenuOption> options;
    protected String prompt;

    /**
     * Set the prompt.
     */
    protected abstract void onSetPrompt();

    /**
     * Set the options.
     */
    protected abstract void onSetOptions();

    /**
     * @return Indicates whether the navController should
     * continue popping after popping this menu.
     */
    public abstract boolean isPopBackStackInclusive();

    public final void print() {
        System.out.println(prompt + ":");
        for (int i = 0; i < options.size(); i++) {
            MenuOption o = options.get(i);

            System.out.println(i + 1 + ". " + o.getOption());
            if (o.hasDescription()) {
                System.out.println("\t- " + o.getDescription());
            }
        }
    }

    public final void choose(int choice) {
        options.get(choice - 1).getOnChooseListener().onChoose();
    }
}

