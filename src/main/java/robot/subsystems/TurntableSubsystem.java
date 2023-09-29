/*
 *	  Copyright (C) 2022  John H. Gaby
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
import robotCore.Logger;
import robotCore.PWMMotor;
import robotCore.Encoder.EncoderType;
import static robot.Constants.TurnTableConstants.*;

/**
 *
 */
public class TurntableSubsystem extends SubsystemBase {
	private static TurntableSubsystem turntable;

	// TODO you know what to do
	//create objects
	private final PWMMotor turntableMotor = new PWMMotor(k_PWMPin, k_DirPin);
	private final Encoder turntableEncoder = new Encoder(EncoderType.Quadrature, k_encoderDirPin, k_encoderIntPin );
	public TurntableSubsystem() {
		Logger.log("TurntableSubsystem", 2, "TurntableSubsystem()");
	}

	public void initDefaultCommand() {
		Logger.log("TurntableSubsystem", 2, "initDefaultCommand()");
	}

	public static TurntableSubsystem getInstance() { //get instances for use later
		if (turntable == null) {
			turntable = new TurntableSubsystem();
		
		}
		return turntable;
	}

	//set motor power and get encoder
	public void setTurntablePower(double power) {
		turntableMotor.set(power);
	}

	public int getTurntableEncoder() {
		return (turntableEncoder.get());
	}


	@Override
	public void periodic() {
		Logger.log("TurntableSubsystem", -1, "periodic()");

	}

	public void setPower(double power) {
	}
}
