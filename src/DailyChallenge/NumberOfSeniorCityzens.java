package DailyChallenge;

public class NumberOfSeniorCityzens {
    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(countSeniors(details));
    }

    public static int countSeniors(String[] details) {
        int res = 0;
        for(int i = 0 ; i < details.length; i++){
            String sub = details[i].substring(11,13);
            int num = Integer.parseInt(sub);
            if(num > 60)res++;
        }
        return res;
    }
}
