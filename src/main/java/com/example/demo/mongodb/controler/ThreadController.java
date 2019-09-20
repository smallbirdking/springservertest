package com.example.demo.mongodb.controler;

import com.example.demo.mongodb.entity.Thread;
import com.example.demo.mongodb.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/thread")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping("/find_userid")
    public List<Thread> findByUserId(Long userId) {
        return threadService.findByUserId(userId);
    }

    @RequestMapping(value= "/insert_thread", method = RequestMethod.PUT)
    public void saveThread(@RequestBody Thread thread) {
        threadService.insertThread(thread);
    }

}
