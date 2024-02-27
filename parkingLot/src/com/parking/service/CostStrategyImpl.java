package com.parking.service;

import java.util.HashMap;
import java.util.Map;

import com.parking.model.VehicleType;

public class CostStrategyImpl implements CostStrategy {
	
	private Map<VehicleType, Double> hourlyRates;

    public CostStrategyImpl() {
        this.hourlyRates = new HashMap<>();
    }

    @Override
    public void setRate(VehicleType vehicleType, double rate) {
        hourlyRates.put(vehicleType, rate);
    }

    @Override
    public double getRate(VehicleType vehicleType) {
        if (hourlyRates.containsKey(vehicleType)) {
            return hourlyRates.get(vehicleType);
        } else {
            return 0.0;
        }
    }
}
