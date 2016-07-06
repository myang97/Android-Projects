package com.projects.android.articlesummarizer.response;

/**
 * Created by lkjjkl97 on 3/26/2016.
 */

public class Response
{
    private String[] topics;

    private String structure;

    private Items[] items;

    private String totalItemsCount;

    private SummarizerDoc summarizerDoc;

    private NamedEntityTree namedEntityTree;

    private ConceptTree conceptTree;

    public String[] getTopics ()
    {
        return topics;
    }

    public void setTopics (String[] topics)
    {
        this.topics = topics;
    }

    public String getStructure ()
    {
        return structure;
    }

    public void setStructure (String structure)
    {
        this.structure = structure;
    }

    public Items[] getItems ()
    {
        return items;
    }

    public void setItems (Items[] items)
    {
        this.items = items;
    }

    public String getTotalItemsCount ()
    {
        return totalItemsCount;
    }

    public void setTotalItemsCount (String totalItemsCount)
    {
        this.totalItemsCount = totalItemsCount;
    }

    public SummarizerDoc getSummarizerDoc ()
    {
        return summarizerDoc;
    }

    public void setSummarizerDoc (SummarizerDoc summarizerDoc)
    {
        this.summarizerDoc = summarizerDoc;
    }

    public NamedEntityTree getNamedEntityTree ()
    {
        return namedEntityTree;
    }

    public void setNamedEntityTree (NamedEntityTree namedEntityTree)
    {
        this.namedEntityTree = namedEntityTree;
    }

    public ConceptTree getConceptTree ()
    {
        return conceptTree;
    }

    public void setConceptTree (ConceptTree conceptTree)
    {
        this.conceptTree = conceptTree;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [topics = "+topics+", structure = "+structure+", items = "+items+", totalItemsCount = "+totalItemsCount+", summarizerDoc = "+summarizerDoc+", namedEntityTree = "+namedEntityTree+", conceptTree = "+conceptTree+"]";
    }
}

