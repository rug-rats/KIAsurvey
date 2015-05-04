package com.sourceit.survey.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Map;

public class MappingUtils {
    
    public static <T> T getObjectFromRequest(HttpServletRequest request, Class<T> type) {
        
        T t;
        try {
            
            t = type.newInstance();
            Field[] fields =  type.getDeclaredFields();
            Map<String, String[]> params = request.getParameterMap();
            for (Field field: fields) {
                
                String fieldName = field.getName();
                if (params.containsKey(fieldName) && params.get(fieldName).length > 0 
                        && !StringUtils.isEmpty(params.get(fieldName)[0])) {

                    Object param = params.get(fieldName)[0];
                    if (field.getType() != String.class) {
                        
                        field.getType().getMethod("valueOf", String.class)
                                .invoke(null, params.get(fieldName)[0]);
                    }
                    type.getMethod("set" + WordUtils.capitalize(fieldName), field.getType())
                            .invoke(t, param);
                }
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            throw new RuntimeException(e);
        } 
        
        return t;
    }
    
}
