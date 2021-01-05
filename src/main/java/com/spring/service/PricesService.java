package com.spring.service;

import com.spring.entity.PriceTable;
import com.spring.repository.PriceTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PricesService {
    @Autowired
    private PriceTableRepo priceTableRepo;

    public Collection<PriceTable> getAllPrices(){
        return priceTableRepo.getAllPrices();
    }

    public boolean updatePrice(String priceId, int newPrice){
        priceTableRepo.updatePrice(priceId, newPrice);
        return true;
    }
}
