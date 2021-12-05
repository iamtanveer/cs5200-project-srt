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
    public List<Follow> findAllRelationsByFollowsId(@Param("userId") Integer userId);
    @Query(value = "SELECT * FROM follows WHERE to_user_fk=:userId",
            nativeQuery = true)
    public List<Follow> findAllRelationsByFollowersId(@Param("userId") Integer userId);

    @Query(value = "DELETE FROM follows WHERE from_user_fk=:userId1 AND to_user_fk=:userId2",
            nativeQuery = true)
    public void deleteRelation(@Param("userId1") Integer userId1, @Param("userId2") Integer userId2);
}
