package com.example.demo.mysql;

import com.example.demo.mysql.entity.UserEntity;
import com.example.demo.mysql.entity.UserProfileEntity;
import com.example.demo.mysql.service.UserEntityService;
import com.example.demo.mysql.service.UserProfileEntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTest {

  @Autowired
  private UserEntityService userEntityService;

  @Autowired
  private UserProfileEntityService userProfileEntityService;

  @Test
  public void testfindAllUsers() {
    List<UserEntity> allUsers = userEntityService.findAll();
    for (UserEntity userEntity : allUsers) {
      printUser(userEntity);
    }
  }

  @Test
  public void testfindUsersByUserName() {
    List<UserEntity> allUsers = userEntityService.findByUserName("sbk");
    for (UserEntity userEntity : allUsers) {
      printUser(userEntity);
    }
  }

  @Test
  public void testfindUsersByUserID() {
    long id = 1;
    Optional<UserEntity> allUser = userEntityService.findByUserId(id);
    printUser(allUser.get());
  }

  @Test
  public void testfindUserProfileByUserID() {
    try (Stream<UserProfileEntity> allUserProfiles = userProfileEntityService.findByUserID(Long.valueOf(1))) {

      allUserProfiles.forEach(userProfile -> printUserProfile(userProfile));
    }
  }

  @Test
  public void testSaveUser() {
    Timestamp time2 = new Timestamp(new Date().getTime());

    UserEntity userEntity = new UserEntity();
    userEntity.setUserName("sbk0");
    userEntity.setUserPassword("123");
//    userEntity.setCreatedTime(time2);
    Optional<UserEntity> userEntityRs = userEntityService.insertUser(userEntity);

    printUser(userEntityRs.get());
  }

  @Test
  public void testSaveUserProfile() {
    long id = 1;
    Optional<UserEntity> allUser = userEntityService.findByUserId(id);
    UserProfileEntity userProfileEntity = new UserProfileEntity();
    userProfileEntity.setFirstName("YU");
    userProfileEntity.setLastName("W");
    // userProfileEntity.setNickName("sbk");
    // userProfileEntity.setPassword("123");
    userProfileEntity.setUserByUserId(allUser.get());
    Optional<UserProfileEntity> userProfileEntityRs = userProfileEntityService.insertUserProfile(userProfileEntity);

    printUserProfile(userProfileEntityRs.get());
  }

  @Test
  public void testDeleteUserByUserName() {
    int status = userEntityService.deleteByUsername("sbk0");
    System.out.println(status);
  }

  @Test
  public void testFindByFirstName() {
    Page<UserProfileEntity> userProfileEntity = userProfileEntityService.findByFirstName("YU",
        new PageRequest(0, 5, Sort.Direction.ASC, "nickName"));
    System.out.println(userProfileEntity);
  }

  private void printUser(UserEntity user) {
    StringBuffer s = new StringBuffer();
    s.append(user.getId());
    s.append(" " + user.getUserName());
    s.append(" " + user.getCreatedTime());
    s.append(" " + user.getCreatedBy());
    s.append(" " + user.getStatus());
    s.append(" " + user.getUpdatedTime());
    System.out.println(s.toString());
  }

  private void printUserProfile(UserProfileEntity userProfile) {
    StringBuffer s = new StringBuffer();
    s.append(userProfile.getId());
    s.append(" " + userProfile.getUserByUserId()
        .getUserName());
    s.append(" " + userProfile.getFirstName());
    s.append(" " + userProfile.getLastName());
    s.append(" " + userProfile.getNickName());
    s.append(" " + userProfile.getEmail());
    s.append(" " + userProfile.getBirthDay());
    s.append(" " + userProfile.getTelephone());
    s.append(" " + userProfile.getSex());
    s.append(" " + userProfile.getUserLevel());
    System.out.println(s.toString());
  }
}
