package dasha;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Service {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "service")
    private String service;
    @Basic
    @Column(name = "cost")
    private String cost;
    @ManyToOne
    @JoinColumn(name = "master_id", referencedColumnName = "id")
    private Master masterByMasterId;
    @OneToMany(mappedBy = "serviceByServiceId")
    private Collection<ServiceClients> serviceClientsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service1 = (Service) o;

        if (id != service1.id) return false;
        if (service != null ? !service.equals(service1.service) : service1.service != null) return false;
        if (cost != null ? !cost.equals(service1.cost) : service1.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (service != null ? service.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    public Master getMasterByMasterId() {
        return masterByMasterId;
    }

    public void setMasterByMasterId(Master masterByMasterId) {
        this.masterByMasterId = masterByMasterId;
    }

    public Collection<ServiceClients> getServiceClientsById() {
        return serviceClientsById;
    }

    public void setServiceClientsById(Collection<ServiceClients> serviceClientsById) {
        this.serviceClientsById = serviceClientsById;
    }
    @Override
    public String toString() {
        return service +
                " " + cost + " rub";
    }
}
