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
	
	Gear[] equipment = new Gear[15]; 

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
        _btn = (Button)findViewById(R.id.action4); 
       	_btn.setOnClickListener(this); 
       	
       	// Get reference on the output textview
		_output = (TextView)findViewById(R.id.outputzone);
		
		// Initialize array
		equipment[0] = new Gear ("Blouse", "t vo", "HM", 72.0, 8.25, 0, false, "XS");
		equipment[1] = new Gear ("Blouse", "é.  ", "HM", 72.0, 8.25, 0, false, "XXS");
		equipment[2] = new Gear ("Blouse", "uxe,", "Armani", 72.0, 8.25, 0, false, "M");
		equipment[3] = new Gear ("Pantalon", " n'e", "HM", 72.0, 8.25, 0, false, "L");
		equipment[4] = new Gear ("Pantalon", "u'or", "Armani", 72.0, 8.25, 0, false, "S");
		equipment[5] = new Gear ("Blouse", " cal", "HM", 72.0, 8.25, 0, false, "S");
		equipment[6] = new Gear ("Pantalon", "Là, ", "HM", 72.0, 8.25, 0, false, "XXL");
		equipment[7] = new Gear ("Pantalon", "dre ", "Armani", 72.0, 8.25, 0, false, "XS");
		equipment[8] = new Gear ("Pantalon", "et b", "HM", 72.0, 8.25, 0, false, "X");
		equipment[9] = new Gear ("Pantalon", "st q", "Armani", 72.0, 8.25, 0, false, "M");
		equipment[10] = new Gear ("Blouse", "eaut", "HM", 72.0, 8.25, 0, false, "XL");
		equipment[11] = new Gear ("Blouse", "me e", "Armani", 72.0, 8.25, 0, false, "S");
		equipment[12] = new Gear ("Blouse", "é, l", "Armani", 72.0, 8.25, 0, false, "L");
		equipment[13] = new Gear ("Pantalon", "tout", "HM", 72.0, 8.25, 0, false, "XL");
		equipment[14] = new Gear ("Blouse", "lupt", "Armani", 72.0, 8.25, 0, false, "XS");
    }

	// Any click on this screen will invoke this handler
	@Override
	public void onClick(View btn) {
		// Let's see which action must be performed
		switch (btn.getId()) 
		{
		case R.id.action1: // Afficher
			_output.setText("Liste de equipment:");
			String check = "";
			for (int i=0; i<equipment.length; i++)
			{
				_output.setText(_output.getText()+"\n"+equipment[i].dump());
				check += equipment[i].getNumber();
			}
			_output.setText(_output.getText()+"\n\nContrôle: "+check);
			break;
		case R.id.action2: // Trier
			
			for (int i=0; i<equipment.length-2; i++)
				for (int cmp=equipment.length-1; cmp > i; cmp--)
					if (equipment[i].compareTo(equipment[cmp]) < 0)
					{
						Gear temp = equipment[i];
						equipment[i] = equipment[cmp];
						equipment[cmp] = temp;
					}
			_output.setText("Tri terminé");
			break;
		case R.id.action3: // Mélanger
			
			for (int i=0; i<equipment.length-1; i++)
			{
				int r = (int)(Math.floor(Math.random() * equipment.length));
				Gear temp = equipment[i];
				equipment[i] = equipment[r];
				equipment[r] = temp;
			}
			_output.setText("Mélange terminé");
			break;
		case R.id.action4: // Rechercher
			
			Gear quid = new Gear ("Pantalon", "Là, ", "HM", 72.0, 8.25, 0, false, "XXL");

			int count = 0;
			
			for (int i=0; i<equipment.length-1; i++)
				if (equipment[i].compareTo(quid) == 0) count++;
			
			_output.setText("Trouvé "+count+ " fois "+ quid.dump()+ " dans la liste");
			break;
		}
	}
		
}
