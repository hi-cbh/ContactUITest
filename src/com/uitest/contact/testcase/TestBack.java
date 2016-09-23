package com.uitest.contact.testcase;

import android.os.RemoteException;
import com.uitest.data.UserConfig;
import com.uitest.readxml.Contact;
import com.uitest.readxml.ReadXml;
import com.uitest.util.TestContactBase;
import com.uitest.util.UiAutomatorHelper;

public class TestBack  extends TestContactBase {
	public static void main(String[] args) {
		String jarName = "TestBack";
		String testClass = "com.uitest.contact.testcase.TestBack";
		String testName = "testPull";
		String androidId = UserConfig.androidId;
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}
	
	
	public void testCase_001() throws RemoteException {

	}
    public void testPull() throws Exception{  

        for(Contact contact : ReadXml.getContact()){  
            System.out.println("contact: "+contact.getName() + ":" 
        + contact.getPhone() + ":" + contact.getEmail());
        }  
    } 
	
}
