
package JoshA.DataBox;

import com.fasterxml.jackson.annotation.JsonCreator; 
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LEMON")
public class Lemon{
    
    @Id
    @Column(name="numberOfLemon")
    public Integer numberOfLemon;
    
    @Column(name="amount")
    public Integer amount;
    
    @JsonIgnore
    @OneToOne
	@JoinColumn(name="numberOfLemon")
    public Fruit fruit;
    
    public Lemon(){}
    
    public void setNumberOfLemon(Integer numberOfLemon){
        this.numberOfLemon = numberOfLemon;
    }
    
    public void setAmount(Integer amount){
        this.amount = amount;
    }
    
    public void setFruit(Fruit fruit){
        this.fruit = fruit;
    }
    
    @JsonIgnore
    public Integer Calc(){
        return this.numberOfLemon * 300;
    }
    
    public Integer getAmount(){
        return this.amount;
    }
    
    public Integer getNumberOfLemon(){
        return this.numberOfLemon;
    }
    
    @JsonIgnore
    public Fruit getFruit(){
        return fruit;
    }
    
    @Override public String toString(){
        return "Cost of "+this.numberOfLemon+" Lemon(s) is "+this.amount;
    }
    
}