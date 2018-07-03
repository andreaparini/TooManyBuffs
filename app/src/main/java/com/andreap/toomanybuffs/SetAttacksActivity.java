package com.andreap.toomanybuffs;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;
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
import java.util.*;
import android.support.v4.content.ContextCompat;







public class SetAttacksActivity extends AppCompatActivity
{
    static String listViewChoice = new String("");
    static String staticAttacksBuildName = new String("");
    
    private RecyclerView recyclerView;
    static private AttacksAdapter mAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   
        listViewChoice = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setattacks);
        Toolbar main_toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(main_toolbar);
        
        Intent intentFromCustomization = getIntent();
        staticAttacksBuildName = intentFromCustomization.getStringExtra("buildName");
        
        
        
    }

    @Override
    protected void onResume()
    {
        listViewChoice = "";
        super.onResume();

        ArrayList<AttackInfo> savedBuilds = readAllAttacksXmlFile(this, staticAttacksBuildName);

        recyclerView = (RecyclerView) findViewById(R.id.attacksRecyclerView1);
        mAdapter = new AttacksAdapter(savedBuilds);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
    }
    
    
    
    public void onAddAttackButtonClick(View view)
    {   
            Intent intent = new Intent(this, AddAttackActivity.class);
            intent.putExtra("loadedBuild", staticAttacksBuildName);
            startActivity(intent);     
    }

    
    public void onModifyAttackButtonClick(View view)
    {   
        
        int pos = mAdapter.row_index;
        if(pos != -1)
        {
            listViewChoice = mAdapter.attacks.get(pos).name;           
            Intent intent = new Intent(this, ModifyAttackActivity.class);
            intent.putExtra("loadedAttack", listViewChoice);
            intent.putExtra("loadedBuild", staticAttacksBuildName);
            intent.putExtra("pos", pos);

            startActivity(intent);     
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
    
    ArrayList<AttackInfo> readAllAttacksXmlFile(Context ctx, String loadedBuild)
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
                                    String attackOn = eAttack.getElementsByTagName("attackbasedon").item(0).getTextContent();
                                    String damageOn = eAttack.getElementsByTagName("damagebasedon").item(0).getTextContent();
                                    String crirical = eAttack.getElementsByTagName("critical").item(0).getTextContent();
                                    
                                    
                                    dbAttacks.add(new AttackInfo(name, attackOn, damageOn, crirical, nAttacks.getLength()));    
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
