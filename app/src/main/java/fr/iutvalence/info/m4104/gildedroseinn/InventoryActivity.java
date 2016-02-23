package fr.iutvalence.info.m4104.gildedroseinn;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class InventoryActivity extends Activity {

    private GildedRoseApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.app = (GildedRoseApplication) this.getApplication();

        this.setContentView(R.layout.inventory_layout);

        InventoryItemAdapter itemAdapter = new InventoryItemAdapter(this, ((GildedRoseApplication) this.getApplication()).getInventory());

        ListView itemsView = (ListView) this.findViewById(R.id.itemsView);
        itemsView.setAdapter(itemAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.app.savePreferences();
    }
}
