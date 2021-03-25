package navigation;

public final class MenuOption {
    private final String option;
    private String description; // nullable
    private final OnChooseListener onChooseListener;

    public MenuOption(String option, OnChooseListener onChooseListener) {
        this(option, null, onChooseListener);
    }

    public MenuOption(String option, String description, OnChooseListener onChooseListener) {
        this.option = option;
        this.description = description;
        this.onChooseListener = onChooseListener;
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

    public OnChooseListener getOnChooseListener() {
        return onChooseListener;
    }
}
