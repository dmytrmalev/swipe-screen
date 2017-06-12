package com.customlist2.activity;

import android.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.customlist2.R;
import com.customlist2.adapter.FoodInformationAdapter;
import com.customlist2.adapter.IngredientAdapter;
import com.customlist2.adapter.NutritionAdapter;
import com.customlist2.adapter.PriceAdapter;
import com.customlist2.adapter.TermAdapter;
import com.customlist2.structure.FoodInformation;
import com.customlist2.view.ExpandableHeightGridView;
import com.customlist2.structure.Ingredient;
import com.customlist2.structure.Nutrition;
import com.customlist2.structure.Price;
import com.customlist2.structure.Term;
import com.customlist2.view.ExpandableHeightListView;
import com.customlist2.view.MyViewPager;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridView                        grd_price;
    ExpandableHeightGridView        grd_ingredient;
    ExpandableHeightGridView        grd_term;
    ExpandableHeightListView        lst_nutrition;

    int    pnBgResourceId[]           =   {R.drawable.bg_food1, R.drawable.bg_food2};
    String strTermNames[]           =   {"Gluten free", "Dairy free", "Nut free", "Spicy", "Vegan", "Vegeterian"};
    String strFoodMenuItems[]       =   {"Per Meal", "Low Carb", "With Steak", "With Chicken", "With Beef"};
    String strNutritionItems[]      =   {"Fat", "Carbohydrate", "Fibre", "Protein", "Salt", "Sodium"};
    String strIngredientItems[]     =   {"Fresh basil pesto", "Grass fed steak", "Extra virgin olive oil", "Bella mushrooms", "White wine", "Rosemary", "Salt", "Pink pepper"};
    String strNutritionAmounts[]    =   {"7.9g", "24g", "13g", "40g", "0.09g", "36mg"};

    Random random = new Random();

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<FoodInformation> arrLstFoodInformation = new ArrayList<>();

        for (int i = 0; i < 2; i++)
        {
            ArrayList<Price> arrLstPrice =  new ArrayList<>();
            for (int j = 0; j < 5; j++)
            {
                arrLstPrice.add(new Price(10 + Math.abs(random.nextInt() % 5), 99, strFoodMenuItems[Math.abs(random.nextInt() % 5)]));
            }

            ArrayList<Ingredient> arrLstIngredient = new ArrayList<>();
            for (int j = 0; j < 8; j++)
            {
                arrLstIngredient.add(new Ingredient(R.drawable.ingredient1 + Math.abs(random.nextInt() % 8), strIngredientItems[Math.abs(random.nextInt() % 8)]));
            }

            ArrayList<Nutrition> arrLstNutrition = new ArrayList<>();
            for (int j = 0; j < 6; j++)
            {
                arrLstNutrition.add(new Nutrition(strNutritionItems[Math.abs(random.nextInt() % 6)], strNutritionAmounts[Math.abs(random.nextInt() % 6)]));
            }

            ArrayList<Term> arrLstTerm = new ArrayList<>();
            for (int j = 0; j < 6; j++)
            {
                arrLstTerm.add(new Term(R.drawable.term1 + Math.abs(random.nextInt() % 6), random.nextInt() % 2 == 0 ? true : false, strTermNames[Math.abs(random.nextInt() % 6)]));
            }

            int nCarories = random.nextInt(240) + 150;
            int nFat = random.nextInt(100);
            int nCarbs = random.nextInt(100 - nFat);
            int nProtein = 100 - nFat - nCarbs;

            arrLstFoodInformation.add(new FoodInformation(pnBgResourceId[i], nCarories, nFat, nCarbs, nProtein,
                    arrLstPrice, arrLstIngredient, arrLstNutrition, arrLstTerm));

            FoodInformationAdapter foodInformationAdapter = new FoodInformationAdapter(this, R.layout.adapter_food_information, arrLstFoodInformation);
            ((ViewPager) findViewById(R.id.viewPager)).setAdapter(foodInformationAdapter);
            ((ViewPager) findViewById(R.id.viewPager)).setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    LinearLayout activeView = (LinearLayout)((ViewPager) findViewById(R.id.viewPager)).getChildAt(((ViewPager) findViewById(R.id.viewPager)).getCurrentItem());
                    ScrollView scrollView = (ScrollView) activeView.getChildAt(0);

                    scrollView.scrollTo(0, 0);
                    //FoodInformationAdapter adapter = (FoodInformationAdapter)((ViewPager) findViewById(R.id.viewPager)).getAdapter();

//                    FoodInformationAdapter adapter = (FoodInformationAdapter) ((ViewPager) findViewById(R.id.viewPager)).getAdapter();
//                    Fragment fragment = adapter.getgetItem(mViewPager.getCurrentItem());
//
//                    View activeView = fragment.getView();
//                    Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }




//        grd_price = (GridView) findViewById(R.id.grd_price);
//        grd_ingredient = (ExpandableHeightGridView) findViewById(R.id.grd_ingredient);
//        grd_ingredient.setExpanded(true);
//
//        grd_term = (ExpandableHeightGridView) findViewById(R.id.grd_terms);
//        grd_term.setExpanded(true);
//
//        lst_nutrition = (ExpandableHeightListView) findViewById(R.id.lst_nutrition);
//        lst_nutrition.setExpanded(true);
//
//        ArrayList<FoodInformation> arrLstFoodLayout = new ArrayList<>();
//
//        ArrayList<Price> arrLstPrice = new ArrayList<>();
//        for (int i = 0; i < 5; i++)
//        {
//            arrLstPrice.add(new Price(10 + Math.abs(random.nextInt() % 5), 99, strFoodMenuItems[Math.abs(random.nextInt() % 5)]));
//        }
//
//        arrLstFoodLayout.add(new FoodInformation(R.drawable.bg_food1, arrLstPrice));
//
//        arrLstPrice.clear();
//        for (int i = 0; i < 5; i++)
//        {
//            arrLstPrice.add(new Price(10 + Math.abs(random.nextInt() % 5), 99, strFoodMenuItems[Math.abs(random.nextInt() % 5)]));
//        }
//        arrLstFoodLayout.add(new FoodInformation(R.drawable.bg_food2, arrLstPrice));
//
//        viewPager = (MyViewPager) findViewById(R.id.viewPager);
//        PagerAdapter adapter = new FoodInformationAdapter(this, R.layout.layout_food, arrLstFoodLayout);
//        viewPager.setAdapter(adapter);
//
//
//        //initializePriceList();
//        initializeIngredientList();
//        initializeNutritionList();
//        initializeTermList();
    }

    public void initializePriceList()
    {
        ArrayList<Price> priceList =  new ArrayList<>();

//        priceList.add(new Price(10, 99, "Per Meal"));
//        priceList.add(new Price(11, 99, "Low Carb"));
//        priceList.add(new Price(13, 99, "With Steak"));
//        priceList.add(new Price(12, 99, "With Chicken"));
//        priceList.add(new Price(14, 99, "With Beef"));
        for (int i = 0; i < 5; i++)
        {
            priceList.add(new Price(10 + Math.abs(random.nextInt() % 5), 99, strFoodMenuItems[Math.abs(random.nextInt() % 5)]));
        }

        PriceAdapter priceAdapter = new PriceAdapter(this, R.layout.adapter_price, priceList);
        grd_price.setAdapter(priceAdapter);
    }

    public void initializeIngredientList()
    {
        ArrayList<Ingredient> ingredientList = new ArrayList<>();

        for (int i = 0; i < 8; i++)
        {
            ingredientList.add(new Ingredient(R.drawable.ingredient1 + Math.abs(random.nextInt() % 8), strIngredientItems[Math.abs(random.nextInt() % 8)]));
        }

//        ingredientList.add(new Ingredient(R.drawable.ingredient1, "Fresh basil pesto"));
//        ingredientList.add(new Ingredient(R.drawable.ingredient2, "Grass fed steak"));
//        ingredientList.add(new Ingredient(R.drawable.ingredient3, "Extra virgin olive oil"));
//
//        ingredientList.add(new Ingredient(R.drawable.ingredient4, "Bella mushrooms"));
//        ingredientList.add(new Ingredient(R.drawable.ingredient5, "White wine"));
//        ingredientList.add(new Ingredient(R.drawable.ingredient6, "Rosemary"));
//
//        ingredientList.add(new Ingredient(R.drawable.ingredient7, "Salt"));
//        ingredientList.add(new Ingredient(R.drawable.ingredient8, "Pink pepper"));
//        ingredientList.add(new Ingredient(R.drawable.ingredient_blank, null));

        IngredientAdapter ingredientAdapter = new IngredientAdapter(this, R.layout.adapter_ingredient, ingredientList);
        grd_ingredient.setAdapter(ingredientAdapter);

    }

    public void initializeNutritionList()
    {
        ArrayList<Nutrition> nutritionList = new ArrayList<>();

        for (int i = 0; i < 6; i++)
        {
            nutritionList.add(new Nutrition(strNutritionItems[Math.abs(random.nextInt() % 6)], strNutritionAmounts[Math.abs(random.nextInt() % 6)]));
        }
//        nutritionList.add(new Nutrition("Fat", "7.9g"));
//        nutritionList.add(new Nutrition("Carbohydrate", "24g"));
//        nutritionList.add(new Nutrition("Fibre", "13g"));
//        nutritionList.add(new Nutrition("Protein", "40g"));
//        nutritionList.add(new Nutrition("Salt", "0.09g"));
//        nutritionList.add(new Nutrition("Sodium", "36mg"));

        NutritionAdapter nutritionAdapter = new NutritionAdapter(this, R.layout.adapter_nutrition, nutritionList);
        lst_nutrition.setAdapter(nutritionAdapter);
    }

    public void initializeTermList()
    {
        ArrayList<Term> termList = new ArrayList<Term>();

        for (int i = 0; i < 6; i++)
        {
            termList.add(new Term(R.drawable.term1 + Math.abs(random.nextInt() % 6), random.nextInt() % 2 == 0 ? true : false, strTermNames[Math.abs(random.nextInt() % 6)]));
        }

//        termList.add(new Term(R.drawable.term1, true, "Gluten free"));
//        termList.add(new Term(R.drawable.term2, true, "Dairy free"));
//        termList.add(new Term(R.drawable.term3, true, "Nut free"));
//        termList.add(new Term(R.drawable.term4, false, "Spicy"));
//        termList.add(new Term(R.drawable.term5, false, "Vegan"));
//        termList.add(new Term(R.drawable.term6, false, "Vegeterian"));

        TermAdapter termAdapter = new TermAdapter(this, R.layout.adapter_term, termList);
        grd_term.setAdapter(termAdapter);

    }
}
