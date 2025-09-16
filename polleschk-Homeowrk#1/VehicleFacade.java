/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class VehicleFacade
 * Name: thomas
 * Created 11/25/2019
 */
package week03.decorator;

/**
 * Course SE2811-051
 * Winter 2019-2020
 * VehicleFacade purpose: implements the facade pattern
 *
 * @author thomas
 * @version created on 11/25/2019 at 2:35 PM
 */
public class VehicleFacade {
    public void prepareForSale(Vehicle vehicle){
        Registration reg = new Registration(vehicle);
        reg.allocateVehicleNumber();
        reg.allocateLicensePlate();

        Documentation.printBrochure(vehicle);

        vehicle.cleanInterior();
        vehicle.cleanExteriorBody();
        vehicle.polishWindows();
        vehicle.takeForTestDrive();
    }
    public static void main(String[] args) {
        //dummy code
        Vehicle myCar =  new Sedan(new StandardEngine(1300),Vehicle.Colour.GREEN);
        System.out.println(myCar);
        VehicleFacade facade = new VehicleFacade();
        facade.prepareForSale(myCar);
    }
}
