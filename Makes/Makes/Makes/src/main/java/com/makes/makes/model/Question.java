package com.makes.makes.model;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

import javax.persistence.Id;

@NoArgsConstructor
public class Question {

    private String id = UUID.randomUUID().toString();
    private String answerType;
    private String label;
    private List<String> answerOptions;
    private String labelInText;

    public Question(String answerType, String label, List<String> answerOptions, String labelInText) {
        this.answerType = answerType;
        this.label = label;
        this.answerOptions = answerOptions;
        this.labelInText = labelInText;
    }

    public Question(Question question) {
        this.answerType = question.getAnswerType();
        this.label = question.getLabel();
        this.answerOptions = question.getAnswerOptions();
        this.labelInText = question.getLabelInText();
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

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setAnswerOptions(List<String> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public void setLabelInText(String labelInText) {
        this.labelInText = labelInText;
    }
}
