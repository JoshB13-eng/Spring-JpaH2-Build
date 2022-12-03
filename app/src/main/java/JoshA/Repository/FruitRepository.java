
package JoshA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import JoshA.DataBox.Fruit;

public interface FruitRepository{
    
	List<Fruit> getAllFruit();
	
	Fruit findByNumberOfFruit(Integer NumberOfFruit);
	
	void createFruit(Fruit fruit);
	
	Fruit update(Fruit Fruit);
	
	void delete(Integer NumberOfFruit);
}
