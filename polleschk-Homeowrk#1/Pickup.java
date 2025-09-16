/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class Pickup
 * Name: thomas
 * Created 11/21/2019
 */
package week03.decorator;


/**
 * Course SE2811-051
 * Winter 2019-2020
 * Pickup purpose: Extends AbstractVan
 *
 * @author thomas
 * @version created on 11/21/2019 at 11:56 AM
 */
public class Pickup extends AbstractVan {
    public Pickup(Engine engine){
        this(engine, Colour.UNPAINTED);
    }
    public Pickup(Engine engine, Colour coulour){
        super(engine,coulour);
    }
    public int getPrice(){
        return 9000;
    }
    public static void main(String[] args) {
        //dummy code
        Vehicle myPickup = new Pickup(new StandardEngine(2400), Colour.RED);
        System.out.println(myPickup);
        myPickup=new SatNav(myPickup);
        System.out.println(myPickup);
    }
}
