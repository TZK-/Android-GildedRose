package fr.iutvalence.info.m4104.gildedroseinn;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseApplication extends Application {

    private List<Item> shop;

    private List<Item> inventory;

    public GildedRoseApplication() {
        super();
        this.shop = new ArrayList<>();
        this.inventory = new ArrayList<>();
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

    public void addShopItem(Item i){
        this.shop.add(i);
    }

    public void addInventoryItem(Item i){
        this.inventory.add(i);
    }

    public void removeInventoryItem(Item i){
        this.inventory.remove(i);
    }

    public List<Item> getShop() {
        return this.shop;
    }

    public List<Item> getInventory() {
        return this.inventory;
    }
}
