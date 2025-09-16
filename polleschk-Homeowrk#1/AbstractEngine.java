/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class AbstractEngine
 * Name: thomas
 * Created 11/20/2019
 */
package week03.decorator;


/**
 * Course: SE2811-051
 * Winter 2019-2020
 * AbstractEngine purpose: The abstract engine class
 *
 * @author thomas
 * @version created on 11/20/2019 at 4:45 PM
 */
public abstract class AbstractEngine implements Engine {
    private int size;
    private boolean turbo;

    public AbstractEngine(int size, boolean turbo){
        this.size =size;
        this.turbo=turbo;
    }
    public int getSize(){
        return size;
    }
    public boolean isTurbo(){
        return turbo;
    }
    public String toString(){
        return getClass().getSimpleName()+" ("+size+")";
    }
    public static void main(String[] args) {
        //dummy code
    }
}
