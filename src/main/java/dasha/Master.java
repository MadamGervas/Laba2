package dasha;

import jakarta.persistence.*;

import java.util.List;

@Entity
@org.hibernate.annotations.NamedQuery(name = "Master.all", query = "from Master p")
public class Master {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff staffByStaffId;
    @OneToMany(mappedBy = "masterByMasterId")
    private List<MasterMaterials> masterMaterialsById;
    @OneToMany(mappedBy = "masterByMasterId")
    private List<MasterSpecialization> masterSpecializationsById;
    @OneToMany(mappedBy = "masterByMasterId")
    private List<Service> servicesById;

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

    public List<MasterMaterials> getMasterMaterialsById() {
        return masterMaterialsById;
    }

    public void setMasterMaterialsById(List<MasterMaterials> masterMaterialsById) {
        this.masterMaterialsById = masterMaterialsById;
    }

    public List<MasterSpecialization> getMasterSpecializationsById() {
        return masterSpecializationsById;
    }

    public void setMasterSpecializationsById(List<MasterSpecialization> masterSpecializationsById) {
        this.masterSpecializationsById = masterSpecializationsById;
    }

    public List<Service> getServicesById() {
        return servicesById;
    }

    public void setServicesById(List<Service> servicesById) {
        this.servicesById = servicesById;
    }

    @Override
    public String toString() {
        String specializations = "Specializations: ";
        int i = 1;
        for (MasterSpecialization specialization :
                masterSpecializationsById) {
            specializations += "\n" + i + ") " + specialization.getSpecializationBySpecializationId().getServicesList() + " ";
            i += 1;
        }

        String materialsName = "Materials: ";
        int j = 1;
        for (MasterMaterials materials :
                masterMaterialsById) {
            materialsName += "\n" + j + ") " +
                    materials.getMaterialsByMaterialsId().getName() +
                    " " + materials.getMaterialsByMaterialsId().getUnitMeasurement() +
                    " " + materials.getCount() + " pieces";
            j += 1;
        }
        specializations += "\n";
        materialsName += "\n";

        return staffByStaffId.getSurname() +
                " " + staffByStaffId.getName() +
                " " + staffByStaffId.getPatronymic() +
                "\n" + specializations +
                "\n" + materialsName;
    }

}
