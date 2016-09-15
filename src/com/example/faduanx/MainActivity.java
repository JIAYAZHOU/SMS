package com.example.faduanx;

import java.util.ArrayList;

import android.R.array;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	private EditText etnum;
	private EditText ettext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etnum = (EditText)findViewById(R.id.editText1);
		ettext = (EditText)findViewById(R.id.editText2);
		
		Button button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(this);
	
	}
	
	@Override
	public void onClick(View v) {
		
		String num=etnum.getText().toString().trim();
		String text=ettext.getText().toString().trim();
		
		if (TextUtils.isEmpty(num)) {
			Toast.makeText(this, "µç»°ºÅÂëÎª¿Õ", 0).show();
			return;
			
		} else {
			
			SmsManager smsManager = SmsManager.getDefault();
			ArrayList<String> texts = smsManager.divideMessage(text);
			for(String str : texts)
			{smsManager.sendTextMessage(num, null, text, null, null);}
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
