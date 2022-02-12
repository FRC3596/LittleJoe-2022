package frc.robot;

import java.util.Iterator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Timer;

public class Delay {
    private static Timer clock = new Timer();
    private static ArrayList<DelayItem> MotorDelays = new ArrayList<DelayItem>();
    private static boolean Enabled = true;
   
    public static void Enable() {
        Enabled = true;
    }

    public static void Disable() {
        Enabled = false;
    }

    public static void BotSpeed(double offset, double speed) {
        MotorDelays.add(new DelayItem(
            true, 
            0, 
            clock.get() + offset, 
            speed
        ));
    }

    public static void MotorSpeed(int id, double offset, double speed) {
        MotorDelays.add(new DelayItem(
            false,
            id,
            clock.get() + offset,
            speed)
        );
    }

    public static void Execute() {
        if (!Enabled) {
            MotorDelays.clear();
            return;
        }

        Iterator<DelayItem> MotorDleaysIt = MotorDelays.iterator();

        while (MotorDleaysIt.hasNext()) {
            DelayItem key = MotorDleaysIt.next();

            if (clock.get() > key.delay) {
                if (key.IsBot) {
                    RobotMappings.driveTrainSub.SetSpeed(key.speed);
    
                    MotorDleaysIt.remove();
                    continue;
                }

                new TalonSRX(key.ID).set(ControlMode.PercentOutput, key.speed);
                MotorDleaysIt.remove();
            }
        }
    }

    public static void Init() {
        clock.start();
    }
}
