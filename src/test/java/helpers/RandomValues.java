package helpers;

public class RandomValues {
//    public String GetRandomString(int n) {
//        // lower limit for LowerCase Letters
//        int lowerLimit = 97;
//
//        // lower limit for LowerCase Letters
//        int upperLimit = 122;
//
//        Random random = new Random();
//
//        // Create a StringBuffer to store the result
//        StringBuffer r = new StringBuffer(n);
//
//        for (int i = 0; i < n; i++) {
//
//            // take a random value between 97 and 122
//            int nextRandomChar = lowerLimit
//                    + (int) (random.nextFloat()
//                    * (upperLimit - lowerLimit + 1));
//
//            // append a character at the end of bs
//            r.append((char) nextRandomChar);
//        }
//
//        // return the resultant string
//        return r.toString();
//    }
//}


    public long currentDateTime() {
            long currentDateTime = System.currentTimeMillis();
            return currentDateTime;
        }

        public String randomName(){
            String createRandomName = "user" + currentDateTime();
            return  createRandomName;
        }
    public String randomEmail(){
        String createRandomEmail = "user" + currentDateTime() + '@' + "testing.com";
        return  createRandomEmail;
    }

    public String randomGender(){
        String createRandomGender = currentDateTime()%2==0 ? "male":"female";
        return  createRandomGender;
    }

    public String randomStatus(){
        String createRandomStatus = currentDateTime()%2==0 ? "active":"inactive";
        return  createRandomStatus;
    }
    }

