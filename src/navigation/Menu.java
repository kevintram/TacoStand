package navigation;

import java.util.ArrayList;

/**
 * Class that represents a menu with a prompt and options.
 */
public abstract class Menu {
    protected ArrayList<MenuOption> options;
    protected String prompt;

    /**
     * Called whenever this menu is navigated to. This is where your menu
     * should update its state if it has any.
     */
    public void onNavigated() {
        onSetPrompt();
        onSetOptions();
    }

    /**
     * Set the prompt.
     */
    protected void onSetPrompt() {
        prompt = getPrompt();
    }

    /**
     * Set the options.
     */
    protected void onSetOptions() {
        options = getOptions();
    }

    /**
     * @return the menu prompt.
     */
    protected abstract String getPrompt();

    /**
     *
     * @return the array of options
     */
    protected abstract ArrayList<MenuOption> getOptions();

    /**
     * @return Indicates whether the navController should
     * continue popping after popping this menu.
     */
    public abstract boolean isPopBackStackInclusive();

    /**
     * Override this to print something after the prompt but before the options.
     */
    public void printPrefix() {}

    public final void print() {
        System.out.println(prompt + ":");
        printPrefix();
        for (int i = 0; i < options.size(); i++) {
            MenuOption o = options.get(i);

            System.out.println(i + 1 + ". " + o.getOption());
            if (o.hasDescription()) {
                System.out.println("\t- " + o.getDescription());
            }
        }
    }

    public final void choose(int choice) {
        if (choice <= options.size()) {
            options.get(choice - 1).getOnChooseListener().onChoose();
        }
    }
}

