package com.uitest.readxml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import com.uitest.data.UserConfig;
import android.util.Xml;

public class ReadXml {

	/**
	 * 读取 Contacts列表
	 * @return
	 * @throws FileNotFoundException
	 */
    public static List<Contact> getContact(){
    
        InputStream input = null;
        List<Contact> contacts = null;
        try {
        	input = new FileInputStream(UserConfig.readXmlPath);
			contacts = ReadXml(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return contacts;
    }
    	
    
    /**
     * 读取xml文件
     * @param inputStream
     * @return
     * @throws Exception
     */
	private static List<Contact> ReadXml(InputStream inputStream) throws Exception{  
        List<Contact> contacts = null;  
        Contact contact = null;  
        XmlPullParser parser = Xml.newPullParser();  
        parser.setInput(inputStream, "UTF-8");  
          
        int event = parser.getEventType();//产生第一个事件  
        while(event!=XmlPullParser.END_DOCUMENT){  
            switch(event){  
            case XmlPullParser.START_DOCUMENT://判断当前事件是否是文档开始事件  
            	contacts = new ArrayList<Contact>();//初始化books集合  
                break;  
            case XmlPullParser.START_TAG://判断当前事件是否是标签元素开始事件  
                if("contact".equals(parser.getName())){//判断开始标签元素是否是book  
                	contact = new Contact();  
                	//contact.setId(Integer.parseInt(parser.getAttributeValue(0)));//得到book标签的属性值，并设置book的id  
                }  
                if(contact!=null){
                	if("id".equals(parser.getName())){
                		contact.setId(Integer.parseInt(parser.nextText())); 
                	}
                	else if("name".equals(parser.getName()))
                	{//判断开始标签元素是否是name  
                    	contact.setName(parser.nextText());  
                    }else if("phone".equals(parser.getName()))
                    {//判断开始标签元素是否是Phone  
                    	contact.setPhone(parser.nextText());  
                    }else if("email".equals(parser.getName()))
                    {
                    	contact.setEmail(parser.nextText());
                    }
                }  
                break;  
            case XmlPullParser.END_TAG://判断当前事件是否是标签元素结束事件  
                if("contact".equals(parser.getName())){//判断结束标签元素是否是book  
                	contacts.add(contact);//将book添加到books集合  
                	contact = null;  
                }  
                break;  
            }  
            event = parser.next();//进入下一个元素并触发相应事件  
        }//end while  
        return contacts;  
    }  
}

