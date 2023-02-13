import DSYS.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        String trainCompanyName;
        String companyCode;
        String check = "null"; // general variable used for prompts(note: in the code the variable is set to "null"
        // as a string in code instead as null (object) because the .equals method can only check for strings not object
        ArrayList<Company> allCompanies = new ArrayList<Company>(); //array of all companies added
        boolean prompt;
        int counter = 0; //keeps track of the amount of companies created
        while (run) {
            while (!(check.equals("train company") || (check.equals("tci") || check.equals("add journey")))) {
                check = Input.getString("Create a new train company,add a journey to an" +
                        " existing company, ot output train company information?" +
                        " (train company, add journey, tci)\n");
            }
            if (check.equals("train company")) {
                trainCompanyName = Input.getString("What is the name of your train company?\n");
                companyCode = Input.getString("what is the code of the company?\n");
                allCompanies.add(new Company(trainCompanyName, companyCode));
                check = "null";
                while (!(check.equals("y") || check.equals("n"))) {
                    check = Input.getString("Add a journey (y or n)\n");
                }
                while (!check.equals("n")) {
                    String routeCode;
                    int delay;
                    boolean weatherRelated;
                    routeCode = Input.getString("What is the routeCode?\n");
                    delay = Input.getInt("What is the delay in minutes?\n");
                    weatherRelated = Input.getBool("is the delay weather related? (t or f)\n", 't', 'f');
                    Journey journey = new Journey(routeCode, delay, weatherRelated);
                    allCompanies.get(counter).addJourney(journey);
                    check = "null";
                    while (!(check.equals("y") || check.equals("n"))) {
                        check = Input.getString("Add a journey? (y or n)\n");
                    }
                }
                counter = counter + 1;
            } else if (check.equals("tci")) {
                check = "null";
                check = Input.getString("what is the name of the companies information you would like to" +
                        "output?\n");
                if (counter > 0) {
                    for (int i = 0; i <= counter; i++) {
                        if (allCompanies.get(i).getCompanyName().equals(check)) {
                            System.out.println(allCompanies.get(i).getCompanyName() + allCompanies.get(i).getCompanyCode());
                            for (int x = 1; x <= allCompanies.get(i).getNumberOfJourneys(); x++) {
                                System.out.println(allCompanies.get(i).getJourney(x));
                                i = counter + 1;
                            }
                        } else {
                            System.out.println("System could not find company.If you wish to retry please re enter tci and " +
                                    "restart the search");
                        }
                    }
                } else {
                    System.out.println("System could not find company any train company. If you wish to search for one" +
                            "please add one using the train company option");
                }
            }else{
            check = "null";
            check = Input.getString("what is the name of the companies information you would like to" +
                    "add a journey to?\n");
            if(counter > 0){
            for (int i = 0; i <= counter; i++) {
                if (allCompanies.get(i).getCompanyName().equals(check)) {
                    String routeCode;
                    int delay;
                    boolean weatherRelated;
                    routeCode = Input.getString("What is the routeCode?\n");
                    delay = Input.getInt("What is the delay in minutes?\n");
                    weatherRelated = Input.getBool("is the delay weather related? (t or f)\n", 't', 'f');
                    Journey journey = new Journey(routeCode, delay, weatherRelated);
                    allCompanies.get(i).addJourney(journey);
                    check = "null";
                    while (!(check.equals("y") || check.equals("n"))) {
                        check = Input.getString("would you like to add one more? (y or n)\n");
                    }
                    while (!check.equals("n")) {
                        routeCode = Input.getString("What is the routeCode?\n");
                        delay = Input.getInt("What is the delay in minutes?\n");
                        weatherRelated = Input.getBool("is the delay weather related? (t or f)\n", 't', 'f');
                        Journey journey2 = new Journey(routeCode, delay, weatherRelated);
                        allCompanies.get(counter).addJourney(journey);
                        check = "null";
                        while (!(check.equals("y") || check.equals("n"))) {
                            check = Input.getString("would you like to add one more? (y or n)\n");
                        }
                        i = counter + 1;
                    }
                } else {
                    System.out.println("System could not find company and therefore could not allow you to add a journey" +
                            ".If you wish to retry please re enter add journey and restart the addition process");
                }
            }
            }else{
                System.out.println("System could not find any company in the system please add a train company using" +
                        "the train company command");
            }
        }

        }
    }
}