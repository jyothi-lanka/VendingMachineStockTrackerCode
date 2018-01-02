package com.project.lanka.code3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private List<Product> products;

    public static final String PRODUCT_ID = "PRODUCT_ID";
    public  static final String GRID_PRODUCT_ID ="GRID_PRODUCT_ID";
    String  gridproduct;
    public String PRODUCT_ID_GRIDACTIVITY ;

    private static final int DETAIL_REQUEST =1111;
    public static final String RETURN_MESSAGE="RETURN_MESSAGE";

    public static  String[] items ;

    private static String email = "info@vendosupport.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Send an email
                String[] addresses = {email};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Information request");
                intent.putExtra(Intent.EXTRA_TEXT, "Please send some information!");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

 //       items = getResources().getStringArray(R.array.displayitems);
//        String[] items = getResources().getStringArray(R.array.displayitems);
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,items);



        gridproduct = getIntent().getStringExtra(GridActivity.GRID_ID);
        System.out.println("gridproduct from GRID_ID" + gridproduct);


        DataProvider.setProductData(gridproduct);

        products = DataProvider.productList;
        ProductListAdapter adapter = new ProductListAdapter(this, R.layout.list_item,products);


        final Product product = DataProvider.productMap.get(gridproduct);

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);

                Product product = products.get(position);
                intent.putExtra(PRODUCT_ID, product.getProductId());
                intent.putExtra(GRID_PRODUCT_ID,gridproduct);
                startActivityForResult(intent, DETAIL_REQUEST);

            }
        });
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
//        if (id == android.R.id.home) {
//            return true;
//        }

        switch (id) {
            case R.id.action_settings:
                Snackbar.make(coordinatorLayout,
                        "You selected settings", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;
            case R.id.about:
//                Snackbar.make(coordinatorLayout,
//                        "You selected About", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);

                return true;
            case R.id.cart:
                Snackbar.make(coordinatorLayout,
                        "You selected the Shopping Cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;
            case R.id.order:
                Snackbar.make(coordinatorLayout,
                        "You selected the Orders", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;
            case R.id.logout:
                Snackbar.make(coordinatorLayout,
                        "You selected Logout", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==DETAIL_REQUEST)
        {
            if(resultCode==RESULT_OK)
            {
                String message = data.getStringExtra(RETURN_MESSAGE);

                System.out.print("RETURN_MESSAGE"+ message);
                        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG).setAction("Go to Orders", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Going to Order", Toast.LENGTH_SHORT).show();

                            }
                        }).show();
            }
        }
    }
}
