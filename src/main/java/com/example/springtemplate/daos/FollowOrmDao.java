package com.example.springtemplate.daos;

import com.example.springtemplate.models.Follow;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.FollowRepository;
import com.example.springtemplate.repositories.UserRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FollowOrmDao {
    @Autowired
    FollowRepository followRepository;

    @PostMapping("/api/follows")
    public Follow createFollow(@RequestBody Follow relation ) {
        return followRepository.save(relation);
    }

    @GetMapping("/api/follows")
    public List<Follow> findAllFollows() {
        List<Follow> l = followRepository.findAllFollows();
        for (Follow f : l) {
            System.out.println(f.getFrom() + "  "+ f.getTo());
        }
        return followRepository.findAllFollows();
    }

    @GetMapping("/api/follows/{followId}")
    public Follow findFollowById(@PathVariable("followId") Integer followId) {
        return followRepository.findFollowById(followId);
    }

    @PutMapping("/api/follows/{followId}")
    public void updateFollowsById(@PathVariable("followId") Integer followId, @RequestBody User fromUser, User toUser) {
        Follow f = followRepository.findFollowById(followId);
        f.setFrom(fromUser);
        f.setTo(toUser);
        followRepository.save(f);
    }

    @GetMapping("/api/follows/following/{userId}")
    public List<Follow> findAllUserFollowing(
            @PathVariable("userId") Integer userId
    ) {
        return followRepository.findAllUserFollowing(userId);
    }

    @GetMapping("/api/follows/followers/{userId}")
    public List<Follow> findAllUserFollowers(
            @PathVariable("userId") Integer userId
    ) {
        return followRepository.findAllUserFollowers(userId);
    }

    @DeleteMapping("/api/follows/{followId}")
    public void deleteFollowsById(@PathVariable("followId") Integer followId) {
        followRepository.deleteById(followId);
    }
}