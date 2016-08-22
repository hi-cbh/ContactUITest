**【通用模块】**

* 将各类常用的控件进行抽象
	
		com.uitest.cmp
	
* 二次封装了uiautoamtor的基础类	
	
		com.uitest.util
		com.uitest.uiautomatorUtil
	
* 常用数据，抽取出来
	
		com.uitest.data
	
* 日志管理类

		com.uitest.log.MyLogcatHelper         //系统运行日志截取
		com.uitest.log.UiautomatorAssistant   //app运行步骤日志记录（默认开启）
	
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

* 记录单个用例的系统运行日志及app运行步骤日志	

		com.uitest.log

* 用于调试

		com.testCode

**【备注】**

* ImageManager类中，已实现截图并标记点击的元素对象，不建议使用，每次截图都耗时1秒
* 运行前，需要提前创建辅助目录（UserConfig中），可用bat辅助。
	