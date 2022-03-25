package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {
  @Override
  public void robotInit() {
    CameraServer.startAutomaticCapture();
    Delay.Init(); // Initalise delay routine timer
  }

  @Override
  public void robotPeriodic() {
    Delay.Execute(); // Execute delayed tasks
  }

  @Override
  public void autonomousInit() {
    Delay.Enable();
    RobotMappings.autoModeSub.Run(); // Run auto code
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    Delay.Enable();
  }

  @Override
  public void teleopPeriodic() {
    RobotMappings.ballLiftSub.SetArmLift(OI.RIGHT_Y_AXIS()); // Set arm motor power to joystick axis

    RobotMappings.driveTrainSub.Drive(); // Run driveing tasks

    Scheduler.getInstance().run(); // Run sceduled tasks
  }

  @Override
  public void disabledInit() {
    Delay.Disable(); // Disable and kill all delayed or delayed executing tasks
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
