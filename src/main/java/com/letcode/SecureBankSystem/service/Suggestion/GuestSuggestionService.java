package com.letcode.SecureBankSystem.service.Suggestion;

import com.letcode.SecureBankSystem.bo.suggestion.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.entity.SuggestionEntity.GuestSuggestionEntity;
import com.letcode.SecureBankSystem.functionalinterface.SuggestionProcessor;
import com.letcode.SecureBankSystem.repository.SuggestionRepository.GuestSuggestionRepository;
import com.letcode.SecureBankSystem.util.enums.SuggestionStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestSuggestionService implements SuggestionService {

    private final GuestSuggestionRepository suggestionRepository;

    public GuestSuggestionService(GuestSuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }


    public List<GuestSuggestionEntity> printAndProcessSuggestion() {
        return suggestionRepository.findAll();
    }



    public List<GuestSuggestionEntity> RemovedSuggestions() {
        return suggestionRepository.findAll();
    }

    public void processSuggestion(CreateSuggestionRequest suggestionTex) {
        SuggestionProcessor suggestionProcessor = suggest -> {
            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
            suggestionEntity.setSuggestionText(suggestionEntity.getSuggestionText());
            suggestionRepository.save(suggestionEntity);
        };
    }

    @Override
    public List<GuestSuggestionEntity> getCreateStatusSuggestions() {
        return suggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getSuggestionText().equals(SuggestionStatus.CREATE))
                .collect(Collectors.toList());
    }
        @Override
        public List<GuestSuggestionEntity> getRemoveStatusSuggestions(){
            return suggestionRepository.findAll().stream()
                    .filter(suggestion -> suggestion.getSuggestionText().equals(SuggestionStatus.REMOVE))
                    .collect(Collectors.toList());

        }
}