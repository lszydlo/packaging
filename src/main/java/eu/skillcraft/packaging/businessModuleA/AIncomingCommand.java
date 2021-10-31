package eu.skillcraft.packaging.businessModuleA;

import eu.skillcraft.packaging.shared.id.AID;
import eu.skillcraft.packaging.shared.messages.IncomingCommand;

public abstract class AIncomingCommand implements IncomingCommand {

    private final AID aggregateId;

    protected AIncomingCommand(AID aggregateId) {
        this.aggregateId = aggregateId;
    }

    public AID aggregateId() {
        return aggregateId;
    }

    public static class DoFirstThing extends AIncomingCommand {

        public DoFirstThing(AID aggregateId) {
            super(aggregateId);
        }
    }
    public static class DoSecondThing extends AIncomingCommand {

        public DoSecondThing(AID aggregateId) {
            super(aggregateId);
        }
    }
    public static class DoThirdThing extends AIncomingCommand {

        public DoThirdThing(AID aggregateId) {
            super(aggregateId);
        }
    }
}
