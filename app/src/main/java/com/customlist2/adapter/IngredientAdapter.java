package com.customlist2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.customlist2.R;
import com.customlist2.structure.Ingredient;

import java.util.ArrayList;

/**
 * Created by Admin on 3/25/2016.
 */
public class IngredientAdapter extends ArrayAdapter<Ingredient>{
    Context context;
    int layout;

    ArrayList<Ingredient> ingredientsList;

    public IngredientAdapter(Context context, int layout, ArrayList<Ingredient> ingredientsList)
    {
        super(context, layout, ingredientsList);
        this.context = context;
        this.layout = layout;
        this.ingredientsList = ingredientsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        Ingredient ingredient = ingredientsList.get(position);

        convertView = inflater.inflate(layout, null);
        if (ingredient.nResourceId != 0)
            ((ImageView) convertView.findViewById(R.id.img_ingredient)).setImageResource(ingredient.nResourceId);
        if (ingredient.strIngredientName != null)
            ((TextView) convertView.findViewById(R.id.txt_ingredient)).setText(ingredient.strIngredientName);
        else
            ((TextView) convertView.findViewById(R.id.txt_ingredient)).setText("");

        return convertView;
    }
}
