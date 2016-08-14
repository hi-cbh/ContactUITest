**【通用模块】**

* 将各类常用的控件进行抽象
	
		com.uitest.cmp
	
* 二次封装了uiautoamtor的基础类	
	
		com.uitest.util
		com.uitest.uiautomatorUtil
	
* 常用数据，抽取出来
	
		com.uitest.data
	
**【测试用例】**

* 和通讯录测试用例

		com.uitest.contact.testcase

* 和通讯录抽取出每个activity常用方法
		
		com.contact.activity

	
**【不需要关注】**

* utf7包，调用utf7的类和方法，实现输入

		com.beetstra.jutf7
		jp.jun_name.test.utf7ime.helper

	**实例：**
	
		uo.setText(Utf7ImeHelper.e(content));
	
* 用于调试

		com.testCode

	