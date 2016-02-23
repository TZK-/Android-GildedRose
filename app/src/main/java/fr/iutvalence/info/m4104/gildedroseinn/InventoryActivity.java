package fr.iutvalence.info.m4104.gildedroseinn;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class InventoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.inventory_layout);

        InventoryItemAdapter itemAdapter = new InventoryItemAdapter(this, ((GildedRoseApplication) this.getApplication()).getInventory());

        ListView itemsView = (ListView) this.findViewById(R.id.itemsView);
        itemsView.setAdapter(itemAdapter);


    }
}
