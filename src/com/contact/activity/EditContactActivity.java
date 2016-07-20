package com.contact.activity;

import com.android.uiautomator.core.UiObject;
import com.uitest.cmp.EditText;
import com.uitest.uiautomatorUtil.ElementManager;

/**
 * 编辑联系人页，页面方法
 * 
 * 日志记录：
 * 版本                  日期                         修改者    更新内容
 * 1.0       2016-06-21   cbh  模块重新整理
 * 
 */
public class EditContactActivity{
/**
 *  新建联系人页：
 * 属性：
 * 组件ID: 页面各个组件ID按功能命名
 * 页面对象：页面各个UI对象
 * 方法：
 * 选择输入框输入内容（姓名、公司、部门）
 * 添加头像（拍照、从图库中选择照片）
 * 保存并返回
 * 添加新属性
 * 删除已有属性
 * 选择标签
 * 选择分组
 * 选择来电秀
 * 创建点返回选择是|否
 */
	
	private static  String contactName = "姓名";
	private static  String company = "公司";
	private static  String department = "部门";
	private static  String fphone = "电话号码";
	
	/**
	 * 设置联系人名称
	 * @param name
	 */
	public static void setContactName(String name){
		UiObject uo = ElementManager.getUiObjectByText(contactName);
		EditText.clearEditText(uo);
		EditText.setText(uo, name);	
	}
	/**
	 * 设置公司名称
	 * @param name
	 */
	public static void setCompany(String name){
		UiObject uo = ElementManager.getUiObjectByText(company);
		EditText.clearEditText(uo);
		EditText.setText(uo, name);	
	}
	
	/**
	 * 设置部门名称
	 */
	public static void setDepartment(String name){

		UiObject uo = ElementManager.getUiObjectByText(department);
		EditText.clearEditText(uo);
		EditText.setText(uo, name);			
		
	}
	
	/**
	 * 设置电话号码
	 * @param phone
	 */
	public static void setPhone(String phone){
		UiObject uo = ElementManager.getUiObjectByText(fphone);
		EditText.clearEditText(uo);
		EditText.setText(uo, phone);			
		
	}
	
	/**
	 * 点击保存
	 */
	public static void saveContact(){
		ElementManager.clickById("iab_ib_action");
		
	}
	
	
}
