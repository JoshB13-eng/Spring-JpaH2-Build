
package JoshA.DataBox;

import com.fasterxml.jackson.annotation.JsonCreator; 
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="FRUIT")
public class Fruit implements Serializable{
    
    public static final long serUID = 2L;
    
    @Id
    @Column(name="numberOfFruit")
    public Integer numberOfFruit;
    
    @OneToOne(mappedBy="fruit")
    public Orange orange;
    
    @OneToOne(mappedBy="fruit")
    public Apple apple;
    
    @OneToOne(mappedBy="fruit")
    public Lemon lemon;
    
    @Column(name="fileByt")
    @JsonIgnore
    public byte[] fileByt;
    
    public Fruit(){}
    
    public void setOrange(Orange orange){
        this.orange = orange;
    }
    
    public void setApple(Apple apple){
        this.apple = apple;
    }
    
    public void setLemon(Lemon lemon){
        this.lemon = lemon;
    }
    
    public void setByte(byte[] fileByt){
        this.fileByt = fileByt;
    }
    
    public void setNumberOfFruit(Integer numberOfFruit){
        this.numberOfFruit = numberOfFruit;
    }
    
    public Integer getnumberOfFruit(){
        return this.numberOfFruit;
    }
    
    public Orange getOrange(){
        return this.orange;
    }
    
    public Apple getApple(){
        return this.apple;
    }
    
    public Lemon getLemon(){
        return this.lemon;
    }
    
    @JsonIgnore
    public byte[] getByte(){
        return this.fileByt;
    }
    
    @Override public String toString(){
        return "Apple :"+this.apple.toString()+"\nLemon :"+this.lemon.toString()+"\nOrange :"+this.orange.toString();
    }
}