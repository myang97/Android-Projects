package com.projects.android.articlesummarizer.response;

/**
 * Created by lkjjkl97 on 3/26/2016.
 */
public class SummarizerDoc
{
    private String id;

    private String title;

    private String sizeFormat;

    private String error;

    private String url;

    private String size;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
{
    return title;
}

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getSizeFormat ()
{
    return sizeFormat;
}

    public void setSizeFormat (String sizeFormat)
    {
        this.sizeFormat = sizeFormat;
    }

    public String getError ()
{
    return error;
}

    public void setError (String error)
    {
        this.error = error;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", title = "+title+", sizeFormat = "+sizeFormat+", error = "+error+", url = "+url+", size = "+size+"]";
    }
}

