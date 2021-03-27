package navigation;

import java.util.Stack;

/**
 * Singleton for managing the current menu and navigation between menus.
 */
public class MenuController {
    private static MenuController instance = null;
    private final Stack<Menu> backStack;

    private MenuController() {
        backStack = new Stack<>();
    }

    public static MenuController getInstance() {
        if (instance == null) {
            synchronized (MenuController.class) {
                if (instance == null) {
                    instance = new MenuController();
                }
            }
        }
        return instance;
    }

    public void navigate(Menu menu) {
        menu.onNavigated();
        backStack.push(menu);
    }

    public void popBackStack() {
        backStack.pop();

        while (backStack.peek().isPopBackStackInclusive()) {
            backStack.pop();
        }

        backStack.peek().onNavigated();
    }

    public boolean isEmpty() {
        return backStack.isEmpty();
    }

    public Menu getCurrMenu() {
        return backStack.peek();
    }
}
