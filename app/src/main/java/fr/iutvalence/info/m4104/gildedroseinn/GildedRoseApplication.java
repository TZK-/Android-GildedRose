package fr.iutvalence.info.m4104.gildedroseinn;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseApplication extends Application {

    private List<Item> shop;

    private List<Item> inventory;

    private int daysPassed;

    private int money;

    public GildedRoseApplication() {
        super();
        this.shop = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.daysPassed = 0;
        this.money = 50;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.generateShop();
    }

    private void generateShop() {
        this.addShopItem(new Item("+5 Dexterity Vest", 10, 20));
        this.addShopItem(new Item("Aged Brie", 2, 0));
        this.addShopItem(new Item("Elixir of the Mongoose", 5, 7));
        this.addShopItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        this.addShopItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
        this.addShopItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        this.addShopItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        this.addShopItem(new Item("Conjured Mana Cake", 3, 6));
    }

    public void addShopItem(Item i) {
        this.shop.add(i);
    }

    public void addInventoryItem(Item i) {
        this.inventory.add(i);
    }

    public List<Item> getShop() {
        return this.shop;
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

    public int getDaysPassed() {
        return this.daysPassed;
    }

    public void incrementNbDays() {
        this.daysPassed++;
    }

    public void decreaseMoney(int money) {
        this.money -= money;
    }

    public int getMoney() {
        return money;
    }

    /**
     * Buy an item.
     *
     * @param i The item to buy
     * @return <tt>true</tt> if the item can be bought, <tt>false</tt> otherwise (no money)
     */
    public boolean buyItem(Item i) {
        if (this.money < i.getSellIn())
            return false;
        this.addInventoryItem(i);
        this.decreaseMoney(i.getSellIn());
        return true;
    }
}
