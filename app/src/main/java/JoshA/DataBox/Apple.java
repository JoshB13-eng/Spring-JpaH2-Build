
package JoshA.DataBox;

import com.fasterxml.jackson.annotation.JsonCreator; 
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "APPLE")
public class Apple{
    
    @Id
    @Column(name="numberOfApple")
    public Integer numberOfApple;
    
    @Column(name="amount")
    public Integer amount;
    
    @JsonIgnore
    @OneToOne
	@JoinColumn(name="numberOfApple")
    public Fruit fruit;
    
    public Apple(){}
    
    public void setNumberOfApple(Integer numberOfApple){
        this.numberOfApple = numberOfApple;
    }
    
    public void setAmount(Integer amount){
        this.amount = amount;
    }
    
    public void setFruit(Fruit fruit){
        this.fruit = fruit;
    }
    
    @JsonIgnore
    public Integer Calc(){
        return this.getNumberOfApple() * 500;
    }
    
    public Integer getAmount(){
        return this.amount;
    }
    
    public Integer getNumberOfApple(){
        return this.numberOfApple;
    }
    
    @JsonIgnore
    public Fruit getFruit(){
        return fruit;
    }
    
    @Override public String toString(){
        return "Cost of "+this.numberOfApple+" Apple(s) is "+this.amount;
    }
    
}
