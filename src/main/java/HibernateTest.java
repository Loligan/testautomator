import Entity.AccountEntity;
import Entity.ClientEntity;
import Repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;

public class HibernateTest {
    public static void main(String[] args) {
        AccountEntity accountEntity = AccountRepository.findById(1);


        List<ClientEntity> clients = new ArrayList<>();

    }
}
