package vip.floatationdevice.mgbdeath;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import vip.floatationdevice.guilded4j.object.Embed;

import static vip.floatationdevice.mgbridge.MGBridge.instance;

public final class MGBDeathExt extends JavaPlugin implements Listener
{

    @Override
    public void onEnable()
    {
        instance.getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("MGBridge can now forward player death messages");
    }

    @Override
    public void onDisable()
    {
        // nothing needed
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        instance.sendGuildedEmbed(new Embed().setTitle(":skull_and_crossbones: " + event.getDeathMessage()).setColor(0xffff00), null, null, null);
    }
}
