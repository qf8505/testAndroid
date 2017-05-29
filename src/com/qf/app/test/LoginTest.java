package com.qf.app.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.robotium.solo.Solo;

public class LoginTest extends ActivityInstrumentationTestCase2 {
	private Solo solo;
	/**
	 * 注意以下两个静态常量字符串 第一个是要测试的包名，和刚刚在AndroidMainfest里配置的包名一直 手机自动化之
	 * Robotium--从入门到精通 39 第二是被测程序的入口类 以下是的包名和入口类
	 */
	private static final String TARGET_PACKAGE_ID = "com.kokozu.hengdian";
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.kokozu.ui.ActivityLoading";
	// 声明一个Class类型的变量，用于ActivityInstrumentationTestCase2加载启动被测程序
	private static Class launcherActivityClass;
	// 静态加载auncherActivityClass也就是被测程序主类
	static {
		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// 构造函数，传入TARGET_PACKAGE_ID,launcherActivityClass即可
	public LoginTest() {
		super(TARGET_PACKAGE_ID, launcherActivityClass);
	}

	@Before
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@After
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	@Test
	public void test_login() {
		/**
		 * 登录功能测试
		 */
		solo.clickOnRadioButton(1);
		solo.sleep(1000);
		solo.clickOnButton(2);
		solo.sleep(1000);
		solo.clickOnImage(0);
		solo.sleep(1000);
		solo.clickOnRadioButton(0);
		solo.sleep(1000);
		solo.clickOnText("我的");
		solo.sleep(1000);
		solo.enterText(0, "15010390293");
		solo.enterText(1, "qinfei");
		solo.clickOnButton("登录");
		solo.sleep(2000);
		solo.clickOnImage(0);
		solo.sleep(1000);
		solo.clickOnRadioButton(0);
		solo.sleep(1000);
		solo.clickOnView(solo.getView("com.kokozu.hengdian:id/lay_select_city"));
		solo.sleep(1000);
		solo.clickOnButton(2);
		solo.sleep(1000);
		solo.clickOnImage(1);
		solo.sleep(1000);
		List<ListView> list=solo.getCurrentViews(ListView.class);
		LinearLayout l=(LinearLayout) list.get(0).getChildAt(0);
		RelativeLayout la=(RelativeLayout) l.getChildAt(0);
		TextView t=(TextView) la.findViewById(0);
		solo.clickOnView(t);
		solo.sleep(5000);
		Button button = solo.getButton(0);
		button.callOnClick();
	}
}