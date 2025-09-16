/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class SatNav
 * Name: thomas
 * Created 11/25/2019
 */
package week03.decorator;

/**
 * Course SE2811-051
 * Winter 2019-2020
 * SatNav purpose: uses decorator pattern
 *
 * @author thomas
 * @version created on 11/25/2019 at 1:36 PM
 */
public class SatNav extends AbstractVehicleOption {
    public SatNav(Vehicle vehicle){
        super(vehicle);
    }
    public int getPrice(){
        return decoratedVehicle.getPrice()+1500;
    }
    public void setDestination(String target){
        //code to set destination
    }
}
