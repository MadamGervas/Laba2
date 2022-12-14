package map;

import dasha.Materials;
import dasha.Service;

import java.util.List;

public class ServiceMap extends BaseOperationMap<Service> {
    public List<Service> findAllByName(Object name) {
        return findByField(".byService", name);
    }
    public List<Service> findAllByCost(Object cost) {
        return findByField(".byCost", cost);
    }

    @Override
    protected Class<Service> getType() {
        return Service.class;
    }

    @Override
    protected String getTableName() {
        return "Service";
    }
}
