package robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team3128.common.hardware.input.NAR_Joystick;
import robot.subsystems.DriveSubsystem;
import robotCore.Joystick;




public class CmdArcadeDrive extends CommandBase {
    private DriveSubsystem m_drive;
    private Joystick m_joystick;
   


    public CmdArcadeDrive(Joystick joystick) {
        m_drive = DriveSubsystem.getInstance();
        m_joystick = joystick; //this joystick is gotten from the joystick parameter, which is from the robotCore

        addRequirements(m_drive);
        


    }

    public CmdArcadeDrive(NAR_Joystick m_joystick2) {
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute() {
        m_drive.setPower(m_joystick.getY() + m_joystick.getX() , m_joystick.getY() - m_joystick.getX());
          //right motor power and left motor power are paramters specified in the original method.
          //ex. the joystick is twisted to the right
          //if the joystick.getY() equals to 1 and getX equals to 1, then the left motor power will be 2. While if the second getY is 1 and the second getX is 1, then the power will be 0. Left motor power is larger than right, so it will turn right
        
    }


    @Override
    public boolean isFinished() {
        return false;
    }
    
    @Override
    public void end(boolean interrupted) {
        m_drive.setPower(0, 0);
    }
}
