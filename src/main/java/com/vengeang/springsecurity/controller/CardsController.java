package com.vengeang.springsecurity.controller;


import com.vengeang.springsecurity.model.Cards;
import com.vengeang.springsecurity.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardsRepository cardsRepository;
    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam long id) {
        return cardsRepository.findByCustomerId(id);
    }

}
