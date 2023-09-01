package robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import robot.subsystems.DriveSubsystem;
import robot.subsystems.FeederSubsystem;
import robot.subsystems.ShooterSubsystem;

public class CmdFeedAndShoot extends ParallelCommandGroup {

    private final ShooterSubsystem m_shooter;
    private final FeederSubsystem m_feeder;
  
    
    public CmdFeedAndShoot(double shooter, double feeder) {
       { //parameters used for calling the commands later
            m_shooter = ShooterSubsystem.getInstance();
            m_feeder =FeederSubsystem.getInstance();
    
            addCommands(
                new CmdFeeder(feeder),
                new CmdShooter(shooter)
        );
    }
    }

    }

