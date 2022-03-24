package frc.robot.subsystems;

import frc.robot.Delay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AutoModeSub extends Subsystem {

    @Override
    protected void initDefaultCommand() {}
    
    public void Run() {
        Delay.MotorSpeed(4, 3, -0.5); // Shoot balls
        Delay.MotorSpeed(4, 5, 0);    // Stop shooting after 2 seconds

        Delay.MotorSpeed(5, 6, -0.5); // Reverse lift
        Delay.MotorSpeed(5, 7, 0);    // Stop lift
    }
}
