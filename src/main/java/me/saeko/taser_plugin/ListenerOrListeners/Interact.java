package me.saeko.taser_plugin.ListenerOrListeners;

import me.saeko.taser_plugin.Cooldown;
import org.bukkit.ChatColor;
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
                if (p.getInventory().getItemInMainHand().getType().equals(Material.CARROT_ON_A_STICK)) { //checks if the player is holding a carrot on a stick

                    //This is where the fun begins aka cooldown shit
                    if(Cooldown.checkCooldown(e.getPlayer())) {
                        e.getPlayer().sendMessage(ChatColor.DARK_RED + "Taser is now on cooldown for 10 seconds");
                        Cooldown.setCooldown(e.getPlayer(), 10);



                    if (distance <= 5) { //makes sure the distance from player A to player B is 5 blocks

                        //The effects that are gonna affect the tased player
                        targetP.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 250));
                        targetP.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 250));
                        targetP.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 250));

                        //this part doesnt do shit but at this point im too afraid to try cause it works anyway
                    } else {
                        e.getPlayer().sendMessage(ChatColor.DARK_RED + "You cant use this for 10 seconds");
                        }
                    }
                }
            }
        }
    }
}