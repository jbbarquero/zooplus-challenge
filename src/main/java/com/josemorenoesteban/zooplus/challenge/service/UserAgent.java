package com.josemorenoesteban.zooplus.challenge.service;

import com.josemorenoesteban.zooplus.challenge.domain.SystemUser;
import com.josemorenoesteban.zooplus.challenge.domain.SystemUserRepository;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAgent {
    @Autowired private SystemUserRepository systemUsers;

    public boolean exist(String email, String password) {
        try {
            return systemUsers.countByEmailAndPassword(email, systemUsers.encrypt(password)) != 0;
        } catch (NoSuchAlgorithmException  | NoSuchPaddingException | IllegalBlockSizeException | 
                 BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(UserAgent.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 

    public boolean signup(String email, String password) {
        try {
            SystemUser newUser = new SystemUser();
            newUser.setEmail(email);
            newUser.setPassword(systemUsers.encrypt(password));
            // Rest of signup fields
            return systemUsers.save(newUser) != null;
        } catch (NoSuchAlgorithmException  | NoSuchPaddingException | IllegalBlockSizeException | 
                 BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(UserAgent.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 

}
