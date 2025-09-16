/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class DecoratedBoxVanDriver
 * Name: thomas
 * Created 12/13/2019
 */
package week03.decorator;


/**
 * Course SE2811-051
 * Winter 2019-2020
 * DecoratedBoxVanDriver purpose: Example of a test of the decorator pattern
 * Consider these updates as factory approved
 *
 * @author thomas
 * @version created on 12/13/2019 at 6:18 PM
 * @version modified 12/16/2022
 */
public class DecoratedBoxVanDriver {
    private static Vehicle myBoxVan;
    public static void main(String[] args) {
        System.out.println(new Banner("Take a Box Van and add several options, showing at each stage the new price")+"\n");
        myBoxVan = new BoxVan(new StandardEngine(8500));
        myBoxVan.paint(Vehicle.Colour.BLUE);
        System.out.println(myBoxVan);
        //Add air-conditioning to the car
        myBoxVan =new AirConditioning(myBoxVan);
        System.out.println(myBoxVan);
        ((AirConditioning)myBoxVan).setTemperature(65);
        //now add alloy wheels
        myBoxVan =new AlloyWheels(myBoxVan);
        System.out.println(myBoxVan);
        //now add leather Seats
        myBoxVan =new LeatherSeats(myBoxVan);
        System.out.println(myBoxVan);
        //now add metallic paint
        myBoxVan =new MetallicPaint(myBoxVan);
        System.out.println(myBoxVan);
        //now add satellite navigation
        myBoxVan =new SatNav(myBoxVan);
        System.out.println(myBoxVan);


    }
}
