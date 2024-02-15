package com.letcode.SecureBankSystem.repository.SuggestionRepository;

import com.letcode.SecureBankSystem.entity.SuggestionEntity.GuestSuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity, Long> {

}
