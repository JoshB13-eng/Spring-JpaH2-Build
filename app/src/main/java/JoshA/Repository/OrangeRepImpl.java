
package JoshA.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import JoshA.DataBox.Orange;


@Repository("OrangeRepository")
public class OrangeRepImpl implements OrangeRepository{
    
    @PersistenceContext
    public EntityManager entitymanager;
    
    @Override public List<Orange> getAllOrange(){
        
        return entitymanager.createQuery("from Orange", Orange.class).getResultList();
    }
    
    @Override public Orange findByNumberOfOrange(Integer NumberOfOrange){
        
        return entitymanager.find(Orange.class, NumberOfOrange);
    }
    
    @Override public List<Orange> findByAmount(Integer AmountX){
        
        return entitymanager.createQuery("from Orange where amount = :AmountX", Orange.class).setParameter("AmountX", AmountX).getResultList();
    }
    
    @Override public void createOrange(Orange Orange){
        
        entitymanager.persist(Orange);
    }
    
    @Override public Orange update(Orange Orange){
        
        return entitymanager.merge(Orange);
    }
    
    @Override public void delete(Integer NumberOfFruit){
        
        entitymanager.remove(entitymanager.getReference(Orange.class, NumberOfFruit));
    }
    
}


