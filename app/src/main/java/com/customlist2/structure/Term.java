package com.customlist2.structure;

/**
 * Created by Admin on 3/25/2016.
 */
public class Term {
    public int         nResourceId;
    public boolean     bHasCross;
    public String      strText;

    public Term(int nResourceId, boolean bHasCross, String strText)
    {
        this.nResourceId = nResourceId;
        this.bHasCross = bHasCross;
        this.strText = strText;
    }
}
