package com.projects.android.articlesummarizer.response;

/**
 * Created by lkjjkl97 on 3/26/2016.
 */

public class Items
{
    private String rank;

    private String text;

    private String weight;

    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getWeight ()
    {
        return weight;
    }

    public void setWeight (String weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rank = "+rank+", text = "+text+", weight = "+weight+"]";
    }
}

