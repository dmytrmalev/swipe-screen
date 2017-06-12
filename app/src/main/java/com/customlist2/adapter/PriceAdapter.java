package com.customlist2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.customlist2.R;
import com.customlist2.structure.Price;

import java.util.ArrayList;

/**
 * Created by Admin on 3/25/2016.
 */
public class PriceAdapter extends ArrayAdapter<Price> {
    Context context;
    int layout;

    ArrayList<Price> priceList;

    public PriceAdapter(Context context, int layout, ArrayList<Price> priceList)
    {
        super(context, layout, priceList);
        this.context = context;
        this.layout = layout;
        this.priceList = priceList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        Price price = priceList.get(position);
        convertView = inflater.inflate(layout, null);

        ((TextView) convertView.findViewById(R.id.txt_dollar)).setText(String.valueOf(price.nDollar));
        ((TextView) convertView.findViewById(R.id.txt_cent)).setText(String.valueOf(price.nCent));
        ((TextView) convertView.findViewById(R.id.txt_text)).setText(price.strText);

        return convertView;
    }
}
