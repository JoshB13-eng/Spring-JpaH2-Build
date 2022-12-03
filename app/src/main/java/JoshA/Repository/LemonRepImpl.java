
package JoshA.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import JoshA.DataBox.Lemon;


@Repository("LemonRepository")
public class LemonRepImpl implements LemonRepository{
    
    @PersistenceContext
    public EntityManager entitymanager;
    
    @Override public List<Lemon> getAllLemon(){
        //
        return entitymanager.createQuery("from Lemon", Lemon.class).getResultList();
    }
    
    @Override public List<Lemon> findByAmount(Integer AmountX){
        //
        return entitymanager.createQuery("from Lemon where amount = :AmountX", Lemon.class).setParameter("AmountX", AmountX).getResultList();
    }
    
    @Override public Lemon findByNumberOfLemon(Integer NumberOfLemon){
        //
        return entitymanager.find(Lemon.class, NumberOfLemon);
    }
    
    @Override public void createLemon(Lemon Lemon){
        //
        entitymanager.persist(Lemon);
    }
    
    @Override public Lemon update(Lemon Lemon){
        //
        return entitymanager.merge(Lemon);
    }
    
    @Override public void delete(Integer NumberOfFruit){
        //
        entitymanager.remove(entitymanager.getReference(Lemon.class, NumberOfFruit));
    }
    
}



