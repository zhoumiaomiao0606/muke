package com.course.modle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle=ResourceBundle.getBundle("application", Locale.CHINA);
    public static String getUrl(InterfaceName name){
        String address=bundle.getString("testurl");
        String uri=null;
        if(name.equals("GETUSERLIST")){
            uri=bundle.getString("getuserlist.uri");
        }
        String testurl= address + uri;
        return testurl;
    }
}
