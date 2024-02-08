package feyz.com.basicApp.Data.Concretes;

import feyz.com.basicApp.Data.Abstracts.UserRepository;
import feyz.com.basicApp.Entities.Concretes.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryUserRepository implements UserRepository {
    List<User> users;
    public InMemoryUserRepository() {
        users = new ArrayList<User>();
        var user1 =  new User(
                1,
                "test@email.com",
                new Date(1991,01,13),
                "TestUser1",
                new Date(),
                1
        );

        var user2 = new User(
                2,
                "test2@email.com",
                new Date(1991,01,14),
                "TestUser2",
                new Date(),
                2
        );

        users.add(user1);
        users.add(user2);
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User Add(User user) {
        users.add(user);
        return  user;
    }

    @Override
    public User Update(User user) {
        Optional<User> existUserOptional = users.stream().filter(x -> x.getId() == user.getId()).findFirst();

        if (existUserOptional.isPresent()) {
            User existUser = existUserOptional.get();
            existUser.setFull_Name(user.getFull_Name());
            existUser.setEmail(user.getEmail());
            existUser.setDate_Birthday(user.getDate_Birthday());
            return existUser;
        } else {
            // Handle case where user with given ID is not found
            return null; // or throw an exception, depending on your requirements
        }
    }

}
