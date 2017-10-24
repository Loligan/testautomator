package Repository;

import Entity.AccountEntity;
import Entity.ClientEntity;
import Entity.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientRepository {

    public static ClientEntity findById(long id) {
        ClientEntity account = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            EntityManager em = session.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            List<ClientEntity> accounts = em.createQuery("from ClientEntity where id=" + id, ClientEntity.class).getResultList();
            if (accounts.size() > 0) {
                account = accounts.get(0);
            }
        }
        return account;
    }

    public static boolean insertOrUpdateObject(ClientEntity clientEntity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(clientEntity);
            session.getTransaction().commit();
            return true;
        }
    }

    public static void insertOrUpdateObjects(List<ClientEntity> clientsEntity) {
        for (ClientEntity clent :
                clientsEntity) {
            insertOrUpdateObject(clent);
        }
    }
}
