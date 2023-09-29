/*
 *	  Copyright (C) 2016  John H. Gaby
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, version 3 of the License.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *    
 *    Contact: robotics@gabysoft.com
 */
package robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robotCore.Encoder;
import robotCore.Encoder.EncoderType;
import robotCore.Logger;
import robotCore.PWMMotor;
import static robot.Constants.FeederConstants.*;


/**
 *
 */
public class FeederSubsystem extends SubsystemBase {
	private static FeederSubsystem feeder;
	private static double speed;
	

	// TODO create motor and encoder objects
	private final PWMMotor feederMotor = new PWMMotor(k_PWMPin, k_DirPin);
	private final Encoder feederEncoder = new Encoder(EncoderType.Quadrature, k_encPin1, k_encPin2 );


	public FeederSubsystem() {
		Logger.log("FeederSubsystem", 2, "Constructor");
	}

	public void initDefaultCommand() {
		Logger.log("FeederSubsystem", 2, "initDefaultCommand()");
	}

	public static FeederSubsystem getInstance() { //get instances for use later
		if(feeder == null) {
		  feeder = new FeederSubsystem();
		}
		return feeder;
	  }

	// TODO Create methods to set motor power and get encoder
	public void setMotorPower(double power) {
		feederMotor.set(power);
	}

	public int getFeederEncoder() {
		return (feederEncoder.get());
	}

	public double getSpeed() {
       speed = feederEncoder.getSpeed();
	   return speed;
    }

	public boolean isJammed() {
		return getSpeed() == 0;
	}

	

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
