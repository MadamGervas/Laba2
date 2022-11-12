package dasha;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@org.hibernate.annotations.NamedQuery(name = "StaffTransfer.byPosition", query = "From StaffTransfer p where upper(p.position) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "StaffTransfer.byReason", query = "from StaffTransfer p where upper(p.reason) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "StaffTransfer.byNumber", query = "from StaffTransfer p where upper(p.number) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "StaffTransfer.byOrderDate", query = "from StaffTransfer p where upper(cast(p.orderDate as string)) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "StaffTransfer.all", query = "from StaffTransfer p")
@Table(name = "staff_transfer", schema = "public", catalog = "salon")
public class StaffTransfer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "position")
    private String position;
    @Basic
    @Column(name = "reason")
    private String reason;
    @Basic
    @Column(name = "number")
    private String number;
    @Basic
    @Column(name = "order_date")
    private Date orderDate;
    @OneToMany(mappedBy = "staffTransferByTransferId")
    private Collection<Staff> staffById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffTransfer that = (StaffTransfer) o;

        if (id != that.id) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        return result;
    }

    public Collection<Staff> getStaffById() {
        return staffById;
    }

    public void setStaffById(Collection<Staff> staffById) {
        this.staffById = staffById;
    }

    @Override
    public String toString() {
        return position +
                " " + reason +
                " " + number +
                ", " + orderDate;
    }

}
