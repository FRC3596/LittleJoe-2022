package frc.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.Timer;

public class Delay {
    private static Timer clock = new Timer();
    private static HashMap<Double, Double> MotorSpeedDelays = new HashMap<>();

    public static void DelayMotorSpeed(double offset, double speed) {
        MotorSpeedDelays.put(clock.get() + offset, speed);
    }

    public static void Execute() {
        MotorSpeedDelays.forEach((offset, speed) -> {
            if (clock.get() > offset) {
                RobotMappings.driveTrainSub.SetSpeed(speed);
                MotorSpeedDelays.remove(offset);
            }
        });
    }

    public static void Init() {
        clock.start();
    }
}
