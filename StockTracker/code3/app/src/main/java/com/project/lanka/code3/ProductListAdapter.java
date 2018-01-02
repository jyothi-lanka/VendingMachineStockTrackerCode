package com.project.lanka.code3;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.List;

public class ProductListAdapter extends ArrayAdapter<Product>{

    private List<Product> products;

    public ProductListAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        products = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item, parent, false);
        }

        Product product = products.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.nameText);
        nameText.setText(product.getName());

//        NumberFormat formatter = NumberFormat.getCurrencyInstance();
//        String price = formatter.format(product.getPrice());
//        TextView priceText = (TextView) convertView.findViewById(R.id.priceText);
//        priceText.setText(price);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        imageView.setImageBitmap(getBitmapFromAssest(product.getProductId()));


//        switch (product.getProductId()){
//            case "coke": priceText.setBackgroundColor(Color.RED);
//                         break;
//            case "lays": priceText.setBackgroundColor(Color.YELLOW);
//                         break;
//        }
        //            case items[1]:priceText.setBackgroundColor(Color.YELLOW);
//                            break;


//        if(product.getProductId().equalsIgnoreCase(MainActivity.items[2])){
//        String[] items = MainActivity.getResources().getStringArray(R.array.displayitems);
//            convertView.setBackgroundColor(Color.GRAY);
//        }
        return convertView;
    }
    private Bitmap getBitmapFromAssest(String productId)
    {
        AssetManager assetManager = getContext().getAssets();
        InputStream stream =null;

        try {
            stream = assetManager.open(productId+".png");
            return BitmapFactory.decodeStream(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
