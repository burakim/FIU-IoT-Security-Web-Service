package iotsecurity;

/**
 * Created by Burak on 9/24/17.
 */
public class ApplicationConstants {


    private static ApplicationConstants self;

    public static void init()
    {
     if(self == null)
         self = new ApplicationConstants();
    }

    public enum RequestResult{
        SUCCESS,
        FAIL
    }
}
