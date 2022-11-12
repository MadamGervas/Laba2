package dasha;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@org.hibernate.annotations.NamedQuery(name = "Clients.byName", query = "From Clients p where upper(p.name) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Clients.bySurname", query = "from Clients p where upper(p.surname) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Clients.byPatronymic", query = "from Clients p where upper(p.patronymic) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Clients.byPhoneNumber", query = "from Clients p where upper(p.phoneNumber) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Clients.all", query = "from Clients p")
public class Clients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "patronymic")
    private String patronymic;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "clientsByClientId")
    private Collection<ServiceClients> serviceClientsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clients clients = (Clients) o;

        if (id != clients.id) return false;
        if (name != null ? !name.equals(clients.name) : clients.name != null) return false;
        if (surname != null ? !surname.equals(clients.surname) : clients.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(clients.patronymic) : clients.patronymic != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(clients.phoneNumber) : clients.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    public Collection<ServiceClients> getServiceClientsById() {
        return serviceClientsById;
    }

    public void setServiceClientsById(Collection<ServiceClients> serviceClientsById) {
        this.serviceClientsById = serviceClientsById;
    }
    @Override
    public String toString() {
        return surname +
                " " + name +
                " " + patronymic +
                ", " + phoneNumber;
    }
}
