package cpnv.jav1.lima;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;


import cpnv.jav1.lima.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DebugActivity extends Activity 
				   implements OnClickListener {

	// References on controls of this activity
	private Button _btn;
	private TextView _output;
	

    // Create activity event handler
	@Override
    public void onCreate(Bundle savedInstanceState) {
		// Initialize and display view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug);
        
        // Log messages (logcat)
        Log.i ("LIMA", "Started debug activity");
        // Retrieve the intent that invoked us
        Intent intent = getIntent();
        // Retrieve parameters
        String arg0 = intent.getStringExtra("arg0");
		int arg1 = intent.getIntExtra("arg1",0);
        
        // Setup event handler on action button
        _btn = (Button)findViewById(R.id.action1); 
       	_btn.setOnClickListener(this); 
        _btn = (Button)findViewById(R.id.action2); 
       	_btn.setOnClickListener(this); 
        _btn = (Button)findViewById(R.id.action3); 
       	_btn.setOnClickListener(this); 
       	
       	// Get reference on the output textview
		_output = (TextView)findViewById(R.id.outputzone);
    }

	// Any click on this screen will invoke this handler 
	@Override
	public void onClick(View btn) {
		// Let's see which action must be performed
		switch (btn.getId()) 
		{
		case R.id.action1: // 
			LimaDb myDb = new LimaDb("http://192.168.0.4");
			Log.i ("LIMA","Test Db connection");
			if (!myDb.connectionIsOK())
			{
				Toast.makeText(getApplicationContext(), "Echec de la connexion � la base de donn�es",Toast.LENGTH_LONG).show();
				return;
			}
			Log.i ("LIMA","Db connection OK");

			int n = myDb.executeQuery("SELECT * FROM article");
			if(n > 0)
			{
				_output.setText("S�lectionn� "+n+" enregistrement(s)\n");
				while (myDb.moveNext())
				{
					append ("Nom:"+myDb.getField("articlename"));
				}
			}
			
			break;
		case R.id.action2: // 
			Time now = new Time();
			now.setToNow();
			append(now.toString());
			break;
		case R.id.action3: // 
			append("click3");
			try {
				Student toto = new Student("Toto","xs", 2012);
				toto.setBirthDate(new Date(2000,4,25));
				append("Dump toto: "+toto.dump());
			} catch (Exception e) {
				append("Exception: "+e.getMessage());
				Log.i ("LIMA","Exception: "+e.getMessage());
			}
			break;
		}
	}
	
	// Append a new line at the end of the display
	private void append(String l)
	{
		_output.setText(_output.getText()+"\n"+l);
	}
		
}
