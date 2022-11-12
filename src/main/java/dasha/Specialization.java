package dasha;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@org.hibernate.annotations.NamedQuery(name = "Specialization.byServicesList", query = "From Specialization p where upper(p.servicesList) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Specialization.all", query = "from Specialization p")

public class Specialization {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "services_list")
    private String servicesList;
    @OneToMany(mappedBy = "specializationBySpecializationId")
    private Collection<MasterSpecialization> masterSpecializationsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServicesList() {
        return servicesList;
    }

    public void setServicesList(String servicesList) {
        this.servicesList = servicesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialization that = (Specialization) o;

        if (id != that.id) return false;
        if (servicesList != null ? !servicesList.equals(that.servicesList) : that.servicesList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (servicesList != null ? servicesList.hashCode() : 0);
        return result;
    }

    public Collection<MasterSpecialization> getMasterSpecializationsById() {
        return masterSpecializationsById;
    }

    public void setMasterSpecializationsById(Collection<MasterSpecialization> masterSpecializationsById) {
        this.masterSpecializationsById = masterSpecializationsById;
    }
    @Override
    public String toString() {
        return servicesList;
    }
}
