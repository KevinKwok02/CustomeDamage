package com.kevinkwok.customdamage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(args.length == 1 && args[0].equals("reload"))
        {
            CustomDamage.Instance.reloadConfig();
            sender.sendMessage("§f[§a§l!] §f重載成功");

            return true;
        }
        else if(args.length == 2 && args[0].equals("debug"))
        {
            if(args[1].equals("true"))
            {
                CustomDamage.debug = true;
                sender.sendMessage("§f[§a§l!] §f調試啟用");
            }
            else if(args[1].equals("false"))
            {
                CustomDamage.debug = false;
                sender.sendMessage("§f[§a§l!] §f調試禁止");
            }
        }

        return false;
    }
}
