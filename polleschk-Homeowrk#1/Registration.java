/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class Registration
 * Name: thomas
 * Created 11/25/2019
 */
package week03.decorator;

/**
 * Course SE2811-051
 * Winter 2019-2020
 * Registration purpose: used with facade pattern
 *
 * @author thomas
 * @version created on 11/25/2019 at 2:30 PM
 */
public class Registration {
    private Vehicle vehicle;
    public Registration(Vehicle vehicle){
        this.vehicle=vehicle;
    }
    public void allocateLicensePlate(){
        //omitted code
        System.out.println("License plate allocated");
    }
    public void allocateVehicleNumber(){
        //Code omitted
        System.out.println("Vehicle number allocated");
    }
}
