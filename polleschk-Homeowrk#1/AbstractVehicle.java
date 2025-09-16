/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class AbstractVehicle
 * Name: thomas
 * Created 11/20/2019
 */
package week03.decorator;


/**
 * Course: SE2811-051
 * Winter 2019-2020
 * AbstractVehicle purpose: implements Vehicle
 *
 * @author thomas
 * @version created on 11/20/2019 at 5:00 PM
 */
public abstract class AbstractVehicle implements Vehicle {
    private Engine engine;
    private Colour colour;

    public AbstractVehicle(Engine engine, Colour colour) {
        this.engine = engine;
        this.colour = colour;
    }

    public AbstractVehicle(Engine engine) {
        this(engine, Colour.UNPAINTED);
    }

    public Engine getEngine() {
        return engine;
    }
    public Colour getColour(){
        return colour;
    }
    public void paint (Colour colour){
        this.colour=colour;
    }
    protected String getVehicleName(){
        return getClass().getSimpleName();
    }
    public String toString(){
        return getVehicleName()+" ("+engine+", "+colour+", price "+getPrice()+")";
    }

    //for facade pattern
    public void cleanInterior(){
        System.out.println("Cleaning interior");
    }
    public void cleanExteriorBody(){
        System.out.println("Cleaning exterior");
    }
    public void polishWindows(){
        System.out.println("polishing windows");
    }
    public void takeForTestDrive(){
        System.out.println("Taking for test drive");
    }
}
