package com.makes.makes.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Document
public class Book {
    @Id
    private String id;
    private String name;
    private List<Page>  pages;
    private List<Question>  questions;

    public Book(String name,List<Page> pages,List<Question> questions){
        this.name = name;
        this.questions = questions;
        this.pages = pages;

    }

    public String getId() { return id;}

    public String getName() { return name;}

    public List<Page> getPages() { return pages;}

    public List<Question> getQuestions() { return questions;}


    public void createNewBook()
    {
        this.id = UUID.randomUUID().toString();

        // need to get a json answers from the front and make it a map TODO
        //getting an id to a question and an answer form the front
        Map<String, String> questionsMap  = new HashMap<String,String>();
        Map<String,String> labelAnswersMap = createLabelAnswersMap(questionsMap);

        for (Page page:this.pages)
        {
            page.editText(labelAnswersMap);
        }

    }

    private Map<String,String> createLabelAnswersMap(Map<String,String> questionMap)
    {
        String questionLabel;
        Map<String,String> labelAnswersMap = new HashMap<String, String>();

        for (String questionId:questionMap.keySet())
        {
            questionLabel = findQuestionLabel(questionId);
            labelAnswersMap.put(questionLabel,questionMap.get(questionId));
        }
        return labelAnswersMap;
    }

    private String findQuestionLabel(String questionId)
    {
        for (Question question:questions)
        {
           if (question.getId().equals(questionId))
           {
               return question.getLabelInText();
           }
        }
        return null;
    }


}
