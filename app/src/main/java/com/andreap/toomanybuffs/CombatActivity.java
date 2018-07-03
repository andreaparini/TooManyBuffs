package com.andreap.toomanybuffs;


import java.io.File;
import java.io.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.content.*;
import android.support.v7.app.*;
import android.support.v7.widget.Toolbar;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import android.text.*;
import android.content.res.*;
import android.preference.*;

public class CombatActivity extends AppCompatActivity
{
    Build useless = new Build();
    static Build staticBuild;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combat);
        Toolbar main_toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(main_toolbar);

        Intent intentFromCustomization = getIntent();
        staticBuild = (Build) intentFromCustomization.getSerializableExtra("Build");  
        
        TextView strength = (TextView) findViewById(R.id.totalStrength);
        TextView dexterity = (TextView) findViewById(R.id.totalDexterity);
        TextView constitution = (TextView) findViewById(R.id.totalConstitution);
        TextView strengthMod = (TextView) findViewById(R.id.totalStrengthMod);
        TextView dexterityMod = (TextView) findViewById(R.id.totalDexterityMod);
        TextView constitutionMod = (TextView) findViewById(R.id.totalConstitutionMod);
        TextView AC = (TextView) findViewById(R.id.totalAC);
        final TextView HP = (TextView) findViewById(R.id.totalHP);
        
        TextView HPmax = (TextView) findViewById(R.id.totalHPmax);
        
        
        
        int strNumber = staticBuild.getStrength();
        int dexNumber = staticBuild.getDexterity();
        int conNumber = staticBuild.getConstitution();
        int strMod = staticBuild.getStrModifier();
        int dexMod = staticBuild.getDexModifier();
        int conMod = staticBuild.getConModifier();
        int acNumber = staticBuild.getTotalAC();
        int hpNumber = staticBuild.getTotalHP();
        
        String sStrMod = new String(Integer.toString(strMod));
        String sDexMod = new String(Integer.toString(dexMod));
        String sConMod = new String(Integer.toString(conMod));
        
        if (strMod > 0)
        {
            sStrMod = "+"+sStrMod;
        }
        if (strMod > 0)
        {
            sDexMod = "+"+sDexMod;
        }
        if (strMod > 0) 
        {
            sConMod = "+"+sConMod;
        }
        strength.setText(Integer.toString(strNumber));
        dexterity.setText(Integer.toString(dexNumber));
        constitution.setText(Integer.toString(conNumber));
       
        strengthMod.setText(sStrMod);
        dexterityMod.setText(sDexMod);
        constitutionMod.setText(sConMod);
        
        AC.setText(Integer.toString(acNumber));
        
        
        String hpMaxToShow = new String("/"+Integer.toString(hpNumber));
        HPmax.setText(hpMaxToShow);
        
        
        
        String hpID = new String ("HP"+staticBuild.name);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedHP = preferences.getString(hpID, "HPs");
        HP.setText(savedHP);
        
        HP.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {              
                    AlertDialog.Builder alert = new AlertDialog.Builder(CombatActivity.this);
                    alert.setTitle("Insert HP");
                    final EditText input = new EditText(CombatActivity.this);
                    input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    input.setRawInputType(Configuration.KEYBOARD_12KEY);
                    alert.setView(input);  
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                String newHP = new String(input.getText().toString());
                                HP.setText(newHP);
                                
                                String hpID = new String ("HP"+staticBuild.name);
                                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(CombatActivity.this);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString(hpID,newHP);
                                editor.apply();
                                
                                
                            }
                        });
                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                //Put actions for CANCEL button here, or leave in blank
                            }
                        });
                    alert.show();
                }
            });
        
        
        
        ArrayList<AttackInfo> savedAttacks = readCompleteAttacksXmlFile(this, staticBuild.name);
        int nAttacks = savedAttacks.get(0).nattacks;
        if (nAttacks > 0)
        {
            TextView help = (TextView) findViewById(R.id.totalHelper);
            help.setVisibility(View.GONE);
        }
        final int[] relativeLayoutIds ={
            R.id.totalrelativelayout1,
            R.id.totalrelativelayout2,  
            R.id.totalrelativelayout3,
            R.id.totalrelativelayout4,
            R.id.totalrelativelayout5,
            R.id.totalrelativelayout6,
            R.id.totalrelativelayout7,
            R.id.totalrelativelayout8,
            R.id.totalrelativelayout9,
            R.id.totalrelativelayout10  };
            
        final int[] damageIds ={
            R.id.totalDamage1,
            R.id.totalDamage2,  
            R.id.totalDamage3,
            R.id.totalDamage4,
            R.id.totalDamage5,
            R.id.totalDamage6,
            R.id.totalDamage7,
            R.id.totalDamage8,
            R.id.totalDamage9,
            R.id.totalDamage10  };
            
            
        final int[] toHitIds ={
            R.id.totalToHit1,
            R.id.totalToHit2,  
            R.id.totalToHit3,
            R.id.totalToHit4,
            R.id.totalToHit5,
            R.id.totalToHit6,
            R.id.totalToHit7,
            R.id.totalToHit8,
            R.id.totalToHit9,
            R.id.totalToHit10  };
            
        final int[] attackNameIds ={
            R.id.totalAttackName1,
            R.id.totalAttackName2,  
            R.id.totalAttackName3,
            R.id.totalAttackName4,
            R.id.totalAttackName5,
            R.id.totalAttackName6,
            R.id.totalAttackName7,
            R.id.totalAttackName8,
            R.id.totalAttackName9,
            R.id.totalAttackName10  };   
            
        final int[] criticalIds ={
            R.id.critical1,
            R.id.critical2,  
            R.id.critical3,
            R.id.critical4,
            R.id.critical5,
            R.id.critical6,
            R.id.critical7,
            R.id.critical8,
            R.id.critical9,
            R.id.critical10  };        
        
        int j = 1;
        for (int id : relativeLayoutIds) {
            if (j > nAttacks)
            {
                ((RelativeLayout) findViewById(id)).setVisibility(View.GONE);
            }
            else
            {
                ((TextView) findViewById(attackNameIds[j-1])).setText(savedAttacks.get(j-1).name);
                ((TextView) findViewById(criticalIds[j-1])).setText(savedAttacks.get(j-1).critical);
                
                // attack
                
                int numericToHit = staticBuild.bab;
                numericToHit += savedAttacks.get(j-1).customAttackBonus;
                numericToHit += staticBuild.getTotalToHit();
                
                if((savedAttacks.get(j-1).attackBasedOn).equals("Strength"))
                {
                    numericToHit += 
                        staticBuild.getStrModifier();
                } else if ((savedAttacks.get(j-1).attackBasedOn).equals("Dexterity"))
                {
                    numericToHit +=
                        staticBuild.getDexModifier();
                } else if ((savedAttacks.get(j-1).attackBasedOn).equals("Constitution"))
                {
                    numericToHit +=
                        staticBuild.getConModifier();
                }
                
                if((savedAttacks.get(j-1).TWF)
                        .equals("Main Hand: normal penalties (-6)"))
                {
                    numericToHit -= 6;
                    
                } else if((savedAttacks.get(j-1).TWF)
                        .equals("Main Hand: off-hand is light (-4)" ))
                {
                    numericToHit -= 4;
                    
                } else if((savedAttacks.get(j-1).TWF)
                        .equals("Main Hand: TWF feat (-4)"))
                {
                    numericToHit -= 4;
                    
                } else if((savedAttacks.get(j-1).TWF)
                        .equals("Main Hand: TWF feat + off-hand is light (-2)"))
                {
                    numericToHit -= 2;

                } else if((savedAttacks.get(j-1).TWF)
                        .equals("Off Hand: normal penalties (-10)"))
                {
                    numericToHit -= 10;

                } else if((savedAttacks.get(j-1).TWF)
                        .equals("Off Hand: off-hand is light (-8)"))
                {
                    numericToHit -= 8;

                } else if((savedAttacks.get(j-1).TWF)
                        .equals("Off Hand: TWF feat (-4)"))
                {
                    numericToHit -= 4;

                } else if((savedAttacks.get(j-1).TWF)
                        .equals("Off Hand: TWF feat + off-hand is light (-2)"))
                {
                    numericToHit -= 2;

                }
                
                
                if((savedAttacks.get(j-1).weaponEnhancement)
                    .equals("Masterwork"))
                {
                    numericToHit += 1;    
                } else {
                    numericToHit += Integer.parseInt(savedAttacks.get(j-1).weaponEnhancement);
                }
                
                
                
                
                
                if (savedAttacks.get(j-1).iterativeAttacks
                         .equals("None"))
                {                   
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));                    
                    String toHit = new String(sFirst);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                    .equals("2 (0 / -5)"))
                {
                    int second = numericToHit -5;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String toHit = new String(sFirst+"/"+sSecond);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("2 (0 / 0)"))
                {
                    int second = numericToHit;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String toHit = new String(sFirst+"/"+sSecond);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("3 (0 / -5 / -10)"))
                {
                    int second = numericToHit -5;
                    int third = numericToHit -10;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("3 (0 / 0 / -5)"))
                {
                    int second = numericToHit;
                    int third = numericToHit-5;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("3 (0 / 0 / 0)"))
                {
                    int second = numericToHit;
                    int third = numericToHit;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("4 (0 / -5 / -10 / -15)"))
                {
                    int second = numericToHit -5;
                    int third = numericToHit-10;
                    int fourth = numericToHit -15;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String sFourth = new String ( "+" + Integer.toString(fourth));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird+"/"+sFourth);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("4 (0 / 0 / -5 / -10)"))
                {
                    int second = numericToHit;
                    int third = numericToHit -5;
                    int fourth = numericToHit -10;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String sFourth = new String ( "+" + Integer.toString(fourth));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird+"/"+sFourth);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("4 (0 / 0 / -5 / -5)"))
                {
                    int second = numericToHit;
                    int third = numericToHit -5;
                    int fourth = numericToHit -5;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String sFourth = new String ( "+" + Integer.toString(fourth));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird+"/"+sFourth);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("5 (0 / 0 / -5 / -10 / -15)"))
                {
                    int second = numericToHit;
                    int third = numericToHit -5;
                    int fourth = numericToHit -10;
                    int fifth = numericToHit-15;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String sFourth = new String ( "+" + Integer.toString(fourth));
                    String sFifth = new String ( "+" + Integer.toString(fifth));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird+"/"+sFourth+"/"+sFifth);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("5 (0 / 0 / -5 / -5 / -10)"))
                {
                    int second = numericToHit;
                    int third = numericToHit-5;
                    int fourth = numericToHit-5;
                    int fifth = numericToHit -10;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String sFourth = new String ( "+" + Integer.toString(fourth));
                    String sFifth = new String ( "+" + Integer.toString(fifth));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird+"/"+sFourth+"/"+sFifth);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("5 (0 / 0 / 0 / -5 / -10)"))
                {
                    int second = numericToHit;
                    int third = numericToHit;
                    int fourth = numericToHit-5;
                    int fifth = numericToHit -10;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String sFourth = new String ( "+" + Integer.toString(fourth));
                    String sFifth = new String ( "+" + Integer.toString(fifth));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird+"/"+sFourth+"/"+sFifth);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("6 (0 / 0 / -5 / -5 / -10 / -10)"))
                {
                    int second = numericToHit;
                    int third = numericToHit -5;
                    int fourth = numericToHit -5;
                    int fifth = numericToHit-10;
                    int sixth = numericToHit-10;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String sFourth = new String ( "+" + Integer.toString(fourth));
                    String sFifth = new String ( "+" + Integer.toString(fifth));
                    String sSixth = new String ( "+" + Integer.toString(sixth));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird+"/"+sFourth+"/"+sFifth+"/"+sSixth);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("6 (0 / 0 / -5 / -5 / -10 / -10)"))
                {
                    int second = numericToHit;
                    int third = numericToHit -5;
                    int fourth = numericToHit -5;
                    int fifth = numericToHit -10;
                    int sixth = numericToHit -10;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String sFourth = new String ( "+" + Integer.toString(fourth));
                    String sFifth = new String ( "+" + Integer.toString(fifth));
                    String sSixth = new String ( "+" + Integer.toString(sixth));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird+"/"+sFourth+"/"+sFifth+"/"+sSixth);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("6 (0 / 0 / 0 / -5 / -10 / -15)"))
                {
                    int second = numericToHit;
                    int third = numericToHit;
                    int fourth = numericToHit -5;
                    int fifth = numericToHit -10;
                    int sixth = numericToHit -15;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String sFourth = new String ( "+" + Integer.toString(fourth));
                    String sFifth = new String ( "+" + Integer.toString(fifth));
                    String sSixth = new String ( "+" + Integer.toString(sixth));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird+"/"+sFourth+"/"+sFifth+"/"+sSixth);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("7 (0 / 0 / -5 / -5 / -10 / -10 / -15)"))
                {
                    int second = numericToHit;
                    int third = numericToHit;
                    int fourth = numericToHit -5;
                    int fifth = numericToHit -10;
                    int sixth = numericToHit -10;
                    int seventh = numericToHit -15;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String sFourth = new String ( "+" + Integer.toString(fourth));
                    String sFifth = new String ( "+" + Integer.toString(fifth));
                    String sSixth = new String ( "+" + Integer.toString(sixth));
                    String sSeventh = new String ( "+" + Integer.toString(seventh));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird+"/"+sFourth+
                                            "/"+sFifth+"/"+sSixth+"/"+sSeventh);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                } else if (savedAttacks.get(j-1).iterativeAttacks
                           .equals("8 (0 / 0 / -5 / -5 / -10 / -10 / -15 / -15)"))
                {
                    int second = numericToHit;
                    int third = numericToHit -5;
                    int fourth = numericToHit -5;
                    int fifth = numericToHit -10;
                    int sixth = numericToHit -10;
                    int seventh = numericToHit -15;
                    int eighth = numericToHit -15;
                    String sFirst = new String ( "+" + Integer.toString(numericToHit));
                    String sSecond = new String ( "+" + Integer.toString(second));
                    String sThird = new String ( "+" + Integer.toString(third));
                    String sFourth = new String ( "+" + Integer.toString(fourth));
                    String sFifth = new String ( "+" + Integer.toString(fifth));
                    String sSixth = new String ( "+" + Integer.toString(sixth));
                    String sSeventh = new String ( "+" + Integer.toString(seventh));
                    String sEighth = new String ( "+" + Integer.toString(eighth));
                    String toHit = new String(sFirst+"/"+sSecond+"/"+sThird+"/"+sFourth+
                                              "/"+sFifth+"/"+sSixth+"/"+sSeventh+"/"+sEighth);
                    ((TextView) findViewById(toHitIds[j-1])).setText(toHit);
                }
                
                
                
                
                // damage
                int numericBonusDamage = 0;
                if((savedAttacks.get(j-1).damageBasedOn).equals("0.5x Strength"))
                {
                    numericBonusDamage += 
                        staticBuild.getStrModifier()/2;
                } else if ((savedAttacks.get(j-1).damageBasedOn).equals("Strength"))
                {
                    numericBonusDamage +=
                        staticBuild.getStrModifier();
                } else if ((savedAttacks.get(j-1).damageBasedOn).equals("1.5x Strength"))
                {
                    numericBonusDamage +=
                        staticBuild.getStrModifier() + staticBuild.getStrModifier()/2;
                } else if ((savedAttacks.get(j-1).damageBasedOn).equals("2x Strength"))
                {
                    numericBonusDamage +=
                        2*staticBuild.getStrModifier();
                } else if((savedAttacks.get(j-1).damageBasedOn).equals("0.5x Dexterity"))
                {
                    numericBonusDamage += 
                        staticBuild.getDexModifier()/2;
                } else if ((savedAttacks.get(j-1).damageBasedOn).equals("Dexterity"))
                {
                    numericBonusDamage +=
                        staticBuild.getDexModifier();
                } else if ((savedAttacks.get(j-1).damageBasedOn).equals("1.5x Dexterity"))
                {
                    numericBonusDamage +=
                        staticBuild.getDexModifier() + staticBuild.getDexModifier()/2;
                } else if ((savedAttacks.get(j-1).damageBasedOn).equals("Constitution"))
                {
                    numericBonusDamage +=
                        staticBuild.getConModifier();
                } 
                
                if(!(savedAttacks.get(j-1).weaponEnhancement)
                   .equals("Masterwork"))
                {
                    numericBonusDamage += Integer.parseInt(savedAttacks.get(j-1).weaponEnhancement);
                }
                
                numericBonusDamage+= staticBuild.getTotalDmgBonus();
                numericBonusDamage+= savedAttacks.get(j-1).customDamageBonus;
                
                
                
                String firstDice = savedAttacks.get(j-1).baseDamage;
                String secondDice = new String(savedAttacks.get(j-1).bonusDiceDamage);
                String thirdDice = new String(savedAttacks.get(j-1).bonusDiceDamage2);
                if (!secondDice.equals("") )
                {
                    secondDice = " + " + secondDice;
                }
                if (!thirdDice.equals(""))
                {
                    thirdDice = " + " + thirdDice;
                }
                String damage = new String( 
                                    firstDice + " + " +
                                    Integer.toString(numericBonusDamage) +
                                    secondDice +
                                    thirdDice);
                                    
                ((TextView) findViewById(damageIds[j-1])).setText(damage);                   
                
            }
            j++;
        }
        
        
        
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate main_menu.xml 
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {          

            case R.id.custMenuHelp:
                Toast.makeText(this, 
                               "to do", 
                               Toast.LENGTH_LONG).show();
                            
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    
    ArrayList<AttackInfo> readCompleteAttacksXmlFile(Context ctx, String loadedBuild)
    {
        try
        {
            File xmldb = new File(getFilesDir() + "/attacks_db.xml");
            if (xmldb.exists())
            {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmldb);

                //optional, but recommended
                //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName("build");

                ArrayList<AttackInfo> dbAttacks = new ArrayList<AttackInfo>();

                for (int temp = 0; temp < nList.getLength(); temp++)
                {

                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE)
                    {

                        Element eElement = (Element) nNode;
                        if (eElement.getAttribute("id").equals(loadedBuild))
                        {                                               
                            NodeList nAttacks = eElement.getElementsByTagName("attack");

                            for (int i = 0; i < nAttacks.getLength(); i++)
                            {

                                Node nAttack = nAttacks.item(i);

                                if (nAttack.getNodeType() == Node.ELEMENT_NODE)
                                {
                                    Element eAttack = (Element) nAttack;
                                    String name = eAttack.getElementsByTagName("name").item(0).getTextContent();
                                    String weaponEnhancement = eAttack.getElementsByTagName("weaponenhancement").item(0).getTextContent();
                                    String attackBasedOn = eAttack.getElementsByTagName("attackbasedon").item(0).getTextContent();
                                    String damageBasedOn = eAttack.getElementsByTagName("damagebasedon").item(0).getTextContent();
                                    String critical = eAttack.getElementsByTagName("critical").item(0).getTextContent();
                                    String baseDamage = eAttack.getElementsByTagName("basedicedamage").item(0).getTextContent();
                                    String bonusDiceDamage = eAttack.getElementsByTagName("bonusdicedamage").item(0).getTextContent();
                                    String bonusDiceDamage2 = eAttack.getElementsByTagName("bonusdicedamage2").item(0).getTextContent();
                                    String iterativeAttacks = eAttack.getElementsByTagName("iterativeattacks").item(0).getTextContent();
                                    String TWF = eAttack.getElementsByTagName("twf").item(0).getTextContent();
                                    int customAttackBonus =  Integer.parseInt(eAttack.getElementsByTagName("customattackbonus").item(0).getTextContent());
                                    int customDamageBonus = Integer.parseInt(eAttack.getElementsByTagName("customdamagebonus").item(0).getTextContent());
                                    
                                    
                                    dbAttacks.add(new AttackInfo
                                                 (name, baseDamage, weaponEnhancement, bonusDiceDamage, 
                                                  bonusDiceDamage2, attackBasedOn, damageBasedOn, 
                                                  iterativeAttacks, critical, 
                                                  TWF, customAttackBonus,
                                                  customDamageBonus, nAttacks.getLength()));
                                }

                            }

                        }
                    }

                }
                if (!dbAttacks.isEmpty())
                {
                    return dbAttacks;
                } else {
                    ArrayList<AttackInfo> noAttacks = new ArrayList<AttackInfo>();
                    noAttacks.add(new AttackInfo("noname", "noclass", "noattackon", "nodamageon", 0));
                    return noAttacks;
                }

            }
            else
            {
                ArrayList<AttackInfo> noAttacks = new ArrayList<AttackInfo>();
                noAttacks.add(new AttackInfo("noname", "noclass", "noattackon", "nodamageon", 0));
                return noAttacks;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;

        }

    }
    
    
    
    
    
}

    
