package cpnv.jav1.lima;

import java.util.ArrayList;
import java.util.zip.Inflater;

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
	
	Gear[] blouses = new Gear[15]; 

    // Create activity event handler
	@Override
    public void onCreate(Bundle savedInstanceState) {
		// Initialize and display view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug);
        
        final String résultat = ""; 
        // Setup event handler on action button
        _btn = (Button)findViewById(R.id.action1); 
       	_btn.setOnClickListener(this); 
        _btn = (Button)findViewById(R.id.action2); 
       	_btn.setOnClickListener(this); 
        _btn = (Button)findViewById(R.id.action3); 
       	_btn.setOnClickListener(this); 
       	
       	// Get reference on the output textview
		_output = (TextView)findViewById(R.id.outputzone);
		
		// Initialize array
		blouses[0] = new Gear ("Blouse bleue", "t vo", "HM", 72.0, 8.25, 0, false, "XS");
		blouses[1] = new Gear ("Blouse bleue", "é.  ", "HM", 72.0, 8.25, 0, false, "XXS");
		blouses[2] = new Gear ("Blouse bleue", "uxe,", "Armani", 72.0, 8.25, 0, false, "M");
		blouses[3] = new Gear ("Blouse verte", " n'e", "HM", 72.0, 8.25, 0, false, "L");
		blouses[4] = new Gear ("Blouse verte", "u'or", "Armani", 72.0, 8.25, 0, false, "S");
		blouses[5] = new Gear ("Blouse bleue", " cal", "HM", 72.0, 8.25, 0, false, "S");
		blouses[6] = new Gear ("Blouse verte", "Là, ", "HM", 72.0, 8.25, 0, false, "XXL");
		blouses[7] = new Gear ("Blouse verte", "dre ", "Armani", 72.0, 8.25, 0, false, "XS");
		blouses[8] = new Gear ("Blouse verte", "et b", "HM", 72.0, 8.25, 0, false, "X");
		blouses[9] = new Gear ("Blouse verte", "st q", "Armani", 72.0, 8.25, 0, false, "M");
		blouses[10] = new Gear ("Blouse bleue", "eaut", "HM", 72.0, 8.25, 0, false, "XL");
		blouses[11] = new Gear ("Blouse bleue", "me e", "Armani", 72.0, 8.25, 0, false, "S");
		blouses[12] = new Gear ("Blouse bleue", "é, l", "Armani", 72.0, 8.25, 0, false, "L");
		blouses[13] = new Gear ("Blouse verte", "tout", "HM", 72.0, 8.25, 0, false, "XL");
		blouses[14] = new Gear ("Blouse bleue", "lupt", "Armani", 72.0, 8.25, 0, false, "XS");
    }

	// Any click on this screen will invoke this handler
	@Override
	public void onClick(View btn) {
		// Let's see which action must be performed
		switch (btn.getId()) 
		{
		case R.id.action1: // Afficher
			_output.setText("Liste de blouses:");
			String check = "";
			for (int i=0; i<blouses.length; i++)
			{
				_output.setText(_output.getText()+"\n"+blouses[i].dump());
				check += blouses[i].getNumber();
			}
			_output.setText(_output.getText()+"\n\nContrôle: "+check);
			break;
		case R.id.action2: // Trier
			
			for (int i=0; i<blouses.length-2; i++)
				for (int bulle=blouses.length-1; bulle > i; bulle--)
					if (blouses[i].compareTo(blouses[bulle]) < 0)
					{
						Gear temp = blouses[i];
						blouses[i] = blouses[bulle];
						blouses[bulle] = temp;
					}
			_output.setText("Tri terminé");
			break;
		case R.id.action3: // Mélanger
			
			for (int i=0; i<blouses.length-1; i++)
			{
				int bulle = (int)(Math.floor(Math.random() * blouses.length));
				Gear temp = blouses[i];
				blouses[i] = blouses[bulle];
				blouses[bulle] = temp;
			}
			_output.setText("Mélange terminé");
			break;
		}
	}
		
}
