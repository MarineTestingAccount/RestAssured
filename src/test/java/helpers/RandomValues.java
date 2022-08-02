package helpers;

public class RandomValues {
    public long currentDateTime() {
        return System.currentTimeMillis();
        }
    public String randomName(){
            return "user" + currentDateTime();
        }
    public String randomEmail(){
        return "user" + currentDateTime() + '@' + "testing.com";
    }

    public String randomGender(){
        return currentDateTime()%2==0 ? "male":"female";
    }

    public String randomStatus(){
        return  currentDateTime()%2==0 ? "active":"inactive";
    }
}

