package com.makes.makes.systemObjects;

import java.util.List;

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

    public void addOption(String option)throws Exception{// TODO Adi: build a special Exception class?
        if(this.options.size() < this.maxOptions) {
            this.options.add(option);
        }
        else {
            throw new Exception("There are already" + maxOptions + "options in the options list, list is already full");
        }
    }
}
