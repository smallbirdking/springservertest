package com.example.demo.mongodb.controler;

import com.example.demo.mongodb.entity.Thread;
import com.example.demo.mongodb.entity.ThreadData;
import com.example.demo.mongodb.entity.UserHeader;
import com.example.demo.mongodb.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

//    @RequestMapping(value= "/insert_thread/thread_content", method = RequestMethod.PUT)
//    public void saveThread(@RequestBody Thread thread) {
//        threadService.insertThread(thread);
//    }

    @RequestMapping(value= "/insert_thread/thread_content", method = RequestMethod.PUT)
    public void saveThread(@RequestHeader UserHeader userHeader, ThreadData threadContent) {
        long userId = userHeader.getUserId();
        Thread thread = new Thread();
        thread.setCreatedUserId(userId);
        thread.setCreatedTime(new Date());
        thread.setTrBody();

        threadService.insertThread(thread);
    }

}
