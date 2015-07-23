package unit.circle;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author mallory
 */
public class FrameMaster extends JFrame{

    private CircleComponent circleFrame;
    private SettingsPanel settings;
    private JSplitPane settingsCircleDivider;
    private MouseTracker circleFrameListener;
    private MouseTracker settingsFrameListener;
    private boolean circleActive = true;
    public FrameMaster(){

        circleFrame = new CircleComponent(300,300);
        settings = new SettingsPanel(300,300);
        settingsCircleDivider = new JSplitPane();
        settingsCircleDivider.setEnabled(false);
        settingsCircleDivider.setLeftComponent(circleFrame);
        settingsCircleDivider.setRightComponent(settings);
        
        circleFrameListener = new MouseTracker();
        settingsFrameListener = new MouseTracker();
        circleFrame.addMouseListener(circleFrameListener);
        settings.addMouseListener(settingsFrameListener);
        
        this.add(settingsCircleDivider);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setName("Unit Circle");
        this.setTitle("Unit Circle");
        this.pack();
    }
    
    public void updateComponents(){
        
        if(circleFrameListener.getClicked()){
            circleActive = true;
            circleFrame.updateComponent(true);
            
            Resources.angle = circleFrame.angle;
            Resources.cos = circleFrame.cos;
            Resources.sin = circleFrame.sin;
            
            settings.updateComponent(true);
        }else if(settingsFrameListener.getClicked()){
            circleActive = false;
            settings.updateComponent(false);
            
            circleFrame.updateComponent(false);
        }else{   
        }
    }
}
