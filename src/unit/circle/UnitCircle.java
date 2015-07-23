package unit.circle;

/**
 *
 * @author mallory
 */
public class UnitCircle {

    
    public static void main(String[] args) {
        FrameMaster frameMaster = new FrameMaster();
        while(true){
            Resources.angle = (Resources.angle + 360) % 360;
            Resources.lastAngle = (Resources.lastAngle + 360) % 360;
            frameMaster.updateComponents();
        }
    }

}
