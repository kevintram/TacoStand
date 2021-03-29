package orderable;

public class DoubleDeckerTaco extends Taco {
    private FoodBase innerTaco;

    public DoubleDeckerTaco(FoodBase innerTaco, Protein outerProtein) {
        super(outerProtein);
        this.innerTaco = innerTaco;
    }

    @Override
    public float getPrice() {
        return super.getPrice() + innerTaco.getPrice();
    }

    @Override
    public String getString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(super.getString())
                .append(" stuffed with")
                .append(removePrice(innerTaco.getString()));
        return sb.toString();
    }

    private String removePrice(String s) {
        return s.replaceAll("\\$(\\d+\\.\\d{2})", "");
    }

    public FoodBase getInnerTaco() {
        return innerTaco;
    }
}
