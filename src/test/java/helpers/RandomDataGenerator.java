package helpers;

import pojo.Data;

public class RandomDataGenerator {
    public long currentDateTime() {
        return System.currentTimeMillis();
    }

    public String randomName() {
        return "user" + currentDateTime();
    }

    public String randomEmail() {
        return "user" + currentDateTime() + '@' + "testing.com";
    }

    public String randomGender() {
        return currentDateTime() % 2 == 0 ? "male" : "female";
    }

    public String randomStatus() {
        return currentDateTime() % 2 == 0 ? "active" : "inactive";
    }

    public Data setRandomData() {
        String randName = this.randomName();
        String randGender = this.randomGender();
        String randEmail = this.randomEmail();
        String randStatus = this.randomStatus();

        Data requestUser = new Data(randName, randGender, randEmail, randStatus);
        return requestUser;
    }

    public Data setRandomDataWithEmptyName() {
        String randName = "";
        String randGender = this.randomGender();
        String randEmail = this.randomEmail();
        String randStatus = this.randomStatus();

        Data requestUser = new Data(randName, randGender, randEmail, randStatus);
        return requestUser;
    }
}
