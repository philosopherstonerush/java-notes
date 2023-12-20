package com.bsn.testEx.TestProject.Controllers;

import com.bsn.testEx.TestProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserRepository userDao;

}
