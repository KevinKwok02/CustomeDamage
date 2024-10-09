package com.kevinkwok.customdamage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class CustomDamage extends JavaPlugin {

    static CustomDamage Instance;

    public static boolean debug = false;

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("已加載插件");

        Bukkit.getPluginCommand("customdamage").setExecutor(new Commands());
        Bukkit.getPluginManager().registerEvents(new Listener(),this);

        Initialization();

        Instance = this;
    }

    private void Initialization()
    {
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println("已卸載插件");

    }
}
