package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMappings;
import frc.robot.subsystems.BallAssemblySub;

public class BallLift extends Command {

    private final BallAssemblySub Sub;
    private final boolean Active;

    public BallLift(BallAssemblySub s, boolean a) {
        Sub = s;
        requires(Sub);

        Active = a;
    }

    @Override
    public void initialize() {
        if (Active) {
            RobotMappings.liftMotor.set(ControlMode.PercentOutput, 0.5);
        } else {
            RobotMappings.liftMotor.set(ControlMode.PercentOutput, 0);
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    
}
