package dasha;

import jakarta.persistence.*;

@Entity
@Table(name = "master_specialization", schema = "public", catalog = "salon")
public class MasterSpecialization {
    @ManyToOne
    @JoinColumn(name = "master_id", referencedColumnName = "id")
    private Master masterByMasterId;
    @ManyToOne
    @JoinColumn(name = "specialization_id", referencedColumnName = "id")
    private Specialization specializationBySpecializationId;
    @Id
    private Long id;




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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
