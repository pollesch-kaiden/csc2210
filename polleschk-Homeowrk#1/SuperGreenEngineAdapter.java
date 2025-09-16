/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class SuperGreenEngineAdapter
 * Name: thomas
 * Created 11/21/2019
 */
package week03.decorator;


/**
 * Course SE2811-051
 * Winter 2019-2020
 * SuperGreenEngineAdapter purpose: extends AbstractEngine
 *
 * @author thomas
 * @version created on 11/21/2019 at 1:07 PM
 */
public class SuperGreenEngineAdapter extends AbstractEngine {
    public SuperGreenEngineAdapter(SuperGreenEngine greenEngine) {
        super(greenEngine.getEngineSize(), false);
    }
}
