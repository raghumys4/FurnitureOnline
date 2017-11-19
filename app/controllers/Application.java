package controllers;


import Entity.register;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.Furnitue.Utils.PasswordHashing;
import play.mvc.*;

import java.lang.*;

import ServiceImpl.RegisterServiceImpl;
import views.html.*;
import javax.inject.Inject;

public class Application extends Controller {

    @Inject
    register registrationdetailsEntity;
    @Inject
    RegisterServiceImpl registerService;
    @Inject
    PasswordHashing passwordHashing;

    public  Result index() {
        return ok(index.render("Your new application is ready."));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result srv001(){
        JsonNode jsonNode=request().body().asJson();
        ObjectMapper jsonObjectMapper=new ObjectMapper();
        try{
            String reultPassword="";
            register registrationdetailsEntity = jsonObjectMapper.treeToValue(jsonNode, register.class);

            reultPassword=PasswordHashing.getSaltedHash(registrationdetailsEntity.getAt002());
            System.out.println("Hash"+reultPassword);
            registrationdetailsEntity.setAt002(reultPassword);
            registerService.saveRegistrationDetails(registrationdetailsEntity);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            return ok(":registration unsucessful");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ok(":registration unsucessful");

        }
        return ok(":registration sucess");
    }
}
