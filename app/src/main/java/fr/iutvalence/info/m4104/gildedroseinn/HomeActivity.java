package fr.iutvalence.info.m4104.gildedroseinn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
    }
    public void homeActivityClickListener(View view)
    {
        switch (view.getId())
        {
            case R.id.shop_button :
                startShopActivity();
                break;
            case R.id.inventory_button :
                startInventoryActivity();
                break;
            case R.id.next_button :
                nextDay();
                break;
            default :
        }
    }

    private void nextDay()
    {
        // TODO Auto-generated method stub

    }

    private void startInventoryActivity()
    {
        this.startActivity(new Intent(this, InventoryActivity.class));
    }

    private void startShopActivity()
    {
        this.startActivity( new Intent(this, ShopActivity.class));
    }

}
