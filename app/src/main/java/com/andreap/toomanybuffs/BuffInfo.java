package com.andreap.toomanybuffs;

public class BuffInfo
{
    public String buffStat;
    public String bonusType;
    public int bonus;
    public int stacked;
    
    
    BuffInfo(String buffStat, String bonusType, int bonus,
            int stacked)
    {
        this.buffStat = buffStat;
        this.bonusType = bonusType;
        this.bonus = bonus;
        this.stacked = stacked;
    }
}
