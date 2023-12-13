package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void defaultProductQualityMinOne() {
        Item[] items = new Item[]{
                new Item("foo", 5, 3)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals("foo", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void defaultProductQualityPositive() {
        Item[] items = new Item[]{
                new Item("banana", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals("banana", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void AgedBrieQualityPlusOne() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 2, 5)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        //AgedBrie
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void AgedBrieQualityMaxFifty() {
        Item[] items = new Item[]{
                new Item("Aged Brie", -1, 49)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        //AgedBrie
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void AgedBrieSellingPassed() {
        Item[] items = new Item[]{
                new Item("Aged Brie", -1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    public void Legendary() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 5, 5)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void Conjured() {
        Item[] items = new Item[]{
                new Item("Conjured Mana Cake", 5, 5)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void BackstagePassMoreThanTen() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 14, 5)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(13, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void BackstagePassTenDaysOrLess() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 7, 5)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(6, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    public void BackstagePassFiveDaysOrLess() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 5)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void BackstagePassConcertPassed() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}