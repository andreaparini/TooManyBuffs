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

public class NewBuildActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbuild);
        Toolbar main_toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(main_toolbar);
        
        
        
    }
    
    public void onCreateBuildButtonClick(View view)
    {   
        EditText nameView = (EditText) findViewById(R.id.newbuildName);
        EditText classView = (EditText) findViewById(R.id.newbuildClass);
        EditText levelView = (EditText) findViewById(R.id.newbuildLevel);
        EditText strView = (EditText) findViewById(R.id.newbuildStrength);
        EditText dexView = (EditText) findViewById(R.id.newbuildDexterity);
        EditText conView = (EditText) findViewById(R.id.newbuildConstitution);
        EditText babView = (EditText) findViewById(R.id.newbuildBab);
        EditText hpView = (EditText) findViewById(R.id.newbuildBaseHP);
        
        if( !nameView.getText().toString().equals("") && nameView.getText().toString().length() > 0 &&   
            !classView.getText().toString().equals("") && classView.getText().toString().length() > 0 &&
            !levelView.getText().toString().equals("") && levelView.getText().toString().length() > 0 &&
            !strView.getText().toString().equals("") && strView.getText().toString().length() > 0 &&
            !dexView.getText().toString().equals("") && dexView.getText().toString().length() > 0 &&
            !conView.getText().toString().equals("") && conView.getText().toString().length() > 0 &&
            !babView.getText().toString().equals("") && babView.getText().toString().length() > 0 &&
            !hpView.getText().toString().equals("") && hpView.getText().toString().length() > 0)
        {
            String name = new String(nameView.getText().toString());
            String playClass = new String(classView.getText().toString());
            String levelString = new String(levelView.getText().toString());
            String strString = new String(strView.getText().toString());
            String dexString = new String(dexView.getText().toString());
            String conString = new String(conView.getText().toString());
            String babString = new String(babView.getText().toString());
            String baseHpString = new String(hpView.getText().toString());
            int level = Integer.parseInt(levelString);
            int str = Integer.parseInt(strString);
            int dex = Integer.parseInt(dexString);
            int con = Integer.parseInt(conString);
            int bab = Integer.parseInt(babString);
            int baseHp = Integer.parseInt(baseHpString);

            name = name.trim();
            playClass = playClass.trim();
            levelString = levelString.trim();
            strString = strString.trim();
            dexString = dexString.trim();
            conString = conString.trim();
            babString = babString.trim();
            baseHpString = baseHpString.trim();
            
            if (!buildExistsXmlFile(this, name))
            {
                addNewBuild(this, name, playClass, level, str, dex , con, bab, baseHp);
                Intent intent = new Intent(this, CustomizationActivity.class);
                intent.putExtra("loadedBuild", name);
                startActivity(intent);
            } else {
                Toast.makeText(this, 
                               "A build with this name already exists. Please use another name", 
                               Toast.LENGTH_LONG).show();
            }
            

            
        } else {
            Toast.makeText(this, 
                           "One or more fields are empty", 
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
                Intent intent = new Intent(this, HelpActivity.class);
                intent.putExtra("from","newBuildActivity");
                startActivity(intent);
                return true;

            
        }
        return super.onOptionsItemSelected(item);
    }
    



    public void addNewBuild (Context ctx, String name, String playClass,
                             int level, int str, int dex, int con, 
                             int bab, int baseHp)
    {

        try
        {         
            File xmldb = new File(getFilesDir()+"/build_db.xml");
            if(xmldb.exists())
            {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(xmldb);

                // Get the root element
                
                Element root = doc.getDocumentElement();
                Element rootElement = doc.getDocumentElement();
                
                Element newBuild = doc.createElement("build");
                rootElement.appendChild(newBuild);

                Element newName = doc.createElement("name");
                newName.appendChild(doc.createTextNode(name));
                Element newClass = doc.createElement("playableclass");
                newClass.appendChild(doc.createTextNode(playClass));
                Element newLevel = doc.createElement("level");
                newLevel.appendChild(doc.createTextNode(Integer.toString(level)));
                Element newBab = doc.createElement("bab");
                newBab.appendChild(doc.createTextNode(Integer.toString(bab)));
                Element newBaseHp = doc.createElement("basehp");
                newBaseHp.appendChild(doc.createTextNode(Integer.toString(baseHp)));
                Element newStr = doc.createElement("str");
                newStr.appendChild(doc.createTextNode(Integer.toString(str)));
                Element newDex = doc.createElement("dex");
                newDex.appendChild(doc.createTextNode(Integer.toString(dex)));
                Element newCon = doc.createElement("con");
                newCon.appendChild(doc.createTextNode(Integer.toString(con)));



                Element newStrEnhancement = doc.createElement("strenhancement");
                newStrEnhancement.appendChild(doc.createTextNode("0"));
                Element newStrMorale = doc.createElement("strmorale");
                newStrMorale.appendChild(doc.createTextNode("0"));
                Element newStrSize = doc.createElement("strsize");
                newStrSize.appendChild(doc.createTextNode("0"));
                Element newStrAlchemical = doc.createElement("stralchemical");
                newStrAlchemical.appendChild(doc.createTextNode("0"));
                Element newStrInherent = doc.createElement("strinherent");
                newStrInherent.appendChild(doc.createTextNode("0"));
                Element newStrOther = doc.createElement("strother");
                newStrOther.appendChild(doc.createTextNode("0"));

                Element newDexEnhancement = doc.createElement("dexenhancement");
                newDexEnhancement.appendChild(doc.createTextNode("0"));
                Element newDexMorale = doc.createElement("dexmorale");
                newDexMorale.appendChild(doc.createTextNode("0"));
                Element newDexSize = doc.createElement("dexsize");
                newDexSize.appendChild(doc.createTextNode("0"));
                Element newDexAlchemical = doc.createElement("dexalchemical");
                newDexAlchemical.appendChild(doc.createTextNode("0"));
                Element newDexInherent = doc.createElement("dexinherent");
                newDexInherent.appendChild(doc.createTextNode("0"));
                Element newDexOther = doc.createElement("dexother");
                newDexOther.appendChild(doc.createTextNode("0"));

                Element newConEnhancement = doc.createElement("conenhancement");
                newConEnhancement.appendChild(doc.createTextNode("0"));
                Element newConMorale = doc.createElement("conmorale");
                newConMorale.appendChild(doc.createTextNode("0"));
                Element newConSize = doc.createElement("consize");
                newConSize.appendChild(doc.createTextNode("0"));
                Element newConAlchemical = doc.createElement("conalchemical");
                newConAlchemical.appendChild(doc.createTextNode("0"));
                Element newConInherent = doc.createElement("coninherent");
                newConInherent.appendChild(doc.createTextNode("0"));
                Element newConOther = doc.createElement("conother");
                newConOther.appendChild(doc.createTextNode("0"));

                Element newToHitMorale = doc.createElement("tohitmorale");
                newToHitMorale.appendChild(doc.createTextNode("0"));
                Element newToHitLuck = doc.createElement("tohitluck");
                newToHitLuck.appendChild(doc.createTextNode("0"));
                Element newToHitSacred = doc.createElement("tohitsacred");
                newToHitSacred.appendChild(doc.createTextNode("0"));
                Element newToHitSize = doc.createElement("tohitsize");
                newToHitSize.appendChild(doc.createTextNode("0")); 
                Element newToHitUntyped = doc.createElement("tohituntyped");
                newToHitUntyped.appendChild(doc.createTextNode("0"));
                Element newToHitOther = doc.createElement("tohitother");
                newToHitOther.appendChild(doc.createTextNode("0")); 

                Element newDmgMorale = doc.createElement("dmgmorale");
                newDmgMorale.appendChild(doc.createTextNode("0"));
                Element newDmgLuck = doc.createElement("dmgluck");
                newDmgLuck.appendChild(doc.createTextNode("0"));
                Element newDmgSacred = doc.createElement("dmgsacred");
                newDmgSacred.appendChild(doc.createTextNode("0"));
                Element newDmgUntyped = doc.createElement("dmguntyped");
                newDmgUntyped.appendChild(doc.createTextNode("0"));
                Element newDmgOther = doc.createElement("dmgother");
                newDmgOther.appendChild(doc.createTextNode("0")); 

                Element newAcArmor = doc.createElement("acarmor");
                newAcArmor.appendChild(doc.createTextNode("0"));
                Element newAcNatural = doc.createElement("acnatural");
                newAcNatural.appendChild(doc.createTextNode("0"));
                Element newAcNaturalEnhancement = doc.createElement("acnaturalenhancement");
                newAcNaturalEnhancement.appendChild(doc.createTextNode("0"));
                Element newAcSacred = doc.createElement("acsacred");
                newAcSacred.appendChild(doc.createTextNode("0"));
                Element newAcShield = doc.createElement("acshield");
                newAcShield.appendChild(doc.createTextNode("0"));
                Element newAcDeflection = doc.createElement("acdeflection");
                newAcDeflection.appendChild(doc.createTextNode("0"));
                Element newAcUntyped = doc.createElement("acuntyped");
                newAcUntyped.appendChild(doc.createTextNode("0"));
                Element newAcSize = doc.createElement("acsize");
                newAcSize.appendChild(doc.createTextNode("0"));
                Element newAcOther = doc.createElement("acother");
                newAcOther.appendChild(doc.createTextNode("0")); 
                Element newAcDexMax = doc.createElement("acdexmax");
                newAcDexMax.appendChild(doc.createTextNode("-1")); 
                


                newBuild.appendChild(newName);
                newBuild.appendChild(newClass);
                newBuild.appendChild(newLevel);
                newBuild.appendChild(newBab);
                newBuild.appendChild(newBaseHp);
                newBuild.appendChild(newStr);
                newBuild.appendChild(newDex);
                newBuild.appendChild(newCon);

                newBuild.appendChild(newStrEnhancement);
                newBuild.appendChild(newStrMorale);
                newBuild.appendChild(newStrSize);
                newBuild.appendChild(newStrAlchemical);
                newBuild.appendChild(newStrInherent);
                newBuild.appendChild(newStrOther);

                newBuild.appendChild(newDexEnhancement);
                newBuild.appendChild(newDexMorale);
                newBuild.appendChild(newDexSize);
                newBuild.appendChild(newDexAlchemical);
                newBuild.appendChild(newDexInherent);
                newBuild.appendChild(newDexOther);

                newBuild.appendChild(newConEnhancement);
                newBuild.appendChild(newConMorale);
                newBuild.appendChild(newConSize);
                newBuild.appendChild(newConAlchemical);
                newBuild.appendChild(newConInherent);
                newBuild.appendChild(newConOther);

                newBuild.appendChild(newToHitMorale);
                newBuild.appendChild(newToHitLuck);
                newBuild.appendChild(newToHitSacred);             
                newBuild.appendChild(newToHitSize);
                newBuild.appendChild(newToHitUntyped);
                newBuild.appendChild(newToHitOther);

                newBuild.appendChild(newDmgMorale);
                newBuild.appendChild(newDmgLuck);
                newBuild.appendChild(newDmgSacred);            
                newBuild.appendChild(newDmgUntyped);
                newBuild.appendChild(newDmgOther);


                newBuild.appendChild(newAcArmor);
                newBuild.appendChild(newAcNatural);
                newBuild.appendChild(newAcNaturalEnhancement);
                newBuild.appendChild(newAcSacred);
                newBuild.appendChild(newAcShield);
                newBuild.appendChild(newAcDeflection);
                newBuild.appendChild(newAcUntyped);
                newBuild.appendChild(newAcSize);
                newBuild.appendChild(newAcOther);
                newBuild.appendChild(newAcDexMax);
                
                

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(xmldb);
                transformer.transform(source, result);
            }
            else
            {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                // root elements
                Document doc = docBuilder.newDocument();
                
                Element rootElement = doc.createElement("database");
                doc.appendChild(rootElement);

                
                Element newBuild = doc.createElement("build");
                rootElement.appendChild(newBuild);
                
                Element newName = doc.createElement("name");
                newName.appendChild(doc.createTextNode(name));
                Element newClass = doc.createElement("playableclass");
                newClass.appendChild(doc.createTextNode(playClass));
                Element newLevel = doc.createElement("level");
                newLevel.appendChild(doc.createTextNode(Integer.toString(level)));
                Element newBab = doc.createElement("bab");
                newBab.appendChild(doc.createTextNode(Integer.toString(bab)));
                Element newBaseHp = doc.createElement("basehp");
                newBaseHp.appendChild(doc.createTextNode(Integer.toString(baseHp)));
                Element newStr = doc.createElement("str");
                newStr.appendChild(doc.createTextNode(Integer.toString(str)));
                Element newDex = doc.createElement("dex");
                newDex.appendChild(doc.createTextNode(Integer.toString(dex)));
                Element newCon = doc.createElement("con");
                newCon.appendChild(doc.createTextNode(Integer.toString(con)));



                Element newStrEnhancement = doc.createElement("strenhancement");
                newStrEnhancement.appendChild(doc.createTextNode("0"));
                Element newStrMorale = doc.createElement("strmorale");
                newStrMorale.appendChild(doc.createTextNode("0"));
                Element newStrSize = doc.createElement("strsize");
                newStrSize.appendChild(doc.createTextNode("0"));
                Element newStrAlchemical = doc.createElement("stralchemical");
                newStrAlchemical.appendChild(doc.createTextNode("0"));
                Element newStrInherent = doc.createElement("strinherent");
                newStrInherent.appendChild(doc.createTextNode("0"));
                Element newStrOther = doc.createElement("strother");
                newStrOther.appendChild(doc.createTextNode("0"));

                Element newDexEnhancement = doc.createElement("dexenhancement");
                newDexEnhancement.appendChild(doc.createTextNode("0"));
                Element newDexMorale = doc.createElement("dexmorale");
                newDexMorale.appendChild(doc.createTextNode("0"));
                Element newDexSize = doc.createElement("dexsize");
                newDexSize.appendChild(doc.createTextNode("0"));
                Element newDexAlchemical = doc.createElement("dexalchemical");
                newDexAlchemical.appendChild(doc.createTextNode("0"));
                Element newDexInherent = doc.createElement("dexinherent");
                newDexInherent.appendChild(doc.createTextNode("0"));
                Element newDexOther = doc.createElement("dexother");
                newDexOther.appendChild(doc.createTextNode("0"));

                Element newConEnhancement = doc.createElement("conenhancement");
                newConEnhancement.appendChild(doc.createTextNode("0"));
                Element newConMorale = doc.createElement("conmorale");
                newConMorale.appendChild(doc.createTextNode("0"));
                Element newConSize = doc.createElement("consize");
                newConSize.appendChild(doc.createTextNode("0"));
                Element newConAlchemical = doc.createElement("conalchemical");
                newConAlchemical.appendChild(doc.createTextNode("0"));
                Element newConInherent = doc.createElement("coninherent");
                newConInherent.appendChild(doc.createTextNode("0"));
                Element newConOther = doc.createElement("conother");
                newConOther.appendChild(doc.createTextNode("0"));

                Element newToHitMorale = doc.createElement("tohitmorale");
                newToHitMorale.appendChild(doc.createTextNode("0"));
                Element newToHitLuck = doc.createElement("tohitluck");
                newToHitLuck.appendChild(doc.createTextNode("0"));
                Element newToHitSacred = doc.createElement("tohitsacred");
                newToHitSacred.appendChild(doc.createTextNode("0"));            
                Element newToHitSize = doc.createElement("tohitsize");
                newToHitSize.appendChild(doc.createTextNode("0"));
                Element newToHitUntyped = doc.createElement("tohituntyped");
                newToHitUntyped.appendChild(doc.createTextNode("0"));
                Element newToHitOther = doc.createElement("tohitother");
                newToHitOther.appendChild(doc.createTextNode("0")); 

                Element newDmgMorale = doc.createElement("dmgmorale");
                newDmgMorale.appendChild(doc.createTextNode("0"));
                Element newDmgLuck = doc.createElement("dmgluck");
                newDmgLuck.appendChild(doc.createTextNode("0"));
                Element newDmgSacred = doc.createElement("dmgsacred");
                newDmgSacred.appendChild(doc.createTextNode("0"));
                Element newDmgUntyped = doc.createElement("dmguntyped");
                newDmgUntyped.appendChild(doc.createTextNode("0"));
                Element newDmgOther = doc.createElement("dmgother");
                newDmgOther.appendChild(doc.createTextNode("0")); 

                Element newAcArmor = doc.createElement("acarmor");
                newAcArmor.appendChild(doc.createTextNode("0"));
                Element newAcNatural = doc.createElement("acnatural");
                newAcNatural.appendChild(doc.createTextNode("0"));
                Element newAcNaturalEnhancement = doc.createElement("acnaturalenhancement");
                newAcNaturalEnhancement.appendChild(doc.createTextNode("0"));
                Element newAcSacred = doc.createElement("acsacred");
                newAcSacred.appendChild(doc.createTextNode("0"));
                Element newAcShield = doc.createElement("acshield");
                newAcShield.appendChild(doc.createTextNode("0"));
                Element newAcDeflection = doc.createElement("acdeflection");
                newAcDeflection.appendChild(doc.createTextNode("0"));
                Element newAcUntyped = doc.createElement("acuntyped");
                newAcUntyped.appendChild(doc.createTextNode("0"));
                Element newAcSize = doc.createElement("acsize");
                newAcSize.appendChild(doc.createTextNode("0"));
                Element newAcOther = doc.createElement("acother");
                newAcOther.appendChild(doc.createTextNode("0")); 
                Element newAcDexMax = doc.createElement("acdexmax");
                newAcDexMax.appendChild(doc.createTextNode("-1")); 


                newBuild.appendChild(newName);
                newBuild.appendChild(newClass);
                newBuild.appendChild(newLevel);
                newBuild.appendChild(newBab);
                newBuild.appendChild(newBaseHp);
                newBuild.appendChild(newStr);
                newBuild.appendChild(newDex);
                newBuild.appendChild(newCon);

                newBuild.appendChild(newStrEnhancement);
                newBuild.appendChild(newStrMorale);
                newBuild.appendChild(newStrSize);
                newBuild.appendChild(newStrAlchemical);
                newBuild.appendChild(newStrInherent);
                newBuild.appendChild(newStrOther);

                newBuild.appendChild(newDexEnhancement);
                newBuild.appendChild(newDexMorale);
                newBuild.appendChild(newDexSize);
                newBuild.appendChild(newDexAlchemical);
                newBuild.appendChild(newDexInherent);
                newBuild.appendChild(newDexOther);

                newBuild.appendChild(newConEnhancement);
                newBuild.appendChild(newConMorale);
                newBuild.appendChild(newConSize);
                newBuild.appendChild(newConAlchemical);
                newBuild.appendChild(newConInherent);
                newBuild.appendChild(newConOther);

                newBuild.appendChild(newToHitMorale);
                newBuild.appendChild(newToHitLuck);
                newBuild.appendChild(newToHitSacred);
                newBuild.appendChild(newToHitSize);
                newBuild.appendChild(newToHitUntyped);
                newBuild.appendChild(newToHitOther);

                newBuild.appendChild(newDmgMorale);
                newBuild.appendChild(newDmgLuck);
                newBuild.appendChild(newDmgSacred);
                newBuild.appendChild(newDmgUntyped);
                newBuild.appendChild(newDmgOther);


                newBuild.appendChild(newAcArmor);
                newBuild.appendChild(newAcNatural);
                newBuild.appendChild(newAcNaturalEnhancement);
                newBuild.appendChild(newAcSacred);
                newBuild.appendChild(newAcShield);
                newBuild.appendChild(newAcDeflection);
                newBuild.appendChild(newAcUntyped);
                newBuild.appendChild(newAcSize);
                newBuild.appendChild(newAcOther);          
                newBuild.appendChild(newAcDexMax);
                

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(getFilesDir()+"/build_db.xml"));

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
    
    
    public boolean buildExistsXmlFile (Context ctx, String buildName)
    {
        boolean found = false;
       
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
                    
                    
                    if ((eElement.getElementsByTagName("name").item(0).getTextContent()).equals(buildName))
                    {                       
                        found = true;                      
                    }    // end if name = passed name                                              
                }   // end if node is a element
            }  // end for
                                                
        }  // end try
        catch (Exception e)
        {
            e.printStackTrace();
            
        }
        return found;
    }
    
    
    
    
}
