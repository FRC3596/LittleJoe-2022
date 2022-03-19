package frc.robot.commands;

import frc.robot.RobotMappings;
import frc.robot.subsystems.BallAssemblySub;

import edu.wpi.first.wpilibj.command.Command;

public class BallShoot extends Command {

    private final BallAssemblySub Sub;
    private final Boolean Active;

    public BallShoot(BallAssemblySub s, boolean a) {
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