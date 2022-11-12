package dasha;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "service_clients", schema = "public", catalog = "salon")
public class ServiceClients {
    @Basic
    @Column(name = "service_time")
    private Date serviceTime;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Clients clientsByClientId;
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service serviceByServiceId;
    @Id
    private Long id;


    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceClients that = (ServiceClients) o;

        if (serviceTime != null ? !serviceTime.equals(that.serviceTime) : that.serviceTime != null) return false;

        return true;
    }


    public Clients getClientsByClientId() {
        return clientsByClientId;
    }

    public void setClientsByClientId(Clients clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }

    public Service getServiceByServiceId() {
        return serviceByServiceId;
    }

    public void setServiceByServiceId(Service serviceByServiceId) {
        this.serviceByServiceId = serviceByServiceId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
