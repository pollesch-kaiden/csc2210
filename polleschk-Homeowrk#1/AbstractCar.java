/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class AbstractCar
 * Name: thomas
 * Created 11/20/2019
 */
package week03.decorator;


/**
 * Course: SE2811-051
 * Winter 2019-2020
 * AbstractCar purpose: extends AbstractVehicle
 *
 * @author thomas
 * @version created on 11/20/2019 at 5:17 PM
 */
public abstract class AbstractCar extends AbstractVehicle {
    public AbstractCar(Engine engine, Colour colour){
        super(engine,colour);
    }
    public AbstractCar(Engine engine){
        this(engine, Colour.UNPAINTED);
    }
}
