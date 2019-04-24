package com.lostvip.app.util;

/**
 * 
 */

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lostvip.app.pojo.AuthUser;
import com.lostvip.app.pojo.AuthUserTest;


/**
 * @author dell
 *
 */
public class JsonUtil {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     * @param data
     * @return
     * @throws IOException 
     */
    public static String objectToJson(Object data)  {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 将json结果集转化为对象
     * 
     * @param jsonData json数据
     * @param clazz 对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
   
    
    
    public static void main(String[] args) {
    	AuthUser a = new AuthUser();
    	a.setAccount("test");
		System.out.println(objectToJson(a));
		
		AuthUserTest a1 = new AuthUserTest();
    	a1.setAccount("test1");
		System.out.println(objectToJson(a1));
		
	}
}