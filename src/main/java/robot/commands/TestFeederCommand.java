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

package robot.commands;

import javax.imageio.plugins.tiff.TIFFDirectory;

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.FeederSubsystem;
import robotCore.Encoder;
import robotCore.Logger;
import robotCore.Timer;


/**
 *
 */
public class TestFeederCommand extends CommandBase {
	private final FeederSubsystem m_subsystem;
	private final Encoder m_encoder;
	private final Timer m_timer;
	private boolean FeederFoward = true;

	public TestFeederCommand(FeederSubsystem subsystem) {
		Logger.log("FeederCommand", 3, "FeederCommand()");

		m_subsystem = subsystem;
		m_encoder = m_subsystem.getEncoder();
		m_timer = new Timer();

		// Use requires() here to declare subsystem dependencies
		addRequirements(m_subsystem);
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {
		Logger.log("FeederCommand", 2, "initialize()");
		

		m_subsystem.SetPower(0.5);
		m_timer.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		Logger.log("FeederCommand", -1, "execute()");

		Logger.log("FeederCommand", 1, String.format("Speed = %d", m_encoder.getSpeed()));

	

		
		if (m_encoder.getSpeed() > 10 && FeederFoward) {//slowest normal speed in RPM
			m_timer.reset();
		} else if (m_timer.get() > 1) {//greatest stall time allowed
			m_subsystem.SetPower(-0.5);
			m_timer.reset();
			FeederFoward = false;
		} 
			
		
		if (!FeederFoward && m_timer.get() > 0.5) {//time we want the feeder to reverse
			m_subsystem.SetPower(0.5);
			m_timer.reset();
			FeederFoward = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	public void end(boolean interrupted) {
		Logger.log("FeederCommand", 2, "end()");

		m_subsystem.SetPower(0);
	}
}
