package Shared.Infrastructure.Adapter.CommandBus;

import Shared.Presentation.CommandBus.CommandInterface;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
public class AxonCommandBus {
    private final CommandGateway commandGateway;

    public void send(CommandInterface command) {
        this.commandGateway.send(command);
    }
}
