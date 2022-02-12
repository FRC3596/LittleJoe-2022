package frc.robot;

import frc.robot.subsystems.*;

public class RobotMappings {
    public static BallLiftSub ballLiftSub = new BallLiftSub();
    public static DriveTrainSub driveTrainSub = new DriveTrainSub();
    public static AutoModeSub autoModeSub = new AutoModeSub();
    public static BallAssemblySub ballAssemblySub = new BallAssemblySub();

    public static OI m_oi = new OI();
}

class DelayItem {
    public DelayItem(boolean isbot, int id, double o, double s) {
        IsBot = isbot;
        ID = id;
        delay = o;
        speed = s;
    }

    public final boolean IsBot;
    public final int ID;
    public final double delay;
    public final double speed;
}