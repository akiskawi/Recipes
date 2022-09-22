
const LoginPageA = ({ user, handleFormChange, handleLoginForm, changeDocTitle }) => {
    changeDocTitle("Login")
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