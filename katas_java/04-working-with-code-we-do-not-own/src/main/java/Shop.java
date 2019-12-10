import items.Item;

public class Shop {

    private Item[] items;

    public Shop(Item[] items) {

        this.items = items;
    }

    public void updateInventory() {
        for (Item item: items) {
            CreateInventoryItem(item).Update();
        }
    }


    private InventoryItem CreateInventoryItem(Item item) {
        switch (item.name){
            case "Aged Brie":
                return new AgedBrieItem(item);
            default:
                return new InventoryItem(item);
        }
    }


}
