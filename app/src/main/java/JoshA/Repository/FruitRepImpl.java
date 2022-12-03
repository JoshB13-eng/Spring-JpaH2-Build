

package JoshA.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

import JoshA.DataBox.Fruit;


@Repository("FruitRepository")
public class FruitRepImpl implements FruitRepository{
    
    @PersistenceContext
    public EntityManager entitymanager;
    
    @Override public List<Fruit> getAllFruit(){
        
        return entitymanager.createQuery("from Fruit", Fruit.class).getResultList();
    }
    
    @Override public Fruit findByNumberOfFruit(Integer NumberOfFruit){
        
        return entitymanager.find(Fruit.class, NumberOfFruit);
    }
    
    @Override public void createFruit(Fruit Fruit){
        
        entitymanager.persist(Fruit);
    }
    
    @Override public Fruit update(Fruit Fruit){
        
        return entitymanager.merge(Fruit);
    }
    
    @Override public void delete(Integer NumberOfFruit){
        
        entitymanager.remove(entitymanager.getReference(Fruit.class, NumberOfFruit));
    }
    
}
