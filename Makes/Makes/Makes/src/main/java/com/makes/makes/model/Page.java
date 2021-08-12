package com.makes.makes.model;


import lombok.NoArgsConstructor;
import org.hibernate.type.UUIDBinaryType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.Map;
import java.util.UUID;
import com.makes.makes.model.*;

import com.makes.makes.model.*;

@NoArgsConstructor
public class Page {
    private UUID id;
    static private int pageNum;
    private String text;
    // private Image background;
    private String background;
    private Boolean turningPointExist;
    private TurningPoint turningPoint = null;
    private UUID[] nextPageId;
    private UUID prevPageId;

    //@PersistenceConstructor
    public Page(String text, /*Image*/String background,Boolean turningPointExist ,TurningPoint turningPoint,UUID pageId,UUID[] nextPageId,UUID prevPageId){
        pageNum ++;
        this.id = pageId;
        this.nextPageId = new UUID[2];
        this.nextPageId[0] = nextPageId[0];
        this.nextPageId[1] = nextPageId[1];
        this.prevPageId = prevPageId;
        this.id = pageId;
        this.text = text;
        this.background = background;
        this.turningPoint = turningPoint;
        this.turningPointExist = turningPointExist;
    }

    public Page(Page page){
        pageNum ++;
        this.id = page.id;
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

    public UUID getId() { return id; }

    public UUID getPrevPageId() { return prevPageId; }

    public void editText(Map<String,String> labelAnswersMap)
    {

        int beginIndex = text.indexOf("<") ;
        int endIndex = text.indexOf(">");

        while (beginIndex>=0 & endIndex>=0)
        {
            String substituteStr = labelAnswersMap.get(text.substring(beginIndex+1,endIndex));
            text = text.replace(text.substring(beginIndex,endIndex+1),substituteStr);
            beginIndex =  text.indexOf("<");
            endIndex = text.indexOf(">");
        }

    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setTurningPointExist(Boolean turningPointExist) {
        this.turningPointExist = turningPointExist;
    }

    public void setTurningPoint(TurningPoint turningPoint) {
        this.turningPoint = turningPoint;
    }

    public void setNextPageId(UUID[] nextPageId) {
        this.nextPageId = nextPageId;
    }

    public void setPrevPageId(UUID prevPageId) {
        this.prevPageId = prevPageId;
    }

    private String alignTextRTL(String text)
    {
        String[] lines = text.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            sb.append("\u202B");   // right-to-left embedding
            sb.append(lines[i]);
            sb.append("\u202C\n"); // pop directional formatting
        }
        return sb.toString();
    }
}
