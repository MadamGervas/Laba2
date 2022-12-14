package map;

import dasha.MasterSpecialization;

public class MasterSpecializationMap extends BaseOperationMap<MasterSpecialization>{

    @Override
    protected Class<MasterSpecialization> getType() {
        return MasterSpecialization.class;
    }

    @Override
    protected String getTableName() {
        return "MasterSpecialization";
    }
}
