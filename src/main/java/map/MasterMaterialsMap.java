package map;

import dasha.MasterMaterials;

public class MasterMaterialsMap extends BaseOperationMap<MasterMaterials>{
    @Override
    protected Class<MasterMaterials> getType() {
        return MasterMaterials.class;
    }

    @Override
    protected String getTableName() {
        return "MasterMaterials";
    }
}
