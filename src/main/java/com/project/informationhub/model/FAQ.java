package com.project.informationhub.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FAQ {
    
    @Id
    @GeneratedValue
    // (strategy = GenerationType.AUTO)
    private Long id;

    private String question;
    private String answer;

    public FAQ() {}

    public FAQ(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
        return true;
        if (!(o instanceof FAQ))
        return false;
        FAQ faq = (FAQ) o;
        return Objects.equals(this.id, faq.id) && Objects.equals(this.question, faq.question)
            && Objects.equals(this.answer, faq.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.question, this.answer);
    }

    @Override
    public String toString() {
        return "Id: " + id + " Q : (" + question + ") A : (" + answer + ")";
    }
}
