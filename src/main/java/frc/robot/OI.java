package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	/*
	Setup for Joystick class.
	This is every button and joystick on the controller that can be used in the code
	*/
	private static XboxController joy = new XboxController(0);

	public static JoystickButton A = new JoystickButton(joy, 1);
	public static JoystickButton B = new JoystickButton(joy, 2);
	public static JoystickButton X = new JoystickButton(joy, 3);
	public static JoystickButton Y = new JoystickButton(joy, 4);
	public static JoystickButton LB = new JoystickButton(joy, 5);
	public static JoystickButton RB = new JoystickButton(joy, 6);
	public static JoystickButton BACK = new JoystickButton(joy, 7);
	public static JoystickButton START = new JoystickButton(joy, 8);
	public static JoystickButton LSB = new JoystickButton(joy, 9);
	public static JoystickButton RSB = new JoystickButton(joy, 10);

	public static Button LT = new LTrigger();
	public static Button RT = new RTrigger();

	// Left joystick X axis
	public static double LEFT_X_AXIS() {
        return joy.getRawAxis(0);
    }

	// Left joystick Y axis
    public static double LEFT_Y_AXIS() {
        return joy.getRawAxis(1);
    }

	public static double GetLT() {
		return joy.getRawAxis(2);
	}

	public static double GetRT() {
		return joy.getRawAxis(3);
	}

	// Right joystick X axis
    public static double RIGHT_X_AXIS() {
        return joy.getRawAxis(4);
    }

	// Right joystick Y axis
    public static double RIGHT_Y_AXIS() {
        return joy.getRawAxis(5);
    }
	
	public OI()
	{
		
	}
}

class LTrigger extends Button {
	public LTrigger() {}
	
	@Override
	public boolean get() {
		return OI.GetLT() > 0.9;
	}
}

class RTrigger extends Button {
	public RTrigger() {}
	
	@Override
	public boolean get() {
		return OI.GetRT() > 0.9;
	}
}