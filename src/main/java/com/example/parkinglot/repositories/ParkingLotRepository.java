package com.example.parkinglot.repositories;

import com.example.parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLots = new HashMap<>();
    private long idSequence = 0;

    public ParkingLot save(ParkingLot parkingLot){
        idSequence++;
        parkingLot.setId(idSequence);
        parkingLots.put(idSequence, parkingLot);
        return parkingLot;
    }
}
