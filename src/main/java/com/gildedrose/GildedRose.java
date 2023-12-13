package com.gildedrose;

public class GildedRose {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    public Item[] items;

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
        if (qualityIsCorrect(item)) {
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

    public void maxQuality(Item item){
        item.quality = Math.min(MAX_QUALITY, item.quality);
    }

    public void minQuality(Item item){
        item.quality = Math.max(MIN_QUALITY, item.quality);
    }

    public void updateAgedBrie(Item item){
            if(item.sellIn>=0){
                item.quality ++;
                maxQuality(item);
            }
            else{
                item.quality +=2;
                maxQuality(item);
            }
    }

    public void updateBackstagePasses(Item item){
        if(item.sellIn>10){
                item.quality ++;
                maxQuality(item);
            } else if (item.sellIn <=10 && item.sellIn>5){
                item.quality +=2;
                maxQuality(item);
            } else if (item.sellIn<=5 && item.sellIn>0){
                item.quality +=3;
                maxQuality(item);
            } else if (item.sellIn<=0) {
                item.quality = 0;
            }
    }

    public void updateLegendary(Item item){
        //Nothing happens
    }

    public void updateConjured(Item item){
            item.quality -=2;
            minQuality(item);
        }

    public void updateDefault(Item item){
            item.quality -=1;
            minQuality(item);
        }
}
