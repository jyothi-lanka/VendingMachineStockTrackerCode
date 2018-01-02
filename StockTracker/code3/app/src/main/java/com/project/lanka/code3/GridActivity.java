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
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

public class GridActivity extends AppCompatActivity {

//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//    }
//    private List<Product> products = DataProvider.productList;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_grid);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    }
//
////    ProductListAdapter adapter = new ProductListAdapter(this, R.layout.grid_list,products);
////    GridView gv = (GridView) findViewById(R.id.gridView);
////    gv.setAdapter(adapter);
////
////    gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////        @Override
////        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////            Intent intent = new Intent(MainActivity.this,DetailActivity.class);
////
////            Product product = products.get(position);
////            intent.putExtra(PRODUCT_ID, product.getProductId());
////
////            startActivityForResult(intent, DETAIL_REQUEST);
////
////        }
////    });
//
//    ProductListAdapter adapter = new ProductListAdapter(this, R.layout.list_item,products);
//    ListView lv = (ListView) findViewById(R.id.listView);
//    lv.setAdapter(adapter);
//
//    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Intent intent = new Intent(MainActivity.this,DetailActivity.class);
//
//            Product product = products.get(position);
//            intent.putExtra(PRODUCT_ID, product.getProductId());
//
//            startActivityForResult(intent, DETAIL_REQUEST);
//
//        }
//    });

    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private List<Product> products;

    public static final String GRID_ID = "GRID_ID";

    private static final int DETAIL_REQUEST =1111;
    public static final String RETURN_MESSAGE="RETURN_MESSAGE";

    public static  String[] items ;

    private static String email = "info@hplussport.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                String[] addresses = {email};
//                Intent intent = new Intent(Intent.ACTION_SENDTO);
//                intent.setData(Uri.parse("mailto:"));
//                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Information request");
//                intent.putExtra(Intent.EXTRA_TEXT, "Please send some information!");
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//                }
//            }
//        });

        items = getResources().getStringArray(R.array.displayitems);
//        String[] items = getResources().getStringArray(R.array.displayitems);
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,items);
        DataProvider.setProductData("gridview");
        products = DataProvider.productList;
        GridAdapter adapter = new GridAdapter(this, R.layout.grid_list,products);
        GridView gv = (GridView) findViewById(R.id.gridView);
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GridActivity.this,MainActivity.class);
                DataProvider.setProductData("gridview");
                products = DataProvider.productList;

                Product product = products.get(position);
                intent.putExtra(GRID_ID, product.getProductId());
                System.out.println("Product id:" + product.getProductId());
                startActivity(intent);

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
        if (id == android.R.id.home) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
