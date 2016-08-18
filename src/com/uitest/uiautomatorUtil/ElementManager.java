package com.uitest.uiautomatorUtil;

import android.graphics.Rect;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.uitest.cmp.EditText;
import com.uitest.log.UiAutomationLogManager;

/**
 * 用于页面元素管理，等待页面元素，判断页面元素是否存在、是否被显示等。
 * 
 * 日志记录： 版本 日期 修改者 更新内容 1.0 2016-06-04 cbh 模块重新整理
 * 
 */

public class ElementManager extends UiAutomatorTestCase{
	// 时间(ms)
	public static long MAXRUNTIME = 60000;
	public static long MIDRUNTIME = 45000;
	public static long MINRUNTIME = 10000;

	// //////////////////////////判断元素是否存在模块/////////////////////////

	/**
	 * 页面是否存在控件，通过控件对象
	 * 
	 * @param uo
	 * @return
	 */
	public static boolean elementExist(UiObject uo) {
		// System.out.println("elementExist");
		if (uo.exists()) {
			System.out.println("elementExist: true");
			return true;
		} else {
			System.out.println("elementExist: false");
			return false;
		}
	}

	/**
	 * 页面是否存在控件，通过ID
	 */
	public static boolean isExistById(String id) {
		System.out.println("isExistById: " + id);
		return elementExist(getUiObjectByResourceIdMatches(id));
	}

	/**
	 * 页面是否存在控件，通过desc
	 */
	public static boolean isExistByDesc(String desc) {
		System.out.println("isExistByDesc: " + desc);
		return elementExist(getUiObjectByDescriptionMatches(desc));

	}

	/**
	 * 页面是否存在控件，通过Classname
	 */
	public static boolean isExistByClassName(String name) {
		System.out.println("isExistByClassName: " + name);
		return elementExist(getUiObjectByClassNameMatches(name));
	}

	/**
	 * 页面是否存在控件，通过name
	 */
	public static boolean isExistByName(String name) {
		System.out.println("isExistByName: " + name);
		return elementExist(getUiObjectByText(name));
	}

	/**
	 * 获取ID控件下的，匹配文本的控件
	 */
	public static boolean isExistByIdAndName(String id, String name) {
		System.out.println("isExistByIdAndName: " + id);
		UiObject uo;
		uo = new UiObject(new UiSelector().resourceIdMatches(".*" + id).text(
				name));
		return elementExist(uo);
	}

	// ///////////////////////获取通过各种途径获取页面元素////////////////////////////

	/**
	 * 需求：根据文本获取UiObject对象
	 * 
	 * @param text
	 * @return
	 */
	public static UiObject getUiObjectByText(String text) {
		return new UiObject(new UiSelector().textContains(text));
	}

	/**
	 * 需求：根据文本获取UiObject对象
	 * 
	 * @param text
	 * @return
	 */
	public static UiObject getUiObjectByTextMatches(String text) {
		return new UiObject(new UiSelector().textMatches(".*" + text));
	}

	/**
	 * 需求：根据资源ID出获取UiObject对象
	 * 
	 * @param text
	 * @return
	 */
	public static UiObject getUiObjectByResourceId(String id) {
		return new UiObject(new UiSelector().resourceId(id));
	}

	/**
	 * 需求：根据资源ID获取UiObject对象
	 * 
	 * @param text
	 * @return
	 */
	public static UiObject getUiObjectByResourceIdMatches(String id) {
		return new UiObject(new UiSelector().resourceIdMatches(".*" + id));
	}

	/**
	 * 需求：根据ClassName获取UiObject对象
	 * 
	 * @param text
	 * @return
	 */
	public static UiObject getUiObjectByClassName(String classname) {
		return new UiObject(new UiSelector().className(classname));
	}

	/**
	 * 需求：根据ClassName获取UiObject对象
	 * 
	 * @param text
	 * @return
	 */
	public static UiObject getUiObjectByClassNameMatches(String classname) {
		return new UiObject(new UiSelector().classNameMatches(".*" + classname));
	}

	/**
	 * 需求：根据description获取UiObject对象
	 * 
	 * @param text
	 * @return
	 */
	public static UiObject getUiObjectByDescription(String desc) {
		return new UiObject(new UiSelector().description(desc));
	}

	/**
	 * 需求：根据description获取UiObject对象
	 * 
	 * @param text
	 * @return
	 */
	public static UiObject getUiObjectByDescriptionMatches(String desc) {
		return new UiObject(new UiSelector().descriptionMatches(".*" + desc));
	}

	/**
	 * 需求：根据资源ID获取UiObject对象
	 * 
	 * @param text
	 * @return
	 */
	public static UiObject getUiObjectByResourceIdMatchesIndex(String id,
			int index) {
		return new UiObject(new UiSelector().resourceIdMatches(".*" + id)
				.index(index));
	}

	/**
	 * 通过根、子类型和第几个元素，准确获取对象
	 * 
	 * @param id
	 * @param destClass
	 * @param num
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject getUiObjectByIdClass(String id, String destClass,
			int num) throws UiObjectNotFoundException {
		return getSameClassObjectMatches("id", id, "class", destClass, num);

	}

	/**
	 * 通过根、子类型和第几个元素，准确获取对象
	 * 
	 * @param rootid
	 * @param id
	 * @param num
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject getUiObjectByIdId(String rootid, String id, int num)
			throws UiObjectNotFoundException {
		return getSameClassObjectMatches("id", rootid, "id", id, num);
	}

	/**
	 * 通过根、子类型和第几个元素，准确获取对象
	 * 
	 * @param rootClass
	 * @param destClass
	 * @param num
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject getUiObjectByClassClass(String rootClass,
			String destClass, int num) throws UiObjectNotFoundException {
		return getSameClassObjectMatches("class", rootClass, "class",
				destClass, num);
	}

	/**
	 * 通过根、子类型和第几个元素，准确获取对象
	 * 
	 * @param rootClass
	 * @param id
	 * @param num
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject getUiObjectByClassId(String rootClass, String id,
			int num) throws UiObjectNotFoundException {
		return getSameClassObjectMatches("class", rootClass, "id", id, num);

	}

	/**
	 * 通过根路径、子路径还有 第几个，获取对象
	 * 
	 * @param type1
	 *            根路径的类型
	 * @param root
	 *            根路径名字
	 * @param type2
	 *            子路径的类型
	 * @param sub
	 *            子路径的名字
	 * @param num
	 *            第几个
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject getSameClassObject(String type1, String root,
			String type2, String sub, int num) throws UiObjectNotFoundException {

		UiCollection collection = null;
		UiObject CheckObject = null;
		if (type1.equals("class")) {
			collection = new UiCollection(new UiSelector().className(root));
		} else if (type1.equals("id")) {
			collection = new UiCollection(new UiSelector().resourceId(root));
		} else if (type1.equals("text")) {
			collection = new UiCollection(new UiSelector().text(root));
		}

		if (type2.equals("class")) {
			CheckObject = collection.getChildByInstance(
					new UiSelector().className(sub), num);
		} else if (type2.equals("id")) {
			CheckObject = collection.getChildByInstance(
					new UiSelector().resourceId(sub), num);
		} else if (type2.equals("text")) {
			CheckObject = collection.getChildByInstance(
					new UiSelector().text(sub), num);
		}
		return CheckObject;
	}

	/**
	 * 通过根路径、子路径还有 第几个，获取对象（使用正则表达式获取控件）
	 * 
	 * @param type1
	 * @param root
	 * @param type2
	 * @param sub
	 * @param num
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject getSameClassObjectMatches(String type1, String root,
			String type2, String sub, int num) throws UiObjectNotFoundException {

		UiCollection collection = null;
		UiObject CheckObject = null;
		if (type1.equals("class")) {
			collection = new UiCollection(
					new UiSelector().classNameMatches(".*" + root));
		} else if (type1.equals("id")) {
			collection = new UiCollection(
					new UiSelector().resourceIdMatches(".*" + root));
		} else if (type1.equals("text")) {
			collection = new UiCollection(new UiSelector().textContains(root));
		}

		if (type2.equals("class")) {
			CheckObject = collection.getChildByInstance(
					new UiSelector().classNameMatches(".*" + sub), num);
		} else if (type2.equals("id")) {
			CheckObject = collection.getChildByInstance(
					new UiSelector().resourceIdMatches(".*" + sub), num);
		} else if (type2.equals("text")) {
			CheckObject = collection.getChildByInstance(
					new UiSelector().textContains(sub), num);
		}
		return CheckObject;
	}

	/**
	 * 需求：根据ClassName,在搜索该布局下的匹配name的第一个控件。
	 * 
	 * @param name
	 */
	public static UiObject getUiObjectSearchByClassNameAndName(
			String className, String name) {
		System.out.println("getUiObjectSearchByClassNameAndName: " + className);
		UiCollection collection = new UiCollection(new UiSelector().index(0));
		UiObject CheckObject = null;
		try {

			for (int i = 0; i < 10; i++) {
				CheckObject = collection.getChildByInstance(
						new UiSelector().className(className), i);

				if (CheckObject.getText().equals(name)) {
					return CheckObject;
				}
			}
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		return CheckObject;
	}

	/**
	 * 获取同一ClassName下，最后一个匹配id类型的对象
	 * 
	 * @param id
	 * @param destClass
	 * @return
	 */
	public static UiObject getEndClassObjectById(String id, String destClass) {
		UiCollection collection = new UiCollection(
				new UiSelector().resourceId(id));
		UiObject CheckObject = null;

		int num1 = collection.getChildCount(new UiSelector()
				.className(destClass));

		System.out.println("cnt: " + num1);
		try {
			if (num1 == 0) {
				return null;
			} else {
				CheckObject = collection.getChildByInstance(
						new UiSelector().className(destClass), num1 - 1);
			}
		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();
		}
		return CheckObject;
	}

	/**
	 * 获取同一ClassName下，首个匹配id类型的对象
	 * 
	 * @param id
	 * @param destClass
	 * @return
	 */
	public static UiObject getStartClassObjectById(String id, String destClass) {
		UiCollection collection = new UiCollection(
				new UiSelector().resourceId(id));
		UiObject CheckObject = null;

		int num1 = collection.getChildCount(new UiSelector()
				.className(destClass));

		System.out.println("cnt: " + num1);
		try {
			if (num1 == 0) {
				return null;
			} else {
				CheckObject = collection.getChildByInstance(
						new UiSelector().className(destClass), 1);
			}
		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();
		}
		return CheckObject;
	}

	/**
	 * 获取同行对象，可以设置上下的偏移量
	 * 
	 * @param srcObject
	 * @param destClass
	 * @param upOffset
	 * @param dowmOffset
	 * @return
	 */
	public static UiObject getSameLineObject(UiObject srcObject,
			String destClass, int upOffset, int dowmOffset) {
		Rect r1;
		UiCollection collection = new UiCollection(new UiSelector().index(0));
		UiObject CheckObject = null;
		try {
			r1 = srcObject.getBounds();
			int y0 = r1.top + upOffset;
			int y1 = r1.bottom + dowmOffset;
			for (int i = 0; i < 10; i++) {
				CheckObject = collection.getChildByInstance(
						new UiSelector().className(destClass), i);
				Rect rect = CheckObject.getBounds();
				int centy = rect.centerY();
				if (centy > y0 && centy < y1) {
					return CheckObject;
				}
			}
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		return CheckObject;
	}

	/**
	 * 获取同行对象，可以设置上下的偏移量
	 * 
	 * @param srcObject
	 * @param destClass
	 * @param upOffset
	 * @param dowmOffset
	 * @return
	 */
	public static UiObject getSameLineObjectById(UiObject srcObject, String id,
			int upOffset, int dowmOffset) {
		Rect r1;
		UiCollection collection = new UiCollection(new UiSelector().index(0));
		UiObject CheckObject = null;
		try {
			r1 = srcObject.getBounds();
			int y0 = r1.top + upOffset;
			int y1 = r1.bottom + dowmOffset;
			for (int i = 0; i < 10; i++) {
				CheckObject = collection.getChildByInstance(
						new UiSelector().resourceId(id), i);
				Rect rect = CheckObject.getBounds();
				int centy = rect.centerY();
				if (centy > y0 && centy < y1) {
					return CheckObject;
				}
			}
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		return CheckObject;
	}

	/**
	 * 通过ID，获取textView的文本
	 * 
	 * @param id
	 * @return
	 */
	public static String getViewTextById(String id) {
		String txt = "";
		try {
			txt = getUiObjectByResourceIdMatches(id).getText();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		return txt;
	}

	/**
	 * 获取根据父rootclas下，匹配id类型的控件数量
	 * 
	 * @param className
	 * @return
	 */
	public static int getChildCountByClassId(String rootClass, String id) {
		UiCollection collection = new UiCollection(
				new UiSelector().classNameMatches(".*" + rootClass));
		int cnt = collection.getChildCount(new UiSelector()
				.resourceIdMatches(".*" + id));
		return cnt;
	}

	/**
	 * 获取根据父rootclas下，匹配subclass类型的控件数量
	 * 
	 * @param className
	 * @return
	 */
	public static int getChildCountByClassClass(String rootClass,
			String subClass) {
		UiCollection collection = new UiCollection(
				new UiSelector().classNameMatches(".*" + rootClass));
		int cnt = collection.getChildCount(new UiSelector()
				.classNameMatches(".*" + subClass));
		return cnt;
	}

	/**
	 * 获取屏幕中，匹配classname类型，第num个的控件
	 * 
	 * @param className
	 * @param num
	 * @return
	 */
	public static UiObject getAllViewByClassName(String className, int num) {
		UiCollection collection = new UiCollection(new UiSelector().index(0));
		try {
			return collection.getChildByInstance(
					new UiSelector().className(className), num);
		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 滑动列表，直到匹配到text为止，获取对象
	 * 
	 * @param text
	 * @return
	 */
	public static UiObject getUiObjectScrollListViewByText(String classname,
			String text) {
		UiScrollable scroll = new UiScrollable(
				new UiSelector().classNameMatches(".*" + classname));
		UiObject object = null;
		try {
			scroll.scrollTextIntoView(text);
			object = new UiObject(new UiSelector().text(text));
		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();
		}
		return object;
	}

	// 等待操作----------------------------------

	/**
	 * 等待资源ID存在
	 */
	public static boolean waitForExiststById(String id) {
		System.out.println("waitForExiststById: " + id);
		UiObject uo = getUiObjectByResourceIdMatches(id);
		if (uo.waitForExists(MINRUNTIME)) {
			System.out.println("waitForExiststById: true");
			return true;
		} else {
			System.out.println("waitForExiststById: false");
			return false;
		}
	}

	/**
	 * 等待资源ID消失
	 */
	public static boolean waitUntilGoneById(String id) {
		System.out.println("waitUntilGoneById: " + id);
		UiObject uo = getUiObjectByResourceIdMatches(id);
		if (uo.waitUntilGone(MINRUNTIME)) {
			System.out.println("waitUntilGoneById: true");
			return true;
		} else {
			System.out.println("waitUntilGoneById: false");
			return false;
		}
	}

	// /点击操作-------------------------------------

	/**
	 * 添加容错处理，添加操作日志的记录
	 * @param CLICK
	 * @param str
	 * @return
	 */
	public  boolean clickByInfo(int CLICK, String str) {
		UiObject uo;
		// switch根据不同的CLICK标识，创建出UiObject的对象
		switch (CLICK) {
		case 1:
			uo = getUiObjectByResourceIdMatches(str);
			break;
		case 2:
			uo = getUiObjectByText(str);
			break;
		default:
			return false;
		}

		// 判断该控件是否存在
		int i = 0;
		while (!uo.exists() && i < 5) {
			//SolveProblems();
			sleep(500);
			if (i == 4) {
				//TakeScreen(str + "-not-find");
				return false;
			}
			i++;
		}
		// 点击
		try {
			UiAutomationLogManager.UiAutomationLog("click type:" + CLICK + " content:" + str);
			uo.click();
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

	
	
	/**
	 * 通过坐标点击
	 * 
	 * @param x
	 * @param y
	 */
	public static void click(int x, int y) {

		UiDevice.getInstance().click(x, y);
	}

	/**
	 * 通过uiobject对象点击
	 * 
	 * @param uo
	 */
	public static void clickbyObject(UiObject uo) {
		// System.out.println("clickbyObject:");
		try {
			if (uo.exists()) {
				
				uo.click();
				// System.out.println("clicking finish");
			} else {

				System.out.println("uiobject not found");
			}
		} catch (UiObjectNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 需求：根据资源name点击Uiobject
	 * 
	 * @param name
	 */
	public static void clickByName(String name) {
		System.out.println("clickByName: " + name);
		clickbyObject(getUiObjectByTextMatches(name));
	}

	/**
	 * 需求：根据资源id点击Uiobject
	 * 
	 * @param id
	 */
	public static void clickById(String id) {
		System.out.println("clickById: " + id);

		clickbyObject(getUiObjectByResourceIdMatches(id));

	}

	/**
	 * 
	 * @param uo
	 */
	public static void clickLongByUiObject(UiObject uo) {
		System.out.println("start long click");
		if (!uo.exists()) {
			System.out.println("clickLongByUiObject null");
			return;
		}
		myLongClick(uo, 100);
		System.out.println("end long click");
	}

	/**
	 * 通过元素坐标，点击控件
	 * 
	 * @param uo
	 * @param step
	 */
	private static void myLongClick(UiObject uo, int step) {
		Rect buttonRect;
		try {
			buttonRect = uo.getBounds();
			// 滑动同一点
			UiDevice.getInstance().swipe(buttonRect.centerX(),
					buttonRect.centerY(), buttonRect.centerX(),
					buttonRect.centerY(), step);
		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 同类控件，根据num，获取按顺序的对象
	 * 
	 * @param srcObject
	 *            父类classname
	 * @param destClass
	 *            控件id
	 * @param num
	 *            第几个，从0开始
	 * @return
	 */
	public static void clickSameClassObjectByOne(String rootClass, String id,
			int num) {
		try {
			getUiObjectByClassId(rootClass, id, num).click();
		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 同类控件，根据num，获取按顺序的对象
	 * 
	 * @param srcObject
	 * @param destClass
	 * @return
	 */
	public static void clickSameClassObject(String type1, String rootClass,
			String styp2, String destClass, int num) {
		try {
			getSameClassObject(type1, rootClass, styp2, destClass, num).click();
		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 点击相同类型的对象，按顺序点击
	 * 
	 * @param srcObject
	 * @param id
	 * @return
	 */
	public static void clickSameClassObjectByMore(String rootClass, String id,
			int num) {
		for (int i = 0; i < num; i++) {
			clickSameClassObjectByOne(rootClass, id, i);
		}
	}

	public static void clickClassId(String root, String sub, int num) {
		try {
			getUiObjectByClassId(root, sub, num).click();
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickClassClass(String root, String sub, int num) {

		try {
			getUiObjectByClassClass(root, sub, num).click();
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickIdClass(String root, String sub, int num) {
		try {
			getUiObjectByIdClass(root, sub, num).click();
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickIdId(String root, String sub, int num) {
		try {
			getUiObjectByIdId(root, sub, num).click();
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 需求：根据ClassName和资源name点击Uiobject
	 */
	public static void clickSameTextByClassAndName(String className, String name) {
		try {
			getUiObjectSearchByClassNameAndName(className, name).click();
		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 滑动列表，并点击匹配txt的控件
	 * 
	 * @param classname
	 * @param text
	 */
	public static void clickWithScrollList(String classname, String text) {
		try {
			getUiObjectScrollListViewByText(classname, text).click();
		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 需求：点击资源ID，等待窗口更新
	 * 
	 * @param id
	 */
	public static void clickAndWaitForNewWindowById(String id) {
		System.out.println("clickAndWaitForNewWindowById: " + id);
		UiObject uo;
		try {
			uo = getUiObjectByResourceIdMatches(id);
			if (uo.exists()) {
				uo.clickAndWaitForNewWindow();
			} else {
				System.out.println("clickAndWaitForNewWindowById: " + id
						+ " not exists, return null");
			}
		} catch (Exception e) {
			System.out.println("[error] clickById");
		}
	}

	/**
	 * 点击屏幕中间
	 */
	public static void clickPageCenter() {
		int width = UiDevice.getInstance().getDisplayWidth();
		int height = UiDevice.getInstance().getDisplayHeight();
		UiDevice.getInstance().click(width / 2, height / 2);
	}

	// 输入操作--------------------------------------

	/**
	 * 获取对象，输入
	 * 
	 * @param uo
	 * @param content
	 */
	public static void inputText(UiObject uo, String content) {
		System.out.println("[start] inputText: " + content);
		if (!uo.exists()) {
			System.out.println("[end] can not find: ");
			return;
		}
		EditText.clearEditText(uo);
		EditText.setText(uo, content);
		System.out.println("[end] inputText: " + " , input: " + content);
	}

	/**
	 * 需求：根据控件name，输入内容
	 * 
	 * @param name
	 * @param content
	 */
	public static void inputTextByName(String name, String content) {
		System.out.println("[start] inputTextByName: " + name + " , input: "
				+ content);
		UiObject uo = getUiObjectByText(name);
		inputText(uo, content);

	}

	/**
	 * 需求：根据控件id，输入内容
	 * 
	 * @param id
	 * @param content
	 */
	public static void inputTextById(String id, String content) {
		System.out.println("[start] inputTextByName: " + id + " , input: "
				+ content);
		UiObject uo = getUiObjectByResourceIdMatches(id);
		inputText(uo, content);
	}

	/**
	 * 需求：根据坐标点击后，输入内容
	 * 
	 * @param name
	 * @param content
	 */
	public static void inputTextByPoint(String id, String content) {
		System.out.println("[start] inputTextByName: " + id + " , input: "
				+ content);
		UiObject uo = getUiObjectByResourceIdMatches(id);
		if (!uo.exists()) {
			System.out.println("[end] can not find: " + id);
			return;
		}

		Rect ct;
		try {
			ct = uo.getBounds();
			click(ct.top, ct.top);
			EditText.setText(uo, content);
			System.out.println("[end] inputTextByName: " + id + " , input: "
					+ content);
		} catch (UiObjectNotFoundException e) {

			e.printStackTrace();
		}
	}

}
