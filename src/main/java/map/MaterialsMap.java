package map;

import dasha.Materials;

import java.util.List;

public class MaterialsMap extends BaseOperationMap<Materials> {
    public List<Materials> findAllByName(Object name) {
        return findByField(".byName", name);
    }
    public List<Materials> findAllByUnitMeasurement(Object unitMeasurement) {
        return findByField(".byUnitMeasurement", unitMeasurement);
    }

    public List<Materials> findAllByCost(Object cost) {
        return findByField(".byCost", cost);
    }

    @Override
    protected Class<Materials> getType() {
        return Materials.class;
    }

    @Override
    protected String getTableName() {
        return "Materials";
    }
}
