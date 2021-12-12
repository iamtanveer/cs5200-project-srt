package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Follow;
import com.example.springtemplate.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowRepository extends CrudRepository<Follow, Integer> {
    @Query(value = "SELECT * FROM follows",
            nativeQuery = true)
    public List<Follow> findAllFollows();
    @Query(value = "SELECT * FROM follows WHERE from_user_fk=:userId",
            nativeQuery = true)
    public List<Follow> findAllUserFollowing(@Param("userId") Integer userId);
    @Query(value = "SELECT * FROM follows WHERE to_user_fk=:userId",
            nativeQuery = true)
    public List<Follow> findAllUserFollowers(@Param("userId") Integer userId);

    @Query(value = "SELECT * FROM follows WHERE id=:followId",
            nativeQuery = true)
    public Follow findFollowById(@Param("followId") long followId);
}
