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

/**
 * Created by Lanka on 4/24/2016.
 */
public class GridAdapter  extends ArrayAdapter<Product> {

    private List<Product> products;

    public GridAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        products = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.grid_list, parent, false);
        }

        Product product = products.get(position);


        ImageView imageView = (ImageView) convertView.findViewById(R.id.gridimageView);
        imageView.setImageBitmap(getBitmapFromAssest(product.getProductId()));

        TextView nameText = (TextView) convertView.findViewById(R.id.gridnameText);
        nameText.setText(product.getName());

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
