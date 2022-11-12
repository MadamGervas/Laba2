package Menu;

import dasha.Materials;
import dasha.Specialization;
import dasha.Staff;
import dasha.StaffTransfer;
import map.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

public class Menu {
    private ClientsMap clientsMap;
    private MaterialsMap materialsMap;
    private ServiceMap serviceMap;

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
//        mastersMapper = new MastersMapper();
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
                case 1: { // MovingInformation
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideMovingInformation();
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
                            } //Write moving information

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
                            } //Add a moving information

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
                                    movingInformationEdit();
                                    System.out.println("Write what are you want to edit: ");
                                    int editKey = Integer.parseInt(write());
                                    switch (editKey) {
                                        case 1: {
                                            System.out.println("Write new position: ");
                                            staffTransferEdit.setPosition(write());
                                            break;
                                        } // edit Position
                                        case 2: {
                                            System.out.println("Write new transfer reason: ");
                                            staffTransferEdit.setReason(write());
                                            break;
                                        } // edit Transfer reason

                                        case 3: {
                                            System.out.println("Write new number of order: ");
                                            staffTransferEdit.setNumber(write());
                                            break;
                                        } // edit Order number

                                        case 4: {
                                            System.out.println("Write new date of order (yyyy-mm-dd): ");
                                            staffTransferEdit.setOrderDate(Date.valueOf(write()));
                                            break;
                                        } // edit Date of order

                                        default: {
                                            isEdit = false;
                                            break;
                                        }
                                    }

                                }

                                staffTransferMap.edit(staffTransferEdit);
                                break;
                            } // Edit a moving information

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
                            } //Delete moving information

                            case 5: {
                                boolean isFind = true;
                                while (isFind) {
                                    movingInformationFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());
                                    /*
                                    *  System.out.println("1. Position");
                                        System.out.println("2. Transfer reason");
                                        System.out.println("3. Order number");
                                        System.out.println("4. Date of order");
                                    * */
                                    switch (infoKey) {
                                        case 1: {
                                            System.out.println("Write: ");
                                            for (StaffTransfer movingInformation :  staffTransferMap.findAllByPosition(write())) {
                                                System.out.println(movingInformation);
                                            }
                                            break;
                                        } // find Position

                                        case 2: {
                                            System.out.println("Write: ");
                                            for (StaffTransfer staffTransfer : staffTransferMap.findAllByReason(write())) {
                                                System.out.println(staffTransfer);
                                            }

                                            break;
                                        }//find Transfer reason

                                        case 3: {
                                            System.out.println("Write: ");
                                            for (StaffTransfer staffTransfer : staffTransferMap.findAllByNumber(write())) {
                                                System.out.println(staffTransfer);
                                            }

                                            break;
                                        }//find Order number

                                        case 4: {
                                            System.out.println("Write: ");
                                            for (StaffTransfer movingInformation : staffTransferMap.findAllByOrderDate(write())) {
                                                System.out.println(movingInformation);
                                            }

                                            break;
                                        }//find ODate of order

                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }
                                break;

                            } //  Find field in moving information
                            default: {
                                insideMenu = false;
                                break;
                            }
                        }

                    }


                }
                case 2: { // Staff
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
                            } //Write staff

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

                                for (int i = 0; i <  staffTransferMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " +  staffTransferMap.findAll().get(i).getReason());
                                }

                                System.out.print("Write transfer reason: ");
                                staff.setStaffTransferByTransferId(staffTransferMap.findAll().get(Integer.parseInt(write()) - 1));
                                staffMap.save(staff);
                                break;
                            } //Add a staff

                            case 3: {
                                boolean isEdit = true;
                                for (int i = 0; i <  staffMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " +  staffMap.findAll().get(i));
                                }
                                System.out.print("What staff you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Staff staffEdit =  staffMap.findAll().get(id - 1);
                                while (isEdit) {
                                    staffEdit();
                                    System.out.println("Write what are you want to edit: ");
                                    int editKey = Integer.parseInt(write());

                                    switch (editKey) {
                                        case 1: {
                                            System.out.println("Write a new surname: ");
                                            staffEdit.setSurname(write());
                                            break;
                                        } //Surname

                                        case 2: {
                                            System.out.println("Write a new name: ");
                                            staffEdit.setName(write());
                                            break;
                                        } //Name

                                        case 3: {
                                            System.out.println("Write a new patronymic: ");
                                            staffEdit.setPatronymic(write());
                                            break;
                                        } // Patronymic

                                        case 4: {
                                            System.out.println("Write a new address: ");
                                            staffEdit.setAddress(write());
                                            break;
                                        } // Address

                                        case 5: {
                                            System.out.println("Write a new date of birth (yyyy-mm-dd): ");
                                            staffEdit.setDateOfBirth(Date.valueOf(write()));
                                            break;
                                        } // Date of birth

                                        case 6: {
                                            System.out.println("Write a new position: ");
                                            staffEdit.setPosition(write());
                                            break;
                                        } // Position

                                        case 7: {
                                            System.out.println("Write a new staff's salary: ");
                                            staffEdit.setSalary(Integer.valueOf(write()));
                                            break;
                                        } // Salary

                                        default: {
                                            isEdit = false;
                                            break;
                                        }
                                    }

                                }
                                staffMap.edit(staffEdit);
                                break;
                            }  //Edit a staff

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
                            } //Delete staff

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
                                        } // Find Surname

                                        case 2: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAllByName(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find Name

                                        case 3: {
                                            System.out.println("Write: ");
                                            for (Staff staff :  staffMap.findAllByPatronymic(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find patronymic

                                        case 4: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAllByAddress(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find address

                                        case 5: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAlByBirthDate(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find date of birth

                                        case 6: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAllByPosition(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find position

                                        case 7: {
                                            System.out.println("Write: ");
                                            for (Staff staff : staffMap.findAllBySalary(write())) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find salary

                                        default: {
                                            isFind = false;
                                            break;
                                        }

                                    }
                                }


                                break;
                            } //  Find field in staff


                            default: {
                                insideMenu = false;
                                break;
                            }
                        }

                    }
                    break;
                }
//                case 3: { // Masters
//                    boolean insideMenu = true;
//                    while (insideMenu) {
//                        menuInsideMasters();
//                        try {
//                            insideAnswer = Integer.parseInt(write());
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                        switch (insideAnswer) {
//                            case 1: {
//                                var masters = mastersMapper.findAll();
//                                for (int i = 0; i < masters.size(); i++) {
//                                    System.out.println((i + 1) + ". " + masters.get(i));
//                                }
//                                break;
//                            } //Write Master
//
//                            case 2: {
//                                Masters masters = new Masters();
//                                System.out.println("Write surname: ");
//                                masters.setSurname(write());
//                                mastersMapper.save(masters);
//                                break;
//                            }//Save master
//
//                            case 3: {
//                                var masters = mastersMapper.findAll();
//                                for (int i = 0; i < masters.size(); i++) {
//                                    System.out.println((i + 1) + ". " + masters.get(i));
//                                }
//                                System.out.print("What master you want to edit (0 to exit): ");
//                                int id = Integer.parseInt(write());
//                                if (id == 0)
//                                    break;
//                                Masters mastersEdit = masters.get(id - 1);
//                                System.out.println("Write new position: ");
//                                mastersEdit.setSurname(write());
//                                mastersMapper.edit(mastersEdit);
//                                break;
//                            } // Edit master

//                            case 4: {
//                                var masters = mastersMapper.findAll();
//                                for (int i = 0; i < masters.size(); i++) {
//                                    System.out.println((i + 1) + ". " + masters.get(i));
//                                }
//                                System.out.print("What master you want to delete (0 to exit): ");
//                                int id = Integer.parseInt(write());
//                                if (id == 0)
//                                    break;
//                                mastersMapper.delete(masters.get(id - 1));
//                                break;
//                            } //delete master
//
//                            case 5: {
//                                boolean isFind = true;
//                                while (isFind) {
//                                    mastersFind();
//                                    System.out.println("Write what are you want to find: ");
//                                    int infoKey = Integer.parseInt(write());
//
//                                    switch (infoKey) {
//                                        case 1: {
//                                            System.out.println("Write: ");
//                                            var masterFind = mastersMapper.findAllBySurname(write());
//                                            for (Masters masters : masterFind) {
//                                                System.out.println(masters);
//                                            }
//                                            break;
//                                        } // find surname
//
//                                        default: {
//                                            isFind = false;
//                                            break;
//                                        }
//                                    }
//                                }
//                                break;
//                            }
//                            default: {
//                                insideMenu = false;
//                                break;
//                            }
//                        }
//
//                    }
//                    break;
//
//                }
                case 4: { // Materials
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
                            } //Write Materials

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
                            } //Add a Materials

                            case 3: {
                                boolean isEdit = true;
                                for (int i = 0; i <  materialsMap.findAll().size(); i++) {
                                    System.out.println((i + 1) + ". " +  materialsMap.findAll().get(i));
                                }
                                System.out.print("What material you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Materials materialEdit =  materialsMap.findAll().get(id - 1);

                                while (isEdit) {
                                    materialsEdit();
                                    System.out.println("Write what are you want to edit: ");
                                    int editKey = Integer.parseInt(write());
                                    switch (editKey) {
                                        case 1: {
                                            System.out.println("Write new name: ");
                                            materialEdit.setName(write());
                                            break;
                                        } // edit Name
                                        case 2: {
                                            System.out.println("Write new unit measurement: ");
                                            materialEdit.setUnitMeasurement(write());
                                            break;
                                        } // edit unit measurement

                                        case 3: {
                                            System.out.println("Write new cost of material: ");
                                            materialEdit.setCost(Integer.valueOf(write()));
                                            break;
                                        } // edit cost

                                        default: {
                                            isEdit = false;
                                            break;
                                        }
                                    }
                                }
                                materialsMap.edit(materialEdit);
                                break;
                            } //Edit Material

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
                            } //Delete Material

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
                                        } //find name

                                        case 2: {
                                            System.out.println("Write: ");
                                            for (Materials materials : materialsMap.findAllByUnitMeasurement(write())) {
                                                System.out.println(materials);
                                            }
                                            break;
                                        } //find unit mesurement

                                        case 3: {
                                            System.out.println("Write: ");
                                            for (Materials materials :  materialsMap.findAllByCost(write())) {
                                                System.out.println(materials);
                                            }
                                            break;
                                        } //find by cost

                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }

                                break;
                            } //Edit material

                            default: {
                                insideMenu = false;
                                break;
                            }
                        }

                    }
                    break;

                }
                case 5: { // Specialization
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
                            } //Write Specialization

                            case 2: {
                                Specialization specialization = new Specialization();
                                System.out.println("Write Specialization");
                                specialization.setServicesList(write());
                                specializationMap.save(specialization);
                                break;
                            } //Add Specialization

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
                            } //Edit Specialization


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

                            } //Delete Specialization


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
                                        } // find name of specialiation
                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }
                                break;

                            } //Find Specialization

                            default: {
                                insideMenu = false;
                                break;
                            }
                        }

                    }
                    break;
                }
                case 6: { // Order
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideOrder();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            //TODO
                        }

                    }
                    break;

                }
                case 7: { // Client
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideClients();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            //TODO
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
        System.out.println("1. Moving Information");
        System.out.println("2. Staff");
        System.out.println("3. Masters");
        System.out.println("4. Materials");
        System.out.println("5. Specialization");
        System.out.println("6. Order");
        System.out.println("7. Client");
        System.out.println("0. Exit");
        System.out.println("Enter the item");
    }

    private void menuInsideMovingInformation() {
        System.out.println("Moving Information");
        System.out.println("1. List all moving information");
        System.out.println("2. Add a moving information");
        System.out.println("3. Edit a moving information");
        System.out.println("4. Delete moving information");
        System.out.println("5. Find field in moving information");
        System.out.println("0. Back");
    }

    private void movingInformationEdit() {
        System.out.println("What are you want to edit?");
        System.out.println("1. Position");
        System.out.println("2. Transfer reason");
        System.out.println("3. Order number");
        System.out.println("4. Date of order");
        System.out.println("0. Back");
    }

    private void movingInformationFind() {
        System.out.println("What are you want to find from?");
        System.out.println("1. Position");
        System.out.println("2. Transfer reason");
        System.out.println("3. Order number");
        System.out.println("4. Date of order");
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
        System.out.println("0. Back");
    }

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

    private void menuInsideOrder() {
        System.out.println("Order");
        System.out.println("1. List all orders");
        System.out.println("2. Add a order");
        System.out.println("3. Edit a order");
        System.out.println("4. Delete order");
        System.out.println("5. Find field in order");
        System.out.println("0. Back");
    }

    private void menuInsideClients() {
        System.out.println("Clients");
        System.out.println("1. List all clients");
        System.out.println("2. Add a client");
        System.out.println("3. Edit a client");
        System.out.println("4. Delete client");
        System.out.println("5. Find field in client");
        System.out.println("0. Back");
    }
}
