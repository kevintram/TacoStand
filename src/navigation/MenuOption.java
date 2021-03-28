package navigation;

/**
 * A data class for storing an option and its description and how to handle when it's chosen.
 */
public final class MenuOption {
    private final String option;
    private String description; // nullable
    private final OnOptionChosenListener onOptionChosenListener;

    public MenuOption(String option, OnOptionChosenListener onOptionChosenListener) {
        this(option, null, onOptionChosenListener);
    }

    public MenuOption(String option, String description, OnOptionChosenListener onOptionChosenListener) {
        this.option = option;
        this.description = description;
        this.onOptionChosenListener = onOptionChosenListener;
    }

    public String getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasDescription() {
        return description != null;
    }

    public OnOptionChosenListener getOnChooseListener() {
        return onOptionChosenListener;
    }
}
