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

public class ChangeInfoActivity extends AppCompatActivity
{
    static String staticOldBuildName = new String("");
    Build useless = new Build();
    static Build staticBuildChangeInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeinfo);
        Toolbar main_toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(main_toolbar);
        
        Intent intentFromCustomization = getIntent();
        staticOldBuildName = intentFromCustomization.getStringExtra("oldBuildName");
        staticBuildChangeInfo = useless.readBuildXmlFile(this, staticOldBuildName);
        EditText nameView = (EditText) findViewById(R.id.updatebuildName);
        EditText classView = (EditText) findViewById(R.id.updatebuildClass);
        EditText levelView = (EditText) findViewById(R.id.updatebuildLevel);
        EditText strView = (EditText) findViewById(R.id.updatebuildStrength);
        EditText dexView = (EditText) findViewById(R.id.updatebuildDexterity);
        EditText conView = (EditText) findViewById(R.id.updatebuildConstitution);
        EditText intlView = (EditText) findViewById(R.id.updatebuildIntelligence);
        EditText wisView = (EditText) findViewById(R.id.updatebuildWisdom);
        EditText chaView = (EditText) findViewById(R.id.updatebuildCharisma);
        EditText babView = (EditText) findViewById(R.id.updatebuildBab);
        EditText hpView = (EditText) findViewById(R.id.updatebuildBaseHP);
        
        nameView.setText(staticBuildChangeInfo.name);
        classView.setText(staticBuildChangeInfo.playableClass);
        levelView.setText(Integer.toString(staticBuildChangeInfo.level));
        strView.setText(Integer.toString(staticBuildChangeInfo.str));
        dexView.setText(Integer.toString(staticBuildChangeInfo.dex));
        conView.setText(Integer.toString(staticBuildChangeInfo.con));
        intlView.setText(Integer.toString(staticBuildChangeInfo.intl));
        wisView.setText(Integer.toString(staticBuildChangeInfo.wis));
        chaView.setText(Integer.toString(staticBuildChangeInfo.cha));
        babView.setText(Integer.toString(staticBuildChangeInfo.bab));
        hpView.setText(Integer.toString(staticBuildChangeInfo.baseHP));
        
    }

    public void onUpdateBuildButtonClick(View view)
    {   
        EditText nameView = (EditText) findViewById(R.id.updatebuildName);
        EditText classView = (EditText) findViewById(R.id.updatebuildClass);
        EditText levelView = (EditText) findViewById(R.id.updatebuildLevel);
        EditText strView = (EditText) findViewById(R.id.updatebuildStrength);
        EditText dexView = (EditText) findViewById(R.id.updatebuildDexterity);
        EditText conView = (EditText) findViewById(R.id.updatebuildConstitution);
        EditText intlView = (EditText) findViewById(R.id.updatebuildIntelligence);
        EditText wisView = (EditText) findViewById(R.id.updatebuildWisdom);
        EditText chaView = (EditText) findViewById(R.id.updatebuildCharisma);
        EditText babView = (EditText) findViewById(R.id.updatebuildBab);
        EditText hpView = (EditText) findViewById(R.id.updatebuildBaseHP);

        if( !nameView.getText().toString().equals("") && nameView.getText().toString().length() > 0 &&
                !classView.getText().toString().equals("") && classView.getText().toString().length() > 0 &&
                !levelView.getText().toString().equals("") && levelView.getText().toString().length() > 0 &&
                !strView.getText().toString().equals("") && strView.getText().toString().length() > 0 &&
                !dexView.getText().toString().equals("") && dexView.getText().toString().length() > 0 &&
                !conView.getText().toString().equals("") && conView.getText().toString().length() > 0 &&
                !intlView.getText().toString().equals("") && intlView.getText().toString().length() > 0 &&
                !wisView.getText().toString().equals("") && wisView.getText().toString().length() > 0 &&
                !chaView.getText().toString().equals("") && chaView.getText().toString().length() > 0 &&
                !babView.getText().toString().equals("") && babView.getText().toString().length() > 0 &&
                !hpView.getText().toString().equals("") && hpView.getText().toString().length() > 0)

        {
            String name = new String(nameView.getText().toString());
            String playClass = new String(classView.getText().toString());
            String levelString = new String(levelView.getText().toString());
            String strString = new String(strView.getText().toString());
            String dexString = new String(dexView.getText().toString());
            String conString = new String(conView.getText().toString());
            String intlString = new String(intlView.getText().toString());
            String wisString = new String(wisView.getText().toString());
            String chaString = new String(chaView.getText().toString());
            String babString = new String(babView.getText().toString());
            String baseHpString = new String(hpView.getText().toString());
            int level = Integer.parseInt(levelString);
            int str = Integer.parseInt(strString);
            int dex = Integer.parseInt(dexString);
            int con = Integer.parseInt(conString);
            int intl = Integer.parseInt(intlString);
            int wis = Integer.parseInt(wisString);
            int cha = Integer.parseInt(chaString);
            int bab = Integer.parseInt(babString);
            int baseHp = Integer.parseInt(baseHpString);

            changeBuildNameinAttackXml(staticBuildChangeInfo.name, name);
            
            staticBuildChangeInfo = staticBuildChangeInfo.updateBuildInXml
            (this, staticBuildChangeInfo.name, name, playClass, level, bab, baseHp, str, 
             staticBuildChangeInfo.strEnhancement, staticBuildChangeInfo.strMorale, staticBuildChangeInfo.strSize, staticBuildChangeInfo.strAlchemical,
             staticBuildChangeInfo.strInherent, staticBuildChangeInfo.strOther, dex, staticBuildChangeInfo.dexEnhancement, staticBuildChangeInfo.dexMorale,
             staticBuildChangeInfo.dexSize, staticBuildChangeInfo.dexAlchemical, staticBuildChangeInfo.dexInherent, staticBuildChangeInfo.dexOther, con,
             staticBuildChangeInfo.conEnhancement, staticBuildChangeInfo.conMorale, staticBuildChangeInfo.conSize, staticBuildChangeInfo.conAlchemical,
             staticBuildChangeInfo.conInherent, staticBuildChangeInfo.conOther, intl, staticBuildChangeInfo.intlEnhancement, staticBuildChangeInfo.intlMorale, staticBuildChangeInfo.intlAlchemical, staticBuildChangeInfo.intlInherent, staticBuildChangeInfo.intlOther, wis, staticBuildChangeInfo.wisEnhancement, staticBuildChangeInfo.wisMorale, staticBuildChangeInfo.wisAlchemical, staticBuildChangeInfo.wisInherent, staticBuildChangeInfo.wisOther, cha, staticBuildChangeInfo.chaEnhancement, staticBuildChangeInfo.chaMorale, staticBuildChangeInfo.chaAlchemical, staticBuildChangeInfo.chaInherent, staticBuildChangeInfo.chaOther, staticBuildChangeInfo.toHitMorale, staticBuildChangeInfo.toHitLuck,
             staticBuildChangeInfo.toHitSacred, staticBuildChangeInfo.toHitSize, staticBuildChangeInfo.toHitUntyped, staticBuildChangeInfo.toHitOther,
             staticBuildChangeInfo.dmgMorale, staticBuildChangeInfo.dmgLuck, staticBuildChangeInfo. dmgSacred,
             staticBuildChangeInfo.dmgUntyped, staticBuildChangeInfo.dmgOther, staticBuildChangeInfo.acArmor, staticBuildChangeInfo.acNatural,
             staticBuildChangeInfo.acNaturalEnhancement, staticBuildChangeInfo.acSacred, staticBuildChangeInfo.acShield, staticBuildChangeInfo.acDeflection,
             staticBuildChangeInfo.acUntyped, staticBuildChangeInfo.acOther, staticBuildChangeInfo.acDexMax, staticBuildChangeInfo.acSize);

             
           
            finish();
            
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
                
                return true;

            
        }
        return super.onOptionsItemSelected(item);
    }


    public void changeBuildNameinAttackXml(
            String oldBuildName,
            String newBuildName)
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

                for (int j = 0; j < nList.getLength(); j++)
                {
                    Node nBuild = nList.item(j);
                    Element eBuild = (Element) nBuild;
                    String buildId = new String(eBuild.getAttribute("id"));
                    if (buildId.equals(oldBuildName))
                    {
                        eBuild.setAttribute("id", newBuildName);
                    }
                }
                
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
