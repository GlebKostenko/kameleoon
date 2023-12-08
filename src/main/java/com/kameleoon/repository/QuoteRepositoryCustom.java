package com.kameleoon.repository;

import com.kameleoon.model.Quote;
import com.kameleoon.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface QuoteRepositoryCustom {
    Quote findByIdAndUpdate(Long quoteId, Optional<String> content, Optional<User> user);
    Quote findByIdAndIncreaseVoteNumber(Long quoteId);
}
