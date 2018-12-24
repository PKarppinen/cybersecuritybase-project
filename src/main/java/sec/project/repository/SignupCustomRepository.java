package sec.project.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

@Component
public class SignupCustomRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    public String findNameByName(String name) {
        Query query = entityManager.createNativeQuery("select * from signup where name = '" + name + "'");        
        List<Object> results = query.getResultList();
        Object[] firstObject = (Object[])results.get(0);        
        return (String)firstObject[2];
    }
}
