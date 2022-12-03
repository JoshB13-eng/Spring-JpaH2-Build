
package JoshA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import JoshA.DataBox.Apple;

public interface AppleRepository{
    
	List<Apple> getAllApple();
	
	List<Apple> findByAmount(Integer Amount);
	
	Apple findByNumberOfApple(Integer NumberOfFruit);
	
	void createApple(Apple apple);
	
	Apple update(Apple apple);
	
	void delete(Integer NumberOfFruit);
}
