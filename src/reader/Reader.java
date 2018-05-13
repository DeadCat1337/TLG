package reader;

import gui.Window;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leha
 */
public class Reader implements Runnable{
    File f;
            
    public Reader(Window w, String path){
        f = new File(path);
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(10);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
