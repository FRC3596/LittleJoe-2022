package frc.robot;

import java.util.HashMap;
import java.util.Iterator;

import edu.wpi.first.wpilibj.Timer;

public class Delay {
    private static Timer clock = new Timer();
    private static HashMap<Double, Double> MotorSpeedDelays = new HashMap<>();
    private static boolean Enabled = true;
   
    public static void Enable() {
        Enabled = true;
    }

    public static void Disable() {
        Enabled = false;
    }

    public static void DelayMotorSpeed(double offset, double speed) {
        MotorSpeedDelays.put(clock.get() + offset, speed);
    }

    public static void Execute() {
        if (!Enabled) {
            MotorSpeedDelays.clear();
            return;
        }

        Iterator<Double> MotorSpeedDleaysIt = MotorSpeedDelays.keySet().iterator();

        while (MotorSpeedDleaysIt.hasNext()) {
            Double key = MotorSpeedDleaysIt.next();
            Double value = MotorSpeedDelays.get(key);

            if (clock.get() > value) {
                RobotMappings.driveTrainSub.SetSpeed(value);
                MotorSpeedDleaysIt.remove();
            }
        }
    }

    public static void Init() {
        clock.start();
    }
}
