package com.customlist2.structure;

import java.util.ArrayList;

/**
 * Created by Admin on 3/28/2016.
 */
public class FoodInformation {
    public int      nFatAmount;
    public int      nCarbsAmount;
    public int      nProteinAmount;
    public int      nCarorieAmount;
    public int      nBgResourceId;

    public ArrayList<Term>          arrLstTerm;
    public ArrayList<Price>         arrLstPrice;
    public ArrayList<Nutrition>     arrLstNutrition;
    public ArrayList<Ingredient>    arrLstIngredient;

    public FoodInformation(int nBgResourceId, int nCarorieAmount, int nFatAmount, int nCarbsAmount, int nProteinAmount,
                           ArrayList<Price> arrLstPrice, ArrayList<Ingredient> arrLstIngredient, ArrayList<Nutrition> arrLstNutrition, ArrayList<Term> arrLstTerm)
    {
        this.nFatAmount = nFatAmount;
        this.nCarbsAmount = nCarbsAmount;
        this.nProteinAmount = nProteinAmount;
        this.nCarorieAmount = nCarorieAmount;
        this.nBgResourceId = nBgResourceId;

        this.arrLstTerm = arrLstTerm;
        this.arrLstPrice = arrLstPrice;
        this.arrLstNutrition = arrLstNutrition;
        this.arrLstIngredient = arrLstIngredient;
    }
}
