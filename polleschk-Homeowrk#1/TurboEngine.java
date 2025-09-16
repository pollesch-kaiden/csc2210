/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class TurboEngine
 * Name: thomas
 * Created 11/20/2019
 */

package week03.decorator;


/**
 * Course: SE2811-051
 * Winter 2019-2020
 * TurboEngine purpose: the turbo charged engine
 *
 * @author thomas
 * @version created on 11/20/2019 at 4:53 PM
 */
public class TurboEngine extends AbstractEngine {
    public TurboEngine(int size){
        super(size,true);   //turbocharged
    }
    public static void main(String[] args) {
        //dummy code
        TurboEngine zoom = new TurboEngine(1500);
        System.out.println(zoom);
    }
}
