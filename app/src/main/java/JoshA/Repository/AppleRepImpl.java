
package JoshA.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

import JoshA.DataBox.Apple;


@Repository("AppleRepository")
public class AppleRepImpl implements AppleRepository{
    
    @PersistenceContext
    public EntityManager entitymanager;
    
    @Override public List<Apple> getAllApple(){
        //
        return entitymanager.createQuery("from Apple", Apple.class).getResultList();
    }
    
    @Override public List<Apple> findByAmount(Integer AmountX){
        //
        return entitymanager.createQuery("from Apple where amount = :AmountX", Apple.class).setParameter("AmountX", AmountX).getResultList();
    }
    
    @Override public Apple findByNumberOfApple(Integer NumberOfApple){
        //
        return entitymanager.find(Apple.class, NumberOfApple);
    }
    
    @Override public void createApple(Apple apple){
        //
        entitymanager.persist(apple);
    }
    
    @Override public Apple update(Apple apple){
        //
        return entitymanager.merge(apple);
    }
    
    @Override public void delete(Integer NumberOfFruit){
        //
        entitymanager.remove(entitymanager.getReference(Apple.class, NumberOfFruit));
    }
    
}



