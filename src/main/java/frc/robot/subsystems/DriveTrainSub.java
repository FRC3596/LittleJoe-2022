package frc.robot.subsystems;

import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveTrainSub extends Subsystem {
    public static final TalonSRX LeftTop = new TalonSRX(0);
    public static final TalonSRX LeftBottom = new TalonSRX(1);
    public static final TalonSRX RightTop = new TalonSRX(2);
    public static final TalonSRX RightBottom = new TalonSRX(3);
    
    public DriveTrainSub() {}

    @Override
    protected void initDefaultCommand() {}
    
    public void Drive() {
        RightBottom.set(ControlMode.PercentOutput, (OI.LEFT_Y_AXIS()-(OI.LEFT_X_AXIS()*-1)));
        RightTop.set(ControlMode.PercentOutput, (OI.LEFT_Y_AXIS()-(OI.LEFT_X_AXIS()*-1)));

        LeftBottom.set(ControlMode.PercentOutput, ((OI.LEFT_Y_AXIS()*-1)-(OI.LEFT_X_AXIS()*-1)));
        LeftTop.set(ControlMode.PercentOutput, ((OI.LEFT_Y_AXIS()*-1)-(OI.LEFT_X_AXIS()*-1)));
    }
}
