package com.kameleoon.repository;

import com.kameleoon.model.Quote;
import com.kameleoon.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class QuoteRepositoryCustomImpl implements QuoteRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Quote findByIdAndUpdate(Long quoteId, Optional<String> content, Optional<User> user) {
        TypedQuery<Quote> tq = entityManager.createQuery("from Quote WHERE quoteId = " + quoteId, Quote.class);
        Quote quote = tq.getSingleResult();
        content.ifPresent(quote::setContent);
        user.ifPresent(quote::setUser);
        entityManager.merge(quote);
        return quote;
    }

    @Override
    public Quote findByIdAndIncreaseVoteNumber(Long quoteId) {
        TypedQuery<Quote> tq = entityManager.createQuery("from Quote WHERE quoteId = " + quoteId, Quote.class);
        Quote quote = tq.getSingleResult();
        quote.setVoteNumber(quote.getVoteNumber() + 1);
        entityManager.merge(quote);
        return quote;
    }
}