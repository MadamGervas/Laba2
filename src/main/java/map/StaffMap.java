package map;

import dasha.Staff;

import java.util.List;

public class StaffMap extends BaseOperationMap<Staff> {
    public List<Staff> findAllByName(Object name) {
        return findByField(".byName", name);
    }

    public List<Staff> findAllBySurname(Object surname) {
        return findByField(".bySurname", surname);
    }

    public List<Staff> findAllByPatronymic(Object patronymic) {
        return findByField(".byPatronymic", patronymic);
    }

    public List<Staff> findAllByAddress(Object address) {
        return findByField(".byAddress", address);
    }

    public List<Staff> findAllByPosition(Object position) {
        return findByField(".byPosition", position);
    }

    public List<Staff> findAlByBirthDate(Object birthDate) {
        return findByField(".byDateOfBirth", birthDate);
    }

    public List<Staff> findAllBySalary(Object salary) {
        return findByField(".bySalary", salary);
    }

    @Override
    protected Class<Staff> getType() {
        return Staff.class;
    }

    @Override
    protected String getTableName() {
        return "Staff";
    }
}
