import { useState, useEffect } from 'react';

const addFriendButton = (loggedInUser, profileUser) => {
    const [isFriend, setIsFriend] = useState();
    const [friend, setFriends] = useState();

    const api = axios.create({
        baseURL: "http://localhost:8080/friendship/"
    })

    useEffect(() => {
        api.get(`/friends/${loggedInUser.id}/${profileUser.id}`).then(res => {
            setIsFriend(res.data);
        }).catch(err => {
            console.log(err)
        })
    }, [isFriend])

    // const addFriend = async () => {
    //     await fetch(`http://localhost:8080/friendship/addFriend`, {
    //         method: 'POST',
    //         headers: {
    //             'Content-type': 'application/json; charset=UTF-8',
    //         },
    //         body: JSON.stringify({
    //             userID: loggedInUser.id,
    //             friendID: profileUser.id,
    //         }),
    //     })
    //         .then((response) => response.json())
    //         .then((data) => {
    //             setFriends((friend) => [...friend, data]);
    //         })
    //         .catch((err) => {
    //             console.log(err.message);
    //         });
    // };
    const addFriend = () => {
        api.post(`/addFriend/${loggedInUser.id}/${profileUser.id}`)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    };
}

if (!isFriend) {
    return (
        <button
            onClick={addFriend}
            type="button"
            className="btn btn-success">
            Add Friend
        </button>
    )
}

export default addFriendButton;