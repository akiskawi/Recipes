
const LoginPageA = (email, handleLoginForm, password, setEmail, setPassword) => {
    return (
        <form onSubmit={handleLoginForm}>
            <input type="email" value={email} onInput={(e) => setEmail(e.target.value)} />
            <input type="password" value={password} onInput={(e) => setPassword(e.target.value)} />
            <button type="submit">Login</button>
        </form>
    )
}

export default LoginPageA