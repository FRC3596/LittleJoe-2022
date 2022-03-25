package frc.robot.subsystems;

import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveTrainSub extends Subsystem {
    private static final TalonSRX LeftTop = new TalonSRX(0);
    private static final TalonSRX LeftBottom = new TalonSRX(1);
    private static final TalonSRX RightTop = new TalonSRX(2);
    private static final TalonSRX RightBottom = new TalonSRX(3);

    private static boolean InvertAxis = false;
    
    public DriveTrainSub() {}

    @Override
    protected void initDefaultCommand() {}
    
    public void Drive() {
        if (InvertAxis) {
            RightBottom.set(ControlMode.PercentOutput, (((OI.LEFT_Y_AXIS()*-1)*-1)-(OI.LEFT_X_AXIS()*-1)));
            RightTop.set(ControlMode.PercentOutput, (((OI.LEFT_Y_AXIS()*-1)*-1)-(OI.LEFT_X_AXIS()*-1)));
    
            LeftBottom.set(ControlMode.PercentOutput, ((OI.LEFT_Y_AXIS()*-1)-(OI.LEFT_X_AXIS()*-1)));
            LeftTop.set(ControlMode.PercentOutput, ((OI.LEFT_Y_AXIS()*-1)-(OI.LEFT_X_AXIS()*-1)));
            return;
        }

        RightBottom.set(ControlMode.PercentOutput, ((OI.LEFT_Y_AXIS()*-1)-(OI.LEFT_X_AXIS()*-1)));
        RightTop.set(ControlMode.PercentOutput, ((OI.LEFT_Y_AXIS()*-1)-(OI.LEFT_X_AXIS()*-1)));

        LeftBottom.set(ControlMode.PercentOutput, (OI.LEFT_Y_AXIS()-(OI.LEFT_X_AXIS()*-1)));
        LeftTop.set(ControlMode.PercentOutput, (OI.LEFT_Y_AXIS()-(OI.LEFT_X_AXIS()*-1)));
    }

    public void SetSpeed(double s) {
        RightBottom.set(ControlMode.PercentOutput, s);
        RightTop.set(ControlMode.PercentOutput, s);
        LeftBottom.set(ControlMode.PercentOutput, s*-1);
        LeftTop.set(ControlMode.PercentOutput, s*-1);
    }

    public void ToggleAxisFlip() {
        InvertAxis = !InvertAxis;
    }
}
