package feyz.com.basicApp.Business.Abstracts;

import feyz.com.basicApp.Entities.Concretes.User;

import java.util.List;

public interface UserService {
List<User> GetAll();
User GetById(Long id);
void DeleteById(Long id);
User Add(User user);
User Update(User user);



}
