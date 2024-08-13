package org.beer.works.beer.inventory.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.beer.works.beer.inventory.config.JmsConfig;
import org.beer.works.beer.inventory.domain.BeerInventory;
import org.beer.works.beer.inventory.repositories.BeerInventoryRepository;
import org.beer.works.common.events.NewInventoryEvent;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NewInventoryListener {

    private final BeerInventoryRepository beerInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event){
        log.debug("Got inventory: " + event.toString());

        beerInventoryRepository.save(BeerInventory.builder()
                .beerId(event.getBeerDto().getId())
                .upc(event.getBeerDto().getUpc())
                .quantityOnHand(event.getBeerDto().getQualityOnHand())
                .build());
    }
}
