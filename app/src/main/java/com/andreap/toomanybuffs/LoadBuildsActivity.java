package com.andreap.toomanybuffs;

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

import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.content.*;
import android.support.v7.app.*;
import android.support.v7.widget.Toolbar;

public class LoadBuildsActivity extends AppCompatActivity
{
    static String listViewChoice = new String("");
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        listViewChoice = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadbuilds);
        Toolbar main_toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(main_toolbar);
        
        final BuildInfo[] savedBuilds = readAllBuildsXmlFile(this);
        
        if(savedBuilds[0].nbuilds > 0)
        {
            String[] buildNames = new String[savedBuilds[0].nbuilds];
            String[] buildClasses= new String[savedBuilds[0].nbuilds];
            int[] buildLevels = new int[savedBuilds[0].nbuilds];
            String[] infoBuildToShow = new String[savedBuilds[0].nbuilds];
            for (int i = 0; i < savedBuilds[0].nbuilds; i++)
            {
                buildNames[i] = savedBuilds[i].name;
                buildClasses[i] = savedBuilds[i].playableClass;
                buildLevels[i] = savedBuilds[i].level;
                infoBuildToShow[i] = new String(buildNames[i] + ", " + buildClasses[i] 
                                            + " " + buildLevels[i]);
                
            }

            ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, infoBuildToShow);
            ListView listView = (ListView) findViewById(R.id.loadbuildsListView1);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> l, View v, int position, long id)
                    {                      
                        listViewChoice = savedBuilds[position].name;
                    }
                });
        }
        
    }

    @Override
    protected void onResume()
    {
        listViewChoice = "";
        super.onResume();

        final BuildInfo[] savedBuilds = readAllBuildsXmlFile(this);

        if(savedBuilds[0].nbuilds > 0)
        {
            String[] buildNames = new String[savedBuilds[0].nbuilds];
            String[] buildClasses= new String[savedBuilds[0].nbuilds];
            int[] buildLevels = new int[savedBuilds[0].nbuilds];
            String[] infoBuildToShow = new String[savedBuilds[0].nbuilds];
            for (int i = 0; i < savedBuilds[0].nbuilds; i++)
            {
                buildNames[i] = savedBuilds[i].name;
                buildClasses[i] = savedBuilds[i].playableClass;
                buildLevels[i] = savedBuilds[i].level;
                infoBuildToShow[i] = new String(buildNames[i] + ", " + buildClasses[i] 
                                                + " " + buildLevels[i]);

            }

            ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, infoBuildToShow);
            ListView listView = (ListView) findViewById(R.id.loadbuildsListView1);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> l, View v, int position, long id)
                    {                      
                        listViewChoice = savedBuilds[position].name;
                    }
                });
        }

    }
    
    public void onLoadBuildButtonClick(View view)
    {   
        if (listViewChoice != "")
        {
            Intent intent = new Intent(this, CustomizationActivity.class);
            intent.putExtra("loadedBuild", listViewChoice);
            startActivity(intent);
        }
    }
    
    public void onDeleteBuildButtonClick(View view)
    {   
        if (listViewChoice != "")
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            // Add the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        // User clicked OK button
                        deleteBuild(listViewChoice);
                        dialog.dismiss();
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
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
            builder.setMessage("Are you sure you want to delete this build?");

            // Create the AlertDialog
            builder.show();
        }
    }
    
    
    
    BuildInfo[] readAllBuildsXmlFile(Context ctx)
    {
        try
        {
            File xmldb = new File(getFilesDir() + "/build_db.xml");
            if (xmldb.exists())
            {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmldb);

                //optional, but recommended
                //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName("build");

                if (nList.getLength() > 0)
                {

                    BuildInfo[] dbBuilds = new BuildInfo[nList.getLength()];

                    for (int temp = 0; temp < nList.getLength(); temp++)
                    {

                        Node nNode = nList.item(temp);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE)
                        {

                            Element eElement = (Element) nNode;

                            String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                            String playableClass = eElement.getElementsByTagName("playableclass").item(0).getTextContent();
                            int level = Integer.parseInt(eElement.getElementsByTagName("level").item(0).getTextContent());

                            dbBuilds[temp] = new BuildInfo(name, playableClass, level, nList.getLength());    
                        }

                    }
                    return dbBuilds;
                } 
                else 
                {
                    BuildInfo[] noBuilds = new BuildInfo[1];
                    noBuilds[0] = new BuildInfo("noname", "noclass", 0, 0);
                    return noBuilds;
                }

            }
            else
            {
                BuildInfo[] noBuilds = new BuildInfo[1];
                noBuilds[0] = new BuildInfo("noname", "noclass", 0, 0);
                return noBuilds;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;

        }

    }

    
    public void deleteBuild(String buildToDelete)
    {
        try
        {
        
            File xmldb = new File(getFilesDir()+"/build_db.xml");
            if(xmldb.exists())
            {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(xmldb);
                
                Element db = doc.getDocumentElement();
                
                NodeList nList = doc.getElementsByTagName("build");
                
                for (int temp = 0; temp < nList.getLength(); temp++)
                {
                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element eElement = (Element) nNode;
                        
                        if((eElement.getElementsByTagName("name").item(0).getTextContent()).equals(buildToDelete))
                        {
                            db.removeChild(eElement);
                        }                      
                    }
                }
                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(xmldb);
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
                        if (buildId.equals(buildToDelete))
                        {
                            rootElement.removeChild(nNode);
                            

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
        
        
    
    }
    
}
