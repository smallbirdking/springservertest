package com.example.demo.mongodb.controler;

import com.example.demo.mongodb.entity.UserHeader;
import com.example.demo.mongodb.entity.thread.Thread;
import com.example.demo.mongodb.entity.thread.ThreadData;
import com.example.demo.mongodb.entity.thread.ThreadResponse;
import com.example.demo.mongodb.service.ThreadService;
import com.example.demo.mysql.service.UserTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/thread")
public class ThreadController {
    private static final Logger LOG = LoggerFactory.getLogger(ThreadController.class);

    @Autowired
    private ThreadService threadService;

    @Autowired
    private UserTokenService userTokenService;

    @RequestMapping("/find_userid")
    public List<Thread> findByUserId(Long userId) {
        return threadService.findByUserId(userId);
    }

//    @RequestMapping(value= "/insert_thread/thread_content", method = RequestMethod.PUT)
//    public void saveThread(@RequestBody Thread thread) {
//        threadService.insertThread(thread);
//    }

    @RequestMapping(value = "/insert_thread/thread_content", method = RequestMethod.PUT)
    public ThreadResponse saveThread(@RequestHeader UserHeader userHeader, ThreadData threadContent) {
        ThreadResponse response = new ThreadResponse();
        long userId = userTokenService.verifyUserAuthen(userHeader, response);

        if (userId>0){
            Thread thread = new Thread();
            thread.setCreatedUserId(userId);
            thread.setCreatedTime(threadContent.getCreatedTime());
            thread.setTrBody(threadContent.getContent());
            thread.setTrSubject(threadContent.getTitle());
            threadService.insertThread(thread);
        }
        return response;
    }
}
