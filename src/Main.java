public class Main {
    public static void main(String[] args) {
        Boolean run = true;
        String trainCompanyName;
        String companyCode;
        String check = null;
        Boolean prompt;
        while(run) {
            while(!(check.equals("train company")||(check.equals("search")))){
                check = Input.getString("Create a new train company or search (train company or search)");
            }
            if(check.equals("train company")){
                trainCompanyName = Input.getString("What is the name of your train company");
                companyCode = Input.getString("what is the code of the company");
            }else{
                prompt = true;
                while (prompt) {

                }
            }
        }
    }
}