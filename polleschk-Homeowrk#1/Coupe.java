/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class Coupe
 * Name: thomas
 * Created 11/25/2019
 */
package week03.decorator;

/**
 * Course SE2811-051
 * Winter 2019-2020
 * Coupe purpose: extends AbstractCar
 *
 * @author thomas
 * @version created on 11/25/2019 at 1:14 PM
 */
public class Coupe extends AbstractCar {
    public Coupe(Engine engine, Colour colour){
        super(engine,colour);
    }
    public Coupe(Engine engine){
        this(engine, Colour.UNPAINTED);
    }
    public int getPrice(){
        return 7000;
    }
    public static void main(String[] args) {
        //dummy code to illustrate decorator pattern
        Vehicle myCar = new Coupe(new StandardEngine(8500));
        myCar.paint(Colour.RED);
        System.out.println(myCar);
        //Add air-conditioning to the car
        myCar=new AirConditioning(myCar);
        System.out.println(myCar);
        //now add alloy wheels
        myCar=new AlloyWheels(myCar);
        System.out.println(myCar);
        //now add leather Seats
        myCar=new LeatherSeats(myCar);
        System.out.println(myCar);
        //now add metallic paing
        myCar=new MetallicPaint(myCar);
        System.out.println(myCar);
        //now add satellite navigation
        myCar=new SatNav(myCar);
        System.out.println(myCar);
    }
}
