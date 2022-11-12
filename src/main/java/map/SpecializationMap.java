package map;
import dasha.Specialization;

import java.util.List;

public class SpecializationMap extends BaseOperationMap<Specialization> {
    public List<Specialization> findAllByServicesList(Object servicesList) {
        return findByField(".byServicesList", servicesList);
    }


    @Override
    protected Class<Specialization> getType() {
        return Specialization.class;
    }

    @Override
    protected String getTableName() {
        return "Specialization";
    }
}
