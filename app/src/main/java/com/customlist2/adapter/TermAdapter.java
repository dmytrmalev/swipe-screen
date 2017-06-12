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
import com.customlist2.structure.Term;

import java.util.ArrayList;

public class TermAdapter extends ArrayAdapter<Term> {
    Context context;
    int layout;

    ArrayList<Term> termsList;

    public TermAdapter(Context context, int layout, ArrayList<Term> termsList)
    {
        super(context, layout, termsList);
        this.context = context;
        this.layout = layout;
        this.termsList = termsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        Term term = termsList.get(position);

        convertView = inflater.inflate(layout, null);
        ((ImageView) convertView.findViewById(R.id.img_term)).setImageResource(term.nResourceId);
        if (term.bHasCross == false)
            ((ImageView) convertView.findViewById(R.id.img_cross)).setVisibility(View.GONE);
        ((TextView) convertView.findViewById(R.id.txt_term)).setText(term.strText);

        return convertView;
    }
}