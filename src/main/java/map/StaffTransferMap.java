package map;

import dasha.StaffTransfer;

import java.util.List;

public class StaffTransferMap extends BaseOperationMap<StaffTransfer> {
    public List<StaffTransfer> findAllByPosition(Object position) {
        return findByField(".byPosition", position);
    }

    public List<StaffTransfer> findAllByReason(Object reason) {
        return findByField(".byReason", reason);
    }

    public List<StaffTransfer> findAllByNumber(Object number) {
        return findByField(".byNumber", number);
    }

    public List<StaffTransfer> findAllByOrderDate(Object orderDate) {
        return findByField(".byOrderDate", orderDate);
    }


    @Override
    protected Class<StaffTransfer> getType() {
        return StaffTransfer.class;
    }

    @Override
    protected String getTableName() {
        return "StaffTransfer";
    }
}
