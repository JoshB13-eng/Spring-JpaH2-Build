
package JoshA.DataBox;

import com.fasterxml.jackson.annotation.JsonCreator; 
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORANGE")
public class Orange{
    
    @Id
    @Column(name="numberOfOrange")
    public Integer numberOfOrange;
    
    @Column(name="amount")
    public Integer amount;
    
    @JsonIgnore
    @OneToOne
	@JoinColumn(name="numberOfOrange")
    public Fruit fruit;
    
    public Orange(){}
    
    public void setNumberOfOrange(Integer numberOfOrange){
        this.numberOfOrange = numberOfOrange;
    }
    
    public void setAmount(Integer amount){
        this.amount = amount;
    }
    
    public void setFruit(Fruit fruit){
        this.fruit = fruit;
    }
    
    @JsonIgnore
    public Integer Calc(){
        return this.numberOfOrange * 100;
    }
    
    public Integer getAmount(){
        return this.amount;
    }
    
    public Integer getNumberOfOrange(){
        return this.numberOfOrange;
    }
    
    @JsonIgnore
    public Fruit getFruit(){
        return fruit;
    }
    
    @Override public String toString(){
        return "Cost of "+this.numberOfOrange+" orange(s) is "+this.amount;
    }
    
}