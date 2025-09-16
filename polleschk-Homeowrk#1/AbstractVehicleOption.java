/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class AbstractVehicleOption
 * Name: thomas
 * Created 11/25/2019
 */
package week03.decorator;

/**
 * Course SE2811-051
 * Winter 2019-2020
 * AbstractVehicleOption purpose: decorator pattern
 *
 * @author thomas
 * @version created on 11/25/2019 at 1:18 PM
 */
public abstract class AbstractVehicleOption extends AbstractVehicle {
    protected Vehicle decoratedVehicle;

    public AbstractVehicleOption(Vehicle vehicle){
        super(vehicle.getEngine(),vehicle.getColour());
        decoratedVehicle=vehicle;
    }
    protected String getVehicleName(){
        return getClass().getSimpleName()+" "+((AbstractVehicle)decoratedVehicle).getVehicleName();
    }
}
