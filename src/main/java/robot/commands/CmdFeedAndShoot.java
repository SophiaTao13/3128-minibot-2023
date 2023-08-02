package robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import robot.subsystems.FeederSubsystem;
import robot.subsystems.ShooterSubsystem;

public class CmdFeedAndShoot extends ParallelCommandGroup {

    private final ShooterSubsystem m_shooter;
    private final FeederSubsystem m_feeder;
    
    public CmdFeedAndShoot(ShooterSubsystem shooter, FeederSubsystem feeder) {
        m_shooter = shooter;
        m_feeder = feeder;

        addCommands(
            
            new TestShooterCommand(m_shooter),
            new TestFeederCommand(m_feeder)
        );
    }
}
