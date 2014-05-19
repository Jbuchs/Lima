package cpnv.jav1.lima;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.util.zip.Inflater;
>>>>>>> fe11ee8296219a2d6d2ffaeb07fb18e16ba91e14

import cpnv.jav1.lima.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DebugActivity extends Activity 
				   implements OnClickListener {

	// References on the controls of this activity
	private Button _btn;
	private TextView _output;
	

    // Create activity event handler
	@Override
    public void onCreate(Bundle savedInstanceState) {
		// Initialize and display view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug);
        
        // Log messages (to logcat)
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
       	_btn = (Button)findViewById(R.id.btnEFY); 
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
		case R.id.action1: // Add timestamp to the debug text
			Book book = Book.findOneById(1);
			ArrayList<Book> books = Book.findAll();
			
			for (Book book2 : books) {
				_output.setText(_output.getText()+book2.dump()+"\n");
			}
			
			//_output.setText(book.dump());
			break;
		case R.id.action2: // get data from web service using POST
			_output.setText(_output.getText()+"\nAction 2");
			break;
		case R.id.action3: // Read button text from external file
			_output.setText(_output.getText()+"\nAction 3");
			break;
		case R.id.btnEFY: // Read button text from external file
			Intent intentEFY = new Intent(this, DebugActivityEFY.class);
			startActivity(intentEFY);
			break;
		}
	}
		
}
