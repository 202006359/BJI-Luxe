package edu.comillas.icai.pat.ejemplopat.service;


import java.util.ArrayList;

import edu.comillas.icai.pat.ejemplopat.dto.UserDTO;
import edu.comillas.icai.pat.ejemplopat.model.UserModel;

public interface UserService{
    Iterable<UserModel> retrieveAll();

    void insertUser(String username, String password);
    void insertUser(String username, String password, String location);

    UserModel getUserByUsername(String username);
    ArrayList<UserDTO> getUsersLikeUsername(String username);

    boolean checkCredencialesUser(String username, String password_encrypted);
    boolean updateUser(String username, String password_encrypted,String location);
    boolean deleteUser(String username, String password_encrypted);
    
}
