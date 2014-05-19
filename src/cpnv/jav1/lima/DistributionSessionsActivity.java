package cpnv.jav1.lima;

import cpnv.jav1.lima.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;

public class DistributionSessionsActivity extends Activity implements OnClickListener{

	private TextView _distriTitle;
	private Spinner _spinnerYear;
	private Button _toClass;
	
	public void onCreate(Bundle savedInstanceState) {
		// Initialize and display view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.distributionsessions);
        
        _distriTitle = (TextView)findViewById(R.id.DistriSessionTitle);
        _spinnerYear = (Spinner)findViewById(R.id.DistriSessionSpinner);
        _toClass = (Button)findViewById(R.id.DistriToClass);
        _toClass.setOnClickListener(this);  
        
        
        
        // Setup event handler on debug button
        /*spinner = 
        _btn = (Button)findViewById(R.id.cmdMainDebug); 
       	_btn.setOnClickListener(this);        

       	// Setup event handler textviews (application buttons)
       	_cmdMainValidation = (TextView)findViewById(R.id.cmdMainValidation);
       	_cmdMainValidation.setOnClickListener(this);        
       	_cmdMainInventory = (TextView)findViewById(R.id.cmdMainInventory);
       	_cmdMainInventory.setOnClickListener(this);        
       	_cmdMainDistribution = (TextView)findViewById(R.id.cmdMainDistribution);
       	_cmdMainDistribution.setOnClickListener(this);       */ 
    }
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch (_toClass.getId()) 
		{
		case R.id.DistriToClass: // Debug button -> switch to debug activity
			Intent myIntent = new Intent(DistributionSessionsActivity.this, DistributionSessionsClassActivity.class);
			// Let's pass some parameters to the debug activity
			myIntent.putExtra("arg0", "arg0 is a string value, unlike arg1, which is an integer");
			myIntent.putExtra("arg1", 5);
			// Call the activity
			DistributionSessionsActivity.this.startActivity(myIntent);			
			break;
		}
	}
	
	
}
