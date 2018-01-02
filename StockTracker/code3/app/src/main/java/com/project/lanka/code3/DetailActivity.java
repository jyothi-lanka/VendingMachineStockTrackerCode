package com.project.lanka.code3;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;

public class DetailActivity extends AppCompatActivity {

    private static final int SUPPLIER_REQUEST =1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String intent = getIntent().getStringExtra(MainActivity.PRODUCT_ID);

        final Product product = DataProvider.productMap.get(intent);

        TextView tv = (TextView) findViewById(R.id.nameText);
        tv.setText(product.getName());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(product.getPrice());
        TextView pv =(TextView) findViewById(R.id.priceText);
        pv.setText(price);

        TextView dv = (TextView) findViewById(R.id.descriptionText);
        dv.setText(product.getDescription());

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(getBitmapFromAssest(product.getProductId()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra(MainActivity.RETURN_MESSAGE, " The Items Ordered");
                setResult(RESULT_OK, data);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        Button supplierbutton = (Button) findViewById(R.id.supplierbutton);

        supplierbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, SupplierActivity.class);
                startActivity(intent);
            }
        });
    }
    private Bitmap getBitmapFromAssest(String productId)
    {
        AssetManager assetManager = getAssets();
        InputStream stream =null;

        try {
            stream = assetManager.open(productId+".png");
            return BitmapFactory.decodeStream(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
