package Menu;

import dasha.*;
import map.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

public class Menu {
    private ClientsMap clientsMap;
    private MaterialsMap materialsMap;
    private MastersMap masterMap;
    private ServiceMap serviceMap;
    private ServiceClientsMap serviceClientsMap;
    private MasterMaterialsMap masterMaterialsMap;
    private MasterSpecializationMap masterSpecializationMap;

    private SpecializationMap specializationMap;
    private StaffTransferMap staffTransferMap;
    private StaffMap staffMap;

    public Menu() throws IOException {
        createCLI();
    }

    public static String write() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        return reader.readLine();
    }


    private void createCLI() throws IOException {
        clientsMap = new ClientsMap();
        masterMap = new MastersMap();
        serviceClientsMap = new ServiceClientsMap();
        masterMaterialsMap = new MasterMaterialsMap();
        masterSpecializationMap = new MasterSpecializationMap();
        materialsMap = new MaterialsMap();
        staffTransferMap = new StaffTransferMap();
        serviceMap = new ServiceMap();
        specializationMap = new SpecializationMap();
        staffMap = new StaffMap();
        boolean isWorking = true;
        int answer = 0;
        int insideAnswer = 0;

        while (isWorking) {
            chooseMainMenu();
            try {
                answer = Integer.parseInt(write());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (answer) {
                case 1: {
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideStaffTransfer();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            case 1: {
                                for (int i = 0; i < staffTransferMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + staffTransferMap.findAll().get(i));
                                }
                                break;
                            }

                            case 2: {
                                StaffTransfer staffTransfer = new StaffTransfer();
                                System.out.println("Write position: ");
                                staffTransfer.setPosition(write());
                                System.out.println("Write reason of transfer: ");
                                staffTransfer.setReason(write());
                                System.out.println("Write number of order: ");
                                staffTransfer.setNumber(write());
                                System.out.println("Write date of this order (yyyy-mm-dd): ");
                                staffTransfer.setOrderDate(Date.valueOf(write()));
                                staffTransferMap.save(staffTransfer);

                                break;
                            }

                            case 3: {
                                boolean isEdit = true;

                                for (int i = 0; i < staffTransferMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + staffTransferMap.findAll().get(i));
                                }
                                System.out.print("What moving information you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                StaffTransfer staffTransferEdit = staffTransferMap.findAll().get(id - 1);
                                while (isEdit) {
                                    staffTransferEdit();
                                    System.out.println("Write what are you want to edit: ");
                                    int editKey = Integer.parseInt(write());
                                    switch (editKey) {
                                        case 1: {
                                            System.out.println("Write new position: ");
                                            staffTransferEdit.setPosition(write());
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("Write new transfer reason: ");
                                            staffTransferEdit.setReason(write());
                                            break;
                                        }

                                        case 3: {
                                            System.out.println("Write new number of order: ");
                                            staffTransferEdit.setNumber(write());
                                            break;
                                        }

                                        case 4: {
                                            System.out.println("Write new date of order (yyyy-mm-dd): ");
                                            staffTransferEdit.setOrderDate(Date.valueOf(write()));
                                            break;
                                        }

                                        default: {
                                            isEdit = false;
                                            break;
                                        }
                                    }

                                }

                                staffTransferMap.edit(staffTransferEdit);
                                break;
                            }

                            case 4: {
                                for (int i = 0; i < staffTransferMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + staffTransferMap.findAll().get(i));
                                }
                                System.out.print("What moving information you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                staffTransferMap.delete(staffTransferMap.findAll().get(id - 1));
                                break;
                            }

                            case 5: {
                                boolean isFind = true;
                                while (isFind) {
                                    staffTransferFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());

                                    switch (infoKey) {
                                        case 1: {
                                            System.out.println("Write: ");
                                            for (StaffTransfer movingInformation : staffTransferMap.findAllByPosition(write())) {
                                                System.out.println(movingInformation);
                                            }
                                            break;
                                        }

                                        case 2: {
                                            System.out.println("Write: ");
                                            for (StaffTransfer staffTransfer : staffTransferMap.findAllByReason(write())) {
                                                System.out.println(staffTransfer);
                                            }

                                            break;
                                        }

                                        case 3: {
                                            System.out.println("Write: ");
                                            for (StaffTransfer staffTransfer : staffTransferMap.findAllByNumber(write())) {
                                                System.out.println(staffTransfer);
                                            }

                                            break;
                                        }

                                        case 4: {
                                            System.out.println("Write: ");
                                            for (StaffTransfer movingInformation : staffTransferMap.findAllByOrderDate(write())) {
                                                System.out.println(movingInformation);
                                            }

                                            break;
                                        }

                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }
                                break;

                            }
                            default: {
                                insideMenu = false;
                                break;
                            }
                        }

                    }

                    break;
                }
                case 2: {
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideStaff();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            case 1: {
                                for (int i = 0; i < staffMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + staffMap.findAll().get(i));
                                }
                                break;
                            }

                            case 2: {
                                Staff staff = new Staff();
                                System.out.println("Write name of staff: ");
                                staff.setName(write());
                                System.out.println("Write surname of staff: ");
                                staff.setSurname(write());
                                System.out.println("Write patronymic of staff: ");
                                staff.setPatronymic(write());
                                System.out.println("Write address of staff: ");
                                staff.setAddress(write());
                                System.out.println("Write date of staff's birth (yyyy-mm-dd): ");
                                staff.setDateOfBirth(Date.valueOf(write()));
                                System.out.println("Write name of staff's position: ");
                                staff.setPosition(write());
                                System.out.println("Write salary of staff: ");
                                staff.setSalary(Integer.valueOf(write()));

                                for (int i = 0; i < staffTransferMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + staffTransferMap.findAll().get(i).getReason());
                                }

                                System.out.print("Write transfer reason: ");
                                staff.setStaffTransferByTransferId(staffTransferMap.findAll().get(Integer.parseInt(write()) - 1));
                                staffMap.save(staff);
                                break;
                            }

                            case 3: {
                                boolean isEdit = true;
                                for (int i = 0; i < staffMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + staffMap.findAll().get(i));
                                }
                                System.out.print("What staff you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Staff staffEdit = staffMap.findAll().get(id - 1);
                                while (isEdit) {
                                    staffEdit();
                                    System.out.println("Write what are you want to edit: ");
                                    int editKey = Integer.parseInt(write());

                                    switch (editKey) {
                                        case 1: {
                                            System.out.println("Write a new surname: ");
                                            staffEdit.setSurname(write());
                                            break;
                                        }

                                        case 2: {
                                            System.out.println("Write a new name: ");
                                            staffEdit.setName(write());
                                            break;
                                        }

                                        case 3: {
                                            System.out.println("Write a new patronymic: ");
                                            staffEdit.setPatronymic(write());
                                            break;
                                        }

                                        case 4: {
                                            System.out.println("Write a new address: ");
                                            staffEdit.setAddress(write());
                                            break;
                                        }

                                        case 5: {
                                            System.out.println("Write a new date of birth (yyyy-mm-dd): ");
                                            staffEdit.setDateOfBirth(Date.valueOf(write()));
                                            break;
                                        }

                                        case 6: {
                                            System.out.println("Write a new position: ");
                                            staffEdit.setPosition(write());
                                            break;
                                        }

                                        case 7: {
                                            System.out.println("Write a new staff's salary: ");
                                            staffEdit.setSalary(Integer.valueOf(write()));
                                            break;
                                        }

                                        default: {
                                            isEdit = false;
                                            break;
                                        }
                                    }

                                }
                                staffMap.edit(staffEdit);
                                break;
                            }

                            case 4: {
                                for (int i = 0; i < staffMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + staffMap.findAll().get(i));
                                }
                                System.out.print("What staff you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                staffMap.delete(staffMap.findAll().get(id - 1));
                                break;
                            }

                            case 5: {
                                boolean isFind = true;
                                while (isFind) {
                                    staffFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());
                                    switch (infoKey) {
                                        case 1: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAllBySurname(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        }

                                        case 2: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAllByName(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        }

                                        case 3: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAllByPatronymic(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        }

                                        case 4: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAllByAddress(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        }

                                        case 5: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAlByBirthDate(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        }

                                        case 6: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAllByPosition(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        }

                                        case 7: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAllBySalary(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        }

                                        default: {
                                            isFind = false;
                                            break;
                                        }

                                    }
                                }


                                break;
                            }


                            default: {
                                insideMenu = false;
                                break;
                            }
                        }

                    }
                    break;
                }
                case 3: {
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideMasters();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            case 1: {
                                for (int i = 0; i < masterMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + masterMap.findAll().get(i));
                                }
                                break;
                            }

                            case 2: {
                                Master masters = new Master();
                                for (int i = 0; i < staffMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + staffMap.findAll().get(i));
                                }
                                System.out.print("Write staff number: ");
                                masters.setStaffByStaffId(staffMap.findAll().get(Integer.parseInt(write()) - 1));
                                masterMap.save(masters);
                                break;
                            }

                            case 3: {
                                for (int i = 0; i < masterMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + masterMap.findAll().get(i));
                                }
                                System.out.print("What master you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Master mastersEdit = masterMap.findAll().get(id - 1);

                                for (int i = 0; i < staffMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + staffMap.findAll().get(i).getSurname() +
                                            staffMap.findAll().get(i).getName() + staffMap.findAll().get(i).getPatronymic() + staffMap.findAll().get(i).getPosition());
                                }
                                System.out.print("Choose staff: ");
                                mastersEdit.setStaffByStaffId(staffMap.findAll().get(Integer.parseInt(write()) - 1));

                                masterMap.edit(mastersEdit);
                                break;
                            }

                            case 4: {
                                for (int i = 0; i < masterMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + masterMap.findAll().get(i));
                                }
                                System.out.print("What master you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                masterMap.delete(masterMap.findAll().get(id - 1));
                                break;
                            }

                            case 5: {
                                boolean isFind = true;
                                while (isFind) {
                                    mastersFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());

                                    switch (infoKey) {
                                        case 1: {

                                            for (int i = 0; i < staffMap.findAll().size(); i++) {
                                                System.out.println((i + 1) + ". " + staffMap.findAll().get(i));
                                            }
                                            System.out.println("Choose staff: ");
                                            Staff staff = staffMap.findAll().get(Integer.parseInt(write()) - 1);

                                            for (Master master :
                                                    masterMap.findByStaff(staff)) {
                                                System.out.println(master);
                                            }

                                            break;
                                        }

                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }
                                break;
                            }

                            case 6: {
                                MasterSpecialization masterSpecialization = new MasterSpecialization();

                                for (int i = 0; i < specializationMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + specializationMap.findAll().get(i));
                                }
                                System.out.print("Write specialization number: ");
                                masterSpecialization.setSpecializationBySpecializationId(specializationMap.findAll().get(Integer.parseInt(write()) - 1));


                                for (int i = 0; i < masterMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + masterMap.findAll().get(i));
                                }
                                System.out.print("Write masters number: ");
                                masterSpecialization.setMasterByMasterId(masterMap.findAll().get(Integer.parseInt(write()) - 1));

                                masterSpecializationMap.save(masterSpecialization);

                                break;
                            }

                            case 7: {
                                for (int i = 0; i < masterSpecializationMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + masterSpecializationMap.findAll().get(i));
                                }
                                System.out.print("What master's specialization you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                masterSpecializationMap.delete(masterSpecializationMap.findAll().get(id - 1));
                                break;
                            }

                            case 8: {
                                MasterMaterials mastersMaterials = new MasterMaterials();

                                for (int i = 0; i < materialsMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + materialsMap.findAll().get(i));
                                }
                                System.out.print("Write materials number: ");
                                mastersMaterials.setMaterialsByMaterialsId(materialsMap.findAll().get(Integer.parseInt(write()) - 1));
                                for (int i = 0; i < masterMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + masterMap.findAll().get(i));
                                }
                                System.out.print("Write masters number: ");

                                mastersMaterials.setMasterByMasterId(masterMap.findAll().get(Integer.parseInt(write()) - 1));
                                System.out.println("Write count: ");
                                mastersMaterials.setCount(Integer.parseInt(write()));
                                masterMaterialsMap.save(mastersMaterials);

                                break;
                            }

                            case 9: {
                                for (int i = 0; i < masterMaterialsMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + masterMaterialsMap.findAll().get(i));
                                }
                                System.out.print("What master's materials you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                masterMaterialsMap.delete(masterMaterialsMap.findAll().get(id - 1));
                                break;
                            }

                            default: {
                                insideMenu = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideMaterials();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            case 1: {
                                for (int i = 0; i < materialsMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + materialsMap.findAll().get(i));
                                }
                                break;
                            }

                            case 2: {
                                Materials materials = new Materials();
                                System.out.println("Write name of material: ");
                                materials.setName(write());
                                System.out.println("Write unit measurement: ");
                                materials.setUnitMeasurement(write());
                                System.out.println("Write cost: ");
                                materials.setCost(Integer.valueOf(write()));
                                materialsMap.save(materials);
                                break;
                            }

                            case 3: {
                                boolean isEdit = true;
                                for (int i = 0; i < materialsMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + materialsMap.findAll().get(i));
                                }
                                System.out.print("What material you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Materials materialEdit = materialsMap.findAll().get(id - 1);

                                while (isEdit) {
                                    materialsEdit();
                                    System.out.println("Write what are you want to edit: ");
                                    int editKey = Integer.parseInt(write());
                                    switch (editKey) {
                                        case 1: {
                                            System.out.println("Write new name: ");
                                            materialEdit.setName(write());
                                            break;
                                        }
                                        case 2: {
                                            System.out.println("Write new unit measurement: ");
                                            materialEdit.setUnitMeasurement(write());
                                            break;
                                        }

                                        case 3: {
                                            System.out.println("Write new cost of material: ");
                                            materialEdit.setCost(Integer.valueOf(write()));
                                            break;
                                        }

                                        default: {
                                            isEdit = false;
                                            break;
                                        }
                                    }
                                }
                                materialsMap.edit(materialEdit);
                                break;
                            }

                            case 4: {
                                for (int i = 0; i < materialsMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + materialsMap.findAll().get(i));
                                }
                                System.out.print("What material you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                materialsMap.delete(materialsMap.findAll().get(id - 1));
                                break;
                            }

                            case 5: {
                                boolean isFind = true;
                                while (isFind) {
                                    materialsFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());
                                    switch (infoKey) {

                                        case 1: {
                                            System.out.println("Write: ");
                                            for (Materials materials : materialsMap.findAllByName(write())) {
                                                System.out.println(materials);
                                            }
                                            break;
                                        }

                                        case 2: {
                                            System.out.println("Write: ");
                                            for (Materials materials : materialsMap.findAllByUnitMeasurement(write())) {
                                                System.out.println(materials);
                                            }
                                            break;
                                        }

                                        case 3: {
                                            System.out.println("Write: ");
                                            for (Materials materials : materialsMap.findAllByCost(write())) {
                                                System.out.println(materials);
                                            }
                                            break;
                                        }

                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }

                                break;
                            }

                            default: {
                                insideMenu = false;
                                break;
                            }
                        }

                    }
                    break;

                }
                case 5: {
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideSpecialization();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            case 1: {
                                for (int i = 0; i < specializationMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + specializationMap.findAll().get(i));
                                }
                                break;
                            }

                            case 2: {
                                Specialization specialization = new Specialization();
                                System.out.println("Write Specialization");
                                specialization.setServicesList(write());
                                specializationMap.save(specialization);
                                break;
                            }

                            case 3: {
                                for (int i = 0; i < specializationMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + specializationMap.findAll().get(i));
                                }
                                System.out.print("What specialization you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Specialization specializationEdit = specializationMap.findAll().get(id - 1);
                                System.out.println("Write new name of specialization: ");
                                specializationEdit.setServicesList(write());
                                specializationMap.edit(specializationEdit);
                                break;
                            }


                            case 4: {
                                for (int i = 0; i < specializationMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + specializationMap.findAll().get(i));
                                }
                                System.out.print("What specialization you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                specializationMap.delete(specializationMap.findAll().get(id - 1));
                                break;

                            }


                            case 5: {
                                boolean isFind = true;
                                while (isFind) {
                                    specializationFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());

                                    switch (infoKey) {
                                        case 1: {
                                            System.out.println("Write: ");
                                            for (Specialization specialization : specializationMap.findAllByServicesList(write())) {
                                                System.out.println(specialization);
                                            }
                                            break;
                                        }
                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }
                                break;

                            }

                            default: {
                                insideMenu = false;
                                break;
                            }
                        }

                    }
                    break;
                }
                case 6: {
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideService();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            case 1: {
                                for (int i = 0; i < serviceMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + serviceMap.findAll().get(i));
                                }
                                break;
                            }

                            case 2: {
                                Service service = new Service();
                                System.out.println("Write name of service");
                                service.setService(write());
                                System.out.println("Write price of service");
                                service.setCost(write());

                                for (int i = 0; i < masterMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + masterMap.findAll().get(i).getStaffByStaffId().getSurname() + " "
                                            + masterMap.findAll().get(i).getStaffByStaffId().getName() + " "
                                            + masterMap.findAll().get(i).getStaffByStaffId().getPatronymic());
                                }
                                System.out.print("Write master: ");
                                service.setMasterByMasterId(masterMap.findAll().get(Integer.parseInt(write()) - 1));

                                serviceMap.save(service);
                                break;
                            }

                            case 3: {
                                boolean isEdit = true;
                                for (int i = 0; i < serviceMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + serviceMap.findAll().get(i));
                                }
                                System.out.print("What order you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Service serviceEdit = serviceMap.findAll().get(id - 1);
                                while (isEdit) {
                                    serviceEdit();
                                    System.out.println("Write what are you want to edit: ");
                                    int editKey = Integer.parseInt(write());
                                    switch (editKey) {

                                        case 1: {
                                            System.out.println("Write new service name: ");
                                            serviceEdit.setService(write());
                                            break;
                                        }

                                        case 2: {
                                            System.out.println("Write new price of service: ");
                                            serviceEdit.setCost(write());
                                            break;
                                        }

                                        default: {
                                            isEdit = false;
                                            break;
                                        }
                                    }

                                }
                                serviceMap.edit(serviceEdit);
                                break;
                            }

                            case 4: {
                                for (int i = 0; i < serviceMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + serviceMap.findAll().get(i));
                                }
                                System.out.print("What order you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                serviceMap.delete(serviceMap.findAll().get(id - 1));
                                break;
                            }

                            case 5: {
                                boolean isFind = true;
                                while (isFind) {
                                    serviceFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());
                                    switch (infoKey) {
                                        case 1: {
                                            System.out.println("Write: ");
                                            for (Service service : serviceMap.findAllByName(write())) {
                                                System.out.println(service);
                                            }
                                            break;
                                        }

                                        case 2: {
                                            System.out.println("Write: ");
                                            for (Service service : serviceMap.findAllByCost(write())) {
                                                System.out.println(service);
                                            }
                                            break;
                                        }

                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }

                                }
                                break;
                            }

                            default: {
                                insideMenu = false;
                                break;
                            }
                        }

                    }
                    break;

                }
                case 7: {
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideClients();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            case 1: {
                                for (int i = 0; i < clientsMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + clientsMap.findAll().get(i));
                                }
                                break;
                            }

                            case 2: {
                                Clients clients = new Clients();
                                System.out.println("Write surname of client: ");
                                clients.setSurname(write());
                                System.out.println("Write name of client: ");
                                clients.setName(write());
                                System.out.println("Write patronymic of client: ");
                                clients.setPatronymic(write());
                                System.out.println("Write phone number of client: ");
                                clients.setPhoneNumber(write());

                                clientsMap.save(clients);
                                break;
                            }

                            case 3: {
                                boolean isEdit = true;
                                for (int i = 0; i < clientsMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + clientsMap.findAll().get(i));
                                }
                                System.out.print("What client you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Clients clientEdit = clientsMap.findAll().get(id - 1);
                                while (isEdit) {
                                    clientEdit();
                                    System.out.println("Write what are you want to edit: ");
                                    int editKey = Integer.parseInt(write());
                                    switch (editKey) {

                                        case 1: {
                                            System.out.println("Write new surname: ");
                                            clientEdit.setSurname(write());
                                            break;
                                        }

                                        case 2: {
                                            System.out.println("Write new name: ");
                                            clientEdit.setName(write());
                                            break;
                                        }

                                        case 3: {
                                            System.out.println("Write new patronymic: ");
                                            clientEdit.setPatronymic(write());
                                            break;
                                        }

                                        case 4: {
                                            System.out.println("Write new phone number of client: ");
                                            clientEdit.setPhoneNumber(write());
                                            break;
                                        }

                                        default: {
                                            isEdit = false;
                                            break;
                                        }
                                    }
                                }
                                clientsMap.edit(clientEdit);
                                break;
                            }

                            case 4: {
                                for (int i = 0; i < clientsMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + clientsMap.findAll().get(i));
                                }
                                System.out.print("What client you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                clientsMap.delete(clientsMap.findAll().get(id - 1));
                                break;
                            }

                            case 5: {
                                boolean isFind = true;
                                while (isFind) {
                                    clientFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());
                                    switch (infoKey) {

                                        case 1: {
                                            System.out.println("Write: ");
                                            for (Clients clients : clientsMap.findAllBySurname(write())) {
                                                System.out.println(clients);
                                            }
                                            break;
                                        }

                                        case 2: {
                                            System.out.println("Write: ");
                                            for (Clients clients : clientsMap.findAllByName(write())) {
                                                System.out.println(clients);
                                            }
                                            break;
                                        }

                                        case 3: {
                                            System.out.println("Write: ");
                                            for (Clients clients : clientsMap.findAllByPatronymic(write())) {
                                                System.out.println(clients);
                                            }
                                            break;
                                        }

                                        case 4: {
                                            System.out.println("Write: ");
                                            for (Clients clients : clientsMap.findAllByPhoneNumber(write())) {
                                                System.out.println(clients);
                                            }
                                            break;
                                        }

                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }
                                break;
                            }

                            case 6: {
                                ServiceClients orderDate = new ServiceClients();

                                for (int i = 0; i < serviceMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + serviceMap.findAll().get(i));
                                }
                                System.out.print("Write order's number: ");
                                orderDate.setServiceByServiceId(serviceMap.findAll().get(Integer.parseInt(write()) - 1));


                                for (int i = 0; i < clientsMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + clientsMap.findAll().get(i));
                                }
                                System.out.print("Write client's number: ");
                                orderDate.setClientsByClientId(clientsMap.findAll().get(Integer.parseInt(write()) - 1));

                                System.out.println("Write date od order (yyyy-mm-dd): ");
                                orderDate.setServiceTime(Date.valueOf(write()));

                                serviceClientsMap.save(orderDate);

                                break;
                            }

                            case 7: {
                                for (int i = 0; i < serviceClientsMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " + serviceClientsMap.findAll().get(i));
                                }
                                System.out.print("What order you want to delete from client (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                serviceClientsMap.delete(serviceClientsMap.findAll().get(id - 1));
                                break;
                            }

                            default: {
                                insideMenu = false;
                                break;
                            }
                        }
                    }

                    break;
                }
                default: {
                    isWorking = false;
                    break;
                }
            }
        }
    }

    private void chooseMainMenu() {
        System.out.println("Beauty Salon");
        System.out.println("----------------------");
        System.out.println("1. Staff transfer");
        System.out.println("2. Staff");
        System.out.println("3. Masters");
        System.out.println("4. Materials");
        System.out.println("5. Specialization");
        System.out.println("6. Service");
        System.out.println("7. Client");
        System.out.println("0. Exit");
        System.out.println("Enter the item");
    }

    private void menuInsideStaffTransfer() {
        System.out.println("Staff transfer");
        System.out.println("1. List all staff transfer");
        System.out.println("2. Add a staff transfer");
        System.out.println("3. Edit a staff transfer");
        System.out.println("4. Delete staff transfer");
        System.out.println("5. Find field in staff transfer");
        System.out.println("0. Back");
    }

    private void staffTransferEdit() {
        System.out.println("What are you want to edit?");
        System.out.println("1. Position");
        System.out.println("2. Transfer reason");
        System.out.println("3. Number");
        System.out.println("4. Order date");
        System.out.println("0. Back");
    }

    private void staffTransferFind() {
        System.out.println("What are you want to find from?");
        System.out.println("1. Position");
        System.out.println("2. Transfer reason");
        System.out.println("3. Number");
        System.out.println("4. Order date");
        System.out.println("0. Back");
    }

    private void menuInsideStaff() {
        System.out.println("Staff");
        System.out.println("1. List all staffs");
        System.out.println("2. Add a staff");
        System.out.println("3. Edit a staff");
        System.out.println("4. Delete staff");
        System.out.println("5. Find field in staff");
        System.out.println("0. Back");
    }

    private void staffEdit() {
        System.out.println("What are you want to edit?");
        System.out.println("1. Surname");
        System.out.println("2. Name");
        System.out.println("3. Patronymic");
        System.out.println("4. Address");
        System.out.println("5. Date of birth");
        System.out.println("6. Position");
        System.out.println("7. Salary");
        System.out.println("0. Back");
    }

    private void staffFind() {
        System.out.println("What are you want to find from?");
        System.out.println("1. Surname");
        System.out.println("2. Name");
        System.out.println("3. Patronymic");
        System.out.println("4. Address");
        System.out.println("5. Date of birth");
        System.out.println("6. Position");
        System.out.println("7. Salary");
        System.out.println("0. Back");
    }

    private void menuInsideMasters() {
        System.out.println("Masters");
        System.out.println("1. List all masters");
        System.out.println("2. Add a master");
        System.out.println("3. Edit a master");
        System.out.println("4. Delete master");
        System.out.println("5. Find field in master");
        System.out.println("6. Add specialization to master");
        System.out.println("7. Remove specialization from master");
        System.out.println("8. Add materials to master");
        System.out.println("9. Remove materials from master");
        System.out.println("0. Back");
    }

    //todo - что делать с этим если там еще он и тута
    private void mastersFind() {
        System.out.println("What are you want to find from?");
        System.out.println("1. Surname");
        System.out.println("0. Back");
    }

    private void menuInsideSpecialization() {
        System.out.println("Specialization");
        System.out.println("1. List all specializations");
        System.out.println("2. Add a specialization");
        System.out.println("3. Edit a specialization");
        System.out.println("4. Delete specialization");
        System.out.println("5. Find field in specialization");
        System.out.println("0. Back");
    }

    private void specializationFind() {
        System.out.println("What are you want to find from?");
        System.out.println("1. Name of specialization");
        System.out.println("0. Back");
    }

    private void menuInsideMaterials() {
        System.out.println("Materials");
        System.out.println("1. List all materials");
        System.out.println("2. Add a material");
        System.out.println("3. Edit a material");
        System.out.println("4. Delete material");
        System.out.println("5. Find field in material");
        System.out.println("0. Back");
    }

    private void materialsEdit() {
        System.out.println("What are you want to edit?");
        System.out.println("1. Name");
        System.out.println("2. Unit measurement");
        System.out.println("3. Cost");
        System.out.println("0. Back");
    }

    private void materialsFind() {
        System.out.println("What are you want to find?");
        System.out.println("1. Name");
        System.out.println("2. Unit measurement");
        System.out.println("3. Cost");
        System.out.println("0. Back");
    }


    private void serviceEdit() {
        System.out.println("What are you want to edit?");
        System.out.println("1. Name of service");
        System.out.println("2. Price of service");
        System.out.println("0. Back");
    }

    private void serviceFind() {
        System.out.println("What are you want to find?");
        System.out.println("1. Name of service");
        System.out.println("2. Price of service");
        System.out.println("0. Back");
    }

    private void menuInsideService() {
        System.out.println("Service");
        System.out.println("1. List all service");
        System.out.println("2. Add a service");
        System.out.println("3. Edit a service");
        System.out.println("4. Delete service");
        System.out.println("5. Find field in service");
        System.out.println("0. Back");
    }

    private void menuInsideClients() {
        System.out.println("Clients");
        System.out.println("1. List all clients");
        System.out.println("2. Add a client");
        System.out.println("3. Edit a client");
        System.out.println("4. Delete client");
        System.out.println("5. Find field in client");
        System.out.println("6. Add order to client");
        System.out.println("7. Remove order from client");
        System.out.println("0. Back");
    }

    private void clientEdit() {
        System.out.println("What are you want to edit?");
        System.out.println("1. Surname of client");
        System.out.println("2. Name of client");
        System.out.println("3. Patronymic of client");
        System.out.println("4. Phone number of client");
        System.out.println("0. Back");
    }

    private void clientFind() {
        System.out.println("What are you want to find?");
        System.out.println("1. Surname of client");
        System.out.println("2. Name of client");
        System.out.println("3. Patronymic of client");
        System.out.println("4. Phone number of client");
        System.out.println("0. Back");
    }
}
