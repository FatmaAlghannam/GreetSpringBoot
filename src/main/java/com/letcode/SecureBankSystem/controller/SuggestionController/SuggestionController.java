package com.letcode.SecureBankSystem.controller.SuggestionController;

import com.letcode.SecureBankSystem.controller.userController.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.service.Suggestion.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/guest")
public class SuggestionController  {
    @Autowired
    private GuestSuggestionService guestSuggestionService;


    @PostMapping("/suggestions")
    public String handleSuggestion(@RequestBody CreateSuggestionRequest suggestionRequest) {
        guestSuggestionService.processSuggestion(suggestionRequest.getSuggestionText());
        return "Suggestion is successfully!!";
    }
}
