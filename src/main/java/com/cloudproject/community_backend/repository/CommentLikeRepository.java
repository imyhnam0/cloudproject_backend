package com.cloudproject.community_backend.repository;

import com.cloudproject.community_backend.entity.Comment;
import com.cloudproject.community_backend.entity.CommentLike;
import com.cloudproject.community_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
    Optional<CommentLike> findByCommentAndUser(Comment comment, User user);
    long countByCommentAndLiked(Comment comment, boolean liked);

    @Modifying
    @Transactional
    @Query("DELETE FROM CommentLike cl WHERE cl.comment.id IN (SELECT c.id FROM Comment c WHERE c.post.id = :postId)")
    void deleteByPostId(Long postId);
}
