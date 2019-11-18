package com.example.demo.mongodb.controler;

import com.example.demo.Util.AuthenUtil;
import com.example.demo.mongodb.entity.UserHeader;
import com.example.demo.mongodb.entity.thread.Thread;
import com.example.demo.mongodb.entity.thread.ThreadData;
import com.example.demo.mongodb.entity.thread.ThreadResponse;
import com.example.demo.mongodb.service.ThreadService;
import com.example.demo.mysql.service.UserTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/thread")
public class ThreadController {
    private static final Logger LOG = LoggerFactory.getLogger(ThreadController.class);

    @Autowired
    private ThreadService threadService;

    @Autowired
    private UserTokenService userTokenService;

    @Autowired
    HttpServletRequest requestHeader;

    @RequestMapping("/find_userid")
    public List<Thread> findByUserId(Long userId) {
        return threadService.findByUserId(userId);
    }

//    @RequestMapping(value= "/insert_thread/thread_content", method = RequestMethod.PUT)
//    public void saveThread(@RequestBody Thread thread) {
//        threadService.insertThread(thread);
//    }

    @RequestMapping(value = "/insert_thread/thread_content", method = RequestMethod.PUT)
    public ThreadResponse saveThread(@RequestBody ThreadData threadContent) throws ParseException {
        UserHeader userHeader = AuthenUtil.getUserHeader(requestHeader);
        ThreadResponse response = new ThreadResponse();
        long userId = userTokenService.verifyUserAuthen(userHeader, response);
        if (userId>0){
            Thread thread = new Thread();
            thread.setCreatedUserId(userId);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            sdf.parse(threadContent.getCreatedTime());
            thread.setCreatedTime(sdf.parse(threadContent.getCreatedTime()));
            thread.setTrBody(threadContent.getContent());
            thread.setTrSubject(threadContent.getTitle());
            threadService.insertThread(thread);
        }
        return response;
    }

}
