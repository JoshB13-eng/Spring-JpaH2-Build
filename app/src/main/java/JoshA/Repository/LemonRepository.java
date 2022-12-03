
package JoshA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import JoshA.DataBox.Lemon;

public interface LemonRepository{
    
	List<Lemon> getAllLemon();
	
	List<Lemon> findByAmount(Integer Amount);
	
	Lemon findByNumberOfLemon(Integer NumberOfLemon);
	
	void createLemon(Lemon Lemon);
	
	Lemon update(Lemon lemon);
	
	void delete(Integer NumberOfLemon);
}
