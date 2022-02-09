package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMappings;
import frc.robot.subsystems.BallAssemblySub;

public class BallPickup extends Command {

    private final BallAssemblySub Sub;
    private final boolean Active;

    public BallPickup(BallAssemblySub s, boolean a) {
        Sub = s;
        requires(Sub);

        Active = a;
    }

    @Override
    public void initialize() {
        if (Active) {
           RobotMappings.ballLiftSub.Gather(true);
        } else {
           RobotMappings.ballLiftSub.Gather(false);
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    
}
