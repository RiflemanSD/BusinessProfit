
package org.riflemansd.businessprofit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <h1>EsodaEksoda</h1>
 * <h3>Class NewClass</h3> 
 * <p>Created: 20 Ιαν 2016, 12:15:55 πμ</p>
 *
 * <p>Copyright © 2015 | RiflemanSD | All right reserved</p>
 *
 * @author RiflemanSD
 */
public class NewClass {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        // Get the date today using Calendar object.
        Date today = Calendar.getInstance().getTime();        
        // Using DateFormat format method we can create a string 
        // representation of a date with the defined format.
        String reportDate = df.format(today);
        
        System.out.println(reportDate);
    }
}
