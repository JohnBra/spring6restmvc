package com.spryse.spring_6_rest_mvc.services;

import com.spryse.spring_6_rest_mvc.models.BeerDTO;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<BeerDTO> listBeers();

    BeerDTO getBeerById(UUID id);
}
