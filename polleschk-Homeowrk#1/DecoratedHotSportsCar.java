/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class DecoratedHotSportsCar
 * Name: thomas
 * Created 12/14/2019
 */
package week03.decorator;


/**
 * Course SE2811-051
 * Winter 2019-2020
 * DecoratedHotSportsCar purpose: Decorates a Sports Car starting
 * with a Turbo Engine. Illustrates the process with three options: MetallicPaint, SatNav and AirConditioning
 *
 * @author thomas
 * @version created on 12/14/2019 at 12:27 PM
 */
public class DecoratedHotSportsCar {
    private Vehicle hotSportsCar=new Sport(new TurboEngine(2400), Vehicle.Colour.UNPAINTED);
    public Vehicle getHotSportsCar(Vehicle.Colour colour){
        System.out.println(hotSportsCar);
        hotSportsCar.paint(colour);
        System.out.println(hotSportsCar);
        hotSportsCar=new MetallicPaint(hotSportsCar);
        System.out.println(hotSportsCar);
        hotSportsCar=new SatNav(hotSportsCar);
        System.out.println(hotSportsCar);
        hotSportsCar=new AirConditioning(hotSportsCar);
        System.out.println(hotSportsCar);
        return hotSportsCar;
    }
    public static void main(String[] args) {
        //code for unit testing of class
        DecoratedHotSportsCar decoratedHotSportsCar = new DecoratedHotSportsCar();
        Vehicle myHotSportsCar=decoratedHotSportsCar.getHotSportsCar(Vehicle.Colour.GREEN);
        System.out.println("\n"+myHotSportsCar);
    }
}
