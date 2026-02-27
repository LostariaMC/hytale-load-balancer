package fr.lostaria.hytaleloadbalancer.listeners;

import com.hypixel.hytale.server.core.event.events.player.PlayerSetupConnectEvent;

public class PlayerSetupConnectListener {

    public static void onPlayerSetupConnect(PlayerSetupConnectEvent event) {
        event.setCancelled(true);
        if(event.getPacketHandler().getSniHostname().equalsIgnoreCase("hytale.lostaria.fr")) {
            event.setReason(formatReason("Cette adresse IP ne sera bientôt plus prise en charge\nMerci d'utiliser dorénavant : play.lostaria.fr"));
        } else {
            event.setReason(formatReason("Infrastructure en cours de developpement\nOn arrive vite ! ;)"));
        }
    }

    private static String formatReason(String reason) {
        return "\n——————————— Lostaria ———————————\n\n" + reason + "\n\n———————————————————————————\n";
    }

}
