package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMappings;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class BallLiftSub extends Subsystem {
    public static VictorSPX ballMover = new VictorSPX(4);
    public static CANSparkMax liftMotorLeft = new CANSparkMax(5, MotorType.kBrushless);
    public static CANSparkMax liftMotorRight = new CANSparkMax(6, MotorType.kBrushless);

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

    public void Shoot(boolean Status) {
        if (Status) {
            ballMover.set(ControlMode.PercentOutput, -1); // TODO: Flip negative to gather if backwards
        } else {
            ballMover.set(ControlMode.PercentOutput, 0);
        }

        ShootStatusInd = Status;
    }

    public void Gather(boolean Status) {
        if (Status) {
            ballMover.set(ControlMode.PercentOutput, 1);
        } else {
            ballMover.set(ControlMode.PercentOutput, 0);
        }

        GatherStatusInd = Status;
    }

    public void SetArmLift(double value) {
        if (!RobotMappings.ArmTopStatus.get() && value < 0)
        {
            liftMotorLeft.set(0);
            liftMotorRight.set(0);
        }
        /*
        else if (!RobotMappings.ArmBottomStatus.get() && value > 0)
        {
            liftMotorLeft.set(0);
            liftMotorRight.set(0);
        
        }*/ else {
            liftMotorLeft.set(value/5);
            liftMotorRight.set(value*-1/5);
        }
    }
}
