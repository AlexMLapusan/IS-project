package com.spring.service;

import com.spring.entity.TripsSubscription;
import com.spring.repository.TripSubscriptionRepo;
import com.spring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
public class TripSubscriptionService {

    @Autowired
    private TripSubscriptionRepo tripSubscriptionRepo;

    public TripsSubscription createNewSubscription(String userId, Integer type) {
        UserRepo userRepo = new UserRepo();
        TripsSubscription ts = new TripsSubscription();

        ts.setId(UUID.randomUUID().toString());
        ts.setUser(userRepo.findUser(userId));

        TripsSubscription.Type subType = TripsSubscription.Type._30_TRIPS_SUBSCRIPTION;
        switch (type){
            case 30 :
                subType = TripsSubscription.Type._30_TRIPS_SUBSCRIPTION;
                break;
            case 60 :
                subType = TripsSubscription.Type._60_TRIPS_SUBSCRIPTION;
                break;
            case 90 :
                subType = TripsSubscription.Type._90_TRIPS_SUBSCRIPTION;
                break;
            case 120 :
                subType = TripsSubscription.Type._120_TRIPS_SUBSCRIPTION;
                break;
            case 150 :
                subType = TripsSubscription.Type._UNLIMITED_TRIPS_SUBSCRIPTION;
                break;
        }
        ts.setType(subType);

        Calendar calendar = Calendar.getInstance();
        ts.setCreationDate(calendar.getTime());
        calendar.add(Calendar.MONTH, 1);
        ts.setExpiryDate(calendar.getTime());
        return ts;
    }

    public boolean insertNewSubscription(TripsSubscription ts) {
        //todo validari, schimbare tip returnat, all the good stuff

        tripSubscriptionRepo.insertNewSubscription(ts);
        return true;
    }
}
