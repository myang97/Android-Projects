package com.projects.android.articlesummarizer.response;

/**
 * Created by lkjjkl97 on 3/26/2016.
 */
public class Children
{
    private String w;

    private String text;

    private String mp;

    private String[] sentenceIds;

    private String[] children;

    private String st;

    public String getW ()
    {
        return w;
    }

    public void setW (String w)
    {
        this.w = w;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getMp ()
    {
        return mp;
    }

    public void setMp (String mp)
    {
        this.mp = mp;
    }

    public String[] getSentenceIds ()
    {
        return sentenceIds;
    }

    public void setSentenceIds (String[] sentenceIds)
    {
        this.sentenceIds = sentenceIds;
    }

    public String[] getChildren ()
    {
        return children;
    }

    public void setChildren (String[] children)
    {
        this.children = children;
    }

    public String getSt ()
    {
        return st;
    }

    public void setSt (String st)
    {
        this.st = st;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [w = "+w+", text = "+text+", mp = "+mp+", sentenceIds = "+sentenceIds+", children = "+children+", st = "+st+"]";
    }
}