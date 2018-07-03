package com.andreap.toomanybuffs;

public class BuildInfo
{
    public String name;
    public String playableClass;
    public int level;
    public int nbuilds;

    BuildInfo(String name, String playableClass, int level, int nbuilds)
    {
        this.name = name;
        this.playableClass = playableClass;
        this.level = level;
        this.nbuilds = nbuilds;
    }
}
