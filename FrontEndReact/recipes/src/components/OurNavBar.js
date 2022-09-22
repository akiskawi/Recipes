import { Link } from 'react-router-dom'

import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

<<<<<<< HEAD
function CollapsibleExample({ loggedInUser, setProfileUser, setLoggedInUser, setJwtToken ,loggedinuser}) {
=======
function CollapsibleExample({ profileName, userId, setLoggedInUser }) {
>>>>>>> parent of 03160f15 (Merge branch 'Yourwash' of https://github.com/akiskawi/Recipes into Yourwash)
    return (
        <div className="row">
            <div className="col">
                <Navbar collapseOnSelect expand="md" bg="light" >
                    <Navbar.Brand>Menu</Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="me-auto">
                            <Link className='nav-link' to="/">Home</Link>
                            {userId !== null
                                ? <><Link className='nav-link' to={`/profile/${profileName}`}>My Profile</Link>
                                    <Link className='nav-link' to="/createrecipe">Create Recipe</Link>
                                    <Link className='nav-link' to="/" style={{ position: "absolute", right: "30px" }} onClick={() => setLoggedInUser({
                                        name: null,
                                        email: null,
                                        id: null
                                    })}>Logout</Link>
                                </>
                                : <>
                                    < Link className='nav-link' to="/login" style={{ position: "absolute", right: "120px" }}>Login</Link>
                                    <Link className='nav-link' to="/register" style={{ position: "absolute", right: "30px" }}>Register</Link>
                                </>}


                        </Nav>
                    </Navbar.Collapse>
                </Navbar>
            </div>
        </div >
    );
}

export default CollapsibleExample;