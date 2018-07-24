package com.andreap.toomanybuffs;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.support.v7.app.*;
import android.support.v7.widget.Toolbar;

public class BuffsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buffs);
        Toolbar main_toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(main_toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate main_menu.xml 
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void onNewBuffButtonClick(View view)
    {
        Intent intent = new Intent(this, NewBuffActivity.class);
        startActivity(intent);
    }
    public void onManageBuffsButtonClick(View view)
    {
        Intent intent = new Intent(this, LoadBuildsActivity.class);
        startActivity(intent);
    }
    public void onManageFavoritesButtonClick(View view)
    {
        Intent intent = new Intent(this, BuffsActivity.class);
        startActivity(intent);
    }
    
}
