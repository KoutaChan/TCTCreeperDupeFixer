package koutachan.tctcreeperdupefixer;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;


public class Event implements Listener {

    private final Plugin plugin;

    public Event(TCTCreeperDupeFixer plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (e.getHand() == EquipmentSlot.OFF_HAND && e.getItemInHand().getType() == Material.SKULL_ITEM && e.getItemInHand().getDurability() == 4 && e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
            new BukkitRunnable(){
                @Override
                public void run() {
                    if (e.getBlock().getLocation().getBlock().getType() == Material.SKULL) {
                        for (ItemStack itemStack : e.getPlayer().getInventory().getContents()) {
                            if (itemStack != null && itemStack.getType() == Material.SKULL_ITEM) {
                                itemStack.setAmount(itemStack.getAmount() - 1);

                            }
                        }
                    }
                }
            }.runTaskLater(plugin, 7);
        }
    }
}
