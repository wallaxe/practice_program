import items.Item;

public class InventoryItem {

    public Item item;


    public InventoryItem(Item item) {
        this.item = item;
    }


    int BASE_DEGRADE_QUALITY = -1;
    int DOUBLE_DEGRADE_QUALITY = -2;

    protected int MAX_QUALITY = 6000;
    int MIN_QUALITY = 0;

    public void Update() {
        item.sellIn -= 1;

        int qualityRate = calculateQualityRate();

        item.quality = limitQuality(item.quality + qualityRate);
    }

    protected int calculateQualityRate(){
        int degradeQuality = BASE_DEGRADE_QUALITY;
        if (item.sellIn<0)
        {
            degradeQuality = DOUBLE_DEGRADE_QUALITY;
        }
        return degradeQuality;
    }

    private int limitQuality(int quality){
       if(quality < MIN_QUALITY){
           return MIN_QUALITY;
       }

       if(quality > MAX_QUALITY){
            return MAX_QUALITY;
        }

        return quality;
    }

    protected void IncreaseQuality(){
        item.quality += 1;
    }
}
