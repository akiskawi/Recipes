import { useState, useEffect } from 'react';

const addFriendButton = ({ loggedInUser, profileUser }) => {

    const [isFriend, setIsFriend] = useState();
    const [friend, setFriends] = useState();

    const api = axios.create({
        baseURL: "http://localhost:8080/friendship/"
    })

    useEffect(() => {
        api.get(`/friend/${loggedInUser.id}/${profileUser.id}`).then(res => {
            setIsFriend(res.data);
        }).catch(err => {
            console.log(err)
        })
    }, [isFriend])

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