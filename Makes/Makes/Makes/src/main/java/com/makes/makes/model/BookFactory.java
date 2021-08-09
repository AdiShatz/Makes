package com.makes.makes.model;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class BookFactory {

    public CustomBook createNewBook(BookTemplate bookTemplate,String ownerName,Map<String,String>questionsMap)
    /// get maybe an id from the front and question id +answer
    {
        List<Page> customPages = new ArrayList<Page>();

        // need to get a json answers from the front and make it a map TODO
        //getting an id to a question and an answer form the front
        //Map<String, String> questionsMap  = new HashMap<String,String>();
        Map<String,String> labelAnswersMap = createLabelAnswersMap(questionsMap,bookTemplate.getQuestions());

        for (Page page:bookTemplate.getPages())
        {
          Page newPage = new Page(page);
          newPage.editText(labelAnswersMap);
          customPages.add(newPage);
        }
        CustomBook customBook = new CustomBook(bookTemplate.getName(),customPages,ownerName );
        return customBook;

    }

    private Map<String,String> createLabelAnswersMap(Map<String,String> questionMap, List<Question> questions)
    {
        String questionLabel;
        Map<String,String> labelAnswersMap = new HashMap<String, String>();

        for (String questionId:questionMap.keySet())
        {
            questionLabel = findQuestionLabel(questionId,questions);
            labelAnswersMap.put(questionLabel,questionMap.get(questionId));
        }
        return labelAnswersMap;
    }

    private String findQuestionLabel(String questionId,List<Question> questions)
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
