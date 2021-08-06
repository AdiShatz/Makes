package com.makes.makes.model;

import org.springframework.data.annotation.PersistenceConstructor;

import java.util.Map;
import java.util.UUID;

public class Page {
    private String id = UUID.randomUUID().toString();
    static private int pageNum;
    private String text;
    // private Image background;
    private String background;
    private Boolean turningPointExist;
    private TurningPoint turningPoint = null;
    private UUID[] nextPageId;
    private UUID prevPageId;

    @PersistenceConstructor
    public Page(String text, /*Image*/String background,Boolean turningPointExist ,TurningPoint turningPoint,UUID[] nextPageId,UUID prevPageId){
        pageNum ++;
        this.nextPageId = new UUID[2];
        this.nextPageId[0] = nextPageId[0];
        this.nextPageId[1] = nextPageId[1];
        this.prevPageId = prevPageId;
        this.text = text;
        this.background = background;
        this.turningPoint = turningPoint;
        this.turningPointExist = turningPointExist;
    }

    public Page(Page page){
        pageNum ++;
        this.id = UUID.randomUUID().toString();
        this.nextPageId = new UUID[2];
        this.nextPageId[0] = page.nextPageId[0];
        this.nextPageId[1] = page.nextPageId[1];
        this.prevPageId = page.prevPageId;
        this.text = page.text;
        this.background = page.background;
        this.turningPoint = page.turningPoint;
        this.turningPointExist = page.turningPointExist;

    }

    public /*Image*/String getBackground() {
        return background;
    }

    public String getText() { return text;}

    public TurningPoint getTurningPoint() { return turningPoint;}

    public Boolean getTurningPointExist() { return turningPointExist; }

    public UUID[] getNextPageId() { return nextPageId; }

    public static int getPageNum() { return pageNum;}

    public String getId() { return id; }

    public UUID getPrevPageId() { return prevPageId; }

    public void editText(Map<String,String> labelAnswersMap)
    {
        int beginIndex = text.indexOf("<") ;
        int endIndex = text.indexOf("<");

        while (beginIndex>=0 & endIndex>=0)
        {
            String strToReplace = labelAnswersMap.get(text.substring(beginIndex+1,endIndex-1));
            text = text.replace(text.substring(beginIndex,endIndex),strToReplace);
            beginIndex =  text.indexOf("<",beginIndex+1);
            endIndex = text.indexOf(">",endIndex+1);
        }
    }

}