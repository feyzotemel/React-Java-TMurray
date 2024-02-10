package feyz.com.basicApp.Business.Abstracts;

import feyz.com.basicApp.Entities.Concretes.User;

import java.util.List;

public interface UserService {
List<User> GetAll();
User GetById(int id);
void DeleteById(int id);
User Add(User user);
User Update(User user);



}
