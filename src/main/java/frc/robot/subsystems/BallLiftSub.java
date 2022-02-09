package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BallLiftSub extends Subsystem {
    public static TalonSRX ballPuller = new TalonSRX(4);
    public static TalonSRX liftMotor = new TalonSRX(5);

    @Override
    protected void initDefaultCommand() {}

    public void Lift (boolean Status) {
        if (Status) {
            liftMotor.set(ControlMode.PercentOutput, 0.5);
        } else {
            liftMotor.set(ControlMode.PercentOutput, 0);
        }
    }

    public void Shoot(boolean Status) {
        if (Status) {
            ballPuller.set(ControlMode.PercentOutput, -0.5);
        } else {
            ballPuller.set(ControlMode.PercentOutput, 0);
        }

    }

    public void Gather(boolean Status) {
        if (Status) {
            ballPuller.set(ControlMode.PercentOutput, 0.5);
        } else {
            ballPuller.set(ControlMode.PercentOutput, 0);
        }
    }
}


