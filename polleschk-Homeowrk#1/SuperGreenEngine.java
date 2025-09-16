/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class SuperGreenEngine
 * Name: thomas
 * Created 11/21/2019
 */
package week03.decorator;

/**
 * Course SE2811-051
 * Winter 2019-2020
 * SuperGreenEngine purpose: third party product
 *
 * @author thomas
 * @version created on 11/21/2019 at 1:11 PM
 */
public class SuperGreenEngine  {
    private int size;
    public SuperGreenEngine(int size){
        this.size=size;
    }
    public int getEngineSize(){
        return size;
    }
    public String toString(){
        return "SUPER ENGINE "+ size;
    }
}
