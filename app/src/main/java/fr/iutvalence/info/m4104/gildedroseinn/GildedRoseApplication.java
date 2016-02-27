package fr.iutvalence.info.m4104.gildedroseinn;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import fr.iutvalence.info.m4104.gildedroseinn.utils.ObjectSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GildedRoseApplication extends Application {

    private final static int DEFAULT_MONEY = 100;

    private final static int DEFAULT_DAYS_PASSED = 0;

    private SharedPreferences prefs;

    private List<Item> shop;

    private List<Item> inventory;

    private int daysPassed;

    private int money;

    public GildedRoseApplication() {
        super();
        this.shop = new ArrayList<Item>();
        this.inventory = new ArrayList<Item>();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.prefs = this.getSharedPreferences("GildedRose", Context.MODE_PRIVATE);
        this.generateShop();
        this.loadPreferences();
    }

    public void loadPreferences() {
        try {
            String emptyArrayList = ObjectSerializer.toString(new ArrayList<Item>());
            this.inventory = (ArrayList<Item>) ObjectSerializer.fromString(this.prefs.getString("InventoryItems",
                    emptyArrayList));
            this.daysPassed = this.prefs.getInt("Days", DEFAULT_DAYS_PASSED);
            this.money = this.prefs.getInt("Money", DEFAULT_MONEY);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void savePreferences() {
        SharedPreferences.Editor editor = this.prefs.edit();
        try {
            editor.putString("InventoryItems", ObjectSerializer.toString(this.getInventory()));
            editor.putInt("Days", this.getDaysPassed());
            editor.putInt("Money", this.getMoney());
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.commit();
    }

    /**
     * Clear the SharedPreferences file.
     * Used for tests
     */
    public void clearPreferences() {
        SharedPreferences.Editor editor = this.prefs.edit();
        editor.clear();
        editor.commit();
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
        return this.money;
    }

    public void increaseMoney(int money) {
        this.money += money;
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
