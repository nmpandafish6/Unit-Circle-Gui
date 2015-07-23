package unit.circle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author mallory
 */
public class MouseTracker extends MouseInputAdapter{

    private int mouseX = 0;
    private int mouseY = 0;
    private boolean update = false;
    private boolean clicked = true;
    
    public int getMouseX(){
        return mouseX;
    }
    
    public int getMouseY(){
        return mouseY;
    }
    
    public boolean getUpdate(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(MouseTracker.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean returnValue = update;
        update = false;
        return returnValue;
    }
    
    public boolean getClicked(){
        return clicked;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicked = true;
        update = mouseX != e.getX() || mouseY != e.getY();
        mouseX = e.getX();
        mouseY = e.getY();
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        update = mouseX != e.getX() || mouseY != e.getY();
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

}
