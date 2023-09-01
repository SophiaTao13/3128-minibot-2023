package robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.TurntableSubsystem;


public class CmdTurntable extends CommandBase{ //commandBase contains some methods like stop, which stops the motors
    private TurntableSubsystem m_turret;
    private double power; //create variable

    public CmdTurntable(double power) { //Constructor name has to match up with the file name. power would be a parameter. In robotContainer, power would be 0.6
        m_turret = TurntableSubsystem.getInstance(); //creates object of the turntable
        this.power = power; //the current power will be whatever the parameter is
        addRequirements(m_turret); //for the command to work, this subsystem is needed
    }

        @Override
        public void initialize() {
            m_turret.setPower(power);
        }

        @Override
        public void execute() {
            
        }

        @Override
        public boolean isFinished() {
            return false; //continues running
        }

        @Override
        public void end(boolean interrupted) {
            m_turret.setPower(0);
        }
    }
    

   

    

