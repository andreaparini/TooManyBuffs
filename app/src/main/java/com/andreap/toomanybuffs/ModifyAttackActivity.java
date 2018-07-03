package com.andreap.toomanybuffs;


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
import java.util.*;

public class ModifyAttackActivity extends AppCompatActivity
{
    static String staticModifyAttackBuildName = new String ("");
    static String staticModifyAttackOldName = new String("");
    static int modAttPos = -1;
    
    static String stName = new String("");
    static String stWeaponEnhancement = new String("");
    static String stCritical = new String("");
    static String stBaseDiceDamage = new String("");
    static String stBonusDiceDamage = new String("");
    static String stBonusDiceDamage2 = new String("");
    static String stAttackBasedOn = new String("");
    static String stDamageBasedOn = new String("");
    static String stIterativeAttacks = new String("");
    static String stTWF = new String("");
    static String stCustomAttackBonus = new String("");
    static String stCustomDamageBonus = new String("");
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifyattack);
        Toolbar main_toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(main_toolbar);

        // getting intent extras
        Intent intentFromSetAttacks = getIntent();
        staticModifyAttackBuildName = intentFromSetAttacks.getStringExtra("loadedBuild");
        staticModifyAttackOldName = intentFromSetAttacks.getStringExtra("loadedAttack");
        modAttPos = intentFromSetAttacks.getIntExtra("pos",-1);
        
        EditText attackView = (EditText) findViewById(R.id.modifyattackName);
        
        Spinner baseDamageSpinner = (Spinner) findViewById(R.id.modifyattackBaseDamageSpinner);       
        ArrayAdapter<CharSequence> baseDamageAdapter = ArrayAdapter.createFromResource
        (this, R.array.basedamage, android.R.layout.simple_spinner_item);
        baseDamageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        baseDamageSpinner.setAdapter(baseDamageAdapter);

        Spinner weaponEnhancementSpinner = (Spinner) findViewById(R.id.modifyattackWeaponEnhancementSpinner);       
        ArrayAdapter<CharSequence> weaponEnhancementAdapter = ArrayAdapter.createFromResource
        (this, R.array.weaponenhancement, android.R.layout.simple_spinner_item);
        weaponEnhancementAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weaponEnhancementSpinner.setAdapter(weaponEnhancementAdapter);
        
        
        Spinner criticalSpinner = (Spinner) findViewById(R.id.modifyattackCriticalSpinner);       
        ArrayAdapter<CharSequence> criticalAdapter = ArrayAdapter.createFromResource
        (this, R.array.critical, android.R.layout.simple_spinner_item);
        criticalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        criticalSpinner.setAdapter(criticalAdapter);


        Spinner bonusDiceDamageSpinner = (Spinner) findViewById(R.id.modifyattackBonusDiceSpinner);       
        ArrayAdapter<CharSequence> bonusDiceDamageAdapter = ArrayAdapter.createFromResource
        (this, R.array.bonusdicedamage, android.R.layout.simple_spinner_item);
        bonusDiceDamageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bonusDiceDamageSpinner.setAdapter(bonusDiceDamageAdapter);

        Spinner bonusDiceDamageSpinner2 = (Spinner) findViewById(R.id.modifyattackBonusDiceSpinner2);       
        ArrayAdapter<CharSequence> bonusDiceDamageAdapter2 = ArrayAdapter.createFromResource
        (this, R.array.bonusdicedamage, android.R.layout.simple_spinner_item);
        bonusDiceDamageAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bonusDiceDamageSpinner2.setAdapter(bonusDiceDamageAdapter2);

        Spinner attackBasedOnSpinner = (Spinner) findViewById(R.id.modifyattackAttackBasedOnSpinner);       
        ArrayAdapter<CharSequence> attackBasedOnAdapter = ArrayAdapter.createFromResource
        (this, R.array.attacktype, android.R.layout.simple_spinner_item);
        attackBasedOnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attackBasedOnSpinner.setAdapter(attackBasedOnAdapter);

        Spinner damageBasedOnSpinner = (Spinner) findViewById(R.id.modifyattackDamageBasedOnSpinner);       
        ArrayAdapter<CharSequence> damageBasedOnAdapter = ArrayAdapter.createFromResource
        (this, R.array.damagetype, android.R.layout.simple_spinner_item);
        damageBasedOnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        damageBasedOnSpinner.setAdapter(damageBasedOnAdapter);

        Spinner iterativeAttacksSpinner = (Spinner) findViewById(R.id.modifyattackIterativeAttacksSpinner);       
        ArrayAdapter<CharSequence> iterativeAttacksAdapter = ArrayAdapter.createFromResource
        (this, R.array.iterativeattacks, android.R.layout.simple_spinner_item);
        iterativeAttacksAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        iterativeAttacksSpinner.setAdapter(iterativeAttacksAdapter);

        Spinner TWFSpinner = (Spinner) findViewById(R.id.modifyattackTWFSpinner);       
        ArrayAdapter<CharSequence> TWFAdapter = ArrayAdapter.createFromResource
        (this, R.array.twoweaponfighting, android.R.layout.simple_spinner_item);
        TWFAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TWFSpinner.setAdapter(TWFAdapter);       

        Spinner customAttackBonusSpinner = (Spinner) findViewById(R.id.modifyattackCustomAttackBonusSpinner);       
        ArrayAdapter<CharSequence> customAttackBonusAdapter = ArrayAdapter.createFromResource
        (this, R.array.numbers15, android.R.layout.simple_spinner_item);
        customAttackBonusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customAttackBonusSpinner.setAdapter(customAttackBonusAdapter);

        Spinner customDamageBonusSpinner = (Spinner) findViewById(R.id.modifyattackCustomDamageBonusSpinner);       
        ArrayAdapter<CharSequence> customDamageBonusAdapter = ArrayAdapter.createFromResource
        (this, R.array.numbers15, android.R.layout.simple_spinner_item);
        customDamageBonusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customDamageBonusSpinner.setAdapter(customDamageBonusAdapter);

        readAttackXmlFile(this);
        
        if (stName != null) {
            attackView.setText(stName);
        }    
        if (stBaseDiceDamage != null) {
            int namePos = baseDamageAdapter.getPosition(stBaseDiceDamage);
            baseDamageSpinner.setSelection(namePos);
        }
        if (stWeaponEnhancement != null) {
            int namePos = weaponEnhancementAdapter.getPosition(stWeaponEnhancement);
            weaponEnhancementSpinner.setSelection(namePos);
        }
        if (stCritical != null) {
            int criticalPos = criticalAdapter.getPosition(stCritical);
            criticalSpinner.setSelection(criticalPos);
        }
        if (stBonusDiceDamage != null) {
            int bonusDicePos = bonusDiceDamageAdapter.getPosition(stBonusDiceDamage);
            bonusDiceDamageSpinner.setSelection(bonusDicePos);
        }
        if (stBonusDiceDamage2 != null) {
            int bonusDice2Pos = bonusDiceDamageAdapter2.getPosition(stBonusDiceDamage2);
            bonusDiceDamageSpinner2.setSelection(bonusDice2Pos);
        }
        if (stAttackBasedOn != null) {
            int attBasedOnPos = attackBasedOnAdapter.getPosition(stAttackBasedOn);
            attackBasedOnSpinner.setSelection(attBasedOnPos);
        }
        if (stDamageBasedOn != null) {
            int damageBasedOnPos = damageBasedOnAdapter.getPosition(stDamageBasedOn);
            damageBasedOnSpinner.setSelection(damageBasedOnPos);
        }
        if (stTWF != null) {
            int TWFPos = TWFAdapter.getPosition(stTWF);
            TWFSpinner.setSelection(TWFPos);
        }
        if (stIterativeAttacks != null) {
            int iterativeAttacksPos = iterativeAttacksAdapter.getPosition(stIterativeAttacks);
            iterativeAttacksSpinner.setSelection(iterativeAttacksPos);
        }
        if (stCustomAttackBonus != null) {
            int customAttackBonusPos = customAttackBonusAdapter.getPosition(stCustomAttackBonus);
            customAttackBonusSpinner.setSelection(customAttackBonusPos);
        }
        if (stCustomDamageBonus != null) {
            int customDamageBonusPos = customDamageBonusAdapter.getPosition(stCustomDamageBonus);
            customDamageBonusSpinner.setSelection(customDamageBonusPos);
        }
        
        
    }

    public void onModifyAttackButtonClick(View view)
    {   
        EditText attackView = (EditText) findViewById(R.id.modifyattackName);

        if( !attackView.getText().toString().equals("") && attackView.getText().toString().length() > 0 )
        {

            Spinner baseDamageSpinner = (Spinner) findViewById(R.id.modifyattackBaseDamageSpinner);
            Spinner weaponEnhancementSpinner = (Spinner) findViewById(R.id.modifyattackWeaponEnhancementSpinner);
            Spinner criticalSpinner = (Spinner) findViewById(R.id.modifyattackCriticalSpinner);                  
            Spinner bonusDiceDamageSpinner = (Spinner) findViewById(R.id.modifyattackBonusDiceSpinner);                   
            Spinner bonusDiceDamageSpinner2 = (Spinner) findViewById(R.id.modifyattackBonusDiceSpinner2);                  
            Spinner attackBasedOnSpinner = (Spinner) findViewById(R.id.modifyattackAttackBasedOnSpinner);                 
            Spinner damageBasedOnSpinner = (Spinner) findViewById(R.id.modifyattackDamageBasedOnSpinner);                
            Spinner iterativeAttacksSpinner = (Spinner) findViewById(R.id.modifyattackIterativeAttacksSpinner);                   
            Spinner TWFSpinner = (Spinner) findViewById(R.id.modifyattackTWFSpinner);                   
            Spinner customAttackBonusSpinner = (Spinner) findViewById(R.id.modifyattackCustomAttackBonusSpinner);                   
            Spinner customDamageBonusSpinner = (Spinner) findViewById(R.id.modifyattackCustomDamageBonusSpinner);       

            String name = new String(attackView.getText().toString());
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

            modifyAttack (this, name, modAttPos, baseDamage, weaponEnhancement,
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

    
    public void onDeleteAttackButtonClick(View view)
    {   
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Add the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id)
                {
                    // User clicked OK button
                    deleteAttack(ModifyAttackActivity.this);
                    dialog.dismiss();               
                    finish();
                    
                }
            });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id)
                {
                    // User cancelled the dialog
                    dialog.dismiss();
                }
            });
        // Set other dialog properties
        builder.setMessage("Are you sure you want to delete this attack?");

        // Create the AlertDialog
        builder.show();
            
            

        
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

    public void modifyAttack (Context ctx,
                              String newName, int pos, String baseDamage, String weaponEnhancement,
                              String critical, String bonusDiceDamage,
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

                for (int temp = 0; temp < nList.getLength(); temp++)
                {

                    Node nNode = nList.item(temp);          


                    if (nNode.getNodeType() == Node.ELEMENT_NODE)
                    {

                        Element eElement = (Element) nNode;
                        
                        String buildId = new String(eElement.getAttribute("id"));
                        if (buildId.equals(staticModifyAttackBuildName))
                        {
                            //build already exists, just add attack
                            NodeList nAttacks = eElement.getElementsByTagName("attack");
                            
                            
                            for (int j = 0; j < nAttacks.getLength(); j++)
                            {
                                Node nAttack = nAttacks.item(j);
                                if (nAttack.getNodeType() == Node.ELEMENT_NODE)
                                {
                                    Element eAttack = (Element) nAttack;
                                    if ((eAttack.getElementsByTagName("name").item(0).getTextContent()).equals(staticModifyAttackOldName)
                                        && Integer.parseInt(eAttack.getAttribute("attackid")) == pos)
                                    {
                                        
                                        eAttack.getElementsByTagName("name").item(0).setTextContent(newName);
                                        eAttack.getElementsByTagName("basedicedamage").item(0).setTextContent(baseDamage);
                                        eAttack.getElementsByTagName("weaponenhancement").item(0).setTextContent(weaponEnhancement);
                                        eAttack.getElementsByTagName("critical").item(0).setTextContent(critical);
                                        eAttack.getElementsByTagName("bonusdicedamage").item(0).setTextContent(bonusDiceDamage);
                                        eAttack.getElementsByTagName("bonusdicedamage2").item(0).setTextContent(bonusDiceDamage2);
                                        
                                        
                                        eAttack.getElementsByTagName("attackbasedon").item(0).setTextContent(attackBasedOn);
                                        eAttack.getElementsByTagName("damagebasedon").item(0).setTextContent(damageBasedOn);
                                        eAttack.getElementsByTagName("iterativeattacks").item(0).setTextContent(iterativeAttacks);
                                        eAttack.getElementsByTagName("twf").item(0).setTextContent(TWF);
                                        eAttack.getElementsByTagName("customattackbonus").item(0).setTextContent(Integer.toString(customAttackBonusInt));
                                        eAttack.getElementsByTagName("customdamagebonus").item(0).setTextContent(Integer.toString(customDamageBonusInt));
                                        
                                    }
                                }
                            }
                  
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

                }
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
    
    
    
    public void deleteAttack (Context ctx)                             
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

                for (int temp = 0; temp < nList.getLength(); temp++)
                {

                    Node nNode = nList.item(temp);          


                    if (nNode.getNodeType() == Node.ELEMENT_NODE)
                    {

                        Element eElement = (Element) nNode;

                        String buildId = new String(eElement.getAttribute("id"));
                        if (buildId.equals(staticModifyAttackBuildName))
                        {
                            //build already exists, just add attack
                            NodeList nAttacks = eElement.getElementsByTagName("attack");

                            boolean found = false;
                            for (int j = 0; j < nAttacks.getLength(); j++)
                            {
                                Node nAttack = nAttacks.item(j);
                                if (nAttack.getNodeType() == Node.ELEMENT_NODE)
                                {   
                                    Element eAttack = (Element) nAttack;
                                    if (found == true)
                                    {
                                        eAttack.setAttribute("attackid", Integer.toString(j-1));
                                    }
                                    if ((eAttack.getElementsByTagName("name").item(0).getTextContent()).equals(staticModifyAttackOldName)
                                        && Integer.parseInt(eAttack.getAttribute("attackid")) == modAttPos
                                        && found == false)
                                    {
                                        eElement.removeChild(nAttack); 
                                        found = true;
                                    }
                                    
                                }
                            }

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

                }
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
    
    
    
    
    void readAttackXmlFile(Context ctx)
    {
        try
        {
            File attackdb = new File(getFilesDir() + "/attacks_db.xml");
            if (attackdb.exists())
            {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(attackdb);

                Element rootElement = doc.getDocumentElement();

                NodeList nList = doc.getElementsByTagName("build");

                for (int temp = 0; temp < nList.getLength(); temp++)
                {

                    Node nNode = nList.item(temp);          


                    if (nNode.getNodeType() == Node.ELEMENT_NODE)
                    {

                        Element eElement = (Element) nNode;
                            
                        String buildId = new String(eElement.getAttribute("id"));
                        if (buildId.equals(staticModifyAttackBuildName))
                        {
                            //build already exists, just add attack
                            NodeList nAttacks = eElement.getElementsByTagName("attack");


                            for (int j = 0; j < nAttacks.getLength(); j++)
                            {
                                Node nAttack = nAttacks.item(j);
                                if (nAttack.getNodeType() == Node.ELEMENT_NODE)
                                {
                                    Element eAttack = (Element) nAttack;
                                    if ((eAttack.getElementsByTagName("name").item(0).getTextContent()).equals(staticModifyAttackOldName)
                                        && Integer.parseInt(eAttack.getAttribute("attackid")) == modAttPos)
                                    {
                                        
                                        stName = eAttack.getElementsByTagName("name").item(0).getTextContent();
                                        stBaseDiceDamage = eAttack.getElementsByTagName("basedicedamage").item(0).getTextContent();
                                        stWeaponEnhancement = eAttack.getElementsByTagName("weaponenhancement").item(0).getTextContent();   
                                        stCritical = eAttack.getElementsByTagName("critical").item(0).getTextContent();
                                        stBonusDiceDamage = eAttack.getElementsByTagName("bonusdicedamage").item(0).getTextContent();
                                        stBonusDiceDamage2 = eAttack.getElementsByTagName("bonusdicedamage2").item(0).getTextContent();
                                        
                                        
                                        stAttackBasedOn = eAttack.getElementsByTagName("attackbasedon").item(0).getTextContent();
                                        stDamageBasedOn = eAttack.getElementsByTagName("damagebasedon").item(0).getTextContent();
                                        stIterativeAttacks = eAttack.getElementsByTagName("iterativeattacks").item(0).getTextContent();
                                        stTWF = eAttack.getElementsByTagName("twf").item(0).getTextContent();
                                        stCustomAttackBonus = eAttack.getElementsByTagName("customattackbonus").item(0).getTextContent();
                                        stCustomDamageBonus = eAttack.getElementsByTagName("customdamagebonus").item(0).getTextContent();
                                        
                                    }
                                }
                            }

                            
                        } 

                    }

                }
            }


        }
        catch (ParserConfigurationException pce)
        {
            pce.printStackTrace();
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
