package dasha;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Master {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff staffByStaffId;
    @OneToMany(mappedBy = "masterByMasterId")
    private Collection<MasterMaterials> masterMaterialsById;
    @OneToMany(mappedBy = "masterByMasterId")
    private Collection<MasterSpecialization> masterSpecializationsById;
    @OneToMany(mappedBy = "masterByMasterId")
    private Collection<Service> servicesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Master master = (Master) o;

        if (id != master.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public Staff getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(Staff staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }

    public Collection<MasterMaterials> getMasterMaterialsById() {
        return masterMaterialsById;
    }

    public void setMasterMaterialsById(Collection<MasterMaterials> masterMaterialsById) {
        this.masterMaterialsById = masterMaterialsById;
    }

    public Collection<MasterSpecialization> getMasterSpecializationsById() {
        return masterSpecializationsById;
    }

    public void setMasterSpecializationsById(Collection<MasterSpecialization> masterSpecializationsById) {
        this.masterSpecializationsById = masterSpecializationsById;
    }

    public Collection<Service> getServicesById() {
        return servicesById;
    }

    public void setServicesById(Collection<Service> servicesById) {
        this.servicesById = servicesById;
    }
}
