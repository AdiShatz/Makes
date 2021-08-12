package com.makes.makes.model;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class TurningPoint {
    String question ;
    List<String> options;
    int maxOptions;

    public TurningPoint(String question, List<String> options, int maxOptions){
        this.maxOptions = maxOptions;
        setOptions(options);
        setQuestion(question);
    }

    public TurningPoint(String question, List<String> options){
        this.maxOptions = 2;
        setOptions(options);
        setQuestion(question);
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void addOption(String option)
    {
        if(this.options.size() < this.maxOptions)
        {
            this.options.add(option);
        }
    }

    public void setMaxOptions(int maxOptions) {
        this.maxOptions = maxOptions;
    }
}
