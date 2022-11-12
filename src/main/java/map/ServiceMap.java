package map;

import dasha.Service;

import java.util.List;

public class ServiceMap extends BaseOperationMap<Service> {
    public List<Service> findAllByName(Object name) {
        return findByField(".byName", name);
    }
    public List<Service> findAllByUnitMeasurement(Object unitMeasurement) {
        return findByField(".byUnitMeasurement", unitMeasurement);
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
