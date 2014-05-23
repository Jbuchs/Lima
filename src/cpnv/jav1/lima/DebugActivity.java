package cpnv.jav1.lima;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
			LimaDb myDb = new LimaDb("http://192.168.0.10");
			Log.i ("LIMA","Test Db connection");
			if (myDb.connectionIsOK())
				Log.i ("LIMA","Success");
			else
				Log.i ("LIMA","Failure");
			List<Article> articles = myDb.limaSelect("Select * from article",Article.class);
			append("List<Article>:");
			Iterator<Article> i = articles.iterator();
			while(i.hasNext())
			{
				Article a = (Article) i.next();
				append("Article: "+a.getName()+", no "+a.getNumber());
			}
			break;
		case R.id.action2: // 
			Teacher Jack = null;
			try {
				Jack = new Teacher("Jack", "Sparrow", new Date(1916,4,25), "Piraterie");
				append(Jack.dump());
			} catch (LimaException e1) {
				Log.i ("LIMA","Exception: "+e1.getMessage());
			}
		    break;
		case R.id.action3: // 
			append("click3");
			Gear g1 = new Gear ("Blouse", "b1", "HM", 72, 8.25, 0, false, "XS");
			Gear g2 = new Gear ("Blouse", "b2", "HM", 72, 8.25, 0, false, "S");
			Gear g3 = new Gear ("Blouse", "b3", "HM", 72, 8.25, 0, false, "M");
			Gear g4 = new Gear ("Blouse", "b4", "HM", 72, 8.25, 0, false, "M");
			Gear g5 = new Gear ("Blouse", "b5", "HM", 72, 8.25, 0, false, "XL");
			
			append ("Comparaison g1/g2: "+g1.compareTo(g2));
			append ("Comparaison g1/g3: "+g1.compareTo(g3));
			append ("Comparaison g3/g4: "+g3.compareTo(g4));
			append ("Comparaison g4/g5: "+g4.compareTo(g5));
			append ("Comparaison g5/g1: "+g5.compareTo(g1));
			append ("Comparaison g2/g3: "+g2.compareTo(g3));
			append ("Comparaison g2/g4: "+g2.compareTo(g4));
			break;
		}
	}
	
	private String getClassDetails(Object o)
	{
        return o.getClass().getName()+"\n"+getAllFields(o.getClass());
	}
	
	private String getAllFields(Class C)
	{
		String res = null;
		Class sc = C.getSuperclass();
		if (sc != null) res = getAllFields(sc);
        for (Field field : C.getDeclaredFields())
        {
        	String sf = field.getName()+" ("+field.getType().getSimpleName()+")";
        	if (res == null)
        		res = sf;
        	else
        		res += "\n"+sf;
        }
        return res;
	}
	
	/** Append a new line at the end of the display
	 * 
	 * @param l
	 * Message to display
	 */
	private void append(String l)
	{
		_output.setText(_output.getText()+"\n"+l);
	}
		
}
