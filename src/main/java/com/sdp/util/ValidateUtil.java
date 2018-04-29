package com.sdp.util;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;


import com.sdp.enumeration.ExceptionEnum;
import com.sdp.exception.BaseException;

public class ValidateUtil {
    private static Validator validator = Validation.buildDefaultValidatorFactory()  
            .getValidator();  
    
    public static <T> boolean validate(T obj) throws BaseException {
    	String validateResult = validateInner(obj);
		if(validateResult != null) {
			throw new BaseException(ExceptionEnum.WRONG_PARAM, validateResult);
		}
		return true;
    }
    private static <T> String validateInner(T obj){    
        Set<ConstraintViolation<T>> set = validator.validate(obj);  
        String property = null;  
        for(ConstraintViolation<T> cv : set){  
            //这里循环获取错误信息，可以自定义格式  
            property = cv.getPropertyPath().toString();  
            return property;
//                if(errorMap.get(property) != null){  
//                    errorMap.get(property).append("," + cv.getMessage());  
//                }else{  
//                    StringBuffer sb = new StringBuffer();  
//                    sb.append(cv.getMessage());  
//                    errorMap.put(property, sb);  
//                }    
        }
		return property;    
    }  
}
