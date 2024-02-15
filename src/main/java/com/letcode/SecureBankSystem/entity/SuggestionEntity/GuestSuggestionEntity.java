package com.letcode.SecureBankSystem.entity.SuggestionEntity;

import com.letcode.SecureBankSystem.util.enums.SuggestionStatus;

import javax.persistence.*;

@Entity
@Table(name = "Guest")
public class GuestSuggestionEntity {
    // assigned id to be my primary key
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rate;
    private String suggestionText;

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }


}




