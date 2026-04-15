package fr.lostaria.hytaleloadbalancer.listeners;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.event.events.player.PlayerSetupConnectEvent;

import java.awt.*;

public class PlayerSetupConnectListener {

    public static void onPlayerSetupConnect(PlayerSetupConnectEvent event) {
        event.setCancelled(true);
        if(event.getPacketHandler().getSniHostname().equalsIgnoreCase("hytale.lostaria.fr")) {
            Message info = Message.raw("Cette adresse IP ne sera bientôt plus prise en charge\nMerci d'utiliser dorénavant : ").color(Color.YELLOW);
            Message ip = Message.raw("play.lostaria.fr").color(Color.ORANGE);
            event.setReason(formatReason(Message.join(info, ip)));
        } else {
            event.setReason(formatReason(Message.raw("Infrastructure en cours de developpement\nOn arrive vite ! ;) (ou presque)").color(Color.YELLOW)));
        }
    }

    private static Message formatReason(Message reason) {
        Message topLine = Message.raw("———————————").color(Color.GRAY);
        Message bottomLine = Message.raw("———————————————————————————").color(Color.GRAY);

        Message serverName = Message.raw("Lostaria").color(Color.CYAN);

        Message top = Message.join(Message.raw("\n"), topLine, Message.raw(" "), serverName, Message.raw(" "), topLine, Message.raw("\n\n"));
        Message bottom = Message.join(Message.raw("\n\n"), bottomLine, Message.raw("\n"));

        return Message.join(top, reason, bottom);
    }

}
