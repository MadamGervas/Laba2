package dasha;

import jakarta.persistence.*;

@Entity
@org.hibernate.annotations.NamedQuery(name = "MasterSpecialization.all", query = "from MasterSpecialization p")
@Table(name = "master_specialization", schema = "public", catalog = "salon")

public class MasterSpecialization {
    @Id
    @ManyToOne
    @JoinColumn(name = "master_id", referencedColumnName = "id")
    private Master masterByMasterId;
    @Id
    @ManyToOne
    @JoinColumn(name = "specialization_id", referencedColumnName = "id")
    private Specialization specializationBySpecializationId;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MasterSpecialization that = (MasterSpecialization) o;

        return true;
    }

    public Master getMasterByMasterId() {
        return masterByMasterId;
    }

    public void setMasterByMasterId(Master masterByMasterId) {
        this.masterByMasterId = masterByMasterId;
    }

    public Specialization getSpecializationBySpecializationId() {
        return specializationBySpecializationId;
    }

    public void setSpecializationBySpecializationId(Specialization specializationBySpecializationId) {
        this.specializationBySpecializationId = specializationBySpecializationId;
    }


        @Override
        public String toString() {
            return specializationBySpecializationId.getServicesList() +
                    ", " +masterByMasterId.getStaffByStaffId().getSurname() +
                    " " +masterByMasterId.getStaffByStaffId().getName() +
                    " " +masterByMasterId.getStaffByStaffId().getPatronymic();

    }
}
