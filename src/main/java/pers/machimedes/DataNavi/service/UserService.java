package pers.machimedes.DataNavi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.machimedes.DataNavi.exception.AccountExistsException;
import pers.machimedes.DataNavi.exception.DatabaseOperationException;
import pers.machimedes.DataNavi.model.User;
import pers.machimedes.DataNavi.repository.UserRepository;
import pers.machimedes.DataNavi.util.BCryptPasswordEncoderUtil;
import pers.machimedes.DataNavi.util.ResultWrap;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResultWrap<User> createUser(User user) {
        List<User> users = null;
        try {
            users = queryUserByAccount(user);
        } catch (Exception exception) {
            return ResultWrap.fail(new DatabaseOperationException("查询用户失败"));
        }

        System.out.println(user);
        if (users == null || users.size() == 0) {
            user.setPassword(BCryptPasswordEncoderUtil.encode(user.getPassword()));
            User ret = userRepository.save(user);
            ret.setPassword(null);
            return ResultWrap.success(ret);
        } else {
            return ResultWrap.fail(new AccountExistsException());
        }
    }

    public List<User> queryUserByAccount(User user) throws Exception {
        return userRepository.findByAccount(user.getAccount());
    }
}