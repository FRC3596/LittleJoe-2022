package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMappings;
import frc.robot.subsystems.BallLiftSub;

public class BallPickup extends Command {

    private final BallLiftSub Sub;
    private final boolean Active;

    public BallPickup(BallLiftSub s, boolean a) {
        Sub = s;
        requires(Sub);

        Active = a;
    }

    @Override
    public void initialize() {
        RobotMappings.ballLiftSub.Gather(Active);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    
}
