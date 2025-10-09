package com.spryse.spring_6_rest_mvc.services;

import com.spryse.spring_6_rest_mvc.models.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID id);
}
