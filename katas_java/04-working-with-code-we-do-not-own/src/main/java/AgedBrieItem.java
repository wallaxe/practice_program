import items.Item;

public class AgedBrieItem extends InventoryItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    protected int calculateQualityRate() {
        return 1;
    }
}
