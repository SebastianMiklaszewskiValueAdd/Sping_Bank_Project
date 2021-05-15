package Shared.Presentation.CommandBus;

public interface CommandBusPort {
    void dispatchNow(CommandInterface command);
}
