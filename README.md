# Android-ViewInject
this is ShenZhen city itheima android class 31 in china for me

#Android����day12-�����£�&�����Ի���
***
##1. Android�н��̵����ࣨ*��
1. Foreground Process
	1. ӵ��һ������Resumed״̬��Activity�Ľ���.
2. Visisable Process
	1. ӵ��һ������Paused״̬��Activity�Ľ���.
3. Service Process
	1. ӵ��һ��ͨ��startService�������������Ľ���.
4. Background Process
	1. ӵ��һ������ֹͣ״̬��Activity.���ϵͳ�ڴ治����,�ͻᱻɱ��.
5. Empty Progcess
	1. ��ӵ���κ��������е��Ĵ����.��ϵͳ��Ҫ�ڴ��ɱ����.
	2. Android�����ս��̵�ΨһĿ����Ϊ�˻���,�´������ͺܿ�.�����ռ任ʱ��.

##2. Service������������ʽ&�������ڣ�***��
1. startService
	1. onCreate 
	2. onStartCommand(ûִ��һ��startService�ͱ�����һ��)
	3. onDestroy

2. bindService :���Activity��Service�򵥵İ���,��ô��Activity���ٵ�ʱ��,ServiceҲ�ᱻ����.
	1. onCreate
	2. onBind 
	3. �����Service��Activity��������ô:
	4. onUnbind
	5. onDestory

3. startService+bindService+unBindService
	1. onCreate
	2. onStartCommand
	3. onBind
	4. onUnbind
	5. ������stopService��ʱ��Ż�onDestroy.
	
##3. Activity��Service�Ľ�����ʽ(bindService)��**��
1. Extending the Binder class(��Ҫ��ϰ����)
	����-���ֲ�����
2. Using a Messenger(����)

3. Using AIDL(����ʵ��һ��App�е�Activity������һ��App�е�Service֮��ͨ��)
	1. aidl : Android Interface Definition  Language Android�ӿڶ�������.
	2. IPC : inner Process Communication ���̼�ͨ��.

	����-(����(MainActivity)-֧����(AlipayService))(��������ϰ����)

##4. �����Ի���***��
������:AlertDialog
������:ProgressDialog

1. �쳣(�Ի���ֻ��ʹ��Activity�ĶԻ���)

		08-24 07:23:15.006: E/AndroidRuntime(2252): Caused by: android.view.WindowManager$BadTokenException: Unable to add window -- token null is not for an application
		08-24 07:23:15.006: E/AndroidRuntime(2252): 	at android.view.ViewRootImpl.setView(ViewRootImpl.java:589)
		08-24 07:23:15.006: E/AndroidRuntime(2252): 	at android.view.WindowManagerImpl.addView(WindowManagerImpl.java:326)
		08-24 07:23:15.006: E/AndroidRuntime(2252): 	at android.view.WindowManagerImpl.addView(WindowManagerImpl.java:224)
		08-24 07:23:15.006: E/AndroidRuntime(2252): 	at android.view.WindowManagerImpl$CompatModeWrapper.addView(WindowManagerImpl.java:149)

	
2. ȷ����ȡ���Ի���
3. ��ѡ�Ի���
4. ��ѡ�Ի���
5. �������Ի���

	
			int i = 0;
			public void showHorizontalProgressDialog(View view){
				i = 0;
				final ProgressDialog progressDialog = new ProgressDialog(this);
				progressDialog.setIcon(R.drawable.iv8);
				progressDialog.setTitle("���ص�Ӱ");
				progressDialog.setMessage("���Ժ�");
				progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				progressDialog.show();
				
				progressDialog.setMax(100);
				
				handler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						if (i>=100) {
							progressDialog.dismiss();
						}else {
							progressDialog.setProgress(i++);
							//�ݹ����
							handler.postDelayed(this, 100);
						}
					}
				}, 100);
			}			
			

##5. ��ʽ�����⣨*��
1. ��ʽ:��ʵ���ǰѿؼ���ͨ�õ����Գ�ȡ����ʽ�ļ���.
2. ��ʽ�ļ̳�
	1. ͨ��parent

			 <style name="MySmallTextView" parent="MyTextView">
	         <item name="android:textSize">18sp</item>
		    </style>

	2. ͨ�� ����ʽ��.����ʽ��
		
			<style name="MySmallTextView.Yellow">
       			 <item name="android:textColor">#ffff00</item>
   			 </style>

3. ����:Ҳ����ʽ,ֻ������ʽ���ÿؼ�ʹ�õ�,��������Activityʹ�õ�.
	
		 <style name="AppTheme.PINK">
	        <item name="android:background">#ff69b4</item>
	        <item name="android:windowFullscreen">true</item>
	         <item name="android:windowNoTitle">true</item>
    		</style>
	
##6. ���ʻ���*��
i18n:internationalization 
1. ���ֵĹ��ʻ�
2. ͼƬ�Ĺ��ʻ�


##7. www.stackOverFlow.com


##8. Android��Context����

	https://possiblemobile.com/2013/06/context/(*****)

1. Activity  һ��Activity��Ӧһ��Context
2. Service һ��Service��Ӧһ��Context
3. BroadCastReceiver �е�onReceive(Context ) ����ִ��������,�����Context������
4. getApplicationContext  ֻҪApp�Ľ�����,��Context��һֱ����