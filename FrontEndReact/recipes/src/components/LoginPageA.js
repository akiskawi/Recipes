import { useState } from "react";
import { useNavigate } from "react-router-dom"

const LoginPageA = (user,handleLoginChange, handleLoginForm) => {
    return (
        <form onSubmit={handleLoginForm}>
            <input
                type="email"
                value={user.username}
                name='username'
                onChange={handleLoginChange}
                required
                autoFocus
                autoComplete='email' />
            <input
                type="password"
                name='password'
                value={user.password}
                onChange={handleLoginChange}
                required />
            <button type="submit">Login</button>
        </form>
    )
}

export default LoginPageA