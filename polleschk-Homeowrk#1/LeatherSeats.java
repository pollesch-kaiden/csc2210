/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class LeatherSeats
 * Name: thomas
 * Created 11/25/2019
 */
package week03.decorator;

/**
 * Course SE2811-051
 * Winter 2019-2020
 * LeatherSeats purpose: uses decorator pattern
 *
 * @author thomas
 * @version created on 11/25/2019 at 1:32 PM
 */
public class LeatherSeats extends AbstractVehicleOption {
    public LeatherSeats(Vehicle vehicle){
        super(vehicle);
    }
    public int getPrice(){
        return decoratedVehicle.getPrice()+1200;
    }
}
