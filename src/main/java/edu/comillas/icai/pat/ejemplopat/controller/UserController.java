package edu.comillas.icai.pat.ejemplopat.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.comillas.icai.pat.ejemplopat.dao.UserModel;
import edu.comillas.icai.pat.ejemplopat.dto.UserDTO;
import edu.comillas.icai.pat.ejemplopat.service.impl.UserServiceImpl;
import edu.comillas.icai.pat.ejemplopat.util.PasswordEncrypter;
import lombok.extern.slf4j.Slf4j;




@Controller //indica a Spring que esta clase recibe peticiones http
@Slf4j
public class UserController{
    private final static String DIV_HTML="&";
    private final static String username_key="username";
    private final static String password_key="password";
    private final static String password_repeat_key="password_repeat";
    private final static String location_key="localidad";



    @Autowired
    private UserServiceImpl userService;




    @GetMapping("user_search/{username}")
    public ResponseEntity<ArrayList<String>> getUserListByUserName(@PathVariable String username)
    {
        if (!isAlphanumeric(username)) 
        {
            log.error("Error: El usarname no es alfanumerico");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        else //efectivamente es alfanumerico, se lo paso al siguiente
        {
            ArrayList<UserDTO> userDTOs=userService.getUsersLikeUsername(username);
            ArrayList<String> lista_resp= new ArrayList<String>();
            for(UserDTO s: userDTOs)
            {
                lista_resp.add(s.toString());
            }
            log.info("Accediendo a getUserListByUserName");
            return ResponseEntity.status(HttpStatus.OK).body(lista_resp);
        }

    }



    //Put porque estoy haciendo cambios en algo que ya existe en mi base de Datos
    @PutMapping("user_update")
    public ResponseEntity<String> confirmUser(@RequestBody String user)
    {
        String message="";
        String[] clave_valor= user.split(DIV_HTML);
        HashMap<String,String> info_user= new HashMap<String,String>();
        for (int i=0; i<clave_valor.length;i++)
        {
            String[] info=clave_valor[i].split("=");
            if(info.length>1)
            {
                info_user.put(info[0], info[1]);
            }
        }
        String username = info_user.get(username_key);
        String password = info_user.get(password_key);
        String password_repeat = info_user.get(password_repeat_key);
        String location = info_user.get(location_key);

        if (!isAlphanumeric(username))
        {
            message = "\nError, el nombre de usuario no puede contener caracteres especiales, solo puede estar formado por letras y numeros.";
            log.error(message);
            return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
        }
        else if (!password.equals(password_repeat))
        {
            message = "\nError, las contraseñas no son iguales.";
            log.error(message);
            return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
        }
        else if (location != null && !isAlphabetical(location))
        {
            message = "\nError, la localidad del usuario solo puede estar formada por letras.";
            log.error(message);
            return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
        }
        else //todos los checks de seguridad garantizados, paso a verificar credenciales se lo paso al siguiente
         {
            try
            {   //Encriptamos la contraseña para verificar que es igual a la contraseña encriptada anteriormente
                PasswordEncrypter encriptacion= new PasswordEncrypter();
                String password_encrypt= encriptacion.encrypt(password);

                boolean done=userService.updateUser(username, password_encrypt, location);
                if(done)//si ha ido bien
                {
                    message="Operacion realizada con exito, tu nueva localidad es: " + location;
                    log.info(message);
                    return new ResponseEntity<String>(message,HttpStatus.OK);
                }
                else
                {
                    message="Error, usuario y/o contraseña incorrectos";
                    log.error(message);
                    return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
                }
            }
            catch(Exception e)
            { 
                System.out.println(e);
                message="Ha habido un error en el servidor, vuelva a intentarlo más tarde";
                log.error(message);
                return new ResponseEntity<String>(message,HttpStatus.SERVICE_UNAVAILABLE);
            }
        }

    }          
    

    

    @PutMapping("verify_user")
    public ResponseEntity<Boolean> existsUser(@RequestBody String body_html)
    {
        String message="";
        HashMap<String,String> parametros= new  HashMap<String,String>();
        String[] data=body_html.split(DIV_HTML);
        for(String s: data)
        {
            String[] key_value=s.split("=");
            parametros.put(key_value[0],key_value[1]);
        }
        String username = parametros.get(username_key);
        String password = parametros.get(password_key);
        String password_repeat = parametros.get(password_repeat_key);

        if (!isAlphanumeric(username))
        {
            message = "\nError, el nombre de usuario no puede contener caracteres especiales, solo puede estar formado por letras y numeros.";
            log.error(message);
            return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);

        }
        else if (!password.equals(password_repeat))
        {
            message = "\nError, las contraseñas no son iguales.";
            log.error(message);
            return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);

        }
        else//ha pasado los checks
        {
            try
            {   //Encriptamos la contraseña para verificar que es igual a la contraseña encriptada anteriormente
                PasswordEncrypter encriptacion= new PasswordEncrypter();
                String password_encrypt= encriptacion.encrypt(password);
                boolean done= userService.checkCredencialesUser(username, password_encrypt);

                if(done)//si ha ido bien, es el
                {
                    message="Inicio de sesión correcto.\n";
                    log.info(message);
                    return new ResponseEntity<Boolean>(true,HttpStatus.OK);

                }
                else
                {
                    message="Error, usuario y/o contraseña incorrectos";
                    log.error(message);                    
                    return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);

                }
            }
            catch(Exception e)
            { 
                System.out.println(e);
                message="Ha habido un error en el servidor";
                log.error(message);                
                return new ResponseEntity<Boolean>(false,HttpStatus.SERVICE_UNAVAILABLE);

            }        
        }

    }










































    @DeleteMapping("delete_user")
    public ResponseEntity<String> deleteUser(@RequestBody String body_html)
    {
        String message="";
        HashMap<String,String> parametros= new  HashMap<String,String>();
        String[] data=body_html.split(DIV_HTML);
        for(String s: data)
        {
            String[] key_value=s.split("=");
            parametros.put(key_value[0],key_value[1]);
        }
        String username = parametros.get(username_key);
        String password = parametros.get(password_key);
        String password_repeat = parametros.get(password_repeat_key);

        if (!isAlphanumeric(username))
        {
            message = "\nError, el nombre de usuario no puede contener caracteres especiales, solo puede estar formado por letras y numeros.";
            return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
        }
        else if (!password.equals(password_repeat))
        {
            message = "\nError, las contraseñas no son iguales.";
            return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
        }
        else//ha pasado los checks
        {
            try
            {   //Encriptamos la contraseña para verificar que es igual a la contraseña encriptada anteriormente
                PasswordEncrypter encriptacion= new PasswordEncrypter();
                String password_encrypt= encriptacion.encrypt(password);

                boolean done=userService.deleteUser(username, password_encrypt);
                if(done)//si ha ido bien
                {
                    message="Operacion realizada con exito, usuario eliminado";
                    return new ResponseEntity<String>(message,HttpStatus.OK);
                }
                else
                {
                    message="Error, usuario y/o contraseña incorrectos";
                    return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
                }
            }
            catch(Exception e)
            { 
                System.out.println(e);
                message="Ha habido un error en el servidor";
                return new ResponseEntity<String>(message,HttpStatus.SERVICE_UNAVAILABLE);
            }        
        }

    }














    @PostMapping("create_user")
    public ResponseEntity<String> createUser(@RequestBody String user, Model model)
    {
        String message="";
        //RedirectView redirectView = new RedirectView();
        //redirectView.setUrl("/FormularioSignUp.html");

        HashMap<String,String> info_user= new HashMap<String,String>();
        String[] clave_valor= user.split(DIV_HTML);
        for (int i=0; i<clave_valor.length;i++)
        {
            String[] info=clave_valor[i].split("=");
            if(info.length>1)
            {
                info_user.put(info[0], info[1]);
            }
        }
    
        String username = info_user.get(username_key);
        String password = info_user.get(password_key);
        String password_repeat = info_user.get(password_repeat_key);
        String location = info_user.get(location_key);
    
        if (!isAlphanumeric(username))
        {
            message = message+ "\nError, el nombre de usuario no puede contener caracteres especiales, solo puede estar formado por letras y numeros.";
            model.addAttribute("message", message);
            return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
        }
        else if (!password.equals(password_repeat))
        {
            message = message+"\nError, las contraseñas no son iguales.";
            model.addAttribute("message", message);
            return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
        }
        else if (location != null && !isAlphabetical(location))
        {
            message = message+ "\nError, la localidad del usuario solo puede estar formada por letras.";
            model.addAttribute("message", message);
            return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
        }
        else
        {
            UserModel userSearched=userService.getUserByUsername(username);
            if(userSearched==null) //database devuelve vacio, no hay nadie con este nombre -> creo user
            {
                try{
                    PasswordEncrypter encriptacion= new PasswordEncrypter();
                    String password_encrypt= encriptacion.encrypt(password);
                    //Encriptamos la contraseña
                    userService.insertUser(username, password_encrypt, location);
                    message="Su cuenta ha sido creada con éxito!";
                    return new ResponseEntity<String>(message,HttpStatus.CREATED);

                }
                catch(Exception e)
                {
                    System.out.println(e);
                    message="Error en el servidor, por favor refresca la pagina e intentalo de nuevo";
                    return new ResponseEntity<String>(message,HttpStatus.SERVICE_UNAVAILABLE);

                }
            }
            else
            {
                 message = message + "\nError, ya hay una cuenta creada con este username. Por favor, seleccione otro username.";
                 model.addAttribute("message", message);
                 return new ResponseEntity<String>(message,HttpStatus.IM_USED);
                }
        }

    }    
    
    
    @GetMapping("get_user_id/{username}")
    public ResponseEntity<Long> getUserIdByUserName(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUsername(username).getUserId());
    }

    











/**
    EndPoint usado para comprobar la informacion de usuarios en la base de datos
    En la practica esta funcion no es utiilzada por lo que se deja comentada
**/

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserModel>> retrieveAll()
    {
        return new ResponseEntity<Iterable<UserModel>>(userService.retrieveAll(), HttpStatus.OK);    
    }


    
    boolean isAlphanumeric(String check)
    {
		String abc_num="abcdefghijklmnñopqrstuvwxyz1234567890";        
		for(int i=0; i<check.length();i++)
		{
			if( (abc_num.contains(check.substring(i,i+1).toLowerCase()) )==false)
			{
                return false;
			}
		}
        return true;
    }

    boolean isAlphabetical(String check)
    {
        String abc="abcdefghijklmnñopqrstuvwxyz";
		for(int i=0; i<check.length();i++)
		{
			if( (abc.contains(check.substring(i,i+1).toLowerCase()) )==false)
			{
                return false;
			}
		}
        return true;
    }

}
