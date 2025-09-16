/*
 * Course: SE2811-051
 * Winter 2019-2020
 * File header contains class AbstractVan
 * Name: thomas
 * Created 11/20/2019
 */
package week03.decorator;


/**
 * Course: SE2811-051
 * Winter 2019-2020
 * AbstractVan purpose: extends AbstractVehicle
 *
 * @author thomas
 * @version created on 11/20/2019 at 5:22 PM
 */
public abstract class AbstractVan extends AbstractVehicle {
    /**
     * testDriveInstructions purpose: instructions for test drive
     * @author polleschk
     */
    private String testDriveInstructions = "Taking for test drive";

    public AbstractVan(Engine engine, Colour colour){
       super(engine,colour);
    }

    public AbstractVan(Engine engine){
        this(engine, Colour.UNPAINTED);
    }

    /**
     * getTestDriveInstructions purpose: getter for testDriveInstructions
     * @return testDriveInstructions
     * @author polleschk
     */
    public void setTestDriveInstructions(String testDriveInstructions){
        this.testDriveInstructions = testDriveInstructions;
    }

    /**
     * getTestDriveInstructions purpose: getter for testDriveInstructions
     * @return testDriveInstructions
     * @author polleschk
     */
    @Override
    public void takeForTestDrive(){
        System.out.println(testDriveInstructions);
    }
}
