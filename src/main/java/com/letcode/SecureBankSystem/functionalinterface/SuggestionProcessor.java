package com.letcode.SecureBankSystem.functionalinterface;

import com.letcode.SecureBankSystem.bo.suggestion.CreateSuggestionRequest;
@FunctionalInterface
public interface SuggestionProcessor {
    void suggestion (CreateSuggestionRequest createSuggestionRequest);

}
