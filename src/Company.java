public class Company {
    private String companyName;
    private String companyCode;
    private int numberOfJourneys;
    private Journey [] journeyHistory = new Journey[100000];

    public Company (String x, String y){
        this.companyName = x;
        this.companyCode = y;
        this.numberOfJourneys = 0;

    }

    public Company (){

    }

    Journey getJourney (int x){
        return journeyHistory[x];
    }

    public void addJourney (Journey j){
        journeyHistory [numberOfJourneys] = j;
        numberOfJourneys++;
    }

    public double averageDelay(){
        double sum=0;
        for (Journey journey : journeyHistory){
            sum=sum+journey.getDelay();
        }
        return sum/numberOfJourneys;
    }

    public String longestDelay (Codes[] c){
        return "";
    }

    public String toString (Codes[] c){
        return "";
    }
}
