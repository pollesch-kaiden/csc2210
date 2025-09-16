/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class MetallicPaint
 * Name: thomas
 * Created 11/25/2019
 */
package week03.decorator;

/**
 * Course SE2811-051
 * Winter 2019-2020
 * MetallicPaint purpose: uses decorator pattern
 *
 * @author thomas
 * @version created on 11/25/2019 at 1:35 PM
 */
public class MetallicPaint extends AbstractVehicleOption {
    public MetallicPaint(Vehicle vehicle){
        super(vehicle);
    }
    public int getPrice(){
        return decoratedVehicle.getPrice()+750;
    }
}
