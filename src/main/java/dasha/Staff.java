package dasha;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@org.hibernate.annotations.NamedQuery(name = "Staff.byName", query = "From Staff p where upper(p.name) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Staff.bySurname", query = "from Staff p where upper(p.surname) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Staff.byPatronymic", query = "from Staff p where upper(p.patronymic) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Staff.byAddress", query = "from Staff p where upper(p.address) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Staff.byPosition", query = "from Staff p where upper(p.position) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Staff.byDateOfBirth", query = "from Staff p where upper(cast(p.dateOfBirth as string)) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Staff.bySalary", query = "from Staff where salary = ?1")
@org.hibernate.annotations.NamedQuery(name = "Staff.all", query = "from Staff p")
public class Staff {
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
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Basic
    @Column(name = "position")
    private String position;
    @Basic
    @Column(name = "salary")
    private Integer salary;
    @OneToMany(mappedBy = "staffByStaffId")
    private Collection<Master> mastersById;
    @ManyToOne
    @JoinColumn(name = "transfer_id", referencedColumnName = "id")
    private StaffTransfer staffTransferByTransferId;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (id != staff.id) return false;
        if (name != null ? !name.equals(staff.name) : staff.name != null) return false;
        if (surname != null ? !surname.equals(staff.surname) : staff.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(staff.patronymic) : staff.patronymic != null) return false;
        if (address != null ? !address.equals(staff.address) : staff.address != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(staff.dateOfBirth) : staff.dateOfBirth != null) return false;
        if (position != null ? !position.equals(staff.position) : staff.position != null) return false;
        if (salary != null ? !salary.equals(staff.salary) : staff.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    public Collection<Master> getMastersById() {
        return mastersById;
    }

    public void setMastersById(Collection<Master> mastersById) {
        this.mastersById = mastersById;
    }

    public StaffTransfer getStaffTransferByTransferId() {
        return staffTransferByTransferId;
    }

    public void setStaffTransferByTransferId(StaffTransfer staffTransferByTransferId) {
        this.staffTransferByTransferId = staffTransferByTransferId;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + dateOfBirth +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", mastersById=" + mastersById +
                ", staffTransferByTransferId=" + staffTransferByTransferId +
                '}';
    }
}
