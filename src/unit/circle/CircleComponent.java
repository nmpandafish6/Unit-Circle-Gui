package unit.circle;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import org.nico.math.generic.MathUtil;

/**
 *
 * @author mallory
 */
public class CircleComponent extends Canvas{

    private int width = 0;
    private int height = 0;
    private final MouseTracker mouseTracker = new MouseTracker();
    private boolean update = false;
    public double angle = 0;
    public double cos  = 0;
    public double sin = 0;
    private double lastAngle = 0;
    public CircleComponent(int width, int height){
        this.width = width;
        this.height = height;
        this.addMouseListener(mouseTracker);
        this.addMouseMotionListener(mouseTracker);
        this.setSize(width,height);
    }
    
    public void updateComponent(boolean changeRay){
        if(changeRay){
            if(mouseTracker.getUpdate()){
                int x = mouseTracker.getMouseX();
                int y = mouseTracker.getMouseY();
                y = height - y;
                double rise = (y - width/2);
                double run  = (x - height/2);
                angle = MathUtil.slopeToEulerAngle2(rise, run);
                angle = Math.round(angle / Resources.snap) * Resources.snap;
                if(angle != lastAngle){
                    this.repaint();
                }
                
            }
        }else{
            double rise = Resources.sin;
            double run  = Resources.cos;
            angle = MathUtil.slopeToEulerAngle2(rise, run);
            angle = Math.round(angle / Resources.snap) * Resources.snap;
                if(angle != lastAngle){
                    this.repaint();
                }
        }
        lastAngle = angle;
    }
    
    @Override
    public void paint(Graphics g){
        g.clearRect(0, 0, width, height);
        this.drawCircle(g, this.width/2, this.height/2, Math.min(this.width, this.height)/2);
        this.fillCircle(g, this.width/2, this.height/2, 2);
        this.drawRay(g, this.width/2, this.height/2, this.angle, Math.min(this.width, this.height)/2, 1);
    }
    
    public void drawCircle(Graphics g, int x, int y, int r){
        g.drawOval(x-r, y-r, 2*r, 2*r);
    }
    
    public void fillCircle(Graphics g, int x, int y, int r){
        g.fillOval(x-r, y-r, 2*r, 2*r);
    }
    
    public void drawRay(Graphics g, int centerX, int centerY, double angle, int r, int snap){
        int x = 0;
        int y = 0;
        double rads = Math.toRadians(angle);
        cos = Math.cos(rads);
        sin = Math.sin(rads);
        x = (int) (Math.cos(rads) * r) + centerX;
        y = (int) ((int) height - ((Math.sin(rads) * r) + centerY));
        g.drawLine(centerX, centerY, (int) x, (int) y);
    }
    
}
