package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMappings;
import frc.robot.subsystems.BallLiftSub;

public class BallLift extends Command {

    private final BallLiftSub Sub;
    private final boolean Active;

    public BallLift(BallLiftSub s, boolean a) {
        Sub = s;
        requires(Sub);

        Active = a;
    }

    @Override
    public void initialize() {
        System.out.println("Ball Lift command executed");
        RobotMappings.ballLiftSub.Lift(Active);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    
}
