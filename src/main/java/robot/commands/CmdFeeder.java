package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.FeederSubsystem;
import robotCore.Timer;

public class CmdFeeder extends CommandBase {
    private FeederSubsystem m_feeder;
   
    
 
    private double power;
    private double speed;
    public CmdFeeder(double power) {
       m_feeder = FeederSubsystem.getInstance();
       this.power = power;
       addRequirements(m_feeder);
    }

    @Override
    public void initialize() {
        m_feeder.setMotorPower(power);
        
      



        //get speed of the encoder
    }


    @Override
    public void execute() {
        speed = m_feeder.getSpeed();

        if(speed == 0) {
            m_feeder.setMotorPower(-power);
            Timer.delay(0.5);
            m_feeder.setMotorPower(power);
        }

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) { //setting power to 0
        m_feeder.setMotorPower(0);

    


    }
 
   
    //make sure to 
    //get the speed of the encoder. if speed = 0, then turn backwards
    //if motor for feeder stops, turn backwards. -set power to negative.
}