package cpnv.jav1.lima;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DebugActivityEFY extends Activity 
				   implements OnClickListener {

	// References on controls of this activity
	private Button _btn;
	private TextView _output;
	private String out;
	

    // Create activity event handler
	@Override
    public void onCreate(Bundle savedInstanceState) {
		// Initialize and display view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug_efy);
        
        // Log messages (to logcat)
        Log.i ("LIMA", "Started debug activity");
        // Retrieve the intent that invoked us
        Intent intent = getIntent();
        // Retrieve parameters
        String arg0 = intent.getStringExtra("arg0");
		int arg1 = intent.getIntExtra("arg1",0);
        
        // Setup event handler on action button
        _btn = (Button)findViewById(R.id.actionEFY); 
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
		case R.id.actionEFY: // Add timestamp to the debug text
			out = "";
			LimaDb db = new LimaDb("http://192.168.0.4");
			db.executeQuery("SELECT * FROM person");
			
			while (db.moveNext()){
				out += db.getField("personfirstname")+ "\n";
				Log.i ("LIMA", db.getField("personfirstname"));
			}
			
			_output.setText(out);
			break;
		}
	}
		
}
