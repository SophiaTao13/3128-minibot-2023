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

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.TurntableSubsystem;
import robotCore.Encoder;
import robotCore.Logger;

/**
 *
 */
public class TurnTurntable extends CommandBase {
    private final TurntableSubsystem m_subsystem;
    private final Encoder m_encoder;
    private double m_power;

    public TurnTurntable(TurntableSubsystem subsystem, double power) {
        Logger.log("TurnTurntable", 3, "TurnTurntable()");

        m_subsystem = subsystem;
        m_encoder = m_subsystem.getEncoder();
        
        m_power = power;
        // Use requires() here to declare subsystem dependencies
        addRequirements(m_subsystem);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        Logger.log("TurnTurntable", 2, "initialize()");

        
        m_subsystem.setPower(m_power);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        Logger.log("TurnTurntable", -1, "execute()");

        Logger.log("TurnTurntable", 1, String.format("Speed = %d", m_encoder.getSpeed()));

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        Logger.log("TurnTurntable", -1, "isFinished()");

        return (false);
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        Logger.log("TurnTurntable", 2, "end()");

        m_subsystem.setPower(0);
    }
}
