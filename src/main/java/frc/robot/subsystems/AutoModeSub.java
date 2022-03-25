package frc.robot.subsystems;

import frc.robot.Delay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AutoModeSub extends Subsystem {

    @Override
    protected void initDefaultCommand() {}
    
    public void Run() {
        // Delay.MotorSpeed(4, 3, -0.5); // Shoot balls
        // Delay.MotorSpeed(4, 5, 0);    // Stop shooting after 2 seconds

        // Delay.MotorSpeed(5, 6, -0.5); // Reverse lift
        // Delay.MotorSpeed(5, 7, 0);    // Stop lift

        Delay.MotorSpeed(4, 0, -1); // Activate shoot for 1 second - 0 second
        Delay.MotorSpeed(4, 2, 0); // Deactivate shoot for 1 second - 1 second
        Delay.BotSpeed(2, -0.5); // Activate drive for 2 seconds at max speed - 2 seconds
        Delay.BotSpeed(4, 0); // Deactivate drive - 4 seconds
    }
}
