package fr.lostaria.hytaleloadbalancer.listeners;

import com.hypixel.hytale.server.core.event.events.player.PlayerSetupConnectEvent;

public class PlayerSetupConnectListener {

    public static void onPlayerSetupConnect(PlayerSetupConnectEvent event) {
        event.setCancelled(true);
        event.setReason("Infrastructure en cours de developpement");
    }

}
