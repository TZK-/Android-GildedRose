package fr.iutvalence.info.m4104.gildedroseinn;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ShopItemAdapter extends ArrayAdapter<Item> {

    private final Activity activity;

    public ShopItemAdapter(Activity activity, List<Item> items) {
        super(activity, 0, items);
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Item item = this.getItem(position);
        LayoutInflater li = LayoutInflater.from(this.getContext());
        View v = li.inflate(R.layout.shop_item_layout, parent, false);

        TextView name = (TextView) v.findViewById(R.id.name);
        name.setText(item.getName());

        TextView price = (TextView) v.findViewById(R.id.price);
        price.setText(Integer.toString(item.getSellIn()));

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GildedRoseApplication app = (GildedRoseApplication) ShopItemAdapter.this.activity.getApplication();
                app.addInventoryItem(item);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(ShopItemAdapter.this.getContext());

                alertBuilder
                        .setTitle("Achat confirmé")
                        .setMessage("L'item " + item.getName() + " a bien été acheté !")
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel(); // Just close the dialog
                            }
                        });

                AlertDialog alert = alertBuilder.create();
                alert.show();
            }
        });

        return v;
    }
}
