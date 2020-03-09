package com.example.demo.mongodb.controler;

import com.example.demo.Util.AuthenUtil;
import com.example.demo.mongodb.entity.UserHeader;
import com.example.demo.mongodb.entity.thread.*;
import com.example.demo.mongodb.entity.thread.Thread;
import com.example.demo.mongodb.service.RecommendedProviderService;
import com.example.demo.mongodb.service.ThreadService;
import com.example.demo.mysql.service.UserTokenService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/thread")
public class ThreadController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(ThreadController.class);

    @Autowired
    private ThreadService threadService;

    @Autowired
    private RecommendedProviderService recommendedProviderService;

    @Autowired
    HttpServletRequest requestHeader;

    @Autowired
    private UserTokenService userTokenService;

    @RequestMapping("/find_userid")
    public List<Thread> findByUserId(Long userId) {
        return threadService.findByUserId(userId);
    }

    @RequestMapping("/find/threadid")
    public Thread findByThreadId(String threadId) {
        return threadService.findByThreadId(threadId);
    }


//    @RequestMapping(value= "/insert_thread/thread_content", method = RequestMethod.PUT)
//    public void saveThread(@RequestBody Thread thread) {
//        threadService.insertThread(thread);
//    }

    @RequestMapping(value = "/insert_thread/thread_content", method = RequestMethod.PUT)
    public ThreadResponse saveThread(@RequestBody Thread thread) throws ParseException {
        ThreadResponse response = new ThreadResponse();
        long userId = authenticate(response);
        if (userId>0) {
            //Thread thread = new Thread();
            thread.setCreatedUserId(userId);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.getDefault());
//            thread.setCreatedTime(thread.getCreatedTime());//sdf.parse(threadContent.getCreatedTime()));
//            thread.setTrBody(thread.getTrBody());
//            thread.setTrSubject(thread.getTrSubject());
            Set<Long> admins = new HashSet<>();
            admins.add(userId);
            thread.setAdminList(admins);
//            thread.setImageList(thread.getImageList());
            threadService.insertThread(thread);
        }
        return response;
    }

    @RequestMapping(value = "/recommended/bref_thread", method = RequestMethod.GET)
    public RecommendedThreadsResponse collectRecommendedBriefThreads() {
      RecommendedThreadsResponse response = new RecommendedThreadsResponse();
      if (authenticate(response) > 0) {
        List<BrefThread> recommendedBriefThreads = recommendedProviderService.getRecommendedBriefThreads();
        for (BrefThread thread : recommendedBriefThreads) {

        }
        response.setRecommendedBriefThreads(recommendedBriefThreads);
      }
      return response;
    }

    @RequestMapping(value = "/join/one", method = RequestMethod.POST)
    public ThreadResponse joinInThreadAsParticipant(String threadId) {
        UserHeader userHeader = AuthenUtil.getUserHeader(requestHeader);
        ThreadResponse response = new ThreadResponse();
        long userId = userTokenService.verifyUserAuthen(userHeader, response);
        if (userId > 0) {
            Thread thread = threadService.findByThreadId(threadId);

            if (canJoinInThreadasParticipant(thread, userId)) {
                thread.addParticipant(userId);
                threadService.insertThread(thread);
                response.setAction(EnumThreadAnction.JOINASPARTICIPANT.getActionName());
            } else {
                response.setCode("4001");
                response.setMsg("NOT ALLOWED JOIN");
                LOG.error("4001", "NOT ALLOWED JOIN");
            }
        }
        return response;
    }

    @RequestMapping(value = "/quit/partner/one", method = RequestMethod.POST)
    public ThreadResponse quitInThreadInParticipant(String threadId) {
        UserHeader userHeader = AuthenUtil.getUserHeader(requestHeader);
        ThreadResponse response = new ThreadResponse();
        long userId = userTokenService.verifyUserAuthen(userHeader, response);
        if (userId > 0) {
            Thread thread = threadService.findByThreadId(threadId);

            if (canLeftInThreadasParticipant(thread, userId)) {
                thread.removeParticipant(userId);
                threadService.insertThread(thread);
                response.setAction(EnumThreadAnction.QUITINPARTICIPANT.getActionName());
            } else {
                response.setCode("4001");
                response.setMsg("NOT ALLOWED LEFT");
                LOG.error("4001", "NOT ALLOWED LEFT");
            }
        }
        return response;
    }

    @RequestMapping(value = "/left/one", method = RequestMethod.POST)
    public ThreadResponse leftThread(@RequestBody String threadId, Long userId) {
        Thread thread = threadService.findByThreadId(threadId);
        ThreadResponse response = new ThreadResponse();
        if (canLeftInThreadasParticipant(thread, userId)) {
            thread.removeParticipant(userId);
        } else {
            response.setCode("4001");
            response.setMsg("NOT ALLOWED LEFT");
            LOG.error("4001", "NOT ALLOWED LEFT");
        }
        return response;
    }

    private boolean canJoinInThreadasParticipant(Thread thread, Long userId) {
        if (thread == null){
            return false;
        }
        Set<Long> admins = thread.getAdminList();
        Set<Long> participants = thread.getParticipants();

        return (CollectionUtils.isEmpty(participants) || (CollectionUtils.isNotEmpty(participants) && !participants.contains(userId)))
                && (CollectionUtils.isNotEmpty(admins) && !admins.contains(userId));
    }

    private boolean canLeftInThreadasParticipant(Thread thread, Long userId) {
        if (thread == null){
            return false;
        }
        Set<Long> participants = thread.getParticipants();
        return CollectionUtils.isNotEmpty(participants) && participants.contains(userId);
    }

    @RequestMapping()
    public long defaultCall() {
      //Call the default method directly, or use the 'forward' String. Example:
      System.out.println("default method");
      return -1;
    }
}
