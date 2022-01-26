package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.subsystems.*;

public class RobotMappings {
    public static TalonSRX ballPuller = new TalonSRX(4);
    public static TalonSRX liftMotor = new TalonSRX(5);

    public static DriveTrainSub driveTrainSub = new DriveTrainSub();
    public static AutoModeSub autoModeSub = new AutoModeSub();
    public static BallAssemblySub ballAssemblySub = new BallAssemblySub();

    public static OI m_oi = new OI();
}
