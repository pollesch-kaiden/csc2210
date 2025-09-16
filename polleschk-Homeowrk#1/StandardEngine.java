/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class StandardEngine
 * Name: thomas
 * Created 11/20/2019
 */
package week03.decorator;


/**
 * Course: SE2811-051
 * Winter 2019-2020
 * StandardEngine purpose: the standard engine for the factory
 *
 * @author thomas
 * @version created on 11/20/2019 at 4:50 PM
 */
public class StandardEngine extends AbstractEngine {
    public StandardEngine(int size){
        super(size,false);  //not turbo charged
    }
    public static void main(String[] args) {
        //dummy code
        StandardEngine slow = new StandardEngine(850);
        System.out.println(slow);
    }
}
