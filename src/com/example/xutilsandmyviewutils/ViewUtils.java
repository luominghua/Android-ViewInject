package com.example.xutilsandmyviewutils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class ViewUtils {

	public static void inject(Activity activity) {
		bindView(activity);
		bindOnClick(activity);
	}

	//绑定控件
	private static void bindOnClick(Activity activity) {
		Class<? extends Activity> clazz = activity.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			ViewInject viewInject = field.getAnnotation(ViewInject.class);
			if (viewInject != null) {
				int resId = viewInject.value();
				View view = activity.findViewById(resId);
				field.setAccessible(true);
				try {
					field.set(activity, view);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	//绑定点击事件
	private static void bindView(final Activity activity) {
		Class<? extends Activity> clazz = activity.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for (final Method method : methods) {
			OnClick onClick = method.getAnnotation(OnClick.class);
			if (onClick != null) {
				int resId = onClick.value();
				final View view = activity.findViewById(resId);
				view.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						try {
							method.setAccessible(true);
							method.invoke(activity, view);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		}
	}

}
