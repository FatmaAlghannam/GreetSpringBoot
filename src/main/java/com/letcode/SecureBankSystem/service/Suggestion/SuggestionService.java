package com.letcode.SecureBankSystem.service.Suggestion;

import com.letcode.SecureBankSystem.bo.suggestion.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.entity.SuggestionEntity.GuestSuggestionEntity;

import java.util.List;

public interface SuggestionService {
    List<GuestSuggestionEntity> getCreateStatusSuggestions();
    List<GuestSuggestionEntity> printAndProcessSuggestion();
    List<GuestSuggestionEntity> getRemoveStatusSuggestions();


    void processSuggestion(CreateSuggestionRequest suggestionTex);
}
