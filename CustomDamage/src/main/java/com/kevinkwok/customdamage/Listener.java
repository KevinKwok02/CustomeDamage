package com.kevinkwok.customdamage;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event)
    {
        if(event.getEntity() instanceof Player)
        {
            Player player = (Player) event.getEntity();

            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            double damage = 0;
            boolean isPercentage = false;
            double newDamage = 0;
            String damageCase = " ";

            if(event.getCause() == EntityDamageEvent.DamageCause.POISON)
            {
                isPercentage = CustomDamage.Instance.getConfig().getBoolean("DamageEvent.poison.percentage", false);
                newDamage = CustomDamage.Instance.getConfig().getDouble("DamageEvent.poison.damage", 1);
                damageCase = "§a中毒 §2POISON";
            }
            else if(event.getCause() == EntityDamageEvent.DamageCause.FIRE)
            {
                isPercentage = CustomDamage.Instance.getConfig().getBoolean("DamageEvent.fire.percentage", false);
                newDamage = CustomDamage.Instance.getConfig().getDouble("DamageEvent.fire.damage", 1);
                damageCase = "§c灼燒 §4FIRE";
            }
            else if(event.getCause() == EntityDamageEvent.DamageCause.WITHER)
            {
                isPercentage = CustomDamage.Instance.getConfig().getBoolean("DamageEvent.wither.percentage", false);
                newDamage = CustomDamage.Instance.getConfig().getDouble("DamageEvent.wither.damage", 1);
                damageCase = "§7凋零 §8WITHER";
            }
            else
            {
                return;
            }

            if(isPercentage)
            {
                damage = maxHealth * (newDamage / 100);
            }
            else
            {
                damage = newDamage;
            }

            if(CustomDamage.debug)
            {
                player.sendMessage(damageCase + " §f百分比傷害: §e" + isPercentage + " §f數值: §e" + damage + "§8(§7" + newDamage + "§8)");
            }

            event.setDamage(damage);
        }
    }

}
