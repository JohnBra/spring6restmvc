package com.spryse.spring_6_rest_mvc.mappers;

import com.spryse.spring_6_rest_mvc.entities.Beer;
import com.spryse.spring_6_rest_mvc.models.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDTOtoBeer(BeerDTO dto);

    BeerDTO beerToBeerDTO(Beer beer);
}
