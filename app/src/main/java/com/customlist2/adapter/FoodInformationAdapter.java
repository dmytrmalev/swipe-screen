package com.customlist2.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.customlist2.R;
import com.customlist2.activity.MainActivity;
import com.customlist2.structure.FoodInformation;
import com.customlist2.view.ExpandableHeightGridView;
import com.customlist2.view.ExpandableHeightListView;

import java.util.ArrayList;

/**
 * Created by Admin on 3/28/2016.
 */
public class FoodInformationAdapter extends PagerAdapter {

    int                     nLayoutId;
    Context                 context;
    ArrayList<FoodInformation>   arrLstFoodInformation;

    public FoodInformationAdapter(Context context, int nLayoutId, ArrayList<FoodInformation> arrLstFoodInformation)
    {
        this.context = context;
        this.nLayoutId = nLayoutId;
        this.arrLstFoodInformation = arrLstFoodInformation;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrLstFoodInformation.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        View viewItem = inflater.inflate(nLayoutId, container, false);
        FoodInformation foodInformation = arrLstFoodInformation.get(position);

        viewItem.findViewById(R.id.layout_container).setBackgroundResource(foodInformation.nBgResourceId);
        viewItem.findViewById(R.id.img_food_about).setBackgroundResource(foodInformation.nBgResourceId);
        viewItem.findViewById(R.id.img_food_term).setBackgroundResource(foodInformation.nBgResourceId);

        GridView grdPrice = (GridView) viewItem.findViewById(R.id.grd_price);
        PriceAdapter priceAdapter = new PriceAdapter(context, R.layout.adapter_price, foodInformation.arrLstPrice);
        grdPrice.setAdapter(priceAdapter);

        ExpandableHeightGridView grdIngredient = (ExpandableHeightGridView) viewItem.findViewById(R.id.grd_ingredient);
        IngredientAdapter ingredientAdapter = new IngredientAdapter(context, R.layout.adapter_ingredient, foodInformation.arrLstIngredient);
        grdIngredient.setAdapter(ingredientAdapter);
        grdIngredient.setExpanded(true);

        ((TextView) viewItem.findViewById(R.id.txt_carories)).setText(String.valueOf(foodInformation.nCarorieAmount));
        ((TextView) viewItem.findViewById(R.id.txt_fat)).setText(String.valueOf(foodInformation.nFatAmount) + "%");
        ((TextView) viewItem.findViewById(R.id.txt_carbs)).setText(String.valueOf(foodInformation.nCarbsAmount) + "%");
        ((TextView) viewItem.findViewById(R.id.txt_protein)).setText(String.valueOf(foodInformation.nProteinAmount) + "%");

        ExpandableHeightListView lstNutrition = (ExpandableHeightListView) viewItem.findViewById(R.id.lst_nutrition);
        NutritionAdapter nutritionAdapter = new NutritionAdapter(context, R.layout.adapter_nutrition, foodInformation.arrLstNutrition);
        lstNutrition.setAdapter(nutritionAdapter);
        lstNutrition.setExpanded(true);

        ExpandableHeightGridView grdTerm = (ExpandableHeightGridView) viewItem.findViewById(R.id.grd_terms);
        TermAdapter termAdapter = new TermAdapter(context, R.layout.adapter_term, foodInformation.arrLstTerm);
        grdTerm.setAdapter(termAdapter);

        ((ViewPager) container).addView(viewItem);

        return viewItem;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub

        return view == ((View)object);
    }
}
