import { useState } from "react";
import { useNavigate } from "react-router-dom"

const LoginPageA = (/*username, password, setUsername, setPassword,*/ handleLoginForm) => {
    //To login
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')

    const navigate = useNavigate();
    const navigateHome = (e) => {
        handleLoginForm(e)
        navigate('/', { replace: true });

    }

    return (
        <form onSubmit={navigateHome}>
            <input
                type="email"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                required
                autoFocus
                autoComplete='email' />
            <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required />
            <button type="submit">Login</button>
        </form>
    )
}

export default LoginPageA