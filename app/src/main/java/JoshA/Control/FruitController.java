

package JoshA.Control;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.InputStreamResource;

import java.io.File; 
import java.io.FileOutputStream; 
import java.io.FileInputStream; 
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import JoshA.DataBox.Fruit;
import JoshA.DataBox.Apple;
import JoshA.Service.AppService;
import JoshA.Repository.AppleRepository;

@RestController
@RequestMapping(path = "/JoshFruit")
public class FruitController{
    //
    public static String Client;
    public  byte[] fileByt;
    
    //public Map<Integer,Fruit> fruit;
    
    @Autowired
    private AppService appServe;
    
    @Autowired
    private AppleRepository appleServe;
    
    @PostMapping(value="/UploadToDB", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException{
        //Upload file from request
        fileByt = file.getBytes();
        
        return "File is upload successfully"; 
    } 
    
    @PostMapping(path = "/Fruit/Create", consumes = "application/json", produces = "application/json")
    public String createFruit(@RequestBody Fruit fruitp){
        //Create a fruit bean record in DB table
        fruitp.setByte(fileByt);
        
        appServe.createFruit(fruitp);
        
        return "\nFruit is created successfully\n";
    }
    
    @PutMapping(path = "/Fruit/Update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> update(@RequestBody Fruit fruitp){
        //Update a fruit bean record in DB table
        fruitp.setByte(fileByt);
        
        appServe.update(fruitp);
        
        String str = "Fruit Database has been sucessfully updated\n";
        
        return new ResponseEntity<>(str, HttpStatus.OK);
    }
    
    @GetMapping(path = "/Fruit", produces = "application/json")
    public List<Fruit> getFruit(){
        //Get all fruit bean records from DB table and send it to client
        return appServe.getAllFruit();
    }
    
    @GetMapping(path = "/FruitX/{NumberOfFruit}", produces = "application/json")
    public Fruit getFruitX(@PathVariable("NumberOfFruit") Integer NumberOfFruit){
        //Get a particular fruit bean record from DB table and send it to client
        return appServe.findByNumberOfFruit(NumberOfFruit);
    }
    
    @GetMapping(path = "/AppleX/{NumberOfApple}", produces = "application/json")
    public List<Apple> getAppleX(@PathVariable("NumberOfApple") Integer NumberOfApple){
        //Get a particular apple bean record from DB table and send it to client
        return appleServe.findByAmount(NumberOfApple);
    }
    
    @DeleteMapping(path = "/Delete/{NumberOfFruit}")
    public String deleteFruit(@PathVariable("NumberOfFruit") Integer NumberOfFruit){
        //Delete a fruit bean record from DB table
        appServe.delete(NumberOfFruit);
        
        return ""+NumberOfFruit+"NumberOfFruit data/FruitRecord has been sucessfully deleted";
    }
    
    @RequestMapping(path = "/Exit")
    public ResponseEntity<Object> Exit(){
        //Exit app
        return new ResponseEntity<>("\nShutting down server...\n", HttpStatus.OK);
    }
    
}



//To upload File
//curl  -X POST  -i  -F "file=@/path/to/file" -F "additional_parm=param2" http://localhost:8080/JoshFruit/UploadToDB

//To create an Entity to database
//curl -H "Content-Type: application/json" -X POST -d '{"numberOfFruit":25,"orange":{"numberOfOrange":25,"amount":2500},"apple":{"numberOfApple":25,"amount":12500},"lemon":{"numberOfLemon":25,"amount":7500}}' http://localhost:8080/JoshFruit/Fruit/Create

//To update fruit database by adding fruit record to database
//curl -X PUT -d '{"numberOfFruit":15,"orange":{"numberOfOrange":15,"amount":1500},"apple":{"numberOfApple":15,"amount":7500},"lemon":{"numberOfLemon":15,"amount":4500}}' -H "Content-Type: application/json" http://localhost:8080/JoshFruit/Fruit/Update

//To update fruit database again by adding fruit record to database
//curl -X PUT -d '{"numberOfFruit":25,"orange":{"numberOfOrange":25,"amount":2500},"apple":{"numberOfApple":25,"amount":12500},"lemon":{"numberOfLemon":25,"amount":7500}}' -H "Content-Type: application/json" http://localhost:8080/JoshFruit/Fruit/Update

//To get All Records/FruitDatas from database
//curl http://localhost:8080/JoshFruit/Fruit

//To get a specified Record of FRUIT table from database
//curl http://localhost:8080/JoshFruit/FruitX/15

//To get another specified Record of FRUIT table from database
//curl http://localhost:8080/JoshFruit/FruitX/25

//To get a specified Record of APPLE table from database
//curl http://localhost:8080/JoshFruit/AppleX/0

//To delete a specified Record of FRUIT table from database
//curl -X "DELETE" http://localhost:8080/JoshFruit/Delete/0

//To view database from browser console 
//http://localhost:8080/h2-console

//To exit program
//curl http://localhost:8080/JoshFruit/Exit

