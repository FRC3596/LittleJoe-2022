package frc.robot;

import java.util.Iterator;
import java.util.ArrayList;

import edu.wpi.first.wpilibj.Timer;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


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
            false,
            true, 
            0, 
            clock.get() + offset, 
            speed
        ));
    }

    public static void MotorSpeed(int id, double offset, double speed) {
        MotorDelays.add(new DelayItem(
            false,
            false,
            id,
            clock.get() + offset,
            speed)
        );
    }

    public static void ArmSpeed(double offset, double speed) {
        MotorDelays.add(
            new DelayItem(
                true,
                false,
                0,
                offset,
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
                /*
                if (key.IsArm) {
                    RobotMappings.ballLiftSub.SetArmLift(key.speed);
                    
                    MotorDleaysIt.remove();
                    continue;
                }
                */

                if (key.IsBot) {
                    RobotMappings.driveTrainSub.SetSpeed(key.speed);
    
                    MotorDleaysIt.remove();
                    continue;
                }

                if (key.ID == 4) {
                    new VictorSPX(key.ID).set(ControlMode.PercentOutput, key.speed);
                } else {
                    new TalonSRX(key.ID).set(ControlMode.PercentOutput, key.speed);
                }
                MotorDleaysIt.remove();
            }
        }
    }

    public static void Init() {
        clock.start();
    }
}

class DelayItem {
    public DelayItem(boolean isarm, boolean isbot, int id, double o, double s) {
        IsArm = isarm;
        IsBot = isbot;
        ID = id;
        delay = o;
        speed = s;
    }

    public final boolean IsArm;
    public final boolean IsBot;
    public final int ID;
    public final double delay;
    public final double speed;
}
