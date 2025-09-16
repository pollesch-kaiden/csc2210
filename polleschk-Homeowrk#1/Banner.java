/*
 * SE2811-051
 * Winter 2019-2020
 * File header: contains the class Banner
 * Name: thomas
 * Created: 9/26/2019
 */
package week03.decorator;

import java.util.Date;

/**
 * SE2811-051
 * Winter 2019-2020
 * Class purpose: This class will take an input string and
 * return a banner made from that string, the user name and date
 * @author thomas
 * @version 2.0 Created on 9/26/2019 at 8:41 AM.
 * @version 2.12 Modified 11/21/2019 for SE2811
 */
public class Banner {
    private String greeting;

    /**
     * Provide a general purpose greeting banner
     * @param inputGreeting:String basic banner that describes program to be branded
     */
    public Banner(String inputGreeting){
        greeting = inputGreeting;
    }

    /**
     * Default Constructor: greeting is "" + branding
     */
    public Banner(){
        this("");
    }
    /**
     * get function to obtain the greeting String
     * @return complete String with date, author and greeting
     */
    /**
     * getter
     * @return greeting:String
     */
    public String getGreeting(){
        return greeting;
    }

    /**
     * adds date and author to greeting; personalize this with your email name
     * @return banner
     */
    public String getBanner(){
        Date currentDate = new Date();
        return getGreeting()+"\nThe date is : "+currentDate+"\nBy thomas";
    }



    /**
     * Overrides toString to be getBanner()
     * @return returns getBanner()
     */public String toString(){
        return getBanner();
    }
    public static void main(String[] args) {
        System.out.println(new Banner("test banner"));
        Banner testBanner= new Banner("test banner2");
        System.out.println(testBanner+ "\nAnd next: "+ testBanner.getBanner());
    }
}
