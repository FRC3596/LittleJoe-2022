package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  @Override
  public void robotInit() {
    Delay.Init(); // Initalise delay routine timer
  }

  @Override
  public void robotPeriodic() {
    Delay.Execute(); // Execute delayed tasks
  }

  @Override
  public void autonomousInit() {
    Delay.Enable();
    RobotMappings.autoModeSub.Drive2Feet();
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    Delay.Enable();
  }

  @Override
  public void teleopPeriodic() {
    // RobotMappings.ballLiftSub.Lift(true);
    RobotMappings.ballLiftSub.SetBallMover(OI.RIGHT_X_AXIS());
    RobotMappings.ballLiftSub.SetArmLift(OI.RIGHT_Y_AXIS());

    RobotMappings.driveTrainSub.Drive();
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
    Delay.Disable();
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {
    Delay.Enable();
  }

  @Override
  public void testPeriodic() {}
}
