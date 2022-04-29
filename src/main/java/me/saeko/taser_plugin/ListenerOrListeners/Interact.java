package me.saeko.taser_plugin.ListenerOrListeners;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static me.saeko.taser_plugin.Managers.Targeter.getTargetPlayer;

public class Interact implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                Player p = e.getPlayer(); // This gives you the player that actually DOES THE EVENT
                if (getTargetPlayer(p) != null) {
                    Player targetP = getTargetPlayer(p);
                double distance = p.getLocation().distance(targetP.getLocation());
                if (p.getInventory().getItemInMainHand().getType().equals(Material.CARROT_ON_A_STICK)) {
                    if (distance <= 5) {
                        targetP.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 250));
                        targetP.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 250));
                        targetP.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 250));


                    }
                }
            }
        }
    }
}