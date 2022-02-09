package frc.robot.commands;

import frc.robot.RobotMappings;
import frc.robot.subsystems.BallAssemblySub;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class BallLaunch extends Command {

    private final BallAssemblySub Sub;
    private final Boolean Active;

    public BallLaunch(BallAssemblySub s, boolean a) {
        Sub = s;
        requires(Sub);

        Active = a;
    }

    @Override
    public void initialize() {
        if (Active) {
           RobotMappings.ballLiftSub.Shoot(true);
        } else {
           RobotMappings.ballLiftSub.Shoot(false);
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    
}
