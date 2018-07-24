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
import org.apache.http.util.*;
import org.w3c.dom.*;
import android.widget.AdapterView.*;
import java.util.*;

public class NewBuffActivity extends AppCompatActivity
{
    
    static ArrayList<BuffInfo> staticBuffsArray = new ArrayList<BuffInfo>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbuff);
        Toolbar main_toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(main_toolbar);      

        
        Spinner buffSpinner = (Spinner) findViewById(R.id.newBuffBuffSpinner);       
        ArrayAdapter<CharSequence> buffAdapter = ArrayAdapter.createFromResource
        (this, R.array.bufftype, android.R.layout.simple_spinner_item);
        buffAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        buffSpinner.setAdapter(buffAdapter);

        

        final Spinner bonusTypeSpinner = (Spinner) findViewById(R.id.newbuffBonusTypeSpinner);       
        final ArrayAdapter<CharSequence> bonusStrDexConTypeAdapter = ArrayAdapter.createFromResource
        (this, R.array.strdexconbuffs, android.R.layout.simple_spinner_item);
        bonusStrDexConTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bonusTypeSpinner.setAdapter(bonusStrDexConTypeAdapter);
        
        
        final ArrayAdapter<CharSequence> bonusIntWisChaTypeAdapter = ArrayAdapter.createFromResource
        (this, R.array.intwischabuffs, android.R.layout.simple_spinner_item);
        bonusIntWisChaTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        final ArrayAdapter<CharSequence> bonusToHitDmgTypeAdapter = ArrayAdapter.createFromResource
        (this, R.array.tohitdmgbuffs, android.R.layout.simple_spinner_item);
        bonusToHitDmgTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        final ArrayAdapter<CharSequence> bonusAcTypeAdapter = ArrayAdapter.createFromResource
        (this, R.array.acbuffs, android.R.layout.simple_spinner_item);
        bonusAcTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        
        
        buffSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){
            
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view,
                                           int position, long id) {
                    Object item = adapterView.getItemAtPosition(position);
                    if (item != null) {
                                            
                        if( (item.toString()).equals("Strength") ||
                            (item.toString()).equals("Dexterity") ||
                            (item.toString()).equals("Constitution") )
                        {
                            bonusTypeSpinner.setAdapter(bonusStrDexConTypeAdapter);
                        }
                        else if( (item.toString()).equals("Intelligence") ||
                           (item.toString()).equals("Wisdom") ||
                           (item.toString()).equals("Charisma") )
                        {
                            bonusTypeSpinner.setAdapter(bonusIntWisChaTypeAdapter);
                        }
                        else if( (item.toString()).equals("AC") )
                        {
                            bonusTypeSpinner.setAdapter(bonusAcTypeAdapter);
                        }
                                       
                    }
                    
                }
                
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    // TODO Auto-generated method stub

                }
        });

        Spinner bonusSpinner = (Spinner) findViewById(R.id.newbuffBonusSpinner);       
        ArrayAdapter<CharSequence> bonusAdapter = ArrayAdapter.createFromResource
        (this, R.array.numbers15, android.R.layout.simple_spinner_item);
        bonusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bonusSpinner.setAdapter(bonusAdapter);   
        bonusSpinner.setSelection(15);


        
    }

    public void onAddBonusButtonClick(View view)
    {
        Spinner buffSpinner = (Spinner) findViewById(R.id.newBuffBuffSpinner);
        Spinner bonusTypeSpinner = (Spinner) findViewById(R.id.newbuffBonusTypeSpinner);
        Spinner bonusSpinner = (Spinner) findViewById(R.id.newbuffBonusSpinner);                  
        CheckBox stackedCheckBox = (CheckBox) findViewById(R.id.newbuffStackedCheckBox);

        String buff = new String(String.valueOf(buffSpinner.getSelectedItem()));
        String bonusType = new String(String.valueOf(bonusTypeSpinner.getSelectedItem()));
        int bonus = Integer.parseInt((String.valueOf(bonusSpinner.getSelectedItem())));
        int stacked = 0;
        if (stackedCheckBox.isChecked())
        {
            stacked = 1;
        }
        if (staticBuffsArray.size() < 7)
        {
            BuffInfo buffElement = new BuffInfo(buff, bonusType, bonus, stacked);
            staticBuffsArray.add(buffElement);

            final int[] textviewIds ={
                R.id.newbuffTextview1,
                R.id.newbuffTextview2,  
                R.id.newbuffTextview3,
                R.id.newbuffTextview4,
                R.id.newbuffTextview5,
                R.id.newbuffTextview6,
                R.id.newbuffTextview7};

            final int[] relativeLayoutIds ={
                R.id.newbuffRelativeLayout1,
                R.id.newbuffRelativeLayout2,  
                R.id.newbuffRelativeLayout3,
                R.id.newbuffRelativeLayout4,
                R.id.newbuffRelativeLayout5,
                R.id.newbuffRelativeLayout6,
                R.id.newbuffRelativeLayout7};

            int index = staticBuffsArray.size() - 1;
            RelativeLayout toShow = findViewById(relativeLayoutIds[index]);
            TextView textToShow = findViewById(textviewIds[index]);
            toShow.setVisibility(View.VISIBLE);
            String toSet = new String(buffElement.buffStat + ", " 
                                      + buffElement.bonusType + " + "
                                      + buffElement.bonus);
            textToShow.setText(toSet);
        }
    }
    
    
    public void onCreateBuffButtonClick(View view)
    {   
        EditText nameView = (EditText) findViewById(R.id.newbuffName);

        if( !nameView.getText().toString().equals("") &&
            nameView.getText().toString().length() > 0 )
        {          
            String name = new String(nameView.getText().toString());
            name = name.trim();
            
            if(buffExistsXmlFile(this, name))
            {
                createNewBuff (this, name, staticBuffsArray);
                finish();
            } else {
                Toast.makeText(this, 
                               "A buff with this name is already present in the database. Please use another name", 
                               Toast.LENGTH_LONG).show();
            }                      

        } else {
            Toast.makeText(this, 
                           "Buff name field is empty", 
                           Toast.LENGTH_LONG).show();
        }
    }
    
    public void onDeleteBuffEntryClick(View view)
    {   
        final int[] textviewIds ={
            R.id.newbuffTextview1,
            R.id.newbuffTextview2,  
            R.id.newbuffTextview3,
            R.id.newbuffTextview4,
            R.id.newbuffTextview5,
            R.id.newbuffTextview6,
            R.id.newbuffTextview7};
            
        final int[] relativeLayoutIds ={
            R.id.newbuffRelativeLayout1,
            R.id.newbuffRelativeLayout2,  
            R.id.newbuffRelativeLayout3,
            R.id.newbuffRelativeLayout4,
            R.id.newbuffRelativeLayout5,
            R.id.newbuffRelativeLayout6,
            R.id.newbuffRelativeLayout7};
            
        
            
        switch (view.getId())
        {
            case R.id.newbuffImageButton1:
                staticBuffsArray.remove(0);
                for(int j = 0; j < 6; j++)
                {
                    TextView following = findViewById(textviewIds[j+1]);
                    TextView current = findViewById(textviewIds[j]);
                    String toMove = following.getText().toString();
                    current.setText(toMove);

                }
                if(staticBuffsArray.size() == 6)
                {
                    TextView current = findViewById(textviewIds[6]);
                    current.setText("");
                }
                break;                         
            
            case R.id.newbuffImageButton2:
                staticBuffsArray.remove(1);
                
                for(int j = 1; j < 6; j++)
                {
                    TextView following = findViewById(textviewIds[j+1]);
                    TextView current = findViewById(textviewIds[j]);
                    String toMove = following.getText().toString();
                    current.setText(toMove);
                    
                }
                if(staticBuffsArray.size() == 6)
                {
                    TextView current = findViewById(textviewIds[6]);
                    current.setText("");
                }
                break;
            
            case R.id.newbuffImageButton3:
                staticBuffsArray.remove(2);

                for(int j = 2; j < 6; j++)
                {
                    TextView following = findViewById(textviewIds[j+1]);
                    TextView current = findViewById(textviewIds[j]);
                    String toMove = following.getText().toString();
                    current.setText(toMove);

                }
                if(staticBuffsArray.size() == 6)
                {
                    TextView current = findViewById(textviewIds[6]);
                    current.setText("");
                }
                break;
                
            case R.id.newbuffImageButton4:
                staticBuffsArray.remove(3);

                for(int j = 3; j < 6; j++)
                {
                    TextView following = findViewById(textviewIds[j+1]);
                    TextView current = findViewById(textviewIds[j]);
                    String toMove = following.getText().toString();
                    current.setText(toMove);

                }
                if(staticBuffsArray.size() == 6)
                {
                    TextView current = findViewById(textviewIds[6]);
                    current.setText("");
                }
                break;   
                
            case R.id.newbuffImageButton5:
                staticBuffsArray.remove(4);

                for(int j = 4; j < 6; j++)
                {
                    TextView following = findViewById(textviewIds[j+1]);
                    TextView current = findViewById(textviewIds[j]);
                    String toMove = following.getText().toString();
                    current.setText(toMove);

                }
                if(staticBuffsArray.size() == 6)
                {
                    TextView current = findViewById(textviewIds[6]);
                    current.setText("");
                }
                break;
                
            case R.id.newbuffImageButton6:
                staticBuffsArray.remove(5);

                for(int j = 5; j < 6; j++)
                {
                    TextView following = findViewById(textviewIds[j+1]);
                    TextView current = findViewById(textviewIds[j]);
                    String toMove = following.getText().toString();
                    current.setText(toMove);

                }
                if(staticBuffsArray.size() == 6)
                {
                    TextView current = findViewById(textviewIds[6]);
                    current.setText("");
                }
                break;
                
            case R.id.newbuffImageButton7:
                staticBuffsArray.remove(6);             
                if(staticBuffsArray.size() == 6)
                {
                    TextView current = findViewById(textviewIds[6]);
                    current.setText("");
                }
                break;
                
        }
        
        for(int j = 0; j < 7; j++)
        {
            TextView current = findViewById(textviewIds[j]);
            String toHide = current.getText().toString();
            if (toHide.equals(""))
            {
                RelativeLayout toHide1 = findViewById(relativeLayoutIds[j]);
                toHide1.setVisibility(View.GONE);
            }
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

    //creates a new buff in the database, from the entry array
    //buffsArray
    public void createNewBuff (Context ctx, String name, 
                                ArrayList<BuffInfo> buffsArray)                   
    {
        try
        {         
            File buffsdb = new File(getFilesDir() + "/buffs_db.xml");
            if (buffsdb.exists())
            {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(buffsdb);

                Element rootElement = doc.getDocumentElement();        

                //file exists but is empty                 

                Element newBuff = doc.createElement("buff");
                Attr buffId = doc.createAttribute("name");
                buffId.setValue(name);
                newBuff.setAttributeNode(buffId);
                
                
                for (int i = 0; i < buffsArray.size(); i++)
                {            
                    Element newEntry = doc.createElement("entry");
                    newBuff.appendChild(newEntry);

                    Element buffStat = doc.createElement("stat");
                    buffStat.appendChild(doc.createTextNode(buffsArray.get(i).buffStat));
                    Element buffBonusType = doc.createElement("bonustype");
                    buffBonusType.appendChild(doc.createTextNode(buffsArray.get(i).bonusType));
                    Element buffBonus = doc.createElement("bonus");
                    buffBonus.appendChild(doc.createTextNode(Integer.toString(buffsArray.get(i).bonus)));
                    Element buffStacked = doc.createElement("stacked");
                    buffStacked.appendChild(doc.createTextNode(Integer.toString(buffsArray.get(i).stacked)));

                    newEntry.appendChild(buffStat);
                    newEntry.appendChild(buffBonusType);
                    newEntry.appendChild(buffBonus);
                    newEntry.appendChild(buffStacked);
                }
                
                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(getFilesDir() + "/buffs_db.xml"));

                // Output to console for testing
                //StreamResult result = new StreamResult(System.out);

                transformer.transform(source, result);

            }
            else
            {
                //file does not exist
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                // root elements
                Document doc = docBuilder.newDocument();

                Element rootElement = doc.createElement("buffs");
                doc.appendChild(rootElement);

                Element newBuff = doc.createElement("buff");
                Attr buffId = doc.createAttribute("name");
                buffId.setValue(name);
                newBuff.setAttributeNode(buffId);


                for (int i = 0; i < buffsArray.size(); i++)
                {            
                    Element newEntry = doc.createElement("entry");
                    newBuff.appendChild(newEntry);

                    Element buffStat = doc.createElement("stat");
                    buffStat.appendChild(doc.createTextNode(buffsArray.get(i).buffStat));
                    Element buffBonusType = doc.createElement("bonustype");
                    buffBonusType.appendChild(doc.createTextNode(buffsArray.get(i).bonusType));
                    Element buffBonus = doc.createElement("bonus");
                    buffBonus.appendChild(doc.createTextNode(Integer.toString(buffsArray.get(i).bonus)));
                    Element buffStacked = doc.createElement("stacked");
                    buffStacked.appendChild(doc.createTextNode(Integer.toString(buffsArray.get(i).stacked)));

                    newEntry.appendChild(buffStat);
                    newEntry.appendChild(buffBonusType);
                    newEntry.appendChild(buffBonus);
                    newEntry.appendChild(buffStacked);
                }

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(getFilesDir() + "/buffs_db.xml"));

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
    
    //returns true if a buff with name buffname exists in the database, false otherwise
    public boolean buffExistsXmlFile (Context ctx, String buffName)
    {
        boolean found = false;

        try
        {           
            File xmldb = new File(ctx.getFilesDir() + "/buffs_db.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmldb);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("buff");

            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);          

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode;


                    if ((eElement.getAttribute(("name")).equals(buffName)))
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
