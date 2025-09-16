/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class Sport
 * Name: thomas
 * Created 11/21/2019
 */
package week03.decorator;

/**
 * Course SE2811-051
 * Winter 2019-2020
 * Sport purpose: Extends AbstractCar
 *
 * @author thomas
 * @version created on 11/21/2019 at 11:49 AM
 */
public class Sport extends AbstractCar {
    public Sport(Engine engine){
        this(engine, Colour.UNPAINTED);
    }
    public Sport(Engine engine, Colour coulour){
        super(engine,coulour);
    }
    public int getPrice(){
        return 8000;
    }
    public static void main(String[] args) {
        //dummy code
        Sport myCar = new Sport(new TurboEngine(2400), Colour. RED);
        System.out.println(myCar);
    }
}
