package cpnv.jav1.lima;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class InventoryActivity extends Activity implements OnClickListener {

	TableLayout table_layout;
	EditText rowno_et, colno_et;
	Button build_btn;
	int rownb = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory);

		build_btn = (Button) findViewById(R.id.btnAddRow);

		build_btn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		table_layout = (TableLayout) findViewById(R.id.tableLayoutInventory);

		TableRow row = new TableRow(this);
		//row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,	LayoutParams.WRAP_CONTENT));
		rownb++;
		
		TextView tv = new TextView(this);
		tv.setId(1000+rownb*10+1);
		tv.setText("ID, row "+rownb);
		tv.setHeight(26);
		tv.setTextSize(22);
		tv.setTextColor(Color.RED);
		row.addView(tv);
		
		TextView tv2 = new TextView(this);
		tv2.setId(1000+rownb*10+2);
		tv2.setHeight(26);
		tv2.setTextSize(22);
		tv2.setTextColor(Color.RED);
		tv2.setText("Title, row "+rownb);
		row.addView(tv2);
		
		table_layout.addView(row);
		
		Log.i ("LIMA","Add row. There are now "+table_layout.getChildCount()+" rows");
		
		/*
		// First, get the reference to the TableLayout
		TableLayout summary = (TableLayout) findViewById(R.id.summary);

		// I remove all views before filling it because it can be reused
		table_layout.removeAllViews();

		// I use a for loop to iterate through a Map of data, named speedOverTime
		for (int i=1; i<=3;i++) {

		    // I create a new TableRow each time and I don't need to set the layout parameters
		    TableRow row = new TableRow(this);

		    // I get 3 new TextView's each time and add them right away
		    row.addView(getNewCell("R"+i+"C1"));
		    row.addView(getNewCell("R"+i+"C2"));
		    row.addView(getNewCell("R"+i+"C3"));

		    table_layout.addView(row);
		}
		*/

	}
	// The method getNewCell is a utility method really
	private TextView getNewCell(String content) {
	    // The TextView's don't need the layout params either
	    TextView tv = new TextView(this);
	    tv.setText(content);

	    return tv;
	}

}
