package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.subsystems.*;

public class RobotMappings {
    public static DigitalInput ArmTopStatus = new DigitalInput(0);
    public static DigitalInput ArmBottomStatus = new DigitalInput(1);

    public static BallLiftSub ballLiftSub = new BallLiftSub();
    public static DriveTrainSub driveTrainSub = new DriveTrainSub();
    public static AutoModeSub autoModeSub = new AutoModeSub();
    
    public static OI m_oi = new OI();
}
