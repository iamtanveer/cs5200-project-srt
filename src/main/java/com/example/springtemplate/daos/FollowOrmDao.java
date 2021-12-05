package com.example.springtemplate.daos;

import com.example.springtemplate.models.Follow;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FollowOrmDao {
    @Autowired
    FollowRepository followRepository;

    @PostMapping("/api/follows")
    public Follow createFollow(@RequestBody Follow relation) {
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
    public Follow findFollowById (@PathVariable("followId") long followId) {
        return followRepository.findFollowById(followId);
    }

//    @GetMapping("/api/follows/following/{userId}")
//    public List<Follow> findAllFollowsUser(
//            @PathVariable("userId") User userId
//    ) {
//        return followRepository.findAllRelationsByFollowsId(userId);
//    }
//
//    @GetMapping("/api/follows/followers/{userId}")
//    public List<Follow> findAllFollowersUser(
//            @PathVariable("userId") Integer userId
//    ) {
//        return followRepository.findAllRelationsByFollowersId(userId);
//    }

    @DeleteMapping("/api/follows/{userId1}/{userId2}")
    public void deleteRelation(
            @PathVariable("userId") Integer userId1, @PathVariable("userId") Integer userId2) {
        followRepository.deleteRelation(userId1, userId2);
    }
}


//    @PutMapping("/api/users/{userId}")
//    public User updateUser(
//            @PathVariable("userId") Integer id,
//            @RequestBody User userUpdates) {
//        User user = userRepository.findUserById(id);
//        user.setFirstName(userUpdates.getFirstName());
//        user.setLastName(userUpdates.getLastName());
//        user.setUsername(userUpdates.getUsername());
//        user.setPassword(userUpdates.getPassword());
//        user.setDateOfBirth(userUpdates.getDateOfBirth());
//        user.setCreated(userUpdates.getCreated());
//        user.setUpdated(userUpdates.getUpdated());
//        return userRepository.save(user);
//    }
//
//    @DeleteMapping("/api/users/{userId}")
//    public void deleteUser(
//            @PathVariable("userId") Integer id) {
//        userRepository.deleteById(id);
//    }
//}