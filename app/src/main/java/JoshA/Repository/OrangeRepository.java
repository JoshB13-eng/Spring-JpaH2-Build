
package JoshA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import JoshA.DataBox.Orange;

public interface OrangeRepository{
    
	List<Orange> getAllOrange();
	
	List<Orange> findByAmount(Integer Amount);
	
	Orange findByNumberOfOrange(Integer NumberOfOrange);
	
	void createOrange(Orange Orange);
	
	Orange update(Orange Orange);
	
	void delete(Integer NumberOfOrange);
}
