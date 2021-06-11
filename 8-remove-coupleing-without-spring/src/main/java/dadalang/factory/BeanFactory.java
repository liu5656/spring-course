package dadalang.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Map<String, Object> beans = new HashMap<String,Object>();
    static {
        Properties prop = new Properties();
        InputStream input = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            prop.load(input);
            Enumeration keys = prop.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String path = prop.getProperty(key);
                Object value = Class.forName(path).getDeclaredConstructor().newInstance();
                beans.put(key, value);
            }
        }catch (Exception e) {
            throw new ExceptionInInitializerError("prop initial failed");
        }
    }
    public static Object getBean(String name) {
        return  beans.get(name);
    }
}
