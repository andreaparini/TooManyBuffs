package com.andreap.toomanybuffs;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.support.v7.app.*;
import android.support.v7.widget.Toolbar;
import java.io.File;
import java.io.*;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import android.support.v4.media.session.*;
import org.apache.http.util.*;
import org.w3c.dom.*;

public class AddAttackActivity extends AppCompatActivity
{
    static String staticAddAttackBuildName = new String ("");
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addattack);
        Toolbar main_toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(main_toolbar);
        
        Intent intentFromSetAttacks = getIntent();
        staticAddAttackBuildName = intentFromSetAttacks.getStringExtra("loadedBuild");
        
        
        Spinner baseDamageSpinner = (Spinner) findViewById(R.id.addattackBaseDamageSpinner);       
        ArrayAdapter<CharSequence> baseDamageAdapter = ArrayAdapter.createFromResource
            (this, R.array.basedamage, android.R.layout.simple_spinner_item);
        baseDamageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        baseDamageSpinner.setAdapter(baseDamageAdapter);
        
        Spinner weaponEnhancementSpinner = (Spinner) findViewById(R.id.addattackWeaponEnhancementSpinner);       
        ArrayAdapter<CharSequence> weaponEnhancementAdapter = ArrayAdapter.createFromResource
        (this, R.array.weaponenhancement, android.R.layout.simple_spinner_item);
        weaponEnhancementAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weaponEnhancementSpinner.setAdapter(weaponEnhancementAdapter);
        
        
        Spinner criticalSpinner = (Spinner) findViewById(R.id.addattackCriticalSpinner);       
        ArrayAdapter<CharSequence> criticalAdapter = ArrayAdapter.createFromResource
            (this, R.array.critical, android.R.layout.simple_spinner_item);
        criticalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        criticalSpinner.setAdapter(criticalAdapter);
        
        
        Spinner bonusDiceDamageSpinner = (Spinner) findViewById(R.id.addattackBonusDiceSpinner);       
        ArrayAdapter<CharSequence> bonusDiceDamageAdapter = ArrayAdapter.createFromResource
            (this, R.array.bonusdicedamage, android.R.layout.simple_spinner_item);
        bonusDiceDamageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bonusDiceDamageSpinner.setAdapter(bonusDiceDamageAdapter);
        
        
        Spinner bonusDiceDamageSpinner2 = (Spinner) findViewById(R.id.addattackBonusDiceSpinner2);       
        ArrayAdapter<CharSequence> bonusDiceDamageAdapter2 = ArrayAdapter.createFromResource
            (this, R.array.bonusdicedamage, android.R.layout.simple_spinner_item);
        bonusDiceDamageAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bonusDiceDamageSpinner2.setAdapter(bonusDiceDamageAdapter2);
        
        
        Spinner attackBasedOnSpinner = (Spinner) findViewById(R.id.addattackAttackBasedOnSpinner);       
        ArrayAdapter<CharSequence> attackBasedOnAdapter = ArrayAdapter.createFromResource
            (this, R.array.attacktype, android.R.layout.simple_spinner_item);
        attackBasedOnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attackBasedOnSpinner.setAdapter(attackBasedOnAdapter);
        
        
        Spinner damageBasedOnSpinner = (Spinner) findViewById(R.id.addattackDamageBasedOnSpinner);       
        ArrayAdapter<CharSequence> damageBasedOnAdapter = ArrayAdapter.createFromResource
            (this, R.array.damagetype, android.R.layout.simple_spinner_item);
        damageBasedOnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        damageBasedOnSpinner.setAdapter(damageBasedOnAdapter);
        
        
        Spinner iterativeAttacksSpinner = (Spinner) findViewById(R.id.addattackIterativeAttacksSpinner);       
        ArrayAdapter<CharSequence> iterativeAttacksAdapter = ArrayAdapter.createFromResource
            (this, R.array.iterativeattacks, android.R.layout.simple_spinner_item);
        iterativeAttacksAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        iterativeAttacksSpinner.setAdapter(iterativeAttacksAdapter);
        
        
        
        Spinner TWFSpinner = (Spinner) findViewById(R.id.addattackTWFSpinner);       
        ArrayAdapter<CharSequence> TWFAdapter = ArrayAdapter.createFromResource
            (this, R.array.twoweaponfighting, android.R.layout.simple_spinner_item);
        TWFAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TWFSpinner.setAdapter(TWFAdapter);       
        
        
        Spinner customAttackBonusSpinner = (Spinner) findViewById(R.id.addattackCustomAttackBonusSpinner);       
        ArrayAdapter<CharSequence> customAttackBonusAdapter = ArrayAdapter.createFromResource
            (this, R.array.numbers15, android.R.layout.simple_spinner_item);
        customAttackBonusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customAttackBonusSpinner.setAdapter(customAttackBonusAdapter);
        customAttackBonusSpinner.setSelection(15);
        
        Spinner customDamageBonusSpinner = (Spinner) findViewById(R.id.addattackCustomDamageBonusSpinner);       
        ArrayAdapter<CharSequence> customDamageBonusAdapter = ArrayAdapter.createFromResource
        (this, R.array.numbers15, android.R.layout.simple_spinner_item);
        customDamageBonusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customDamageBonusSpinner.setAdapter(customDamageBonusAdapter);
        customDamageBonusSpinner.setSelection(15);
        
    }

    public void onAddAttackButtonClick(View view)
    {   
        EditText attackView = (EditText) findViewById(R.id.addattackName);
        
        if( !attackView.getText().toString().equals("") && attackView.getText().toString().length() > 0 )
        {
           
            Spinner baseDamageSpinner = (Spinner) findViewById(R.id.addattackBaseDamageSpinner);
            Spinner weaponEnhancementSpinner = (Spinner) findViewById(R.id.addattackWeaponEnhancementSpinner);
            Spinner criticalSpinner = (Spinner) findViewById(R.id.addattackCriticalSpinner);                  
            Spinner bonusDiceDamageSpinner = (Spinner) findViewById(R.id.addattackBonusDiceSpinner);                   
            Spinner bonusDiceDamageSpinner2 = (Spinner) findViewById(R.id.addattackBonusDiceSpinner2);                  
            Spinner attackBasedOnSpinner = (Spinner) findViewById(R.id.addattackAttackBasedOnSpinner);                 
            Spinner damageBasedOnSpinner = (Spinner) findViewById(R.id.addattackDamageBasedOnSpinner);                
            Spinner iterativeAttacksSpinner = (Spinner) findViewById(R.id.addattackIterativeAttacksSpinner);                   
            Spinner TWFSpinner = (Spinner) findViewById(R.id.addattackTWFSpinner);                   
            Spinner customAttackBonusSpinner = (Spinner) findViewById(R.id.addattackCustomAttackBonusSpinner);                   
            Spinner customDamageBonusSpinner = (Spinner) findViewById(R.id.addattackCustomDamageBonusSpinner);       
   
            String name = new String(attackView.getText().toString());
            name = name.trim();
            
            String baseDamage = new String(String.valueOf(baseDamageSpinner.getSelectedItem()));
            String weaponEnhancement = new String(String.valueOf(weaponEnhancementSpinner.getSelectedItem()));
            String critical = new String(String.valueOf(criticalSpinner.getSelectedItem()));
            String bonusDiceDamage = new String(String.valueOf(bonusDiceDamageSpinner.getSelectedItem()));
            String bonusDiceDamage2 = new String(String.valueOf(bonusDiceDamageSpinner2.getSelectedItem()));
            String attackBasedOn = new String(String.valueOf(attackBasedOnSpinner.getSelectedItem()));
            String damageBasedOn = new String(String.valueOf(damageBasedOnSpinner.getSelectedItem()));
            String iterativeAttacks = new String(String.valueOf(iterativeAttacksSpinner.getSelectedItem()));
            String TWF = new String(String.valueOf(TWFSpinner.getSelectedItem()));
            String customAttackBonus = new String(String.valueOf(customAttackBonusSpinner.getSelectedItem()));
            String customDamageBonus = new String(String.valueOf(customDamageBonusSpinner.getSelectedItem()));
            int customAttackBonusInt = Integer.parseInt(customAttackBonus);
            int customDamageBonusInt = Integer.parseInt(customDamageBonus);
                   
            addNewAttack (this, staticAddAttackBuildName,
                         name, baseDamage, weaponEnhancement,
                         critical, bonusDiceDamage,
                         bonusDiceDamage2, attackBasedOn,
                         damageBasedOn, iterativeAttacks,
                         TWF, customAttackBonusInt,
                         customDamageBonusInt);  
                         
            finish();            
            
        } else {
            Toast.makeText(this, 
                           "Attack name field is empty", 
                           Toast.LENGTH_LONG).show();
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
            case R.id.mainMenuHelp:
                
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
    
    public void addNewAttack (Context ctx, String loadedBuildName, String name, String baseDamage,
                              String weaponEnhancement, String critical, String bonusDiceDamage,
                              String bonusDiceDamage2, String attackBasedOn,
                              String damageBasedOn, String iterativeAttacks,
                              String TWF, int customAttackBonusInt,
                              int customDamageBonusInt)                             
    {

        try
        {         
            File attackdb = new File(getFilesDir()+"/attacks_db.xml");
            if(attackdb.exists())
            {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(attackdb);
                
                Element rootElement = doc.getDocumentElement();
                
                NodeList nList = doc.getElementsByTagName("build");
                
                if (nList.getLength() == 0)
                {

                    //file exists but is empty

                    Element newBuild = doc.createElement("build");
                    rootElement.appendChild(newBuild);

                    Attr newBuildId = doc.createAttribute("id");
                    newBuildId.setValue(loadedBuildName);
                    newBuild.setAttributeNode(newBuildId);

                    Element newAttack = doc.createElement("attack");
                    Attr attackId = doc.createAttribute("attackid");
                    attackId.setValue("0");
                    newAttack.setAttributeNode(attackId);
                    newBuild.appendChild(newAttack);

                    Element attackName = doc.createElement("name");
                    attackName.appendChild(doc.createTextNode(name));
                    Element attackBaseDiceDamage = doc.createElement("basedicedamage");
                    attackBaseDiceDamage.appendChild(doc.createTextNode(baseDamage));
                    Element attackWeaponEnhancement = doc.createElement("weaponenhancement");
                    attackWeaponEnhancement.appendChild(doc.createTextNode(weaponEnhancement));
                    Element attackCritical = doc.createElement("critical");
                    attackCritical.appendChild(doc.createTextNode(critical));
                    Element attackBonusDiceDamage = doc.createElement("bonusdicedamage");
                    attackBonusDiceDamage.appendChild(doc.createTextNode(bonusDiceDamage));
                    Element attackBonusDiceDamage2 = doc.createElement("bonusdicedamage2");
                    attackBonusDiceDamage2.appendChild(doc.createTextNode(bonusDiceDamage2));
                    Element attackAttackBasedOn = doc.createElement("attackbasedon");
                    attackAttackBasedOn.appendChild(doc.createTextNode(attackBasedOn));
                    Element attackDamageBasedOn = doc.createElement("damagebasedon");
                    attackDamageBasedOn.appendChild(doc.createTextNode(damageBasedOn));
                    Element attackIterativeAttacks = doc.createElement("iterativeattacks");
                    attackIterativeAttacks.appendChild(doc.createTextNode(iterativeAttacks));
                    Element attackTWF = doc.createElement("twf");
                    attackTWF.appendChild(doc.createTextNode(TWF));


                    Element attackCustomAttackBonus = doc.createElement("customattackbonus");
                    attackCustomAttackBonus.appendChild(doc.createTextNode(Integer.toString(customAttackBonusInt)));
                    Element attackCustomDamageBonus = doc.createElement("customdamagebonus");
                    attackCustomDamageBonus.appendChild(doc.createTextNode(Integer.toString(customDamageBonusInt)));


                    newAttack.appendChild(attackName);
                    newAttack.appendChild(attackBaseDiceDamage);
                    newAttack.appendChild(attackWeaponEnhancement);
                    newAttack.appendChild(attackCritical);
                    newAttack.appendChild(attackBonusDiceDamage);
                    newAttack.appendChild(attackBonusDiceDamage2);
                    newAttack.appendChild(attackAttackBasedOn);
                    newAttack.appendChild(attackDamageBasedOn);
                    newAttack.appendChild(attackIterativeAttacks);
                    newAttack.appendChild(attackTWF);
                    newAttack.appendChild(attackCustomAttackBonus);
                    newAttack.appendChild(attackCustomDamageBonus);


                    // write the content into xml file
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File(getFilesDir() + "/attacks_db.xml"));

                    // Output to console for testing
                    //StreamResult result = new StreamResult(System.out);

                    transformer.transform(source, result);

                }
                else
                {
                    boolean found = false;
                    // file exists and at least 1 build is present
                    for (int temp = 0; temp < nList.getLength(); temp++)
                    {

                        Node nNode = nList.item(temp);          


                        if (nNode.getNodeType() == Node.ELEMENT_NODE)
                        {

                            Element eElement = (Element) nNode;

                            String buildId = new String(eElement.getAttribute("id"));
                            if (buildId.equals(loadedBuildName))
                            {
                                //build already exists, just add attack
                                NodeList nAttacks = eElement.getElementsByTagName("attack");
                                int nid = nAttacks.getLength();

                                Element newAttack = doc.createElement("attack");
                                Attr attackId = doc.createAttribute("attackid");
                                attackId.setValue(Integer.toString(nid));
                                newAttack.setAttributeNode(attackId);
                                eElement.appendChild(newAttack);

                                Element attackName = doc.createElement("name");
                                attackName.appendChild(doc.createTextNode(name));
                                Element attackBaseDiceDamage = doc.createElement("basedicedamage");
                                attackBaseDiceDamage.appendChild(doc.createTextNode(baseDamage));
                                Element attackWeaponEnhancement = doc.createElement("weaponenhancement");
                                attackWeaponEnhancement.appendChild(doc.createTextNode(weaponEnhancement));
                                Element attackCritical = doc.createElement("critical");
                                attackCritical.appendChild(doc.createTextNode(critical));
                                Element attackBonusDiceDamage = doc.createElement("bonusdicedamage");
                                attackBonusDiceDamage.appendChild(doc.createTextNode(bonusDiceDamage));
                                Element attackBonusDiceDamage2 = doc.createElement("bonusdicedamage2");
                                attackBonusDiceDamage2.appendChild(doc.createTextNode(bonusDiceDamage2));
                                Element attackAttackBasedOn = doc.createElement("attackbasedon");
                                attackAttackBasedOn.appendChild(doc.createTextNode(attackBasedOn));
                                Element attackDamageBasedOn = doc.createElement("damagebasedon");
                                attackDamageBasedOn.appendChild(doc.createTextNode(damageBasedOn));
                                Element attackIterativeAttacks = doc.createElement("iterativeattacks");
                                attackIterativeAttacks.appendChild(doc.createTextNode(iterativeAttacks));                        
                                Element attackTWF = doc.createElement("twf");
                                attackTWF.appendChild(doc.createTextNode(TWF));
                                Element attackCustomAttackBonus = doc.createElement("customattackbonus");
                                attackCustomAttackBonus.appendChild(doc.createTextNode(Integer.toString(customAttackBonusInt)));
                                Element attackCustomDamageBonus = doc.createElement("customdamagebonus");
                                attackCustomDamageBonus.appendChild(doc.createTextNode(Integer.toString(customDamageBonusInt)));


                                newAttack.appendChild(attackName);
                                newAttack.appendChild(attackBaseDiceDamage);
                                newAttack.appendChild(attackWeaponEnhancement);
                                newAttack.appendChild(attackCritical);
                                newAttack.appendChild(attackBonusDiceDamage);
                                newAttack.appendChild(attackBonusDiceDamage2);
                                newAttack.appendChild(attackAttackBasedOn);
                                newAttack.appendChild(attackDamageBasedOn);
                                newAttack.appendChild(attackIterativeAttacks);
                                newAttack.appendChild(attackTWF);
                                newAttack.appendChild(attackCustomAttackBonus);
                                newAttack.appendChild(attackCustomDamageBonus);


                                // write the content into xml file
                                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                                Transformer transformer = transformerFactory.newTransformer();
                                DOMSource source = new DOMSource(doc);
                                StreamResult result = new StreamResult(new File(getFilesDir() + "/attacks_db.xml"));

                                // Output to console for testing
                                //StreamResult result = new StreamResult(System.out);

                                transformer.transform(source, result);
                                found = true;
                            } 

                        }

                    }// end for
                    if ( found == false)
                    {
                        Element newBuild = doc.createElement("build");
                        rootElement.appendChild(newBuild);

                        Attr newBuildId = doc.createAttribute("id");
                        newBuildId.setValue(loadedBuildName);
                        newBuild.setAttributeNode(newBuildId);

                        Element newAttack = doc.createElement("attack");
                        Attr attackId = doc.createAttribute("attackid");
                        attackId.setValue("0");
                        newAttack.setAttributeNode(attackId);
                        newBuild.appendChild(newAttack);

                        Element attackName = doc.createElement("name");
                        attackName.appendChild(doc.createTextNode(name));
                        Element attackBaseDiceDamage = doc.createElement("basedicedamage");
                        attackBaseDiceDamage.appendChild(doc.createTextNode(baseDamage));
                        Element attackWeaponEnhancement = doc.createElement("weaponenhancement");
                        attackWeaponEnhancement.appendChild(doc.createTextNode(weaponEnhancement));
                        Element attackCritical = doc.createElement("critical");
                        attackCritical.appendChild(doc.createTextNode(critical));
                        Element attackBonusDiceDamage = doc.createElement("bonusdicedamage");
                        attackBonusDiceDamage.appendChild(doc.createTextNode(bonusDiceDamage));
                        Element attackBonusDiceDamage2 = doc.createElement("bonusdicedamage2");
                        attackBonusDiceDamage2.appendChild(doc.createTextNode(bonusDiceDamage2));
                        Element attackAttackBasedOn = doc.createElement("attackbasedon");
                        attackAttackBasedOn.appendChild(doc.createTextNode(attackBasedOn));
                        Element attackDamageBasedOn = doc.createElement("damagebasedon");
                        attackDamageBasedOn.appendChild(doc.createTextNode(damageBasedOn));
                        Element attackIterativeAttacks = doc.createElement("iterativeattacks");
                        attackIterativeAttacks.appendChild(doc.createTextNode(iterativeAttacks));
                        Element attackTWF = doc.createElement("twf");
                        attackTWF.appendChild(doc.createTextNode(TWF));


                        Element attackCustomAttackBonus = doc.createElement("customattackbonus");
                        attackCustomAttackBonus.appendChild(doc.createTextNode(Integer.toString(customAttackBonusInt)));
                        Element attackCustomDamageBonus = doc.createElement("customdamagebonus");
                        attackCustomDamageBonus.appendChild(doc.createTextNode(Integer.toString(customDamageBonusInt)));


                        newAttack.appendChild(attackName);
                        newAttack.appendChild(attackBaseDiceDamage);
                        newAttack.appendChild(attackWeaponEnhancement);
                        newAttack.appendChild(attackCritical);
                        newAttack.appendChild(attackBonusDiceDamage);
                        newAttack.appendChild(attackBonusDiceDamage2);
                        newAttack.appendChild(attackAttackBasedOn);
                        newAttack.appendChild(attackDamageBasedOn);
                        newAttack.appendChild(attackIterativeAttacks);
                        newAttack.appendChild(attackTWF);
                        newAttack.appendChild(attackCustomAttackBonus);
                        newAttack.appendChild(attackCustomDamageBonus);


                        // write the content into xml file
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(new File(getFilesDir() + "/attacks_db.xml"));

                        // Output to console for testing
                        //StreamResult result = new StreamResult(System.out);

                        transformer.transform(source, result);
                        
                    }
                }
            }
            else
            {
                //file does not exist
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                // root elements
                Document doc = docBuilder.newDocument();

                Element rootElement = doc.createElement("attacks");
                doc.appendChild(rootElement);


                Element newBuild = doc.createElement("build");
                rootElement.appendChild(newBuild);

                Attr buildId = doc.createAttribute("id");
                buildId.setValue(loadedBuildName);
                newBuild.setAttributeNode(buildId);
                
                Element newAttack = doc.createElement("attack");
                Attr attackId = doc.createAttribute("attackid");
                attackId.setValue("0");
                newAttack.setAttributeNode(attackId);
                newBuild.appendChild(newAttack);
                
                Element attackName = doc.createElement("name");
                attackName.appendChild(doc.createTextNode(name));
                Element attackBaseDiceDamage = doc.createElement("basedicedamage");
                attackBaseDiceDamage.appendChild(doc.createTextNode(baseDamage));
                Element attackWeaponEnhancement = doc.createElement("weaponenhancement");
                attackWeaponEnhancement.appendChild(doc.createTextNode(weaponEnhancement));
                Element attackCritical = doc.createElement("critical");
                attackCritical.appendChild(doc.createTextNode(critical));
                Element attackBonusDiceDamage = doc.createElement("bonusdicedamage");
                attackBonusDiceDamage.appendChild(doc.createTextNode(bonusDiceDamage));
                Element attackBonusDiceDamage2 = doc.createElement("bonusdicedamage2");
                attackBonusDiceDamage2.appendChild(doc.createTextNode(bonusDiceDamage2));
                Element attackAttackBasedOn = doc.createElement("attackbasedon");
                attackAttackBasedOn.appendChild(doc.createTextNode(attackBasedOn));
                Element attackDamageBasedOn = doc.createElement("damagebasedon");
                attackDamageBasedOn.appendChild(doc.createTextNode(damageBasedOn));
                Element attackIterativeAttacks = doc.createElement("iterativeattacks");
                attackIterativeAttacks.appendChild(doc.createTextNode(iterativeAttacks));
                Element attackTWF = doc.createElement("twf");
                attackTWF.appendChild(doc.createTextNode(TWF));
                
                
                Element attackCustomAttackBonus = doc.createElement("customattackbonus");
                attackCustomAttackBonus.appendChild(doc.createTextNode(Integer.toString(customAttackBonusInt)));
                Element attackCustomDamageBonus = doc.createElement("customdamagebonus");
                attackCustomDamageBonus.appendChild(doc.createTextNode(Integer.toString(customDamageBonusInt)));
                
                
                newAttack.appendChild(attackName);
                newAttack.appendChild(attackBaseDiceDamage);
                newAttack.appendChild(attackWeaponEnhancement);
                newAttack.appendChild(attackCritical);
                newAttack.appendChild(attackBonusDiceDamage);
                newAttack.appendChild(attackBonusDiceDamage2);
                newAttack.appendChild(attackAttackBasedOn);
                newAttack.appendChild(attackDamageBasedOn);
                newAttack.appendChild(attackIterativeAttacks);
                newAttack.appendChild(attackTWF);
                newAttack.appendChild(attackCustomAttackBonus);
                newAttack.appendChild(attackCustomDamageBonus);
                

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(getFilesDir()+"/attacks_db.xml"));

                // Output to console for testing
                //StreamResult result = new StreamResult(System.out);

                transformer.transform(source, result);
            }

        }
        catch (ParserConfigurationException pce)
        {
            pce.printStackTrace();
        }
        catch (TransformerException tfe)
        {
            tfe.printStackTrace();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (SAXException sae)
        {
            sae.printStackTrace();
        }




        return;
    }
}
