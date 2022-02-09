package frc.robot.commands;

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
           RobotMappings.ballLiftSub.Lift(true);
        } else {
           RobotMappings.ballLiftSub.Lift(false);
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    
}
