package com.parking.main;

import com.parking.model.VehicleType;
import com.parking.repository.ParkingLot;
import com.parking.service.CostStrategy;
import com.parking.service.CostStrategyImpl;

public class Main {
  public static void main(String[] args) {
	  CostStrategy costStrategy = new CostStrategyImpl();
      ParkingLot parkingLot = new ParkingLot(3, 5, costStrategy);

     
      parkingLot.setHourlyRate(VehicleType.CAR, 20);

   
      parkingLot.addVehicle(VehicleType.CAR, "CAR1", "Blue", 10);

 
      parkingLot.removeVehicle("CAR1");

     
      boolean sportsCar= parkingLot.checkAvailability(2, VehicleType.SPORTS_CAR);
      System.out.println( (sportsCar? "Available" : "Not Available"));

    
      parkingLot.addVehicle(VehicleType.BUS, "BUS1", "Yellow", 15);

    
      boolean bus = parkingLot.checkAvailability(2, VehicleType.BUS);
      System.out.println( (bus ? "Available" : "Not Available"));
  }

}
