/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class AdapterDriverExample
 * Name: thomas
 * Created 11/21/2019
 */
package week03.decorator;



import java.util.ArrayList;
import java.util.List;

/**
 * Course SE2811-051
 * Winter 2019-2020
 * AdapterDriverExample purpose: Provide an example with 3rd party engine in a collection
 *
 * @author thomas
 * @version created on 11/21/2019 at 1:20 PM
 */
public class AdapterDriverExample {
    public static List<Engine>  engines = new ArrayList<Engine>();
    public static SuperGreenEngine greenEngine = new SuperGreenEngine(1200);
    public static void main(String[] args) {
        //dummy code

        engines.add(new StandardEngine(1300));
        engines.add(new StandardEngine(1600));
        engines.add(new TurboEngine(2000));

        engines.add(new SuperGreenEngineAdapter(greenEngine));

        for(Engine engine: engines){
            System.out.println(engine);
        }
    }
}
