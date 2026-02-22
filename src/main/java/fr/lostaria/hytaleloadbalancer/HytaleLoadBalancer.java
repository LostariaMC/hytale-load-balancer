package fr.lostaria.hytaleloadbalancer;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.event.events.player.PlayerSetupConnectEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import fr.lostaria.hytaleloadbalancer.listeners.PlayerSetupConnectListener;
import lombok.Getter;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class HytaleLoadBalancer extends JavaPlugin {

    @Getter
    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    public HytaleLoadBalancer(@NonNullDecl JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        LOGGER.atInfo().log("Setting up plugin " + this.getName());

        this.getEventRegistry().registerGlobal(PlayerSetupConnectEvent.class, PlayerSetupConnectListener::onPlayerSetupConnect);
    }
}
