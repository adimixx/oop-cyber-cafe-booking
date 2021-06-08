package Model;

public class ComboBoxItem {
    private final String label;
    private final Object value;

    public ComboBoxItem(String label, Object value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public Object getValue() {
        return value;
    }
}
