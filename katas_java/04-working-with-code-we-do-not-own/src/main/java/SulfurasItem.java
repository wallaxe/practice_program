import items.Item;

public class SulfurasItem extends InventoryItem {

    public SulfurasItem(Item item) {
        super(item);
    }

    @Override
    protected int calculateQualityRate() {
        return 1;
    }
}
