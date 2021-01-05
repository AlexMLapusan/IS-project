package com.spring.controller;

import com.spring.dto.IdUniversalDTO;
import com.spring.entity.PriceTable;
import com.spring.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("req/prices")
public class PricesController {
    @Autowired
    private PricesService pricesService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<PriceTable> getAllTransactions() {
        return pricesService.getAllPrices();
    }

    @RequestMapping(value = "/update/{new_price}", method = RequestMethod.PUT)
    public boolean updatePrice(@RequestBody IdUniversalDTO priceId, @PathVariable int new_price) {
        pricesService.updatePrice(priceId.getId(), new_price);
        return true;
    }
}