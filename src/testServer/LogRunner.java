package testServer;

import java.io.ObjectInputStream;
import java.net.Socket;
import org.apache.log4j.spi.LoggingEvent;

public class LogRunner implements Runnable{  
    private ObjectInputStream ois;  
 
    public LogRunner(Socket client) {  
        try {  
             this.ois = new ObjectInputStream(client.getInputStream());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
 @Override
    public void run() {  
        try {  
            while (true) {  
                Object obj= ois.readObject();  
                System.out.println(obj.toString());  
            	LoggingEvent event = (LoggingEvent) ois.readObject();
            	System.out.println(event.getLoggerName()+":"+event.getMessage());
            }  
        }catch (Exception e) {  
        } finally {  
        }  
    }  
}