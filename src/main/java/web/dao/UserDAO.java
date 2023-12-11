package web.dao;


import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class UserDAO {
    private List<User> users;
    {
        users =new ArrayList<>();
        users.add(new User(1,"Emir","Abdullaev"));
        users.add(new User(2,"Emir","Abdullaev"));
        users.add(new User(3,"Emir","Abdullaev"));
        users.add(new User(4,"Emir","Abdullaev"));
        users.add(new User(5,"Emir","Abdullaev"));
    }
    public List<User> getUsers(){
        return users;
    }
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
    public void save(User user){
        users.add(user);
    }
    public void update(int id, User updateUser){
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setLastName(updateUser.getLastName());
    }
    public void delete(int id){
        users.removeIf(p->p.getId()==id);
    }
}