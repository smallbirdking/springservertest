package com.example.demo.mysql.repository;

import com.example.demo.mysql.entity.UserTokenEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTokenEntityRepository extends CrudRepository<UserTokenEntity, Long> {

    @Query("select u from UserTokenEntity u where u.userId = ?1")
    List<UserTokenEntity> findByUserID(long id);

    @Query("select u from UserTokenEntity u where u.userId = ?1 and u.token = ?2")
    Optional<UserTokenEntity> findByUserIDAndToken(long id, String token);

    @Transactional()
    @Modifying
    @Query("delete from UserTokenEntity where userId = ?1 and refreshToken = ?2")
    int deleteByUsername(long id, String repositoryToken);

    @Transactional()
    @Modifying
    @Query("UPDATE UserTokenEntity u SET u.token = :token WHERE u.userId = :id")
    int upadte(@Param("id") long id,@Param("token") String token);
//    @Async
//     (t.dbname like '%'||?1||'%' or ?1='')
//    ListenableFuture<UserEntity> findOneByLastname(String lastname);
}