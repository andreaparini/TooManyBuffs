package com.andreap.toomanybuffs;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.support.v7.app.*;
import android.support.v7.widget.Toolbar;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;
import org.xml.sax.*;



public class Build implements Serializable
{
    
    public String name;
    public String playableClass;
    
    public int level;
    public int bab;
    public int baseHP; //with unbuffed con bonus
    
    //strength and bonuses
    public int str;
    public int strEnhancement;
    public int strMorale;
    public int strSize;
    public int strAlchemical;
    public int strInherent;
    public int strOther;
    
    //dexterity and bonuses
    public int dex;
    public int dexEnhancement;
    public int dexMorale;
    public int dexSize;
    public int dexAlchemical;
    public int dexInherent;
    public int dexOther;
    
    //constitution and bonuses
    public int con;
    public int conEnhancement;
    public int conMorale;
    public int conSize;
    public int conAlchemical;
    public int conInherent;
    public int conOther;
    
    //to-hit bonuses
    public int toHitMorale;
    public int toHitLuck;
    public int toHitSacred;   
    public int toHitSize;
    public int toHitUntyped;
    public int toHitOther;
    
    //damage bonuses
    public int dmgMorale;
    public int dmgLuck;
    public int dmgSacred;
    public int dmgUntyped;
    public int dmgOther;
    
    //armor class bonuses
    public int acArmor;
    public int acNatural;
    public int acNaturalEnhancement;
    public int acSacred;
    public int acShield;
    public int acDeflection;
    public int acUntyped;
    public int acOther;
    public int acDexMax;
    public int acSize;
    
    public Build(){
        
        this.name = "";
        this.playableClass = "";
        this.level = 0;
        this.bab = 0;
        this.baseHP = 0;


        //strength and bonuses
        this.str = 0;
        this.strEnhancement = 0;
        this.strMorale = 0;
        this.strSize = 0;
        this.strAlchemical = 0;
        this.strInherent = 0;
        this.strOther = 0;

        //dexterity and bonuses
        this.dex = 0;
        this.dexEnhancement = 0;
        this.dexMorale = 0;
        this.dexSize = 0;
        this.dexAlchemical = 0;
        this.dexInherent = 0;
        this.dexOther = 0;

        //constitution and bonuses
        this.con = 0;
        this.conEnhancement = 0;
        this.conMorale = 0;
        this.conSize = 0;
        this.conAlchemical = 0;
        this.conInherent = 0;
        this.conOther = 0;

        //to-hit bonuses
        this.toHitMorale = 0;
        this.toHitLuck = 0;
        this.toHitSacred = 0;
        this.toHitSize = 0;
        this.toHitUntyped = 0;
        this.toHitOther = 0;

        //damage bonuses
        this.dmgMorale = 0;
        this.dmgLuck = 0;
        this.dmgSacred = 0;
        this.dmgUntyped = 0;
        this.dmgOther = 0;

        //armor class bonuses
        this.acArmor = 0;
        this.acNatural = 0;
        this.acNaturalEnhancement = 0;
        this.acSacred = 0;
        this.acShield = 0;
        this.acDeflection = 0;
        this.acUntyped = 0;
        this.acOther = 0;
        this.acDexMax = -1;
        this.acSize = 0;
    };
    
    
    //field initialization
    public Build initialize
    (String name, String playableClass, int level, int bab,
     int baseHP, int str, int dex, int con)
    {
        Build returnBuild = new Build();
        returnBuild.name = name;
        returnBuild.playableClass = playableClass;
        returnBuild.level = level;
        returnBuild.bab = bab;
        returnBuild.baseHP = baseHP;   
        
        return returnBuild;
    }
    
    public Build fullInitialize
    (String name, String playableClass, int level, int bab, int baseHP, 
     int str, int strEnhancement, int strMorale, int strSize, int strAlchemical,
     int strInherent, int strOther, int dex, int dexEnhancement, int dexMorale,
     int dexSize, int dexAlchemical, int dexInherent, int dexOther, int con,
     int conEnhancement, int conMorale, int conSize, int conAlchemical,
     int conInherent, int conOther, int toHitMorale, int toHitLuck,
     int toHitSacred, int toHitSize, int toHitUntyped, int toHitOther,
     int dmgMorale, int dmgLuck,  int dmgSacred,
     int dmgUntyped, int dmgOther, int acArmor, int acNatural,
     int acNaturalEnhancement, int acSacred, int acShield, int acDeflection,
     int acUntyped, int acOther, int acDexMax, int acSize)
    {
        Build returnBuild = new Build();
        
        returnBuild.name = name;
        returnBuild.playableClass = playableClass;
        returnBuild.level = level;
        returnBuild.bab = bab;
        returnBuild.baseHP = baseHP;

        returnBuild.str = str;
        returnBuild.strEnhancement = strEnhancement;
        returnBuild.strMorale = strMorale;
        returnBuild.strSize = strSize;
        returnBuild.strAlchemical = strAlchemical;
        returnBuild.strInherent = strInherent;
        returnBuild.strOther = strOther;

        returnBuild.dex = dex;
        returnBuild.dexEnhancement = dexEnhancement;
        returnBuild.dexMorale = dexMorale;
        returnBuild.dexSize = dexSize;
        returnBuild.dexAlchemical = dexAlchemical;
        returnBuild.dexInherent = dexInherent;
        returnBuild.dexOther = dexOther;

        returnBuild.con = con;
        returnBuild.conEnhancement = conEnhancement;
        returnBuild.conMorale = conMorale;
        returnBuild.conSize = conSize;
        returnBuild.conAlchemical = conAlchemical;
        returnBuild.conInherent = conInherent;
        returnBuild.conOther = conOther;

        returnBuild.toHitMorale = toHitMorale;
        returnBuild.toHitLuck = toHitLuck;
        returnBuild.toHitSacred = toHitSacred;
        returnBuild.toHitSize = toHitSize;
        returnBuild.toHitUntyped = toHitUntyped;
        returnBuild.toHitOther = toHitOther;
        
        returnBuild.dmgMorale = dmgMorale;
        returnBuild.dmgLuck = dmgLuck;
        returnBuild.dmgSacred = dmgSacred;
        returnBuild.dmgUntyped = dmgUntyped;
        returnBuild.dmgOther = dmgOther;
        
        returnBuild.acArmor = acArmor;
        returnBuild.acNatural = acNatural;
        returnBuild.acNaturalEnhancement = acNaturalEnhancement;
        returnBuild.acSacred = acSacred;
        returnBuild.acShield = acShield;
        returnBuild.acDeflection = acDeflection;
        returnBuild.acUntyped = acUntyped;
        returnBuild.acOther = acOther;
        returnBuild.acDexMax = acDexMax;
        returnBuild.acSize = acSize;
        
        return returnBuild;
    }
    
    
    public int getStrModifier ()
    {
        double castedStr = 
                this.str +
                this.strEnhancement +
                this.strMorale +
                this.strSize +
                this.strAlchemical +
                this.strInherent +
                this.strOther -10;
        return (int)(Math.floor(castedStr/2.0));
    }
    
    public int getStrength ()
    {
        return this.str +
            this.strEnhancement +
            this.strMorale +
            this.strSize +
            this.strAlchemical +
            this.strInherent +
            this.strOther;
    }
    
    public int getDexModifier ()
    {
        double castedDex =      
            this.dex +
            this.dexEnhancement +
            this.dexMorale +
            this.dexSize +
            this.dexAlchemical +
            this.dexInherent +
            this.dexOther -10;
        return (int)(Math.floor(castedDex/2.0));
    }
    
    public int getDexterity ()
    {
        return this.dex +
            this.dexEnhancement +
            this.dexMorale +
            this.dexSize +
            this.dexAlchemical +
            this.dexInherent +
            this.dexOther;
    }
    
    public int getConModifier ()
    {
        double castedCon = 
            this.con +
            this.conEnhancement +
            this.conMorale +
            this.conSize +
            this.conAlchemical +
            this.conInherent +
            this.conOther -10;
        return (int)(Math.floor(castedCon/2.0));
    }
    
    public int getConstitution ()
    {
        return this.con +
            this.conEnhancement +
            this.conMorale +
            this.conSize +
            this.conAlchemical +
            this.conInherent +
            this.conOther;
    }
    
    public int getTotalHP ()
    {
        return this.baseHP + 
               this.level * 
               (this.getConModifier() -
            (int)(Math.floor((double)(this.con-10)/2.0)));
    }
    
    public int getTotalToHit()
    {
        return 
               this.toHitMorale +
               this.toHitLuck +
               this.toHitSacred +
               this.toHitSize +
               this.toHitUntyped+
               this.toHitOther;
    }
    
    public int getTotalDmgBonus()
    {
        return
                this.dmgMorale+
                this.dmgLuck +
                this.dmgSacred+
                this.dmgUntyped+
                this.dmgOther;
    }
    
    public int getTotalAC()
    {
        int dexMax = 100;
        if(this.acDexMax != -1)
        {
            dexMax = this.acDexMax;
        }
        return 10 +
            Math.min(this.getDexModifier(),dexMax) +
            this.acArmor +
            this.acNatural +
            this.acNaturalEnhancement +
            this.acSacred +
            this.acShield +
            this.acDeflection +
            this.acUntyped +
            this.acOther +
            this.acSize;
    }
    
    public int getTotalACTouch()
    {
        int dexMax = 100;
        if(this.acDexMax != -1)
        {
            dexMax = this.acDexMax;
        }
        return 10 +
            Math.min(this.getDexModifier(),dexMax) +        
            this.acSacred +          
            this.acDeflection +
            this.acUntyped +
            this.acOther +
            this.acSize;
    }
    
    public int getTotalACFlatFooted()
    {
        
        return 10 +
            
            this.acArmor +
            this.acNatural +
            this.acNaturalEnhancement +
            this.acSacred +
            this.acShield +
            this.acDeflection +
            this.acOther +
            this.acSize;
    }
    
    public Build readBuildXmlFile (Context ctx, String buildName)
    {
        Build useless = new Build();
        Build returnBuild;
        boolean found = false;
        
        String name = "";
        String playableClass = "";
        int level = 0;
        int bab = 0;
        int baseHP = 0; 
        int str = 0;
        int strEnhancement = 0;
        int strMorale = 0;
        int strSize = 0;
        int strAlchemical = 0;
        int strInherent = 0;
        int strOther = 0;
        int dex = 0;
        int dexEnhancement = 0;
        int dexMorale = 0;
        int dexSize = 0;
        int dexAlchemical = 0;
        int dexInherent = 0;
        int dexOther = 0;
        int con = 0;
        int conEnhancement = 0;
        int conMorale = 0;
        int conSize = 0;
        int conAlchemical = 0;
        int conInherent = 0;
        int conOther = 0;
        int toHitMorale = 0;
        int toHitLuck = 0;
        int toHitSacred = 0;
        int toHitSize = 0;
        int toHitUntyped = 0;
        int toHitOther = 0;
        int dmgMorale = 0;
        int dmgLuck = 0;
        int dmgSacred = 0;
        int dmgUntyped = 0;
        int dmgOther = 0;
        int acArmor = 0;
        int acNatural = 0;
        int acNaturalEnhancement = 0;
        int acSacred = 0;
        int acShield = 0;
        int acDeflection = 0;
        int acUntyped = 0;
        int acSize = 0;
        int acOther = 0;
        int acDexMax = -1;
        
        try
        {           
            File xmldb = new File(ctx.getFilesDir() + "/build_db.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmldb);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("build");

            for (int temp = 0; temp < nList.getLength(); temp++)
            {

                Node nNode = nList.item(temp);          

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    
                    Element eElement = (Element) nNode;
                    System.out.println(eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println(buildName);
                    if ((eElement.getElementsByTagName("name").item(0).getTextContent()).equals(buildName))
                    {
                         name = eElement.getElementsByTagName("name").item(0).getTextContent();
                         playableClass = eElement.getElementsByTagName("playableclass").item(0).getTextContent();

                          level = Integer.parseInt(eElement.getElementsByTagName("level").item(0).getTextContent());
                          bab = Integer.parseInt(eElement.getElementsByTagName("bab").item(0).getTextContent());
                          baseHP = Integer.parseInt(eElement.getElementsByTagName("basehp").item(0).getTextContent());

                        //strength and bonuses
                          str = Integer.parseInt(eElement.getElementsByTagName("str").item(0).getTextContent());
                          strEnhancement = Integer.parseInt(eElement.getElementsByTagName("strenhancement").item(0).getTextContent());
                          strMorale = Integer.parseInt(eElement.getElementsByTagName("strmorale").item(0).getTextContent());
                          strSize = Integer.parseInt(eElement.getElementsByTagName("strsize").item(0).getTextContent());
                          strAlchemical = Integer.parseInt(eElement.getElementsByTagName("stralchemical").item(0).getTextContent());
                          strInherent = Integer.parseInt(eElement.getElementsByTagName("strinherent").item(0).getTextContent());
                          strOther = Integer.parseInt(eElement.getElementsByTagName("strother").item(0).getTextContent());

                        //dexterity and bonuses
                          dex = Integer.parseInt(eElement.getElementsByTagName("dex").item(0).getTextContent());
                          dexEnhancement = Integer.parseInt(eElement.getElementsByTagName("dexenhancement").item(0).getTextContent());
                          dexMorale = Integer.parseInt(eElement.getElementsByTagName("dexmorale").item(0).getTextContent());
                          dexSize = Integer.parseInt(eElement.getElementsByTagName("dexsize").item(0).getTextContent());
                          dexAlchemical = Integer.parseInt(eElement.getElementsByTagName("dexalchemical").item(0).getTextContent());
                          dexInherent = Integer.parseInt(eElement.getElementsByTagName("dexinherent").item(0).getTextContent());
                          dexOther = Integer.parseInt(eElement.getElementsByTagName("dexother").item(0).getTextContent());

                        //constitution and bonuses
                          con = Integer.parseInt(eElement.getElementsByTagName("con").item(0).getTextContent());
                          conEnhancement = Integer.parseInt(eElement.getElementsByTagName("conenhancement").item(0).getTextContent());
                          conMorale = Integer.parseInt(eElement.getElementsByTagName("conmorale").item(0).getTextContent());
                          conSize = Integer.parseInt(eElement.getElementsByTagName("consize").item(0).getTextContent());
                          conAlchemical = Integer.parseInt(eElement.getElementsByTagName("conalchemical").item(0).getTextContent());
                          conInherent = Integer.parseInt(eElement.getElementsByTagName("coninherent").item(0).getTextContent());
                          conOther = Integer.parseInt(eElement.getElementsByTagName("conother").item(0).getTextContent());

                        //to-hit bonuses
                          toHitMorale = Integer.parseInt(eElement.getElementsByTagName("tohitmorale").item(0).getTextContent());
                          toHitLuck = Integer.parseInt(eElement.getElementsByTagName("tohitluck").item(0).getTextContent());
                          toHitSacred = Integer.parseInt(eElement.getElementsByTagName("tohitsacred").item(0).getTextContent());           
                          toHitSize = Integer.parseInt(eElement.getElementsByTagName("tohitsize").item(0).getTextContent());
                          toHitUntyped = Integer.parseInt(eElement.getElementsByTagName("tohituntyped").item(0).getTextContent());
                          toHitOther = Integer.parseInt(eElement.getElementsByTagName("tohitother").item(0).getTextContent());

                        //damage bonuses
                          dmgMorale = Integer.parseInt(eElement.getElementsByTagName("dmgmorale").item(0).getTextContent());
                          dmgLuck = Integer.parseInt(eElement.getElementsByTagName("dmgluck").item(0).getTextContent());
                          dmgSacred = Integer.parseInt(eElement.getElementsByTagName("dmgsacred").item(0).getTextContent());                        
                          dmgUntyped = Integer.parseInt(eElement.getElementsByTagName("dmguntyped").item(0).getTextContent());
                          dmgOther = Integer.parseInt(eElement.getElementsByTagName("dmgother").item(0).getTextContent());
                        
                        //armor class bonuses
                          acArmor = Integer.parseInt(eElement.getElementsByTagName("acarmor").item(0).getTextContent());
                          acNatural = Integer.parseInt(eElement.getElementsByTagName("acnatural").item(0).getTextContent());
                          acNaturalEnhancement = Integer.parseInt(eElement.getElementsByTagName("acnaturalenhancement").item(0).getTextContent());
                          acSacred = Integer.parseInt(eElement.getElementsByTagName("acsacred").item(0).getTextContent());
                          acShield = Integer.parseInt(eElement.getElementsByTagName("acshield").item(0).getTextContent());
                          acDeflection = Integer.parseInt(eElement.getElementsByTagName("acdeflection").item(0).getTextContent());
                          acUntyped = Integer.parseInt(eElement.getElementsByTagName("acuntyped").item(0).getTextContent());
                        acSize = Integer.parseInt(eElement.getElementsByTagName("acsize").item(0).getTextContent());
                          acOther = Integer.parseInt(eElement.getElementsByTagName("acother").item(0).getTextContent());
                          acDexMax = Integer.parseInt(eElement.getElementsByTagName("acdexmax").item(0).getTextContent());
                          
                        
                          found = true;
                          System.out.println(found);
                          
                    }    // end if name = passed name                                              
                }   // end if node is a element
                
            }  // end for
            System.out.println(found);
            if (found == false)
            {
                returnBuild = new Build();
                
            } else {
                returnBuild = useless.fullInitialize(name, playableClass, level, bab, baseHP, 
                                                     str, strEnhancement, strMorale, strSize, strAlchemical,
                                                     strInherent, strOther, dex, dexEnhancement, dexMorale,
                                                     dexSize, dexAlchemical, dexInherent, dexOther, con,
                                                     conEnhancement, conMorale, conSize, conAlchemical,
                                                     conInherent, conOther, toHitMorale, toHitLuck,
                                                     toHitSacred, toHitSize, toHitUntyped, toHitOther,
                                                     dmgMorale, dmgLuck, dmgSacred,
                                                     dmgUntyped, dmgOther, acArmor, acNatural,
                                                     acNaturalEnhancement, acSacred, acShield, acDeflection,
                                                     acUntyped, acOther, acDexMax, acSize);
                
            }
        }  // end try
        catch (Exception e)
        {
            e.printStackTrace();
            returnBuild = new Build();
            
        }

        return returnBuild;
        
    }
    
    public Build updateBuildInXml(Context ctx,
                                  String name, String newname, String playableClass, int level, int bab, int baseHP, 
                                  int str, int strEnhancement, int strMorale, int strSize, int strAlchemical,
                                  int strInherent, int strOther, int dex, int dexEnhancement, int dexMorale,
                                  int dexSize, int dexAlchemical, int dexInherent, int dexOther, int con,
                                  int conEnhancement, int conMorale, int conSize, int conAlchemical,
                                  int conInherent, int conOther, int toHitMorale, int toHitLuck,
                                  int toHitSacred, int toHitSize, int toHitUntyped, int toHitOther,
                                  int dmgMorale, int dmgLuck,  int dmgSacred,
                                  int dmgUntyped, int dmgOther, int acArmor, int acNatural,
                                  int acNaturalEnhancement, int acSacred, int acShield, int acDeflection,
                                  int acUntyped, int acOther, int acDexMax, int acSize)
    {
        Build useless = new Build();
        Build returnBuild;
        
        try
        {           
            File xmldb = new File(ctx.getFilesDir() + "/build_db.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmldb);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("build");

            for (int temp = 0; temp < nList.getLength(); temp++)
            {

                Node nNode = nList.item(temp);          

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {

                    Element eElement = (Element) nNode;
                    
                    if ((eElement.getElementsByTagName("name").item(0).getTextContent()).equals(name))
                    {
                        //build info
                        eElement.getElementsByTagName("name").item(0).setTextContent(newname);
                        eElement.getElementsByTagName("playableclass").item(0).setTextContent(playableClass);

                        eElement.getElementsByTagName("level").item(0).setTextContent(Integer.toString(level));
                        eElement.getElementsByTagName("bab").item(0).setTextContent(Integer.toString(bab));
                        eElement.getElementsByTagName("basehp").item(0).setTextContent(Integer.toString(baseHP));
                        
                        
                        //strength and bonuses
                        eElement.getElementsByTagName("str").item(0).setTextContent(Integer.toString(str));
                        eElement.getElementsByTagName("strenhancement").item(0).setTextContent(Integer.toString(strEnhancement));
                        eElement.getElementsByTagName("strmorale").item(0).setTextContent(Integer.toString(strMorale));
                        eElement.getElementsByTagName("strsize").item(0).setTextContent(Integer.toString(strSize));
                        eElement.getElementsByTagName("stralchemical").item(0).setTextContent(Integer.toString(strAlchemical));
                        eElement.getElementsByTagName("strinherent").item(0).setTextContent(Integer.toString(strInherent));
                        eElement.getElementsByTagName("strother").item(0).setTextContent(Integer.toString(strOther));

                        //dexterity and bonuses
                        eElement.getElementsByTagName("dex").item(0).setTextContent(Integer.toString(dex));
                        eElement.getElementsByTagName("dexenhancement").item(0).setTextContent(Integer.toString(dexEnhancement));
                        eElement.getElementsByTagName("dexmorale").item(0).setTextContent(Integer.toString(dexMorale));
                        eElement.getElementsByTagName("dexsize").item(0).setTextContent(Integer.toString(dexSize));
                        eElement.getElementsByTagName("dexalchemical").item(0).setTextContent(Integer.toString(dexAlchemical));
                        eElement.getElementsByTagName("dexinherent").item(0).setTextContent(Integer.toString(dexInherent));
                        eElement.getElementsByTagName("dexother").item(0).setTextContent(Integer.toString(dexOther));

                        //constitution and bonuses
                        eElement.getElementsByTagName("con").item(0).setTextContent(Integer.toString(con));
                        eElement.getElementsByTagName("conenhancement").item(0).setTextContent(Integer.toString(conEnhancement));
                        eElement.getElementsByTagName("conmorale").item(0).setTextContent(Integer.toString(conMorale));
                        eElement.getElementsByTagName("consize").item(0).setTextContent(Integer.toString(conSize));
                        eElement.getElementsByTagName("conalchemical").item(0).setTextContent(Integer.toString(conAlchemical));
                        eElement.getElementsByTagName("coninherent").item(0).setTextContent(Integer.toString(conInherent));
                        eElement.getElementsByTagName("conother").item(0).setTextContent(Integer.toString(conOther));

                        //to-hit bonuses
                        eElement.getElementsByTagName("tohitmorale").item(0).setTextContent(Integer.toString(toHitMorale));
                        eElement.getElementsByTagName("tohitluck").item(0).setTextContent(Integer.toString(toHitLuck));
                        eElement.getElementsByTagName("tohitsacred").item(0).setTextContent(Integer.toString(toHitSacred));                    
                        eElement.getElementsByTagName("tohitsize").item(0).setTextContent(Integer.toString(toHitSize));
                        eElement.getElementsByTagName("tohituntyped").item(0).setTextContent(Integer.toString(toHitUntyped));
                        eElement.getElementsByTagName("tohitother").item(0).setTextContent(Integer.toString(toHitOther));
                        
                        //damage bonuses
                        eElement.getElementsByTagName("dmgmorale").item(0).setTextContent(Integer.toString(dmgMorale));
                        eElement.getElementsByTagName("dmgluck").item(0).setTextContent(Integer.toString(dmgLuck));
                        eElement.getElementsByTagName("dmgsacred").item(0).setTextContent(Integer.toString(dmgSacred));
                        eElement.getElementsByTagName("dmguntyped").item(0).setTextContent(Integer.toString(dmgUntyped));
                        eElement.getElementsByTagName("dmgother").item(0).setTextContent(Integer.toString(dmgOther));
                        
                        //armor class bonuses
                        eElement.getElementsByTagName("acarmor").item(0).setTextContent(Integer.toString(acArmor));
                        eElement.getElementsByTagName("acnatural").item(0).setTextContent(Integer.toString(acNatural));
                        eElement.getElementsByTagName("acnaturalenhancement").item(0).setTextContent(Integer.toString(acNaturalEnhancement));
                        eElement.getElementsByTagName("acsacred").item(0).setTextContent(Integer.toString(acSacred));
                        eElement.getElementsByTagName("acshield").item(0).setTextContent(Integer.toString(acShield));
                        eElement.getElementsByTagName("acdeflection").item(0).setTextContent(Integer.toString(acDeflection));                      
                        eElement.getElementsByTagName("acuntyped").item(0).setTextContent(Integer.toString(acUntyped));
                        eElement.getElementsByTagName("acsize").item(0).setTextContent(Integer.toString(acSize));
                        eElement.getElementsByTagName("acother").item(0).setTextContent(Integer.toString(acOther));         
                        eElement.getElementsByTagName("acdexmax").item(0).setTextContent(Integer.toString(acDexMax));
                        
           
                    }    // end if name = passed name                                              
                }   // end if node is a element

            }  // end for
            
            
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmldb);
            transformer.transform(source, result);   
            
            returnBuild = useless.fullInitialize(name, playableClass, level, bab, baseHP, 
                                                 str, strEnhancement, strMorale, strSize, strAlchemical,
                                                 strInherent, strOther, dex, dexEnhancement, dexMorale,
                                                 dexSize, dexAlchemical, dexInherent, dexOther, con,
                                                 conEnhancement, conMorale, conSize, conAlchemical,
                                                 conInherent, conOther, toHitMorale, toHitLuck,
                                                 toHitSacred, toHitSize, toHitUntyped, toHitOther,
                                                 dmgMorale, dmgLuck,  dmgSacred,
                                                 dmgUntyped, dmgOther, acArmor, acNatural,
                                                 acNaturalEnhancement, acSacred, acShield, acDeflection,
                                                 acUntyped, acOther, acDexMax, acSize);

            
        }  // end try
        catch (ParserConfigurationException pce)
        {
            pce.printStackTrace();
            returnBuild = new Build();
        }
        catch (TransformerException tfe)
        {
            tfe.printStackTrace();
            returnBuild = new Build();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            returnBuild = new Build();
            
        }
        catch (SAXException sae)
        {
            sae.printStackTrace();
            returnBuild = new Build();
        }    
        return returnBuild;
    }
    
    
    
    
}
