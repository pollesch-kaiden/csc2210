/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class AirConditionedVehicle
 * Name: thomas
 * Created 11/25/2019
 */
package week03.decorator;


/**
 * Course SE2811-051
 * Winter 2019-2020
 * AirConditionedVehicle purpose: an option class using decorator class
 *
 * @author thomas
 * @version created on 11/25/2019 at 1:22 PM
 */
public class AirConditioning extends AbstractVehicleOption {
    public AirConditioning(Vehicle vehicle){
        super(vehicle);
    }
    public int getPrice(){
        return decoratedVehicle.getPrice() + 600;
    }
    public void setTemperature(int value){
        //code to set the temperature
        System.out.println("Temperature is set to "+value+" degrees F");
    }

    public static void main(String[] args){
        Vehicle testVan= new BoxVan(new StandardEngine(8500));
        System.out.println(testVan);
        testVan.paint(Colour.RED);
        testVan=new AirConditioning(testVan);
        System.out.println(testVan);
    }
}
