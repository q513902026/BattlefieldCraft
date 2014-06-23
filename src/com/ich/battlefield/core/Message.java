package com.ich.battlefield.core;

import org.bukkit.ChatColor;

import com.ich.battlefield.BattlefieldCraft;

public class Message
{

    public static String PLUGIN_TAG = BattlefieldCraft.instance.battlefieldCommonSetting.getDefLanguager("Plugin Tag", ChatColor.RED + "[Battlefield] :"); 
    
    public static String ERROR = BattlefieldCraft.instance.battlefieldCommonSetting.getDefLanguager("Error",Message.PLUGIN_TAG +"Error message");
    
    public static String TRYJOIN = BattlefieldCraft.instance.battlefieldCommonSetting.getDefLanguager("TryJoin", Message.PLUGIN_TAG + "正在尝试询问系统来加入游戏");
    
    public static String JOIN = BattlefieldCraft.instance.battlefieldCommonSetting.getDefLanguager("Join", Message.PLUGIN_TAG +"已经加入了游戏");
}
