package map;

import dasha.Clients;

import java.util.List;

public class ClientsMap extends BaseOperationMap<Clients> {
    public List<Clients> findAllByName(Object name) {
        return findByField(".byName", name);
    }
    public List<Clients> findAllBySurname(Object surname) {
        return findByField(".bySurname", surname);
    }
    public List<Clients> findAllByPatronymic(Object patronymic) {
        return findByField(".byPatronymic", patronymic);
    }

    public List<Clients> findAllByPhoneNumber(Object phoneNumber) {
        return findByField(".byPhoneNumber", phoneNumber);
    }


    @Override
    protected Class<Clients> getType() {
        return Clients.class;
    }

    @Override
    protected String getTableName() {
        return "Clients";
    }
}
