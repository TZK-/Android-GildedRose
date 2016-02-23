package fr.iutvalence.info.m4104.gildedroseinn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
    }

    public void homeActivityClickListener(View view) {
        switch (view.getId()) {
            case R.id.shop_button:
                startShopActivity();
                break;
            case R.id.inventory_button:
                startInventoryActivity();
                break;
            case R.id.next_button:
                nextDay();
                break;
            default:
        }
    }

    private void nextDay() {
        GildedRoseApplication app = (GildedRoseApplication) this.getApplication();
        app.incrementNbDays();

        TextView daysText = (TextView) this.findViewById(R.id.day_text);
        daysText.setText("Day " + app.getDaysPassed());
        daysText.invalidate();

        for(Item i: app.getShop())
            GildedRose.updateItem(i);
        for(Item i: app.getInventory())
            GildedRose.updateItem(i);
    }

    private void startInventoryActivity() {
        this.startActivity(new Intent(this, InventoryActivity.class));
    }

    private void startShopActivity() {
        this.startActivity(new Intent(this, ShopActivity.class));
    }

}
