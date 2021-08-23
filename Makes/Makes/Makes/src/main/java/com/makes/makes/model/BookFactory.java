package com.makes.makes.model;

import com.makes.makes.service.BookCoverService;
import lombok.AllArgsConstructor;

import java.util.*;


public class BookFactory {

    public CustomBook createNewBook(BookTemplate bookTemplate, String ownerName, Map<String,String>questionsMap,String chosenBookName,String bookCoverId)
    {
        List<Page> customPages = new ArrayList<Page>();
        Map<String,String> labelAnswersMap = createLabelAnswersMap(questionsMap,bookTemplate.getQuestions());

        for (Page page:bookTemplate.getPages())
        {
          Page newPage = new Page(page);
          newPage.editText(labelAnswersMap,bookTemplate.getDefaultLabelsInText());
          customPages.add(newPage);
        }
        CustomBook customBook = new CustomBook(chosenBookName,customPages,ownerName,bookCoverId);
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
            questionId = questionId.replaceAll("\\s+","");
            if (question.getId().equals(questionId))
            {
                return question.getLabelInText();
            }
        }
        return null;
    }

}
