package org.itis.hib.service;

import org.itis.hib.domain.RegistratedUser;
import org.apache.commons.codec.digest.DigestUtils;
import org.itis.hib.util.Constants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDS on 11.05.2016.
 */
@Service
public class RegistratedUserService {
    private static List<RegistratedUser> usersList;

    static {
        usersList=new ArrayList<>();
        RegistratedUser user1 = new RegistratedUser();
        user1.setLogin("admin");
        String password = "123456"+ Constants.SAULT;
        String hashPass = DigestUtils.md5Hex(password);
        user1.setHash_password(hashPass);
        RegistratedUser user2 = new RegistratedUser();
        user2.setLogin("angelina");
        String password2="123457"+ Constants.SAULT;
        String hashPassw2=DigestUtils.md5Hex(password2);
        user2.setHash_password(hashPassw2);
        usersList.add(user1);
        usersList.add(user2);

    }

    public List<RegistratedUser> getUsersList() {

        return usersList;

    }

    public RegistratedUser getUserByLogin(String login) {

        for (RegistratedUser user : usersList) {

            if (user.getLogin().equals(login))

                return user;

        }

        return null;

    }
}
