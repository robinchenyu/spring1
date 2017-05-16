package test;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Administrator on 2017/5/15.
 */
public class ClassPath1 {

    public static void main (String args[]) {

        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
            System.out.println(url.getFile());
        }

    }

}
