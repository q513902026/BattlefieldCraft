package com.ich.battlefield.core;

import org.bukkit.Location;
import org.bukkit.World;

public class Area
{
    private Location startL;
    private Location endL;
    private World world;
    
    public Area(Location startL, Location endL)
    {
        this.startL = startL;
        this.endL = endL;
        this.world = startL.getWorld() == null ? (endL.getWorld() == null ? null : endL.getWorld()) : startL.getWorld();
    }
    public Area(Location l, double raid)
    {
        this.startL = l.add(raid, 0, raid);
        this.endL = l.add(-raid, 0, raid);
    }
    public Location getStartL()
    {
        return this.startL != null ? this.startL : null;
    }
    public Location getEndL()
    {
        return this.endL != null ? this.endL : null;
    }
    public World getWorld()
    {
        return world;
    }
}
