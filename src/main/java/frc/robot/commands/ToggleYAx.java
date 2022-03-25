package frc.robot.commands;

import frc.robot.RobotMappings;
import frc.robot.subsystems.DriveTrainSub;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleYAx extends Command {

    private final DriveTrainSub Sub;

    public ToggleYAx(DriveTrainSub s) {
        Sub = s;
        requires(Sub);
    }

    @Override
    public void initialize() {
        RobotMappings.driveTrainSub.ToggleAxisFlip();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    
}
