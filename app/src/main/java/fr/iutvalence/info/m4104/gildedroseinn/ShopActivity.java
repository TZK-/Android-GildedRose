package fr.iutvalence.info.m4104.gildedroseinn;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;


public class ShopActivity extends ActionBarActivity {

    private GildedRoseApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.app = (GildedRoseApplication) this.getApplication();

        setContentView(R.layout.shop_layout);

        GildedRoseApplication app = (GildedRoseApplication) this.getApplication();

        this.refreshMoney();

        ShopItemAdapter itemAdapter = new ShopItemAdapter(this, ((GildedRoseApplication) this.getApplication()).getShop());

        ListView itemsView = (ListView) this.findViewById(R.id.itemsView);
        itemsView.setAdapter(itemAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.app.savePreferences();
    }

    public void refreshMoney(){
        TextView money = (TextView) this.findViewById(R.id.money);
        money.setText("Money: " + app.getMoney());
        money.invalidate();
    }
}
