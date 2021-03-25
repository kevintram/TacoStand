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
     * @return the prompt.
     */
    protected abstract String onSetPrompt();

    /**
     * Set the options.
     * @return the options
     */
    protected abstract ArrayList<MenuOption> onSetOptions();

    /**
     * @return Indicates whether the navController should
     * continue popping after popping this menu.
     */
    public abstract boolean isPopBackStackInclusive();

    public Menu() {
        prompt = onSetPrompt();
        options = onSetOptions();
    }

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

