package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMappings;

public class AutoModeSub extends Subsystem {
    @Override
    protected void initDefaultCommand() {}
    
    public void Drive2Feet() {
        RobotMappings.driveTrainSub.SetSpeed(0.5);
        RobotMappings.driveTrainSub.SetSpeed(0);
    }
}
