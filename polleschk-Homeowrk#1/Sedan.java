/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class Saloon
 * Name: thomas
 * Created 11/20/2019
 */
package week03.decorator;


/**
 * Course: SE2811-051
 * Winter 2019-2020
 * Saloon purpose: concrete class
 *
 * @author thomas
 * @version created on 11/20/2019 at 5:26 PM
 */
public class Sedan extends AbstractCar {
    public Sedan(Engine engine, Colour colour){
        super(engine,colour);
    }
    public Sedan(Engine engine){
        this(engine, Colour.UNPAINTED);
    }
    public int getPrice(){
        return 6000;
    }




    public static void main(String[] args) {
        //dummy code to illustrate decorator pattern
        Vehicle myCar = new Sedan(new StandardEngine(1300));
        myCar.paint(Colour.BLUE);
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
