package Dao;
import pojo.User;
public interface RegDao {
void registerUser(User u);
int gerUser(String name);
}
