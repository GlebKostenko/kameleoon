package com.kameleoon.rest;

import com.kameleoon.model.Quote;
import com.kameleoon.model.User;
import com.kameleoon.service.QuoteService;
import com.kameleoon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quote-api")
public class QuoteRestController {
    private final QuoteService quoteService;
    private final UserService userService;

    @Autowired
    public QuoteRestController(QuoteService quoteService, UserService userService) {
        this.quoteService = quoteService;
        this.userService = userService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Quote save(@NotBlank @RequestParam("user") String userEmail,
                      @NotBlank @RequestParam("content") String content) throws SQLException {
        User user = userService.findByEmail(userEmail);
        return quoteService.save(new Quote(content, user));
    }

    @GetMapping("/{id}")
    public Quote findById(@PathVariable("id") Long quoteId) {
        return quoteService.findById(new Quote(quoteId));
    }

    @GetMapping()
    public List<Quote> findAll() {
        return quoteService.findAll();
    }

    @PatchMapping("/{id}")
    public Quote findByIdAndUpdate(@RequestParam(value = "user", required = false) String userEmail,
                                  @RequestParam(value = "content", required = false) String content,
                                  @PathVariable("id") Long id) throws SQLException {
        Optional<User> user = Optional.ofNullable(userService.findByEmail(userEmail));
        Optional<String> newContent = Optional.ofNullable(content);
        return quoteService.findByIdAndUpdate(id, newContent, user);
    }
    @PatchMapping("/increase/{id}")
    public Quote findByIdAndIncreaseVoteNumber(@PathVariable("id") Long id) throws SQLException {
        return quoteService.findByIdAndIncreaseVoteNumber(id);
    }

    @GetMapping("/top")
    List<Quote> findTop10ByOrderByVoteNumber() {
        return quoteService.findTop10ByOrderByVoteNumber();
    }

    @GetMapping("/worst")
    List<Quote> findTop10WorstByVoteNumber() {
        return quoteService.findTop10WorstByVoteNumber();
    }

    @GetMapping("/random")
    public Quote getRandomRecord() {
        return quoteService.getRandomRecord();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long quoteId) throws SQLException {
        quoteService.deleteById(new Quote(quoteId));
    }
}
