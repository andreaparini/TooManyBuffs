package com.andreap.toomanybuffs;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.support.v7.app.*;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.mainMenuHelp:
				Intent intent = new Intent(this, HelpActivity.class);
                intent.putExtra("from", "mainActivity");
				startActivity(intent);
				return true;
				
			
		}
		return super.onOptionsItemSelected(item);
	}
    public void onNewBuildButtonClick(View view)
    {
        Intent intent = new Intent(this, NewBuildActivity.class);
        startActivity(intent);
    }
    public void onLoadBuildsButtonClick(View view)
    {
        Intent intent = new Intent(this, LoadBuildsActivity.class);
        startActivity(intent);
    }
    public void onManageBuffsButtonClick(View view)
    {
        Intent intent = new Intent(this, ManageBuffsActivity.class);
        startActivity(intent);
    }
    
}
