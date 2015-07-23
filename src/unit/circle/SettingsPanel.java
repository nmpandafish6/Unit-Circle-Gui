package unit.circle;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import org.nico.math.generic.MathUtil;

/**
 *
 * @author mallory
 */
public class SettingsPanel extends JPanel{

    private JLabeledField xField;
    private JLabeledField yField;
    private JLabeledField angleField;
    private JLabeledField snapField;
    private JButton incrementButton;
    private JButton decrementButton;
    private JButton updateButton;
    private JPanel buttonPanel;
    private MouseTracker incrementTracker;
    private MouseTracker decrementTracker;
    private MouseTracker updateTracker;
    public SettingsPanel(int width, int height){
        this.setSize(width,height);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        xField = new JLabeledField("Cos : ", 15);
        yField = new JLabeledField("Sin : ", 15);
        angleField = new JLabeledField("Angle : ", 15);
        snapField = new JLabeledField("Snap : ", 15);
        xField.setText("1");
        yField.setText("0");
        angleField.setText("0");
        snapField.setText("1");
        buttonPanel = new JPanel();
        incrementButton = new JButton("+");
        incrementButton.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        incrementButton.setPreferredSize(new Dimension(60,60));
        decrementButton = new JButton("-");
        decrementButton.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        decrementButton.setPreferredSize(new Dimension(60,60));
        updateButton = new JButton("UPDATE");
        updateButton.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        updateButton.setPreferredSize(new Dimension(100,60));
        
        incrementTracker = new MouseTracker();
        decrementTracker = new MouseTracker();
        updateTracker = new MouseTracker();
        
//        buttonPanel.add(incrementButton);
//        buttonPanel.add(decrementButton);
        //buttonPanel.add(updateButton);
        int buttonWidth = width - (incrementButton.getPreferredSize().width + decrementButton.getPreferredSize().width + updateButton.getPreferredSize().width);
        int buttonHeight = incrementButton.getPreferredSize().height;
        buttonPanel.add(Box.createRigidArea(new Dimension(buttonWidth, buttonHeight)));
        this.add(buttonPanel);
        xField.add(Box.createRigidArea(new Dimension(300 - xField.getPreferredSize().width, xField.getPreferredSize().height)));
        this.add(xField);
        yField.add(Box.createRigidArea(new Dimension(300 - yField.getPreferredSize().width, yField.getPreferredSize().height)));
        this.add(yField);
        angleField.add(Box.createRigidArea(new Dimension(300 - angleField.getPreferredSize().width, angleField.getPreferredSize().height)));
        this.add(angleField);
        snapField.add(Box.createRigidArea(new Dimension(300 - snapField.getPreferredSize().width, snapField.getPreferredSize().height)));
        this.add(snapField);
    }
    
    public void updateComponent(boolean changeText){
        if(changeText){
            angleField.setText((Resources.angle) + "");
            xField.setText(Resources.cos + "");
            yField.setText(Resources.sin + "");
        }else{
            try{
                if(updateTracker.getClicked()){
                    Resources.snap = Double.parseDouble(snapField.getText().isEmpty() ? "0" : snapField.getText());
                    Resources.angle = Double.parseDouble(angleField.getText().isEmpty() ? "0" : angleField.getText());
                    if(Resources.angle== Resources.lastAngle) {
                        Resources.cos = Double.parseDouble(xField.getText().isEmpty() ? "0" : xField.getText());
                        Resources.sin = Double.parseDouble(yField.getText().isEmpty() ? "0" : yField.getText());
                        double rise = Resources.sin;
                        double run  = Resources.cos;
                        double angle = MathUtil.slopeToEulerAngle2(rise, run);
                        angle = Math.round(angle / Resources.snap) * Resources.snap;
                        if(Resources.angle != angle){
                            Resources.angle = angle;
                            angleField.setText((Resources.angle) + "");
                        }
                    }else{
                        Resources.cos = Math.cos(Math.toRadians(Resources.angle));
                        Resources.sin = Math.sin(Math.toRadians(Resources.angle));
                        xField.setText(Resources.cos + "");
                        yField.setText(Resources.sin + "");
                    }
                    
                }
            }catch(Exception e){
                Resources.angle = 0;
                Resources.cos = 0;
                Resources.sin = 0;
            }
            Resources.lastAngle = Resources.angle;
        }
    }
}
