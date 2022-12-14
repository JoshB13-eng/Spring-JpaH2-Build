/*
 * This Java source file was generated by the Gradle 'init' task.
 */
 
//
package JoshA;


import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.builder.SpringApplicationBuilder; 
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


import JoshA.DataBox.Fruit;

@SpringBootApplication
public class Main extends SpringBootServletInitializer{
    //
    public static void main(String[] args){
        
        SpringApplication.run(Main.class, args); 
    }
    
    @Override  protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        
        return application.sources(Main.class);
    }
}


//java -jar ./app/build/libs/app-JpaH2-0.1.0.war

//To view database from browser console 
//http://localhost:8080/h2-console