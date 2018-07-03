package com.andreap.toomanybuffs;

public class AttackInfo
{
    public String name;                //ok
    public String baseDamage;
    public String weaponEnhancement;
    public String bonusDiceDamage;
    public String bonusDiceDamage2;
    public String attackBasedOn;
    public String damageBasedOn;
    public String iterativeAttacks;
    public String critical;
    public String TWF;
    public int customAttackBonus;
    public int customDamageBonus;
    public int nattacks;

    AttackInfo(String name, String attackBasedOn,
               String damageBasedOn, String critical, int nattacks)
    {
        this.name = name;
        this.attackBasedOn = attackBasedOn;
        this.damageBasedOn = damageBasedOn;
        this.critical = critical;
        this.nattacks = nattacks;
    }
    
    AttackInfo(String name, String baseDamage, String weaponEnhancement,
               String bonusDiceDamage, String bonusDiceDamage2,
               String attackBasedOn, String damageBasedOn, 
               String iterativeAttacks, String critical, 
               String TWF, int customAttackBonus,
               int customDamageBonus, int nattacks)
    {
        this.name = name;
        this.baseDamage = baseDamage;
        this.weaponEnhancement = weaponEnhancement;
        this.bonusDiceDamage = bonusDiceDamage;
        this.bonusDiceDamage2 = bonusDiceDamage2;
        this.attackBasedOn = attackBasedOn;
        this.damageBasedOn = damageBasedOn;
        this.iterativeAttacks = iterativeAttacks;
        this.critical = critical;
        this.TWF = TWF;
        this.customAttackBonus = customAttackBonus;
        this.customDamageBonus = customDamageBonus;
        this.nattacks = nattacks;
    }
}
