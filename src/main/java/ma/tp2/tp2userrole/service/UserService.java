package ma.tp2.tp2userrole.service;

import ma.tp2.tp2userrole.entities.Role;
import ma.tp2.tp2userrole.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName,String roleName);
    User authentificate(String userName,String password);
}