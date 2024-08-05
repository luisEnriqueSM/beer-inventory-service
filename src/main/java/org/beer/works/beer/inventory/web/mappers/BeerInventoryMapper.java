package org.beer.works.beer.inventory.web.mappers;

import org.beer.works.beer.inventory.domain.BeerInventory;
import org.beer.works.beer.inventory.web.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDto);
    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
