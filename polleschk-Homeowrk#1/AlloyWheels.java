/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class AlloyQWheelVehicle
 * Name: thomas
 * Created 11/25/2019
 */
package week03.decorator;

/**
 * Course SE2811-051
 * Winter 2019-2020
 * AlloyQWheelVehicle purpose: option using decorator class
 *
 * @author thomas
 * @version created on 11/25/2019 at 1:26 PM
 */
public class AlloyWheels extends AbstractVehicleOption {
    public AlloyWheels(Vehicle vehicle){
        super(vehicle);
    }
    public int getPrice(){
        return decoratedVehicle.getPrice()+250;
    }
}
