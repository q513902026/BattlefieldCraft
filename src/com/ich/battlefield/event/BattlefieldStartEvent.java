package com.ich.battlefield.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.ich.battlefield.BattlefieldCraft;
import com.ich.battlefield.core.OccupiedState.Ranks;

public class BattlefieldStartEvent extends Event 
{
    private static final HandlerList handlers = new HandlerList();
    private HashMap<Ranks, ArrayList<String>> players = new HashMap<Ranks, ArrayList<String>>();
    private String battlefield;
    private UUID[] leaders;
    
    public BattlefieldStartEvent(Player redLeader, Player blueLeader, String battlefield)
    {
        this.battlefield = battlefield;
        leaders[0] = redLeader.getUniqueId();
        leaders[1] = blueLeader.getUniqueId();
        addPlayers(Ranks.Red, BattlefieldCraft.instance.playerDataSetting.getRanks(redLeader));
        addPlayers(Ranks.Black, BattlefieldCraft.instance.playerDataSetting.getRanks(blueLeader));
    }
    private void addPlayers(Ranks key, ArrayList<String> value)
    {
        players.put(key, value);
    }
    public Player getPlayerLeader(Ranks r)
    {
        return r.equals(Ranks.Red) ? BattlefieldCraft.instance.getServer().getPlayer(leaders[0]) : (r.equals(Ranks.Black) ? Bukkit.getServer().getPlayer(leaders[1]) : null);
    }
    public String getBattlefieldName()
    {
        return this.battlefield;
    }
    public static HandlerList getHandlerList()
    {
        return handlers;
    }
    @Override
    public HandlerList getHandlers()
    {
        return handlers;
    }
}
