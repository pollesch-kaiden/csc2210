/*
 * Course: SWE2410-121
 * Spring 2025
 * Homework #1
 * Name: Kaiden Pollesch
 * Created 4/2/2025
 */
package week03.decorator;

/**
 * Course: SWE2410-121
 * Spring 2025
 * Class DecoratedSedanDriver Purpose: The new driver decorator to decorate a sedan with AirConditioning, Leather Seats, and SatNav
 *
 * @author polleschk
 * SWE2410-121 Laboratory Assignment
 * @version created on 4/2/2025 8:55 PM
 */
public class DecoratedSedanDriver {
    public static void main(String[] args) {
        Vehicle mySedan = new Sedan(new StandardEngine(1600));
        mySedan.paint(Vehicle.Colour.SILVER);
        System.out.println(mySedan);

        // Add air-conditioning to the sedan
        mySedan = new AirConditioning(mySedan);
        System.out.println(mySedan);

        // Add leather seats to the sedan
        mySedan = new LeatherSeats(mySedan);
        System.out.println(mySedan);

        // Add satellite navigation to the sedan
        mySedan = new SatNav(mySedan);
        System.out.println(mySedan);

        // Add alloy wheels to the sedan
        mySedan = new AlloyWheels(mySedan);
        System.out.println(mySedan);

        // Add metallic paint to the sedan
        mySedan = new MetallicPaint(mySedan);
        System.out.println(mySedan);


    }
}