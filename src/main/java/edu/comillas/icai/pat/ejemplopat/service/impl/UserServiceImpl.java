package edu.comillas.icai.pat.ejemplopat.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.comillas.icai.pat.ejemplopat.dao.UserModel;
import edu.comillas.icai.pat.ejemplopat.dto.UserDTO;
import edu.comillas.icai.pat.ejemplopat.repository.UserRepository;
import edu.comillas.icai.pat.ejemplopat.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<UserModel> retrieveAll()
    {
        return userRepository.findAll();
    }


    @Override
    public void insertUser(String username, String password)
    {
        userRepository.insertUser(username, password);
    }

    @Override
    public void insertUser(String username, String password, String location)
    {
        userRepository.insertUser(username, password, location);
    }



    @Override
    public UserModel getUserByUsername(String username)
    {
        return userRepository.getUserByUsername(username);
    }






    @Override
    public ArrayList<UserDTO> getUsersLikeUsername(String username)
    {
        ArrayList<UserModel> userModels= userRepository.getUsersLikeUsername(username);
        ArrayList<UserDTO> userDTOs= new ArrayList<UserDTO>();
        for (UserModel u : userModels)
        {
            userDTOs.add(new UserDTO(u.getUserId(),u.getUsername(),u.getNameLocation()));
        }
        return userDTOs;

    }


    @Override
    public boolean checkCredencialesUser(String username, String password_encrypted)
    {
        UserModel userSearched= getUserByUsername(username);
            if(userSearched!=null) //database devuelve vacio, no hay nadie con este nombre -> creo user
            {
                
                if(username.equals(userSearched.getUsername() )&& password_encrypted.equals(userSearched.getPassword()) )
                {   //Usuario autenticado, se procede a actualizar sus credenciales
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else{ //Si no existe el user, false
                return false;
            }   
    }

    @Override
    public boolean updateUser(String username, String password_encrypted, String location)
    {
        boolean okay=checkCredencialesUser(username, password_encrypted);
        if(okay)
        {
            userRepository.updateUser(username, location);
            return true;
        }
        else
        {
            return false;
        }
    }



    @Override
    public boolean deleteUser(String username, String password_encrypted)
    {
        boolean okay=checkCredencialesUser(username, password_encrypted);
        if(okay)
        {
            userRepository.deleteUser(username);
            return true;
        }
        else
        {
            return false;
        }
    }







    /*
    @Override
    public UserDetails loadUserByUsername(String username)
    {
        UserModel user = userRepository.findByUsername(username);

        List<GrantedAuthority> roles = new ArrayList<>();

        UserDetails newUser= new User(user.getUsername(), user.getPassword(), roles);
        //usuario, contraseña, roles
        //rol = mas o menos acceso

        return newUser;
    }

    */
}
