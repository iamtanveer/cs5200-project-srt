const FOLLOWS_URL = "http://localhost:8080/api/follows"

export const findAllFollows = () => fetch(FOLLOWS_URL)
    .then(response => response.json())

export const findFollowsByID = (id) => fetch(`${FOLLOWS_URL}/${id}`)
    .then(response => response.json())

export const deleteFollow = (id) => fetch(`${FOLLOWS_URL}/${id}`, {
    method: "DELETE"
});

export const createFollow = (follow) => fetch(FOLLOWS_URL, {
    method: "POST",
    body: JSON.stringify(follow),
    headers: {
        'content-type': 'application/json'
    }
}).then(response => response.json())

export const findAllUserFollowing = (userId) => fetch(`${FOLLOWS_URL}/following/${userId}`)
    .then(response => response.json())


export const findAllUserFollowers = (userId) => fetch(`${FOLLOWS_URL}/followers/${userId}`)
    .then(response => response.json())

// Not implementing this because it does not make sense to update follow
// export const updateFollow = (id, follower, following) => fetch(`${FOLLOWS_URL}/${id}`, {
//     method: "PUT",
//     body: JSON.stringify({"from": follower, "to": following}),
//     headers: {
//         'content-type': 'application/json'
//     }
// }).then(response => response.json())

export default {
    findAllFollows,
    findFollowsByID,
    deleteFollow,
    createFollow,
    findAllUserFollowers,
    findAllUserFollowing
    // updateFollow
}
