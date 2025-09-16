/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class BoxVan
 * Name: thomas
 * Created 11/21/2019
 */
package week03.decorator;


/**
 * Course SE2811-051
 * Winter 2019-2020
 * BoxVan purpose: Extends AbstractVan
 *
 * @author thomas
 * @version created on 11/21/2019 at 11:53 AM
 */
public class BoxVan extends AbstractVan {
    public BoxVan(Engine engine){
        this(engine, Colour.UNPAINTED);
    }
    public BoxVan(Engine engine, Colour coulour){
        super(engine,coulour);
    }
    public int getPrice(){
        return 10000;
    }
    public static void main(String[] args) {
        //dummy code for test purposes
        Vehicle myCar = new BoxVan(new StandardEngine(8500));
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
