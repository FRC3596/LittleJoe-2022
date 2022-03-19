package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BallLiftSub extends Subsystem {
    public static TalonSRX ballMover = new TalonSRX(4);
    // public static TalonSRX ballMover = new TalonSRX(4);
    public static CANSparkMax liftMotorLeft = new CANSparkMax(5, MotorType.kBrushless);
    // public static TalonSRX liftMotorLeft = new TalonSRX(5);
    public static CANSparkMax liftMotorRight = new CANSparkMax(6, MotorType.kBrushless);
    // public static TalonSRX liftMotorRight = new TalonSRX(6);

    public final int LiftStatus = 0;
    public final int ShootStatus = 1;
    public final int GatherStatus = 2;

    private static boolean LiftStatusInd = false;
    private static boolean ShootStatusInd = false;
    private static boolean GatherStatusInd = false;

    public BallLiftSub() {
        // Reset default settings on init
        liftMotorLeft.restoreFactoryDefaults();
        liftMotorRight.restoreFactoryDefaults();
    }

    @Override
    protected void initDefaultCommand() {}

    public boolean GetStatus(int value) {
        switch (value) {
            case LiftStatus:
                return LiftStatusInd;
            case ShootStatus:
                return ShootStatusInd;
            case GatherStatus:
                return GatherStatusInd;
        }
        return false;
    }

    public void Lift (boolean Status) {
        if (Status) {
            liftMotorLeft.set(0.5);
            liftMotorRight.set(0.5);
        } else {
            liftMotorLeft.set(0);
            liftMotorRight.set(0);
        }

        LiftStatusInd = Status;
    }

    public void Shoot(boolean Status) {
        Gather(false);

        if (Status) {
            ballMover.set(ControlMode.PercentOutput, -0.5); // TODO: Flip negative to gather if backwards
        } else {
            ballMover.set(ControlMode.PercentOutput, 0);
        }

        ShootStatusInd = Status;
    }

    public void Gather(boolean Status) {
        Shoot(false);

        if (Status) {
            ballMover.set(ControlMode.PercentOutput, 0.5);
        } else {
            ballMover.set(ControlMode.PercentOutput, 0);
        }

        GatherStatusInd = Status;
    }
}
