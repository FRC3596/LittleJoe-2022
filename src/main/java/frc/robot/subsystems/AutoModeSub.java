package frc.robot.subsystems;

import frc.robot.Delay;
import frc.robot.RobotMappings;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AutoModeSub extends Subsystem {

    @Override
    protected void initDefaultCommand() {}
    
    public void Drive2Feet() {
        RobotMappings.driveTrainSub.SetSpeed(0.5); // TODO; reverse if backwards
        Delay.DelayMotorSpeed(2, 0);
    }
    
}
