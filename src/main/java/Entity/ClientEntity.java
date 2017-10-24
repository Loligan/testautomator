package Entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "client", schema = "automator", catalog = "")
public class ClientEntity {
    private int id;
    private String typeClient;
    private Timestamp dateCreate;
    private byte isAlive;
    private AccountEntity accountId;


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type_client")
    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    @Basic
    @Column(name = "date_create")
    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Basic
    @Column(name = "is_alive")
    public byte getIsAlive() {
        return isAlive;
    }
    public void setIsAlive(byte isAlive) {
        this.isAlive = isAlive;
    }


    @ManyToOne
    @JoinColumn(name="account_id")
    public AccountEntity getAccountId() {
        return accountId;
    }

    public void setAccountId(AccountEntity accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (id != that.id) return false;
        if (isAlive != that.isAlive) return false;
        if (typeClient != null ? !typeClient.equals(that.typeClient) : that.typeClient != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeClient != null ? typeClient.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (int) isAlive;
        return result;
    }
}
