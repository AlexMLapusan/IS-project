package com.spring.service;

import com.spring.entity.PriceTable;
import com.spring.repository.PriceTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PriceTableService {
    @Autowired
    private PriceTableRepo priceTableRepo;

    public Collection<PriceTable> getAllPrices() {
        return priceTableRepo.getAllPrices();
    }

    public PriceTable findByType(PriceTable.Type type){
        PriceTable priceTable = priceTableRepo.findByType(type);
        if(priceTable!= null)
        {
            return priceTable;
        }
        else
        {
            return null;
        }
    }
}
