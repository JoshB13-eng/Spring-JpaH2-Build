package JoshA.Service;

import java.util.List;

import JoshA.DataBox.*;

public interface AppService{
    
	List<Fruit> getAllFruit();
	
	Fruit findByNumberOfFruit(Integer NumberOfFruit);
	
	void createFruit(Fruit fruit);
	
	Fruit update(Fruit fruit);
	
	void delete(Integer NumberOfFruit);
}
