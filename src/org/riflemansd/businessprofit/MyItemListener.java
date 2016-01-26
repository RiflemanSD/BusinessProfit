
package org.riflemansd.businessprofit;

import org.riflemansd.businessprofit.main.InsertForm;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * <h1>EsodaEksoda</h1>
 * <h3>Class MyItemListener</h3> 
 * <p>Created: 23 Ιαν 2016, 11:27:44 μμ</p>
 *
 * <p>Copyright © 2015 | RiflemanSD | All right reserved</p>
 *
 * @author RiflemanSD
 */
public class MyItemListener implements ItemListener{
    private InsertForm f;
    
    public MyItemListener(InsertForm f) {
        this.f = f;
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie) {
        Object i = ie.getItem();
        int s = ie.getStateChange();
        
        System.out.println(i + " " + s);
        
        if (s == 1) {
            this.f.setInsertPanel((String)i);
        }
    }

}
