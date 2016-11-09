package springmvc4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ArithmaticController{

    @MessageMapping("/add")
    @SendTo("/topic/showResult")
    public Result addNum(CalcInput input) throws Exception {
        Thread.sleep(2000);
        Result result = new Result(input.getNum1()+"+"+input.getNum2()+"="+(input.getNum1()+input.getNum2())); 
        System.out.println(input.getNum1()+"+"+input.getNum2()+"="+(input.getNum1()+input.getNum2()));
        return result;
    }
    
    
    private static String getTimestamp(){
    	DateFormat dateFormat = new SimpleDateFormat("EEE, MMM d,''yy h:mm a" );
    	return dateFormat.format(new Date());
    }
    
    
    public static void main(String[] args){
    	System.out.println(GreetingController.getTimestamp());
    }

}