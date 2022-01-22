package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.BallAssemblySub;

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
        
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    
}
