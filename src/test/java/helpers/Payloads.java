package helpers;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    RandomValues randomValues = new RandomValues();

    protected String randName = randomValues.randomName();
    protected String randGender = randomValues.randomGender();
    protected String randEmail = randomValues.randomEmail();
    protected String randStatus = randomValues.randomStatus();

    public void createOrPutUserPayload(){
        Map<String, String> user = new HashMap<>();
        user.put("name", randName);
        user.put("gender", randGender);
        user.put("email", randEmail);
        user.put("status", randStatus);
    }

    public void patchUserNameAndEmailPayload(){
        Map<String, String> user = new HashMap<>();
        user.put("name", randName);
        user.put("email", randEmail);
    }
    public void patchUserNameGenderEmailPayload(){
        Map<String, String> user = new HashMap<>();
        user.put("name", randName);
        user.put("gender", randGender);
        user.put("email", randEmail);
    }
    public void patchUserStatusPayload(){
        Map<String, String> user = new HashMap<>();
        user.put("status", randStatus);
    }
}
