package com.kameleoon.service;

import com.kameleoon.model.Quote;
import com.kameleoon.model.User;
import com.kameleoon.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class QuoteService implements ServiceCommon<Quote> {
    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }


    @Override
    @Transactional
    public Quote save(Quote quote) throws SQLException {
        return quoteRepository.save(quote);
    }

    public Quote findById(Quote quote){
        return quoteRepository.findById(quote.getQuoteId()).get();
    }

    public List<Quote> findAll(){
        return (List<Quote>) quoteRepository.findAll();
    }
    @Transactional
    public Quote findByIdAndUpdate(Long quoteId, Optional<String> content, Optional<User> user) {
        return quoteRepository.findByIdAndUpdate(quoteId, content, user);
    }

    @Transactional
    public Quote findByIdAndIncreaseVoteNumber(Long quoteId){
        return quoteRepository.findByIdAndIncreaseVoteNumber(quoteId);
    }

    public List<Quote> findTop10ByOrderByVoteNumber(){
        return quoteRepository.findTop10ByOrderByVoteNumberDesc();
    }

    public List<Quote> findTop10WorstByVoteNumber(){
        return quoteRepository.findTop10ByOrderByVoteNumberAsc();
    }
    public Quote getRandomRecord(){
        return quoteRepository.getRandomRecord();
    }

    public void deleteById(Quote quote) throws SQLException {
        quoteRepository.deleteById(quote.getQuoteId());
    }
}
