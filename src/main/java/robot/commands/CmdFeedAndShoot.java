package robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import robot.subsystems.FeederSubsystem;
import robot.subsystems.ShooterSubsystem;

//command which commands feeder and shooter to run at the same time. parallel command group

public class CmdFeedAndShoot extends ParallelCommandGroup{
    private ShooterSubsystem shooter;
    private FeederSubsystem feeder;
    
    public CmdFeedAndShoot(double feederPower, double shooterPower) { //parameters used for calling the commands later
        shooter = ShooterSubsystem.getInstance();
        feeder =FeederSubsystem.getInstance();

        addCommands(
            new CmdFeeder(feederPower),
            new CmdShooter(shooterPower)
        );
        
    }

    //no need for end because it contains commands which has end
  

    
}


