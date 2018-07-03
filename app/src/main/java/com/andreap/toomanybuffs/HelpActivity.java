package com.andreap.toomanybuffs;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import android.support.v7.app.*;
import android.support.v7.widget.Toolbar;

public class HelpActivity extends AppCompatActivity
{
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        Toolbar main_toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(main_toolbar);
		TextView txtHelp= (TextView) findViewById(R.id.txtRawResource);
        Intent intent = getIntent();
        String fromWho = new String(intent.getStringExtra("from"));
        if (fromWho.equals("mainActivity"))
        {
		    txtHelp.setText(readRawTextFile(this, R.raw.help_mainactivity));
        }
        if (fromWho.equals("newBuildActivity"))
        {
            txtHelp.setText(readRawTextFile(this, R.raw.help_newbuildactivity));
        }
    }
	
	public static String readRawTextFile(Context ctx, int resId)
	{
		InputStream inputStream = ctx.getResources().openRawResource(resId);

		InputStreamReader inputreader = new InputStreamReader(inputStream);
		BufferedReader buffreader = new BufferedReader(inputreader);
		String line;
		StringBuilder text = new StringBuilder();

		try {
			while (( line = buffreader.readLine()) != null) {
				text.append(line);
				text.append('\n');
			}
		} catch (IOException e) {
			return null;
		}
		return text.toString();
	}
}
