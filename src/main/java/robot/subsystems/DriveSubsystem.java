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
import robotCore.Device;
import robotCore.Encoder;
import robotCore.Logger;
import robotCore.PWMMotor;
import robotCore.Encoder.EncoderType;
import static robot.Constants.DrivetrainConstants.*;


public class DriveSubsystem extends SubsystemBase {
  private static DriveSubsystem drive;

  //TODO create motor and encoder objects using PWMMotor.class and Encoder.class (two different motors since two wheels)
  private final PWMMotor m_rightMotor = new PWMMotor(k_rightMotorPWMPin, k_rightMotorDirPin);
  private final PWMMotor m_leftMotor = new PWMMotor(k_leftMotorPWMPin, k_leftMotorDirPin);
  private final Encoder m_rightEncoder = new Encoder(EncoderType.Quadrature, k_rightEncoderIntPin, k_rightEncoderDirPin);
  private final Encoder m_leftEncoder = new Encoder(EncoderType.Quadrature, k_leftEncoderIntPin, k_leftEncoderDirPin);
  
public static DriveSubsystem getInstance() { //get instances for use later
  if(drive == null) {
    drive = new DriveSubsystem();
  }
  return drive;
}
  public DriveSubsystem() {
    Logger.log("DriveSubsystem", 3, "DriveSubsystem()");

    // TODO Invert the left motor encoder
    m_leftEncoder.setInverted(true); //seperate encoders and inverting makes them work seperately. 
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Logger.log("DriveSubsystem", -1, "periodic()");
  }

  // TODO create one method to set power to both motors
  public void setPower(double leftPower, double rightPower)
  {
     m_rightMotor.set(rightPower);
     m_leftMotor.set(leftPower);
  }

  // TODO create two methods to get left and right encoders
  public int getRightEncoder(){
    return (m_rightEncoder.get());
  }
  public int getLeftEncoder(){
    return (m_leftEncoder.get());
  }


  }

