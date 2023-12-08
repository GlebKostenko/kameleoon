package com.kameleoon.model;


import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "quote")
public class Quote extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quote_id")
    private Long quoteId;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "votes")
    private Long voteNumber = 0L;
    public Quote(){}

    public Quote(Long quoteId){
        this.quoteId = quoteId;
    }
    public Quote(String content, User user) {
        this.content = content;
        this.user = user;
        this.voteNumber = voteNumber;
    }
    public Quote(Long quoteId, String content, User user, Long voteNumber) {
        this.quoteId = quoteId;
        this.content = content;
        this.user = user;
        this.voteNumber = voteNumber;
    }


    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getVoteNumber() {
        return voteNumber;
    }

    public void setVoteNumber(Long voteNumber) {
        this.voteNumber = voteNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equals(quoteId, quote.quoteId)
                && Objects.equals(content, quote.content)
                && Objects.equals(super.getLastModified(), quote.getLastModified()) && Objects.equals(user, quote.user)
                && Objects.equals(voteNumber, quote.voteNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quoteId, content, super.getLastModified(), user, voteNumber);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quoteId=" + quoteId +
                ", content='" + content + '\'' +
                ", lastModified=" + super.getLastModified() +
                ", user=" + user +
                ", voteNumber=" + voteNumber +
                '}';
    }
}
