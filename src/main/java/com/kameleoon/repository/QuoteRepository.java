package com.kameleoon.repository;

import com.kameleoon.model.Quote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuoteRepository extends CrudRepository<Quote, Long>, QuoteRepositoryCustom {
    List<Quote> findTop10ByOrderByVoteNumberDesc();

    List<Quote> findTop10ByOrderByVoteNumberAsc();

    @Query(value = "SELECT * FROM quote ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote getRandomRecord();
}
