package frc.robot.subsystems;

import frc.robot.Delay;
import frc.robot.RobotMappings;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AutoModeSub extends Subsystem {

    @Override
    protected void initDefaultCommand() {}
    
    public void Drive2Feet() {
        RobotMappings.driveTrainSub.SetSpeed(0.50); // TODO; reverse if backwards
        Delay.BotSpeed(60*2, -0.5);
        Delay.BotSpeed(60*4, 0);
    }
    
    public void TakeADump() {
        Delay.MotorSpeed(5, 0, 0.5);  // Start lift
        Delay.MotorSpeed(5, 2, 0);    // Stop lift after 2 seconds
        
        Delay.MotorSpeed(4, 3, -0.5); // Shoot balls
        Delay.MotorSpeed(4, 5, 0);    // Stop shooting after 2 seconds

        Delay.MotorSpeed(5, 6, -0.5); // Reverse lift
        Delay.MotorSpeed(5, 7, 0);    // Stop lift
    }
}
