package com.makes.makes.model;

import java.util.List;
import java.util.UUID;
// TODO DELETE
public class Question {

    private String id = UUID.randomUUID().toString();
    private String answerType;
    private String label;
    private List<String> answerOptions;
    private String labelInText;

    public Question(String answerType, String lable, List<String> answerOptions, String lableInText) {
        this.answerType = answerType;
        this.label = lable;
        this.answerOptions = answerOptions;
        this.labelInText = lableInText;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    public String getAnswerType() {
        return answerType;
    }

    public String getLabel() {
        return label;
    }

    public String getLabelInText() {
        return labelInText;
    }

    public String getId() {
        return id;
    }
}
