import { useState, useEffect } from 'react';

const addFriendButton = () => {
    const [isFriend, setIsFriend] = useState();

    const api = axios.create({
        baseURL: "http://localhost:8080/friendship/"
    })

    useEffect(() => {
        api.get('/friends/{userID}/{friendID}').then(res => {
            setIsFriend(res.data);
        }).catch(err => {
            console.log(err)
        })
    }, [isFriend])

    const addFriend = async () => {
        await fetch(`http://localhost:8080/friendship/`, {
            method: 'POST',
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
            body: JSON.stringify({
                userID: '',
                friendID: '',
                request_valid: true
            }),
        })
            .then((response) => response.json())
            .then((data) => {
                setFriends((friends) => [...friends, data]);
            })
            .catch((err) => {
                console.log(err.message);
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