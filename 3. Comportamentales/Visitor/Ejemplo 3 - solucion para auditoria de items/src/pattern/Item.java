package pattern;

public interface Item {
    void accept(ItemVisitor visitor);
}
