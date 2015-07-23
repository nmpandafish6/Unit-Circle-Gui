package unit.circle;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mallory
 */
public class JLabeledField extends JPanel{

    private JLabel label;
    private JFormattedTextField textField;
    private DecimalFormat decimalFormat;
    public JLabeledField(String label, int col){
        this.decimalFormat = new DecimalFormat("#.###");
        this.label = new JLabel(label);
        this.textField = new JFormattedTextField(decimalFormat);
        this.textField.setColumns(col);
        this.add(this.label);
        this.add(this.textField);
    }
    
    public String getText(){
        return this.textField.getText();
    }
    
    public void setText(String text){
        text = this.decimalFormat.format(Double.parseDouble(text));
        this.textField.setText(text);
    }
    
}
