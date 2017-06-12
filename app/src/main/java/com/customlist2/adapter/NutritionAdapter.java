package com.customlist2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.customlist2.R;
import com.customlist2.structure.Nutrition;

import java.util.ArrayList;

public class NutritionAdapter extends ArrayAdapter<Nutrition> {
    Context context;
    int layout;

    ArrayList<Nutrition> nutritionList;

    public NutritionAdapter(Context context, int layout, ArrayList<Nutrition> nutritionList)
    {
        super(context, layout, nutritionList);
        this.context = context;
        this.layout = layout;
        this.nutritionList = nutritionList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        Nutrition nutrition = nutritionList.get(position);

        convertView = inflater.inflate(layout, null);
        ((TextView) convertView.findViewById(R.id.txt_name)).setText(nutrition.strName);
        ((TextView) convertView.findViewById(R.id.txt_amount)).setText(nutrition.strAmount);
        return convertView;
    }
}