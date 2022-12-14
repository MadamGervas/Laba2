package map;

import dasha.Master;
import dasha.Staff;

import java.util.List;


public class MastersMap extends BaseOperationMap<Master> {

    public List<Master> findByStaff(Object staff){
        return ((Staff)staff).getMastersById();
    }

    @Override
    protected Class<Master> getType() {
        return Master.class;
    }

    @Override
    protected String getTableName() {
        return "Master";
    }
}
