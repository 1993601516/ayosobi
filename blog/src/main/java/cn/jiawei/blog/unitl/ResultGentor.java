package cn.jiawei.blog.unitl;

import org.thymeleaf.util.StringUtils;

public class ResultGentor {
   private static final String DEFAULT_SUCCESS_MESSAGE="SUCCESS";
   private static final String DEFAULT_FAIL_MESSAGE="FAIL";
   private static final int DEFAULT_SUCCESS_CODE=200;
   private static final int DEFAULT_FAIL_CODE=500;

   public static Result setSUCCESS_RESULT(){
       Result result= new Result();
       result.setMessage(DEFAULT_SUCCESS_MESSAGE);
       result.setCode(DEFAULT_SUCCESS_CODE);
       return result;
   }
   public static Result setSUCCESS_RESULT(String message){
       Result result =new Result();
       result.setCode(DEFAULT_SUCCESS_CODE);
       result.setMessage(message);
       return result;
   }
   public static Result setSUCCESS_RESULT(Object data){
       Result result=new Result();
       result.setMessage(DEFAULT_SUCCESS_MESSAGE);
       result.setCode(DEFAULT_SUCCESS_CODE);
       result.setData(data);
       return result;
   }
   public static Result setFAIL_RESULT(String message){
       Result result =new Result();
       result.setCode(DEFAULT_FAIL_CODE);
       if(StringUtils.isEmpty(message)){
           result.setMessage(DEFAULT_FAIL_MESSAGE);
       }else{
           result.setMessage(message);
       }
       return result;
   }
   public static Result setERROR_RESULT(int code,String message){
       Result result = new Result();
       result.setMessage(message);
       result.setCode(code);
       return result;
   }
}
