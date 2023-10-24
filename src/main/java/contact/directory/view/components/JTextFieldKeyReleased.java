package contact.directory.view.components;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import contact.directory.view.interfaces.KeyReleasedListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author C.Mateo
 */
public class JTextFieldKeyReleased extends JTextField{
    
    private KeyReleasedListener keyReleasedListener;
    
    public  JTextFieldKeyReleased() {
        super();
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (keyReleasedListener != null) {
                    keyReleasedListener.keyReleased(e);
                }
            }
        });
    }

    public void setKeyReleasedListener(KeyReleasedListener keyReleasedListener) {
        this.keyReleasedListener = keyReleasedListener;
    }

    public void removeKeyReleasedListener() {
        this.keyReleasedListener = null;
    }

    
}
