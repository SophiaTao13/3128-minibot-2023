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


package robot;

import java.time.Instant;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import robot.commands.CmdArcadeDrive;
import robot.commands.CmdFeedAndShoot;
import robot.commands.CmdTurntable;
import robot.subsystems.DriveSubsystem;
import robot.subsystems.FeederSubsystem;
import robot.subsystems.ShooterSubsystem;
import robot.subsystems.TurntableSubsystem;
import robotCore.Joystick;
import frc.team3128.common.hardware.input.NAR_Joystick;
import robot.commands.CmdFeedAndShoot;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 * 
 */
public class RobotContainer {
  private JoystickButton m_shoot, m_turretLeft, m_turretRight;
  private NAR_Joystick m_joystick;

  // The robot's subsystems and commands are defined here...
  // TODO create more buttons
  // private final GenericHID m_joystick = new Joystick(0);
  // private final JoystickButton m_button1 = new JoystickButton(m_joystick, 1); //first button assigned to number 1
  // private final JoystickButton m_button2 = new JoystickButton(m_joystick, 2); //second button assigned to nuber 2
  // private final JoystickButton m_button3 = new JoystickButton(m_joystick, 3); 
  // private final JoystickButton m_button4 = new JoystickButton(m_joystick, 4);
  // private final JoystickButton m_button5 = new JoystickButton(m_joystick, 5);
  

  private DriveSubsystem m_drive;
  private NAR_Joystick m_feeder;
  private NAR_Joystick m_shooter;
  private NAR_Joystick m_turnLeft;
  private NAR_Joystick m_turnRight;
  private NAR_Joystick m_feedAndShoot;
  

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // TODO create subsystems objects
    m_turnLeft = new NAR_Joystick(5);
    m_turnRight = new NAR_Joystick(6);
    m_joystick = new NAR_Joystick(0);
    m_feedAndShoot = new NAR_Joystick(1);
    configureButtonBindings();

    
    // Configure the button bindings

    

    //TODO this line assigns drive command as the default command
    m_drive.setDefaultCommand(new CmdArcadeDrive(m_joystick));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
      // m_joystick.getButton(3).onTrue(new InstantCommand(() -> m_feeder.setPower(0.7))).onFalse(new InstantCommand(() -> m_feeder.setPower(0)));
      // m_joystick.getButton(4).onTrue(new InstantCommand(() -> m_shooter.setPower(0.7))).onFalse(new InstantCommand(() -> m_shooter.setPower(0)));
      // m_joystick.getButton(5).onTrue(new InstantCommand(() -> m_turntable.setPower(0.7))).onFalse(new InstantCommand(() -> m_turntable.setPower(0)));
      // m_joystick.getButton(6).onTrue(new InstantCommand(() -> m_turntable.setPower(-0.7))).onFalse(new InstantCommand(() -> m_turntable.setPower(0)));
      m_feedAndShoot.getButton(1).onTrue(new CmdFeedAndShoot(-0.6, 0.6));
      m_turnLeft.getButton(5).onTrue(new CmdTurntable(-0.7));
      m_turnRight.getButton(6).onTrue(new CmdTurntable(0.7));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}