package com.gildedrose;

public class GildedRose {
    private static final int MAX_QUALITY = 50;
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItem() {
        for (Item item : items) {
            updateQuality(item);
            updateSellIn(item);
        }
    }

    public void updateSellIn(Item item) {
        if (item.name != "Sulfuras, Hand of Ragnaros") {
            item.sellIn--;
        }
    }

    public void updateQuality(Item item) {
        if (qualityIsCorrect(item) == true) {
            switch (item.name) {
                case "Aged Brie":
                    updateAgedBrie(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstagePasses(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    updateLegendary(item);
                    break;
                case "Conjured Mana Cake":
                    updateConjured(item);
                    break;
                default:
                    updateDefault(item);
            }
        }
    }

    public boolean qualityIsCorrect(Item item){
        if (item.quality>=0 && item.quality<=MAX_QUALITY){
            return true;
        }
        else{
            return false;
        }
    }

    public void updateAgedBrie(Item item){
            if(item.sellIn>=0){
                item.quality ++;
            }
            else{
                item.quality +=2;
            }
    }

    public void updateBackstagePasses(Item item){
            if(item.sellIn <=10){
                item.quality +=2;
            } else if (item.sellIn<=5){
                item.quality +=3;
            } else if (item.sellIn<=0){
                item.quality=0;
            }
    }

    public void updateLegendary(Item item){
        //Nothing happens
    }

    public void updateConjured(Item item){
            item.quality -=2;
        }

    public void updateDefault(Item item){
            item.quality -=1;
        }
}
