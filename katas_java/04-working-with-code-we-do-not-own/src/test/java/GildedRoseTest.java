import items.Item;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GildedRoseTest {


    @Test
    public void agedBrieGainsQualityTheOlderItGets()
    {
        Item item = new Item("Aged Brie",1,1);

        Shop shop = new Shop(new Item[]{item});

        shop.updateInventory();

        assertThat(item.quality, is(2));
    }

    @Test
    public void SulfurasNeverHasSoldNotDecreaseQuality()
    {
        Item item = new Item("Sulfuras",1,1);

        Shop shop = new Shop(new Item[]{item});

        shop.updateInventory();

        assertThat(item.quality, is(2));
    }

    @Test
    public void degradeTwiceAsFastWhenDateHasPassed()
    {
        Item item = new Item("GolddCoin",0,4);

        Shop shop = new Shop(new Item[]{item});

        shop.updateInventory();

        assertThat(item.quality, is(2));
    }

    @Test
    public void qualityCantBeNegative()
    {
        Item item = new Item("GolddCoin",0,0);

        Shop shop = new Shop(new Item[]{item});

        shop.updateInventory();

        assertThat(item.quality, is(0));
    }

    @Test
    public void sellInAndQualityEqualTwoDecreaseToOne()
    {
        Item item = new Item("GolddCoin",2,2);

        Shop shop = new Shop(new Item[]{item});

        shop.updateInventory();

        assertThat(item.toString(), is(new Item("GolddCoin",1,1).toString()));
    }

    @Test
    public void sellInAndQualityEqualThreeDecreaseToTwo()
    {
        Item item = new Item("GolddCoin",3,3);

        Shop shop = new Shop(new Item[]{item});

        shop.updateInventory();

        assertThat(item.toString(), is(new Item("GolddCoin",2,2).toString()));
    }


}
