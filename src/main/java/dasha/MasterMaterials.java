package dasha;

import jakarta.persistence.*;

@Entity
@Table(name = "master_materials", schema = "public", catalog = "salon")
public class MasterMaterials {
    @Basic
    @Column(name = "count")
    private Integer count;
    @ManyToOne
    @JoinColumn(name = "master_id", referencedColumnName = "id")
    private Master masterByMasterId;
    @ManyToOne
    @JoinColumn(name = "materials_id", referencedColumnName = "id")
    private Materials materialsByMaterialsId;
    @Id
    private Long id;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MasterMaterials that = (MasterMaterials) o;

        if (count != null ? !count.equals(that.count) : that.count != null) return false;

        return true;
    }


    public Master getMasterByMasterId() {
        return masterByMasterId;
    }

    public void setMasterByMasterId(Master masterByMasterId) {
        this.masterByMasterId = masterByMasterId;
    }

    public Materials getMaterialsByMaterialsId() {
        return materialsByMaterialsId;
    }

    public void setMaterialsByMaterialsId(Materials materialsByMaterialsId) {
        this.materialsByMaterialsId = materialsByMaterialsId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
