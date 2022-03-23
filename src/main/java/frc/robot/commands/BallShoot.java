package frc.robot.commands;

import frc.robot.RobotMappings;
import frc.robot.subsystems.BallLiftSub;

import edu.wpi.first.wpilibj.command.Command;

public class BallShoot extends Command {

    private final BallLiftSub Sub;
    private final Boolean Active;

    public BallShoot(BallLiftSub s, boolean a) {
        Sub = s;
        requires(Sub);

        Active = a;
    }

    @Override
    public void initialize() {
        RobotMappings.ballLiftSub.Shoot(Active);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    
}
