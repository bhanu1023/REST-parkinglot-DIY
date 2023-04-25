package com.example.parkinglot.dto;

import com.example.parkinglot.models.Gate;
import com.example.parkinglot.models.Vehicle;
import com.example.parkinglot.models.VehicleType;

public class GenerateTicketRequestDto {
    private String vehicleNumber;
    private VehicleType vehicleType;

    private int gateid;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getGateid() {
        return gateid;
    }

    public void setGateid(int gateid) {
        this.gateid = gateid;
    }



}
