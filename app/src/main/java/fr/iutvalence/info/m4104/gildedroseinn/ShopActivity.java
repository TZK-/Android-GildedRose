package fr.iutvalence.info.m4104.gildedroseinn;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;


public class ShopActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_layout);

        ShopItemAdapter itemAdapter = new ShopItemAdapter(this, ((GildedRoseApplication) this.getApplication()).getShop());

        ListView itemsView = (ListView) this.findViewById(R.id.itemsView);
        itemsView.setAdapter(itemAdapter);
    }

}
