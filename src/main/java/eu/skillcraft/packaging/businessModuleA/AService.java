package eu.skillcraft.packaging.businessModuleA;

import eu.skillcraft.packaging.businessModuleA.AIncomingCommand.DoFirstThing;
import eu.skillcraft.packaging.businessModuleA.AIncomingCommand.DoSecondThing;
import eu.skillcraft.packaging.businessModuleA.AIncomingCommand.DoThirdThing;
import eu.skillcraft.packaging.businessModuleA.ARepo.ARecord;
import eu.skillcraft.packaging.shared.messages.DomainEvent;
import org.springframework.stereotype.Service;

@Service
public class AService {

  private final ARepo repo;

  public AService(ARepo repo) {
    this.repo = repo;
  }

  public void handle(DoFirstThing command) {
      repo.apply(command.aggregateId(), aggregate -> aggregate.firstThing(command));
  }

  public void handle(DoSecondThing command) {
      repo.apply(command.aggregateId(), aggregate -> aggregate.secondThing(command));
  }

  public void handle(DoThirdThing command) {
      repo.apply(command.aggregateId(), aggregate -> aggregate.thirdThing(command));
  }

  static class AAggregate {

    public AAggregate(ARecord aRecord) {

    }

    public DomainEvent firstThing(DoFirstThing command) {
      // invariants and other stuff
      return new FirstThingWasDone();
    }

    public DomainEvent secondThing(DoSecondThing command) {
      // invariants and other stuff
      return new SecondThingWasDone();
    }

    public DomainEvent thirdThing(DoThirdThing command) {
      // invariants and other stuff
      return new ThirdThingWasDone();
    }

    class FirstThingWasDone implements DomainEvent { }

    class SecondThingWasDone implements DomainEvent { }

    class ThirdThingWasDone implements DomainEvent { }
  }
}
