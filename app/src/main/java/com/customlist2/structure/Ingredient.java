package com.customlist2.structure;

/**
 * Created by Admin on 3/25/2016.
 */
public class Ingredient {
    public int         nResourceId = 0;
    public String      strIngredientName = null;

    public Ingredient(int nResourceId, String strIngredientName)
    {
        this.nResourceId = nResourceId;
        this.strIngredientName = strIngredientName;
    }

    public Ingredient(int nResourceId)
    {
        this.nResourceId = nResourceId;
    }

    public Ingredient(String strIngredientName)
    {
        this.strIngredientName = strIngredientName;
    }
}
