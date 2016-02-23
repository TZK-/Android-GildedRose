package fr.iutvalence.info.m4104.gildedroseinn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import fr.iutvalence.info.m4104.gildedroseinn.utils.ObjectSerializer;

import java.io.IOException;


public class HomeActivity extends Activity {

    private GildedRoseApplication app;

    private CountDownTimer timer;

    public HomeActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        this.app = (GildedRoseApplication) this.getApplication();
        this.refreshDays();

        this.timer = new CountDownTimer(5000, 20) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Nothing to do
            }

            @Override
            public void onFinish() {
                try {
                    HomeActivity.this.nextDay();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
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
        this.app.incrementNbDays();
        this.refreshDays();

        for (Item i : this.app.getShop())
            GildedRose.updateItem(i);
        for (Item i : this.app.getInventory())
            GildedRose.updateItem(i);
        this.timer.start();
    }

    private void refreshDays() {
        TextView daysText = (TextView) this.findViewById(R.id.day_text);
        daysText.setText("Days " + this.app.getDaysPassed());
        daysText.invalidate();
    }

    private void startInventoryActivity() {
        this.startActivity(new Intent(this, InventoryActivity.class));
    }

    private void startShopActivity() {
        this.startActivity(new Intent(this, ShopActivity.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.app.savePreferences();
    }
}
