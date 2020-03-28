






package ie.gmit.single;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class UserController {
    //Handles incoming JSON requests that work on User resource/entity
        private UserPServer userServer = new UserPServer();
        //Create a new user
        public String createUser(String userJson) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(userJson, User.class);
            ValidateU theUser = new ValidateU();
            boolean checkUser = theUser.checkUser(user);
            if(!checkUser) {
                return "ERROR";
            }
            userServer.saveUser(user);
            return "SUCCESS";
        }

 }

