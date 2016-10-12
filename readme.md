
##简介

* **【编写理由】**

    * Java代码练习，加深理解
    
    * 加深理解，并熟练运用Uiautomator Api
    
    * 对初学者指引或借鉴

* **【开发环境】**
   
    * ADT(Android Developer Tools) -- sdk + eclipse
    
    * Java 1.8
   
    * Windows 7 64bit

    * 手机： 三星 i9308; android 4.3
    
    * 代码： [Github连接](https://github.com/hi-cbh/ContactUITest.git)

## 四个阶段

* 第一阶段：学习
    * 配置环境，调试第一个demo，并运行。
    * 熟悉各个类：UiDevice、UiObject等的作用
    * 截屏、截图、图片对比的运用
* 第二阶段：运用
    * 尝试写一些步骤少、操作简单的测试用例脚本（如登录、创建联系人、短信等），代码量建议 > 1000行。
    * 将用例改善，提高容错能力（处理一些异常情况）
    * 将常用步骤、操作，抽取出来，形成一个通用的方法，方便调用。
* 第三阶段：提高
    * 封装公共操作、经常使用、经常使用的组件、经常操作的布局、经常操作的页面、通用的工具函数
    * 版本接口化（研究中）
    * 组件化与布局化（研究中）
* 第四阶段：适合项目
    * 继承TestLisenter，截图Log日志，保存到每个case里
    * 图片处理：添加文字水印、操作步骤记录。
    * 记录用例的执行步骤日志（已实现写入同一文件，没实现写入每个case目录下）
    * 学习调用adb 各类命令
    * 读取Xml，实现用例遍历参数化
    * 部署到Jenkins + tomcat，实行持续集成测试。
    * 报告生成（需要熟悉android开发）：实现android App对每个case目录的日志文件进行同一处理，写入到xls文件中。（已有基础代码，未进行修改）

## 功能介绍

* 已实现功能

    * 每个case产生单独目录，目录下保存运行日志（logcat）、运行步骤日志（需要修改）、结果日志（正确或错误）、错误时截图。
        
    * 可扩展实现，已对常用方法进行二次封装。

* 简化调用，已实现简单方法。


## 目录介绍

目录分别有：src、apk、bat、data


### src目录-代码区域

**【通用模块】**

* 将各类常用的控件进行抽象
	
		com.uitest.cmp
	
* 二次封装了uiautoamtor的基础类
	
		com.uitest.util
		com.uitest.uiautomatorUtil
	
* 用户设置，常用数据
	
		com.uitest.data

	
**【测试用例】**

* 和通讯录测试用例

		com.uitest.contact.testcase   （4.1版本）
		com.uitest.contact4_2.testcase（4.2版本）
		com.uitest.contact430.testcase（4.3版本）

* 和通讯录抽取出每个activity常用方法
		
		com.contact.activity
        com.contact.activity.v420
        com.contact.activity.v430

	
**【不需要关注】**

* utf7包，调用utf7的类和方法，实现输入

		com.beetstra.jutf7
		jp.jun_name.test.utf7ime.helper

	**实例：**
	
		uo.setText(Utf7ImeHelper.e(content));

* 记录单个用例的系统运行日志及app运行步骤日志	

		com.uitest.log

		
* 读取Xml文件类

        com.uitest.readxml
        
* 用于调试

		com.testCode

**【备注】**

* ImageManager类中，已实现截图并标记点击的元素对象，不建议使用，每次截图都耗时1秒
* 运行前，需要提前创建辅助目录，运行以下命令：

        adb shell mkdir /mnt/sdcard/AppTestReportPic/
        adb shell mkdir /mnt/sdcard/AppTestReportLog/
        adb shell mkdir /mnt/sdcard/AppTestReportAppRunLog/


### apk目录辅助工具

* call、com.ktls.tonghuaweizao.apk 通话记录生成器

* mms.apk 短信生成器

* Utf7Ime.apk uiautomator的中文输入

### bat目录-通过monkey调用jar包。（推荐使用Jenkins）

* MonkeyScript.txt

* run.bat


### data目录 数据集

* testdata.xml(使用ExclToXml源码已上传到github)

