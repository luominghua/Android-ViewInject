package com.example.xutilsandmyviewutils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@ViewInject(R.id.tv3)
	private TextView tv3;
	private String result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		ViewUtils.inject(this);
		Intent intent = getIntent();
		result = intent.getStringExtra("msg");
		
	}
	
	@OnClick(R.id.btn2)
	public void start(View view) {
		tv3.setText(result);
	}

}
