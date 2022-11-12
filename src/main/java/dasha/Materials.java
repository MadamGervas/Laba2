package dasha;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@org.hibernate.annotations.NamedQuery(name = "Materials.byName", query = "From Materials p where upper(p.name) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Materials.bySurname", query = "from Materials p where upper(p.unitMeasurement) like concat('%', upper(?1), '%')")
@org.hibernate.annotations.NamedQuery(name = "Materials.byCost", query = "from Materials p where cost = ?1")
@org.hibernate.annotations.NamedQuery(name = "Materials.all", query = "from Materials p")
public class Materials {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "unit_measurement")
    private String unitMeasurement;
    @Basic
    @Column(name = "cost")
    private Integer cost;
    @OneToMany(mappedBy = "materialsByMaterialsId")
    private Collection<MasterMaterials> masterMaterialsById;

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

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Materials materials = (Materials) o;

        if (id != materials.id) return false;
        if (name != null ? !name.equals(materials.name) : materials.name != null) return false;
        if (unitMeasurement != null ? !unitMeasurement.equals(materials.unitMeasurement) : materials.unitMeasurement != null)
            return false;
        if (cost != null ? !cost.equals(materials.cost) : materials.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (unitMeasurement != null ? unitMeasurement.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    public Collection<MasterMaterials> getMasterMaterialsById() {
        return masterMaterialsById;
    }

    public void setMasterMaterialsById(Collection<MasterMaterials> masterMaterialsById) {
        this.masterMaterialsById = masterMaterialsById;
    }
    @Override
    public String toString() {
        return name +
                ", " + unitMeasurement +
                ", " + cost + " rub";
    }
}
