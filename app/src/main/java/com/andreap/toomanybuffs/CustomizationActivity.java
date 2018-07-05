package com.andreap.toomanybuffs;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.content.*;
import android.support.v7.app.*;
import android.support.v7.widget.Toolbar;

public class CustomizationActivity extends AppCompatActivity
{
    static String staticBuildName = new String("");
    Build useless = new Build();
    static Build staticBuild;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customization);
        Toolbar main_toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(main_toolbar);

        Intent intentFromLoadBuilds = getIntent();
        staticBuildName = intentFromLoadBuilds.getStringExtra("loadedBuild");

        staticBuild = useless.readBuildXmlFile(this, staticBuildName);

        TextView strModView = (TextView) findViewById(R.id.customStrTextView);
        TextView dexModView = (TextView) findViewById(R.id.customDexTextView);
        TextView conModView = (TextView) findViewById(R.id.customConTextView);
        TextView intlModView = (TextView) findViewById(R.id.customIntlTextView);
        TextView wisModView = (TextView) findViewById(R.id.customWisTextView);
        TextView chaModView = (TextView) findViewById(R.id.customChaTextView);
        TextView toHitModView = (TextView) findViewById(R.id.customToHitTextView);
        TextView dmgModView = (TextView) findViewById(R.id.customDmgTextView);
        TextView acModView = (TextView) findViewById(R.id.customAcTextView);
        ImageView strModIView = (ImageView) findViewById(R.id.customizationImageView1);
        ImageView dexModIView = (ImageView) findViewById(R.id.customizationImageView2);
        ImageView conModIView = (ImageView) findViewById(R.id.customizationImageView3);
        ImageView toHitModIView = (ImageView) findViewById(R.id.customizationImageView4);
        ImageView dmgModIView = (ImageView) findViewById(R.id.customizationImageView5);
        ImageView acModIView = (ImageView) findViewById(R.id.customizationImageView6);
        ImageView intlModIView = (ImageView) findViewById(R.id.customizationImageView7);
        ImageView wisModIView = (ImageView) findViewById(R.id.customizationImageView8);
        ImageView chaModIView = (ImageView) findViewById(R.id.customizationImageView9);

        strModView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {              
                    View strToShow = (LinearLayout) findViewById(R.id.customStrToShow);
                    if (strToShow.getVisibility() == View.GONE)
                    {
                        strToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        strToShow.setVisibility(View.GONE);
                    }
                }
            });

        dexModView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {              
                    View dexToShow = (LinearLayout) findViewById(R.id.customDexToShow);
                    if (dexToShow.getVisibility() == View.GONE)
                    {
                        dexToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        dexToShow.setVisibility(View.GONE);
                    }
                }
            });

        conModView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {              
                    View conToShow = (LinearLayout) findViewById(R.id.customConToShow);
                    if (conToShow.getVisibility() == View.GONE)
                    {
                        conToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        conToShow.setVisibility(View.GONE);
                    }

                }
            });

        intlModView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {
                    View intlToShow = (LinearLayout) findViewById(R.id.customIntlToShow);
                    if (intlToShow.getVisibility() == View.GONE)
                    {
                        intlToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        intlToShow.setVisibility(View.GONE);
                    }

                }
            });

        wisModView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {
                    View wisToShow = (LinearLayout) findViewById(R.id.customWisToShow);
                    if (wisToShow.getVisibility() == View.GONE)
                    {
                        wisToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        wisToShow.setVisibility(View.GONE);
                    }

                }
            });

        chaModView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {
                    View chaToShow = (LinearLayout) findViewById(R.id.customChaToShow);
                    if (chaToShow.getVisibility() == View.GONE)
                    {
                        chaToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        chaToShow.setVisibility(View.GONE);
                    }

                }
            });

        toHitModView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {              
                    View toHitToShow = (LinearLayout) findViewById(R.id.customToHitToShow);
                    if (toHitToShow.getVisibility() == View.GONE)
                    {
                        toHitToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        toHitToShow.setVisibility(View.GONE);
                    }

                }
            });

        dmgModView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {              
                    View dmgToShow = (LinearLayout) findViewById(R.id.customDmgToShow);
                    if (dmgToShow.getVisibility() == View.GONE)
                    {
                        dmgToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        dmgToShow.setVisibility(View.GONE);
                    }

                }
            });    

        acModView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {              
                    View acToShow = (LinearLayout) findViewById(R.id.customAcToShow);
                    if (acToShow.getVisibility() == View.GONE)
                    {
                        acToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        acToShow.setVisibility(View.GONE);
                    }

                }
            });    

        strModIView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {              
                    View strToShow = (LinearLayout) findViewById(R.id.customStrToShow);
                    if (strToShow.getVisibility() == View.GONE)
                    {
                        strToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        strToShow.setVisibility(View.GONE);
                    }

                }
            });

        dexModIView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {              
                    View dexToShow = (LinearLayout) findViewById(R.id.customDexToShow);
                    if (dexToShow.getVisibility() == View.GONE)
                    {
                        dexToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        dexToShow.setVisibility(View.GONE);
                    }

                }
            });

        conModIView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {              
                    View conToShow = (LinearLayout) findViewById(R.id.customConToShow);
                    if (conToShow.getVisibility() == View.GONE)
                    {
                        conToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        conToShow.setVisibility(View.GONE);
                    }

                }
            });
        intlModIView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    View intlToShow = (LinearLayout) findViewById(R.id.customIntlToShow);
                    if (intlToShow.getVisibility() == View.GONE)
                    {
                        intlToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        intlToShow.setVisibility(View.GONE);
                    }

                }
            });
        wisModIView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    View wisToShow = (LinearLayout) findViewById(R.id.customWisToShow);
                    if (wisToShow.getVisibility() == View.GONE)
                    {
                        wisToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        wisToShow.setVisibility(View.GONE);
                    }

                }
            });
        chaModIView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    View chaToShow = (LinearLayout) findViewById(R.id.customChaToShow);
                    if (chaToShow.getVisibility() == View.GONE)
                    {
                        chaToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        chaToShow.setVisibility(View.GONE);
                    }

                }
            });

        toHitModIView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {              
                    View toHitToShow = (LinearLayout) findViewById(R.id.customToHitToShow);
                    if (toHitToShow.getVisibility() == View.GONE)
                    {
                        toHitToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        toHitToShow.setVisibility(View.GONE);
                    }

                }
            });

        dmgModIView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {              
                    View dmgToShow = (LinearLayout) findViewById(R.id.customDmgToShow);
                    if (dmgToShow.getVisibility() == View.GONE)
                    {
                        dmgToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        dmgToShow.setVisibility(View.GONE);
                    }

                }
            });    

        acModIView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v)
                {              
                    View acToShow = (LinearLayout) findViewById(R.id.customAcToShow);
                    if (acToShow.getVisibility() == View.GONE)
                    {
                        acToShow.setVisibility(View.VISIBLE);
                    }
                    else
                    {                      
                        acToShow.setVisibility(View.GONE);
                    }

                }
            });    

        Spinner strMorale = (Spinner) findViewById(R.id.customStrMorale);
        Spinner strEnhancement = (Spinner) findViewById(R.id.customStrEnhancement);
        Spinner strSize = (Spinner) findViewById(R.id.customStrSize);
        Spinner strAlchemical = (Spinner) findViewById(R.id.customStrAlchemical);
        Spinner strInherent = (Spinner) findViewById(R.id.customStrInherent);
        Spinner strOther = (Spinner) findViewById(R.id.customStrOther);         

        Spinner dexMorale = (Spinner) findViewById(R.id.customDexMorale);
        Spinner dexEnhancement = (Spinner) findViewById(R.id.customDexEnhancement);
        Spinner dexSize = (Spinner) findViewById(R.id.customDexSize);
        Spinner dexAlchemical = (Spinner) findViewById(R.id.customDexAlchemical);
        Spinner dexInherent = (Spinner) findViewById(R.id.customDexInherent);
        Spinner dexOther = (Spinner) findViewById(R.id.customDexOther);         

        Spinner conMorale = (Spinner) findViewById(R.id.customConMorale);
        Spinner conEnhancement = (Spinner) findViewById(R.id.customConEnhancement);
        Spinner conSize = (Spinner) findViewById(R.id.customConSize);
        Spinner conAlchemical = (Spinner) findViewById(R.id.customConAlchemical);
        Spinner conInherent = (Spinner) findViewById(R.id.customConInherent);
        Spinner conOther = (Spinner) findViewById(R.id.customConOther);

        Spinner intlMorale = (Spinner) findViewById(R.id.customIntlMorale);
        Spinner intlEnhancement = (Spinner) findViewById(R.id.customIntlEnhancement);
        Spinner intlAlchemical = (Spinner) findViewById(R.id.customIntlAlchemical);
        Spinner intlInherent = (Spinner) findViewById(R.id.customIntlInherent);
        Spinner intlOther = (Spinner) findViewById(R.id.customIntlOther);

        Spinner wisMorale = (Spinner) findViewById(R.id.customWisMorale);
        Spinner wisEnhancement = (Spinner) findViewById(R.id.customWisEnhancement);
        Spinner wisAlchemical = (Spinner) findViewById(R.id.customWisAlchemical);
        Spinner wisInherent = (Spinner) findViewById(R.id.customWisInherent);
        Spinner wisOther = (Spinner) findViewById(R.id.customWisOther);

        Spinner chaMorale = (Spinner) findViewById(R.id.customChaMorale);
        Spinner chaEnhancement = (Spinner) findViewById(R.id.customChaEnhancement);
        Spinner chaAlchemical = (Spinner) findViewById(R.id.customChaAlchemical);
        Spinner chaInherent = (Spinner) findViewById(R.id.customChaInherent);
        Spinner chaOther = (Spinner) findViewById(R.id.customChaOther);

        Spinner toHitMorale = (Spinner) findViewById(R.id.customToHitMorale);
        Spinner toHitLuck = (Spinner) findViewById(R.id.customToHitLuck);      
        Spinner toHitSize = (Spinner) findViewById(R.id.customToHitSize);
        Spinner toHitSacred = (Spinner) findViewById(R.id.customToHitSacred);
        Spinner toHitUntyped = (Spinner) findViewById(R.id.customToHitUntyped);
        Spinner toHitOther = (Spinner) findViewById(R.id.customToHitOther);         

        Spinner dmgMorale = (Spinner) findViewById(R.id.customDmgMorale);
        Spinner dmgLuck = (Spinner) findViewById(R.id.customDmgLuck);       
        Spinner dmgSacred = (Spinner) findViewById(R.id.customDmgSacred);
        Spinner dmgUntyped = (Spinner) findViewById(R.id.customDmgUntyped);
        Spinner dmgOther = (Spinner) findViewById(R.id.customDmgOther);         

        Spinner acArmor = (Spinner) findViewById(R.id.customAcArmor);
        Spinner acNatural = (Spinner) findViewById(R.id.customAcNatural);
        Spinner acNaturalEnhancement = (Spinner) findViewById(R.id.customAcNaturalEnhancement);
        Spinner acSacred = (Spinner) findViewById(R.id.customAcSacred);
        Spinner acShield = (Spinner) findViewById(R.id.customAcShield);
        Spinner acDeflection = (Spinner) findViewById(R.id.customAcDeflection);
        Spinner acInsight = (Spinner) findViewById(R.id.customAcInsight);
        Spinner acUntyped = (Spinner) findViewById(R.id.customAcUntyped);
        Spinner acOther = (Spinner) findViewById(R.id.customAcOther);     
        Spinner acDexMax = (Spinner) findViewById(R.id.customAcDexMax);
        Spinner acSize = (Spinner) findViewById(R.id.customAcSize);

        CheckBox acMoreBox1 = (CheckBox) findViewById(R.id.customAcMoreBox1);
        CheckBox acMoreBox2 = (CheckBox) findViewById(R.id.customAcMoreBox2);
        Spinner acMoreField1 = (Spinner) findViewById(R.id.customAcMoreField1);
        Spinner acMoreField2 = (Spinner) findViewById(R.id.customAcMoreField2);

        ArrayAdapter<CharSequence> custom015Adapter = ArrayAdapter.createFromResource
        (this, R.array.numbers15, android.R.layout.simple_spinner_item); 

        ArrayAdapter<CharSequence> customDexMaxAdapter = ArrayAdapter.createFromResource
        (this, R.array.dexmax, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> customAcMoreAdapter = ArrayAdapter.createFromResource
        (this, R.array.addmoreac, android.R.layout.simple_spinner_item);


        custom015Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customDexMaxAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customAcMoreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        strMorale.setAdapter(custom015Adapter);
        strEnhancement.setAdapter(custom015Adapter);
        strSize.setAdapter(custom015Adapter);
        strAlchemical.setAdapter(custom015Adapter);
        strInherent.setAdapter(custom015Adapter);
        strOther.setAdapter(custom015Adapter); 

        dexMorale.setAdapter(custom015Adapter);
        dexEnhancement.setAdapter(custom015Adapter);
        dexSize.setAdapter(custom015Adapter);
        dexAlchemical.setAdapter(custom015Adapter);
        dexInherent.setAdapter(custom015Adapter);
        dexOther.setAdapter(custom015Adapter); 

        conMorale.setAdapter(custom015Adapter);
        conEnhancement.setAdapter(custom015Adapter);
        conSize.setAdapter(custom015Adapter);
        conAlchemical.setAdapter(custom015Adapter);
        conInherent.setAdapter(custom015Adapter);
        conOther.setAdapter(custom015Adapter);

        intlMorale.setAdapter(custom015Adapter);
        intlEnhancement.setAdapter(custom015Adapter);
        intlAlchemical.setAdapter(custom015Adapter);
        intlInherent.setAdapter(custom015Adapter);
        intlOther.setAdapter(custom015Adapter);

        wisMorale.setAdapter(custom015Adapter);
        wisEnhancement.setAdapter(custom015Adapter);
        wisAlchemical.setAdapter(custom015Adapter);
        wisInherent.setAdapter(custom015Adapter);
        wisOther.setAdapter(custom015Adapter);

        chaMorale.setAdapter(custom015Adapter);
        chaEnhancement.setAdapter(custom015Adapter);
        chaAlchemical.setAdapter(custom015Adapter);
        chaInherent.setAdapter(custom015Adapter);
        chaOther.setAdapter(custom015Adapter);

        toHitMorale.setAdapter(custom015Adapter);
        toHitLuck.setAdapter(custom015Adapter);
        toHitSize.setAdapter(custom015Adapter);
        toHitSacred.setAdapter(custom015Adapter);
        toHitUntyped.setAdapter(custom015Adapter);
        toHitOther.setAdapter(custom015Adapter); 

        dmgMorale.setAdapter(custom015Adapter);
        dmgLuck.setAdapter(custom015Adapter);
        dmgSacred.setAdapter(custom015Adapter);
        dmgUntyped.setAdapter(custom015Adapter);
        dmgOther.setAdapter(custom015Adapter); 

        acArmor.setAdapter(custom015Adapter);
        acNatural.setAdapter(custom015Adapter);
        acNaturalEnhancement.setAdapter(custom015Adapter);
        acSacred.setAdapter(custom015Adapter);
        acShield.setAdapter(custom015Adapter);
        acDeflection.setAdapter(custom015Adapter);
        acInsight.setAdapter(custom015Adapter);
        acUntyped.setAdapter(custom015Adapter); 
        acOther.setAdapter(custom015Adapter);
        acDexMax.setAdapter(customDexMaxAdapter);
        acSize.setAdapter(custom015Adapter);

        acMoreField1.setAdapter(customAcMoreAdapter);
        acMoreField2.setAdapter(customAcMoreAdapter);  


        buildToSpinner();
    
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        staticBuild = useless.readBuildXmlFile(this, staticBuildName);
        if (!staticBuild.name.equals(staticBuildName))
        {
            Toast.makeText(this, 
                           "Build has changed name, please reload it", 
                           Toast.LENGTH_LONG).show();
            finish();
        }

    }
    
    
    public void onAcMoreCheckboxClicked(View view)
    {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId())
        {
            case R.id.customAcMoreBox1:
                if (checked)
                {
                    Spinner acMoreField1 = findViewById(R.id.customAcMoreField1);
                    acMoreField1.setVisibility(View.VISIBLE);
                    CheckBox acMoreBox2 = findViewById(R.id.customAcMoreBox2);
                    acMoreBox2.setVisibility(View.VISIBLE);
                    TextView acMoreText2 = findViewById(R.id.customAcMoreText2);
                    acMoreText2.setVisibility(View.VISIBLE);
                }           
                else
                {
                    Spinner acMoreField1 = findViewById(R.id.customAcMoreField1);
                    acMoreField1.setVisibility(View.GONE);
                    CheckBox acMoreBox2 = findViewById(R.id.customAcMoreBox2);
                    acMoreBox2.setVisibility(View.GONE);
                    Spinner acMoreField2 = findViewById(R.id.customAcMoreField2);
                    acMoreField2.setVisibility(View.GONE);
                    
                    acMoreBox2.setChecked(false);
                    
                    TextView acMoreText2 = findViewById(R.id.customAcMoreText2);
                    acMoreText2.setVisibility(View.GONE);
                }               
                break;
                
            case R.id.customAcMoreBox2:
                if (checked)
                {
                    Spinner acMoreField2 = findViewById(R.id.customAcMoreField2);
                    acMoreField2.setVisibility(View.VISIBLE);
                    
                    
                }
                else
                {
                    Spinner acMoreField2 = findViewById(R.id.customAcMoreField2);
                    acMoreField2.setVisibility(View.GONE);
                    
                    
                }              
                break;
        }
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate main_menu.xml 
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.customization_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.custMenuSaveAsDefault:

                spinnertoBuild();

                staticBuild = staticBuild.updateBuildInXml
                (this, staticBuild.name, staticBuild.name, staticBuild.playableClass, staticBuild.level, staticBuild.bab, staticBuild.baseHP, staticBuild.str, 
                 staticBuild.strEnhancement, staticBuild.strMorale, staticBuild.strSize, staticBuild.strAlchemical,
                 staticBuild.strInherent, staticBuild.strOther, staticBuild.dex, staticBuild.dexEnhancement, staticBuild.dexMorale,
                 staticBuild.dexSize, staticBuild.dexAlchemical, staticBuild.dexInherent, staticBuild.dexOther, staticBuild.con,
                 staticBuild.conEnhancement, staticBuild.conMorale, staticBuild.conSize, staticBuild.conAlchemical,
                 staticBuild.conInherent, staticBuild.conOther,staticBuild.intl, staticBuild.intlEnhancement, staticBuild.intlMorale, staticBuild.intlAlchemical, 
                 staticBuild.intlInherent, staticBuild.intlOther, staticBuild.wis, staticBuild.wisEnhancement, staticBuild.wisMorale, staticBuild.wisAlchemical,
                 staticBuild.wisInherent, staticBuild.wisOther, staticBuild.cha, staticBuild.chaEnhancement, staticBuild.chaMorale, staticBuild.chaAlchemical,
                 staticBuild.chaInherent, staticBuild.chaOther, staticBuild.toHitMorale, staticBuild.toHitLuck,
                 staticBuild.toHitSacred, staticBuild.toHitSize, staticBuild.toHitUntyped, staticBuild.toHitOther,
                 staticBuild.dmgMorale, staticBuild.dmgLuck, staticBuild. dmgSacred,
                 staticBuild.dmgUntyped, staticBuild.dmgOther, staticBuild.acArmor, staticBuild.acNatural,
                 staticBuild.acNaturalEnhancement, staticBuild.acSacred, staticBuild.acShield, staticBuild.acDeflection,
                 staticBuild.acInsight, staticBuild.acUntyped, staticBuild.acOther, staticBuild.acDexMax, staticBuild.acSize,
                 staticBuild.acMoreButton1, staticBuild.acMoreButton2, staticBuild.acMoreField1, staticBuild.acMoreField2);

                buildToSpinner();                

                return true;

            case R.id.custMenuRestoreDefaults:
                staticBuild = useless.readBuildXmlFile(this, staticBuildName);
                buildToSpinner();

                return true;

            case R.id.custMenuSetAttacks:
                Intent attackActivityIntent = new Intent(this, SetAttacksActivity.class);
                attackActivityIntent.putExtra("buildName", staticBuildName);
                startActivity(attackActivityIntent);
                return true;

            case R.id.custMenuChangeInfo:

                Intent intent = new Intent(this, ChangeInfoActivity.class);
                intent.putExtra("oldBuildName", staticBuildName);
                startActivity(intent);

                return true;


            case R.id.custMenuGetStats:
                spinnertoBuild();
                Intent intentToGetStats = new Intent(this, CombatActivity.class);
                intentToGetStats.putExtra("Build", staticBuild);              
                startActivity(intentToGetStats);             
                return true;  

            case R.id.custMenuHelp:
                Toast.makeText(this, 
                               "to do", 
                               Toast.LENGTH_LONG).show();
                          
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void spinnertoBuild()
    {
        // strength
        Spinner strMorale = (Spinner) findViewById(R.id.customStrMorale);
        Spinner strEnhancement = (Spinner) findViewById(R.id.customStrEnhancement);
        Spinner strSize = (Spinner) findViewById(R.id.customStrSize);
        Spinner strAlchemical = (Spinner) findViewById(R.id.customStrAlchemical);
        Spinner strInherent = (Spinner) findViewById(R.id.customStrInherent);
        Spinner strOther = (Spinner) findViewById(R.id.customStrOther);     


        staticBuild.strMorale = Integer.parseInt(String.valueOf(strMorale.getSelectedItem()));
        staticBuild.strEnhancement = Integer.parseInt(String.valueOf(strEnhancement.getSelectedItem()));
        staticBuild.strSize = Integer.parseInt(String.valueOf(strSize.getSelectedItem()));
        staticBuild.strAlchemical = Integer.parseInt(String.valueOf(strAlchemical.getSelectedItem()));
        staticBuild.strInherent = Integer.parseInt(String.valueOf(strInherent.getSelectedItem()));
        staticBuild.strOther = Integer.parseInt(String.valueOf(strOther.getSelectedItem()));


        //dexterity

        Spinner dexMorale = (Spinner) findViewById(R.id.customDexMorale);
        Spinner dexEnhancement = (Spinner) findViewById(R.id.customDexEnhancement);
        Spinner dexSize = (Spinner) findViewById(R.id.customDexSize);
        Spinner dexAlchemical = (Spinner) findViewById(R.id.customDexAlchemical);
        Spinner dexInherent = (Spinner) findViewById(R.id.customDexInherent);
        Spinner dexOther = (Spinner) findViewById(R.id.customDexOther);                        

        staticBuild.dexMorale = Integer.parseInt(String.valueOf(dexMorale.getSelectedItem()));
        staticBuild.dexEnhancement = Integer.parseInt(String.valueOf(dexEnhancement.getSelectedItem()));
        staticBuild.dexSize = Integer.parseInt(String.valueOf(dexSize.getSelectedItem()));
        staticBuild.dexAlchemical = Integer.parseInt(String.valueOf(dexAlchemical.getSelectedItem()));
        staticBuild.dexInherent = Integer.parseInt(String.valueOf(dexInherent.getSelectedItem()));
        staticBuild.dexOther = Integer.parseInt(String.valueOf(dexOther.getSelectedItem()));



        //constitution

        Spinner conMorale = (Spinner) findViewById(R.id.customConMorale);
        Spinner conEnhancement = (Spinner) findViewById(R.id.customConEnhancement);
        Spinner conSize = (Spinner) findViewById(R.id.customConSize);
        Spinner conAlchemical = (Spinner) findViewById(R.id.customConAlchemical);
        Spinner conInherent = (Spinner) findViewById(R.id.customConInherent);
        Spinner conOther = (Spinner) findViewById(R.id.customConOther);                        

        staticBuild.conMorale = Integer.parseInt(String.valueOf(conMorale.getSelectedItem()));
        staticBuild.conEnhancement = Integer.parseInt(String.valueOf(conEnhancement.getSelectedItem()));
        staticBuild.conSize = Integer.parseInt(String.valueOf(conSize.getSelectedItem()));
        staticBuild.conAlchemical = Integer.parseInt(String.valueOf(conAlchemical.getSelectedItem()));
        staticBuild.conInherent = Integer.parseInt(String.valueOf(conInherent.getSelectedItem()));
        staticBuild.conOther = Integer.parseInt(String.valueOf(conOther.getSelectedItem()));

        //intelligence

        Spinner intlMorale = (Spinner) findViewById(R.id.customIntlMorale);
        Spinner intlEnhancement = (Spinner) findViewById(R.id.customIntlEnhancement);
        Spinner intlAlchemical = (Spinner) findViewById(R.id.customIntlAlchemical);
        Spinner intlInherent = (Spinner) findViewById(R.id.customIntlInherent);
        Spinner intlOther = (Spinner) findViewById(R.id.customIntlOther);

        staticBuild.intlMorale = Integer.parseInt(String.valueOf(intlMorale.getSelectedItem()));
        staticBuild.intlEnhancement = Integer.parseInt(String.valueOf(intlEnhancement.getSelectedItem()));
        staticBuild.intlAlchemical = Integer.parseInt(String.valueOf(intlAlchemical.getSelectedItem()));
        staticBuild.intlInherent = Integer.parseInt(String.valueOf(intlInherent.getSelectedItem()));
        staticBuild.intlOther = Integer.parseInt(String.valueOf(intlOther.getSelectedItem()));


        //wisdom

        Spinner wisMorale = (Spinner) findViewById(R.id.customWisMorale);
        Spinner wisEnhancement = (Spinner) findViewById(R.id.customWisEnhancement);
        Spinner wisAlchemical = (Spinner) findViewById(R.id.customWisAlchemical);
        Spinner wisInherent = (Spinner) findViewById(R.id.customWisInherent);
        Spinner wisOther = (Spinner) findViewById(R.id.customWisOther);

        staticBuild.wisMorale = Integer.parseInt(String.valueOf(wisMorale.getSelectedItem()));
        staticBuild.wisEnhancement = Integer.parseInt(String.valueOf(wisEnhancement.getSelectedItem()));
        staticBuild.wisAlchemical = Integer.parseInt(String.valueOf(wisAlchemical.getSelectedItem()));
        staticBuild.wisInherent = Integer.parseInt(String.valueOf(wisInherent.getSelectedItem()));
        staticBuild.wisOther = Integer.parseInt(String.valueOf(wisOther.getSelectedItem()));


        //charisma

        Spinner chaMorale = (Spinner) findViewById(R.id.customChaMorale);
        Spinner chaEnhancement = (Spinner) findViewById(R.id.customChaEnhancement);
        Spinner chaAlchemical = (Spinner) findViewById(R.id.customChaAlchemical);
        Spinner chaInherent = (Spinner) findViewById(R.id.customChaInherent);
        Spinner chaOther = (Spinner) findViewById(R.id.customChaOther);

        staticBuild.chaMorale = Integer.parseInt(String.valueOf(chaMorale.getSelectedItem()));
        staticBuild.chaEnhancement = Integer.parseInt(String.valueOf(chaEnhancement.getSelectedItem()));
        staticBuild.chaAlchemical = Integer.parseInt(String.valueOf(chaAlchemical.getSelectedItem()));
        staticBuild.chaInherent = Integer.parseInt(String.valueOf(chaInherent.getSelectedItem()));
        staticBuild.chaOther = Integer.parseInt(String.valueOf(chaOther.getSelectedItem()));


        //to hit

        Spinner toHitMorale = (Spinner) findViewById(R.id.customToHitMorale);
        Spinner toHitLuck = (Spinner) findViewById(R.id.customToHitLuck);       
        Spinner toHitSize = (Spinner) findViewById(R.id.customToHitSize);
        Spinner toHitSacred = (Spinner) findViewById(R.id.customToHitSacred);
        Spinner toHitUntyped = (Spinner) findViewById(R.id.customToHitUntyped);
        Spinner toHitOther = (Spinner) findViewById(R.id.customToHitOther);         

        staticBuild.toHitMorale = Integer.parseInt(String.valueOf(toHitMorale.getSelectedItem()));
        staticBuild.toHitLuck = Integer.parseInt(String.valueOf(toHitLuck.getSelectedItem()));
        staticBuild.toHitSize = Integer.parseInt(String.valueOf(toHitSize.getSelectedItem()));
        staticBuild.toHitSacred = Integer.parseInt(String.valueOf(toHitSacred.getSelectedItem()));
        staticBuild.toHitUntyped = Integer.parseInt(String.valueOf(toHitUntyped.getSelectedItem()));
        staticBuild.toHitOther = Integer.parseInt(String.valueOf(toHitOther.getSelectedItem()));


        //damage

        Spinner dmgMorale = (Spinner) findViewById(R.id.customDmgMorale);
        Spinner dmgLuck = (Spinner) findViewById(R.id.customDmgLuck);       
        Spinner dmgSacred = (Spinner) findViewById(R.id.customDmgSacred);
        Spinner dmgUntyped = (Spinner) findViewById(R.id.customDmgUntyped);
        Spinner dmgOther = (Spinner) findViewById(R.id.customDmgOther);         

        staticBuild.dmgMorale = Integer.parseInt(String.valueOf(dmgMorale.getSelectedItem()));
        staticBuild.dmgLuck = Integer.parseInt(String.valueOf(dmgLuck.getSelectedItem()));
        staticBuild.dmgSacred = Integer.parseInt(String.valueOf(dmgSacred.getSelectedItem()));
        staticBuild.dmgUntyped = Integer.parseInt(String.valueOf(dmgUntyped.getSelectedItem()));
        staticBuild.dmgOther = Integer.parseInt(String.valueOf(dmgOther.getSelectedItem()));



        //AC

        Spinner acArmor = (Spinner) findViewById(R.id.customAcArmor);
        Spinner acNatural = (Spinner) findViewById(R.id.customAcNatural);
        Spinner acNaturalEnhancement = (Spinner) findViewById(R.id.customAcNaturalEnhancement);
        Spinner acSacred = (Spinner) findViewById(R.id.customAcSacred);
        Spinner acShield = (Spinner) findViewById(R.id.customAcShield);
        Spinner acDeflection = (Spinner) findViewById(R.id.customAcDeflection);
        Spinner acInsight = (Spinner) findViewById(R.id.customAcInsight);
        Spinner acUntyped = (Spinner) findViewById(R.id.customAcUntyped);
        Spinner acOther = (Spinner) findViewById(R.id.customAcOther);         
        Spinner acSize = (Spinner) findViewById(R.id.customAcSize);
        Spinner acDexMax = (Spinner) findViewById(R.id.customAcDexMax);

        staticBuild.acArmor = Integer.parseInt(String.valueOf(acArmor.getSelectedItem()));
        staticBuild.acNatural = Integer.parseInt(String.valueOf(acNatural.getSelectedItem()));
        staticBuild.acNaturalEnhancement = Integer.parseInt(String.valueOf(acNaturalEnhancement.getSelectedItem()));
        staticBuild.acSacred = Integer.parseInt(String.valueOf(acSacred.getSelectedItem()));
        staticBuild.acShield = Integer.parseInt(String.valueOf(acShield.getSelectedItem()));
        staticBuild.acDeflection = Integer.parseInt(String.valueOf(acDeflection.getSelectedItem()));
        staticBuild.acInsight = Integer.parseInt(String.valueOf(acInsight.getSelectedItem()));
        staticBuild.acUntyped = Integer.parseInt(String.valueOf(acUntyped.getSelectedItem()));
        staticBuild.acSize = Integer.parseInt(String.valueOf(acSize.getSelectedItem()));
        staticBuild.acOther = Integer.parseInt(String.valueOf(acOther.getSelectedItem()));

        String dexMax = String.valueOf(acDexMax.getSelectedItem());
        if (dexMax.equals("No max dex"))
        {
            staticBuild.acDexMax = -1;
        }
        else 
        {
            staticBuild.acDexMax = Integer.parseInt(dexMax);
        }
        
        CheckBox acMoreBox1 = (CheckBox) findViewById(R.id.customAcMoreBox1);
        CheckBox acMoreBox2 = (CheckBox) findViewById(R.id.customAcMoreBox2);
        Spinner acMoreField1 = (Spinner) findViewById(R.id.customAcMoreField1);
        Spinner acMoreField2 = (Spinner) findViewById(R.id.customAcMoreField2);
        
        
        if(acMoreBox1.isChecked())
        {
            staticBuild.acMoreButton1 = 1;
            staticBuild.acMoreField1 = String.valueOf(acMoreField1.getSelectedItem());
        }
        else
        {
            staticBuild.acMoreButton1 = 0;
            staticBuild.acMoreField1 = "None";
        }
            
        if(acMoreBox2.isChecked())
        {
            staticBuild.acMoreButton2 = 1;
            staticBuild.acMoreField2 = String.valueOf(acMoreField2.getSelectedItem());
        }
        else
        {
            staticBuild.acMoreButton2 = 0;
            staticBuild.acMoreField2 = "None";
        }       
        
        
    }

    public void buildToSpinner()
    {
        //staticBuild infos

        TextView nameView = (TextView) findViewById(R.id.customNameTextView);
        TextView classView = (TextView) findViewById(R.id.customClassTextView);
        TextView levelView = (TextView) findViewById(R.id.customLevelTextView);
        nameView.setText(staticBuild.name);
        classView.setText(staticBuild.playableClass);
        levelView.setText(Integer.toString(staticBuild.level));

        ArrayAdapter<CharSequence> custom015Adapter = ArrayAdapter.createFromResource
        (this, R.array.numbers15, android.R.layout.simple_spinner_item);      
        ArrayAdapter<CharSequence> customDexMaxAdapter = ArrayAdapter.createFromResource
        (this, R.array.dexmax, android.R.layout.simple_spinner_item);         
        ArrayAdapter<CharSequence> customAcMoreAdapter = ArrayAdapter.createFromResource
        (this, R.array.addmoreac, android.R.layout.simple_spinner_item);      
        
        custom015Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customDexMaxAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customAcMoreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        
        //strength

        
        Spinner strMorale = (Spinner) findViewById(R.id.customStrMorale);
        Spinner strEnhancement = (Spinner) findViewById(R.id.customStrEnhancement);
        Spinner strSize = (Spinner) findViewById(R.id.customStrSize);
        Spinner strAlchemical = (Spinner) findViewById(R.id.customStrAlchemical);
        Spinner strInherent = (Spinner) findViewById(R.id.customStrInherent);
        Spinner strOther = (Spinner) findViewById(R.id.customStrOther);         


        

        strMorale.setAdapter(custom015Adapter);
        strEnhancement.setAdapter(custom015Adapter);
        strSize.setAdapter(custom015Adapter);
        strAlchemical.setAdapter(custom015Adapter);
        strInherent.setAdapter(custom015Adapter);
        strOther.setAdapter(custom015Adapter); 



        int strMoralePos = custom015Adapter.getPosition(Integer.toString(staticBuild.strMorale));
        strMorale.setSelection(strMoralePos);
        int strEnhancementPos = custom015Adapter.getPosition(Integer.toString(staticBuild.strEnhancement));
        strEnhancement.setSelection(strEnhancementPos);
        int strSizePos = custom015Adapter.getPosition(Integer.toString(staticBuild.strSize));
        strSize.setSelection(strSizePos);
        int strAlchemicalPos = custom015Adapter.getPosition(Integer.toString(staticBuild.strAlchemical));
        strAlchemical.setSelection(strAlchemicalPos);
        int strInherentPos = custom015Adapter.getPosition(Integer.toString(staticBuild.strInherent));
        strInherent.setSelection(strInherentPos);       
        int strOtherPos = custom015Adapter.getPosition(Integer.toString(staticBuild.strOther));
        strOther.setSelection(strOtherPos);






        //dexterity
        
        Spinner dexMorale = (Spinner) findViewById(R.id.customDexMorale);
        Spinner dexEnhancement = (Spinner) findViewById(R.id.customDexEnhancement);
        Spinner dexSize = (Spinner) findViewById(R.id.customDexSize);
        Spinner dexAlchemical = (Spinner) findViewById(R.id.customDexAlchemical);
        Spinner dexInherent = (Spinner) findViewById(R.id.customDexInherent);
        Spinner dexOther = (Spinner) findViewById(R.id.customDexOther);         

        dexMorale.setAdapter(custom015Adapter);
        dexEnhancement.setAdapter(custom015Adapter);
        dexSize.setAdapter(custom015Adapter);
        dexAlchemical.setAdapter(custom015Adapter);
        dexInherent.setAdapter(custom015Adapter);
        dexOther.setAdapter(custom015Adapter); 


        int dexMoralePos = custom015Adapter.getPosition(Integer.toString(staticBuild.dexMorale));
        dexMorale.setSelection(dexMoralePos);
        int dexEnhancementPos = custom015Adapter.getPosition(Integer.toString(staticBuild.dexEnhancement));
        dexEnhancement.setSelection(dexEnhancementPos);
        int dexSizePos = custom015Adapter.getPosition(Integer.toString(staticBuild.dexSize));
        dexSize.setSelection(dexSizePos);
        int dexAlchemicalPos = custom015Adapter.getPosition(Integer.toString(staticBuild.dexAlchemical));
        dexAlchemical.setSelection(dexAlchemicalPos);
        int dexInherentPos = custom015Adapter.getPosition(Integer.toString(staticBuild.dexInherent));
        dexInherent.setSelection(dexInherentPos);       
        int dexOtherPos = custom015Adapter.getPosition(Integer.toString(staticBuild.dexOther));
        dexOther.setSelection(dexOtherPos);



        //constitution
        
        Spinner conMorale = (Spinner) findViewById(R.id.customConMorale);
        Spinner conEnhancement = (Spinner) findViewById(R.id.customConEnhancement);
        Spinner conSize = (Spinner) findViewById(R.id.customConSize);
        Spinner conAlchemical = (Spinner) findViewById(R.id.customConAlchemical);
        Spinner conInherent = (Spinner) findViewById(R.id.customConInherent);
        Spinner conOther = (Spinner) findViewById(R.id.customConOther);         

        conMorale.setAdapter(custom015Adapter);
        conEnhancement.setAdapter(custom015Adapter);
        conSize.setAdapter(custom015Adapter);
        conAlchemical.setAdapter(custom015Adapter);
        conInherent.setAdapter(custom015Adapter);
        conOther.setAdapter(custom015Adapter); 

        int conMoralePos = custom015Adapter.getPosition(Integer.toString(staticBuild.conMorale));
        conMorale.setSelection(conMoralePos);
        int conEnhancementPos = custom015Adapter.getPosition(Integer.toString(staticBuild.conEnhancement));
        conEnhancement.setSelection(conEnhancementPos);
        int conSizePos = custom015Adapter.getPosition(Integer.toString(staticBuild.conSize));
        conSize.setSelection(conSizePos);
        int conAlchemicalPos = custom015Adapter.getPosition(Integer.toString(staticBuild.conAlchemical));
        conAlchemical.setSelection(conAlchemicalPos);
        int conInherentPos = custom015Adapter.getPosition(Integer.toString(staticBuild.conInherent));
        conInherent.setSelection(conInherentPos);       
        int conOtherPos = custom015Adapter.getPosition(Integer.toString(staticBuild.conOther));
        conOther.setSelection(conOtherPos);

        //intelligence


        Spinner intlMorale = (Spinner) findViewById(R.id.customIntlMorale);
        Spinner intlEnhancement = (Spinner) findViewById(R.id.customIntlEnhancement);
        Spinner intlAlchemical = (Spinner) findViewById(R.id.customIntlAlchemical);
        Spinner intlInherent = (Spinner) findViewById(R.id.customIntlInherent);
        Spinner intlOther = (Spinner) findViewById(R.id.customIntlOther);



        intlMorale.setAdapter(custom015Adapter);
        intlEnhancement.setAdapter(custom015Adapter);
        intlAlchemical.setAdapter(custom015Adapter);
        intlInherent.setAdapter(custom015Adapter);
        intlOther.setAdapter(custom015Adapter);



        int intlMoralePos = custom015Adapter.getPosition(Integer.toString(staticBuild.intlMorale));
        intlMorale.setSelection(intlMoralePos);
        int intlEnhancementPos = custom015Adapter.getPosition(Integer.toString(staticBuild.intlEnhancement));
        intlEnhancement.setSelection(intlEnhancementPos);
        int intlAlchemicalPos = custom015Adapter.getPosition(Integer.toString(staticBuild.intlAlchemical));
        intlAlchemical.setSelection(intlAlchemicalPos);
        int intlInherentPos = custom015Adapter.getPosition(Integer.toString(staticBuild.intlInherent));
        intlInherent.setSelection(intlInherentPos);
        int intlOtherPos = custom015Adapter.getPosition(Integer.toString(staticBuild.intlOther));
        intlOther.setSelection(intlOtherPos);

        //wisdom


        Spinner wisMorale = (Spinner) findViewById(R.id.customWisMorale);
        Spinner wisEnhancement = (Spinner) findViewById(R.id.customWisEnhancement);
        Spinner wisAlchemical = (Spinner) findViewById(R.id.customWisAlchemical);
        Spinner wisInherent = (Spinner) findViewById(R.id.customWisInherent);
        Spinner wisOther = (Spinner) findViewById(R.id.customWisOther);

        wisMorale.setAdapter(custom015Adapter);
        wisEnhancement.setAdapter(custom015Adapter);
        wisAlchemical.setAdapter(custom015Adapter);
        wisInherent.setAdapter(custom015Adapter);
        wisOther.setAdapter(custom015Adapter);

        int wisMoralePos = custom015Adapter.getPosition(Integer.toString(staticBuild.wisMorale));
        wisMorale.setSelection(wisMoralePos);
        int wisEnhancementPos = custom015Adapter.getPosition(Integer.toString(staticBuild.wisEnhancement));
        wisEnhancement.setSelection(wisEnhancementPos);
        int wisAlchemicalPos = custom015Adapter.getPosition(Integer.toString(staticBuild.wisAlchemical));
        wisAlchemical.setSelection(wisAlchemicalPos);
        int wisInherentPos = custom015Adapter.getPosition(Integer.toString(staticBuild.wisInherent));
        wisInherent.setSelection(wisInherentPos);
        int wisOtherPos = custom015Adapter.getPosition(Integer.toString(staticBuild.wisOther));
        wisOther.setSelection(wisOtherPos);

        //charisma


        Spinner chaMorale = (Spinner) findViewById(R.id.customChaMorale);
        Spinner chaEnhancement = (Spinner) findViewById(R.id.customChaEnhancement);
        Spinner chaAlchemical = (Spinner) findViewById(R.id.customChaAlchemical);
        Spinner chaInherent = (Spinner) findViewById(R.id.customChaInherent);
        Spinner chaOther = (Spinner) findViewById(R.id.customChaOther);



        chaMorale.setAdapter(custom015Adapter);
        chaEnhancement.setAdapter(custom015Adapter);
        chaAlchemical.setAdapter(custom015Adapter);
        chaInherent.setAdapter(custom015Adapter);
        chaOther.setAdapter(custom015Adapter);



        int chaMoralePos = custom015Adapter.getPosition(Integer.toString(staticBuild.chaMorale));
        chaMorale.setSelection(chaMoralePos);
        int chaEnhancementPos = custom015Adapter.getPosition(Integer.toString(staticBuild.chaEnhancement));
        chaEnhancement.setSelection(chaEnhancementPos);
        int chaAlchemicalPos = custom015Adapter.getPosition(Integer.toString(staticBuild.chaAlchemical));
        chaAlchemical.setSelection(chaAlchemicalPos);
        int chaInherentPos = custom015Adapter.getPosition(Integer.toString(staticBuild.chaInherent));
        chaInherent.setSelection(chaInherentPos);
        int chaOtherPos = custom015Adapter.getPosition(Integer.toString(staticBuild.chaOther));
        chaOther.setSelection(chaOtherPos);



        //to hit
        
        Spinner toHitMorale = (Spinner) findViewById(R.id.customToHitMorale);
        Spinner toHitLuck = (Spinner) findViewById(R.id.customToHitLuck);       
        Spinner toHitSize = (Spinner) findViewById(R.id.customToHitSize);
        Spinner toHitSacred = (Spinner) findViewById(R.id.customToHitSacred);
        Spinner toHitUntyped = (Spinner) findViewById(R.id.customToHitUntyped);
        Spinner toHitOther = (Spinner) findViewById(R.id.customToHitOther);         

        toHitMorale.setAdapter(custom015Adapter);
        toHitLuck.setAdapter(custom015Adapter);
        toHitSacred.setAdapter(custom015Adapter);
        toHitUntyped.setAdapter(custom015Adapter);
        toHitOther.setAdapter(custom015Adapter); 
        toHitSize.setAdapter(custom015Adapter);


        int toHitMoralePos = custom015Adapter.getPosition(Integer.toString(staticBuild.toHitMorale));
        toHitMorale.setSelection(toHitMoralePos);
        int toHitLuckPos = custom015Adapter.getPosition(Integer.toString(staticBuild.toHitLuck));
        toHitLuck.setSelection(toHitLuckPos);                     
        int toHitSizePos = custom015Adapter.getPosition(Integer.toString(staticBuild.toHitSize));
        toHitSize.setSelection(toHitSizePos);   
        int toHitSacredPos = custom015Adapter.getPosition(Integer.toString(staticBuild.toHitSacred));
        toHitSacred.setSelection(toHitSacredPos);
        int toHitUntypedPos = custom015Adapter.getPosition(Integer.toString(staticBuild.toHitUntyped));
        toHitUntyped.setSelection(toHitUntypedPos);       
        int toHitOtherPos = custom015Adapter.getPosition(Integer.toString(staticBuild.toHitOther));
        toHitOther.setSelection(toHitOtherPos);



        //damage
        
        Spinner dmgMorale = (Spinner) findViewById(R.id.customDmgMorale);
        Spinner dmgLuck = (Spinner) findViewById(R.id.customDmgLuck);     
        Spinner dmgSacred = (Spinner) findViewById(R.id.customDmgSacred);
        Spinner dmgUntyped = (Spinner) findViewById(R.id.customDmgUntyped);
        Spinner dmgOther = (Spinner) findViewById(R.id.customDmgOther);         

        dmgMorale.setAdapter(custom015Adapter);
        dmgLuck.setAdapter(custom015Adapter);    
        dmgSacred.setAdapter(custom015Adapter);
        dmgUntyped.setAdapter(custom015Adapter);
        dmgOther.setAdapter(custom015Adapter); 

        int dmgMoralePos = custom015Adapter.getPosition(Integer.toString(staticBuild.dmgMorale));
        dmgMorale.setSelection(dmgMoralePos);
        int dmgLuckPos = custom015Adapter.getPosition(Integer.toString(staticBuild.dmgLuck));
        dmgLuck.setSelection(dmgLuckPos);
        int dmgSacredPos = custom015Adapter.getPosition(Integer.toString(staticBuild.dmgSacred));
        dmgSacred.setSelection(dmgSacredPos);
        int dmgUntypedPos = custom015Adapter.getPosition(Integer.toString(staticBuild.dmgUntyped));
        dmgUntyped.setSelection(dmgUntypedPos);       
        int dmgOtherPos = custom015Adapter.getPosition(Integer.toString(staticBuild.dmgOther));
        dmgOther.setSelection(dmgOtherPos);





        //AC
        
        Spinner acArmor = (Spinner) findViewById(R.id.customAcArmor);
        Spinner acNatural = (Spinner) findViewById(R.id.customAcNatural);
        Spinner acNaturalEnhancement = (Spinner) findViewById(R.id.customAcNaturalEnhancement);
        Spinner acSacred = (Spinner) findViewById(R.id.customAcSacred);
        Spinner acShield = (Spinner) findViewById(R.id.customAcShield);
        Spinner acDeflection = (Spinner) findViewById(R.id.customAcDeflection);
        Spinner acInsight = (Spinner) findViewById(R.id.customAcInsight);
        Spinner acUntyped = (Spinner) findViewById(R.id.customAcUntyped);
        Spinner acOther = (Spinner) findViewById(R.id.customAcOther);         
        Spinner acSize = (Spinner) findViewById(R.id.customAcSize);
        Spinner acDexMax = (Spinner) findViewById(R.id.customAcDexMax);

        acArmor.setAdapter(custom015Adapter);
        acNatural.setAdapter(custom015Adapter);
        acNaturalEnhancement.setAdapter(custom015Adapter);
        acSacred.setAdapter(custom015Adapter);
        acShield.setAdapter(custom015Adapter);
        acDeflection.setAdapter(custom015Adapter);
        acInsight.setAdapter(custom015Adapter);
        acUntyped.setAdapter(custom015Adapter); 
        acOther.setAdapter(custom015Adapter);
        acDexMax.setAdapter(customDexMaxAdapter);
        acSize.setAdapter(custom015Adapter);

        int acArmorPos = custom015Adapter.getPosition(Integer.toString(staticBuild.acArmor));
        acArmor.setSelection(acArmorPos);
        int acNaturalPos = custom015Adapter.getPosition(Integer.toString(staticBuild.acNatural));
        acNatural.setSelection(acNaturalPos);
        int acNaturalEnhancementPos = custom015Adapter.getPosition(Integer.toString(staticBuild.acNaturalEnhancement));
        acNaturalEnhancement.setSelection(acNaturalEnhancementPos);
        int acSacredPos = custom015Adapter.getPosition(Integer.toString(staticBuild.acSacred));
        acSacred.setSelection(acSacredPos);
        int acShieldPos = custom015Adapter.getPosition(Integer.toString(staticBuild.acShield));
        acShield.setSelection(acShieldPos);       
        int acDeflectionPos = custom015Adapter.getPosition(Integer.toString(staticBuild.acDeflection));
        acDeflection.setSelection(acDeflectionPos);
        int acInsightPos = custom015Adapter.getPosition(Integer.toString(staticBuild.acInsight));
        acInsight.setSelection(acInsightPos);
        int acUntypedPos = custom015Adapter.getPosition(Integer.toString(staticBuild.acUntyped));
        acUntyped.setSelection(acUntypedPos);   
        int acSizePos = custom015Adapter.getPosition(Integer.toString(staticBuild.acSize));
        acSize.setSelection(acSizePos);     
        int acOtherPos = custom015Adapter.getPosition(Integer.toString(staticBuild.acOther));
        acOther.setSelection(acOtherPos);
        if(staticBuild.acDexMax == -1)
        {
            acDexMax.setSelection(0);
        }
        else
        {
            int acDexMaxPos = customDexMaxAdapter.getPosition(Integer.toString(staticBuild.acDexMax));
            acDexMax.setSelection(acDexMaxPos);
        }

        CheckBox acMoreBox1 = (CheckBox) findViewById(R.id.customAcMoreBox1);
        CheckBox acMoreBox2 = (CheckBox) findViewById(R.id.customAcMoreBox2);
        Spinner acMoreField1 = (Spinner) findViewById(R.id.customAcMoreField1);
        Spinner acMoreField2 = (Spinner) findViewById(R.id.customAcMoreField2);
        TextView acMoreText2 = findViewById(R.id.customAcMoreText2);
        if(staticBuild.acMoreButton1 == 1)
        {                     
            acMoreBox1.setChecked(true);
                             
            acMoreBox2.setVisibility(View.VISIBLE);
            
            acMoreField1.setVisibility(View.VISIBLE);           
            
            acMoreText2.setVisibility(View.VISIBLE);
            
                                                                
        }       
        else if(staticBuild.acMoreButton1 == 0)
        {
            acMoreBox1.setChecked(false);
            acMoreBox2.setChecked(false);
            
            acMoreBox2.setVisibility(View.GONE);
            acMoreText2.setVisibility(View.GONE);
            acMoreField1.setVisibility(View.GONE);
            acMoreField2.setVisibility(View.GONE);                
            
            
        }

        if(staticBuild.acMoreButton2 == 1)
        {
            acMoreField2.setVisibility(View.VISIBLE);     
            
            acMoreBox2.setChecked(true);

               
        }
        else if (staticBuild.acMoreButton2 == 0)
        {
            acMoreBox2.setChecked(false);
            
            acMoreField2.setVisibility(View.GONE);        
          
        }       
        acMoreField1.setAdapter(customAcMoreAdapter);
        acMoreField2.setAdapter(customAcMoreAdapter);
        
        int acMoreField1Pos = customAcMoreAdapter.getPosition(staticBuild.acMoreField1);
        acMoreField1.setSelection(acMoreField1Pos);             
        int acMoreField2Pos = customAcMoreAdapter.getPosition(staticBuild.acMoreField2);
        acMoreField2.setSelection(acMoreField2Pos);       

    }




}
