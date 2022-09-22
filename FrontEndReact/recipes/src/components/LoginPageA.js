import axios from "axios";
import { useState } from "react";

const LoginPageA = ({ setJwtToken,setLoggedInUser }) => {
    const [user, setUser] = useState({
        username: '',
        password: ''
    })
    const handleFormChange = (e) => {
        e.preventDefault();
        const fieldName = e.target.getAttribute("name");
        const fieldValue = e.target.value;
        const tempUser = { ...user }
        tempUser[fieldName] = fieldValue;
        setUser(tempUser);
    }

    const handleLoginForm = (e) => {
        e.preventDefault();
        const apilogin = axios.create({
            baseURL: "http://localhost:8080/login"
        })
        var bodyFormData = new FormData();
        bodyFormData.append('username', user.username);
        bodyFormData.append('password', user.password);

        apilogin.post('', bodyFormData).then(res => {
            //efoson iparxei to token prepei na iparxei se kathe neo request
            setJwtToken(res.headers['access_token']);
            setLoggedInUser({
                name: res.headers['username'],
                email: res.headers['useremail'],
                id: res.headers['userid']
            });
        }).catch(err => console.log("error", err))
    }
    return (
        <form onSubmit={handleLoginForm}>
            <input
                type="email"
                value={user.username}
                name='username'
                onChange={handleFormChange}
                required
                autoFocus
                autoComplete='email' />
            <input
                type="password"
                name='password'
                value={user.password}
                onChange={handleFormChange}
                required />
            <button type="submit">Login</button>
        </form>
    )
}

export default LoginPageA