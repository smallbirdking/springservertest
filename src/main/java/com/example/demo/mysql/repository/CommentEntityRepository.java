package com.example.demo.mysql.repository;

import com.example.demo.mysql.entity.CommentEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentEntityRepository extends CrudRepository<CommentEntity,Long> {
    @Query(value = "select * from Comment where THREAD_ID = ?1 and LAST_COMMENT_ID = null limit ?2, ?3 order by ID", nativeQuery = true)
    List<CommentEntity> findPrimeCommentByThreadID(String threadId, int begin, int end);

    @Query(value = "select * from Comment where THREAD_ID = ?1 and LAST_COMMENT_ID = ?2 limit ?3, ?4 order by ID", nativeQuery = true)
    List<CommentEntity> findSubCommentByThreadID(String threadId, long lastCommentId, int begin, int end);

    @Query("SELECT COUNT(c) FROM CommentEntity c WHERE c.threadId = ?1 and c.lastCommentId is null")
    Long countPrimeCommentAmount(String threadId);

    @Query("SELECT COUNT(c) FROM CommentEntity c WHERE c.threadId = ?1 and c.lastCommentId = ?2")
    Long countSubCommentAmount(String threadId, long lastCommentId);

    @Transactional()
    @Modifying
    @Query("UPDATE CommentEntity c SET c.status = :status WHERE c.id = :commentId")
    int updateStatus(@Param("commentId") long id, @Param("status") String status);
}
