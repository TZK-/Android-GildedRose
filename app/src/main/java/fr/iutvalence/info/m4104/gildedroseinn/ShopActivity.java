package fr.iutvalence.info.m4104.gildedroseinn;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;


public class ShopActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_layout);

        GildedRoseApplication app = (GildedRoseApplication) this.getApplication();

        TextView money = (TextView) this.findViewById(R.id.money);
        money.setText(money.getText() + " " + app.getMoney());
        money.invalidate();

        ShopItemAdapter itemAdapter = new ShopItemAdapter(this, ((GildedRoseApplication) this.getApplication()).getShop());

        ListView itemsView = (ListView) this.findViewById(R.id.itemsView);
        itemsView.setAdapter(itemAdapter);
    }

}
