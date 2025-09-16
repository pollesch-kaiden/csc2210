/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains interface Vehicle
 * Name: thomas
 * Created 11/20/2019
 */
package week03.decorator;


/**
 * Course: SE2811-051
 * Winter 2019-2020
 * Interface purpose: Factory makes cars and vans
 *
 * @author thomas
 * @version created on 11/20/2019 at 4:40 PM
 */
public interface Vehicle {
    public enum Colour {UNPAINTED, BLUE, BLACK, GREEN, RED, SILVER, WHITE, YELLOW};
    public Engine getEngine();
    public Colour getColour();
    public int getPrice();
    public void paint(Colour colour);
    //for facade pattern
    public void cleanInterior();
    public void cleanExteriorBody();
    public void polishWindows();
    public void takeForTestDrive();
}
