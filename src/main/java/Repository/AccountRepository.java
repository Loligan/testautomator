package Repository;

import Entity.AccountEntity;
import Entity.HibernateSessionFactory;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class AccountRepository {

    public static AccountEntity findById(long id) {
        AccountEntity account = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            EntityManager em = session.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            ;
            List<AccountEntity> accounts = em.createQuery("from AccountEntity where id=" + id, AccountEntity.class).getResultList();
            System.out.println("FFF: " + accounts.size());
            if (accounts.size() > 0) {
                account = accounts.get(0);
            }
        }
        return account;
    }
}
