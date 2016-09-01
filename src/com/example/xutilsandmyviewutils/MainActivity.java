package com.example.xutilsandmyviewutils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 自定义框架(注解加反射类型IOC容器依赖注入的思想 Reverse of Control)
 * @author lmh
 * @date 2016年8月21日
 */
public class MainActivity extends Activity {
	@ViewInject(R.id.tv1)
	private TextView tv1;
	@ViewInject(R.id.tv2)
	private TextView tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ViewUtils.inject(this);
	}
	
	@OnClick(R.id.btn)
	public void myClick(View view) {
		tv1.setText("我是一");
		tv2.setText("我是二");
		Toast.makeText(this, "我被点击了哈...", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("msg", "来了");
		startActivity(intent);
	}

}
