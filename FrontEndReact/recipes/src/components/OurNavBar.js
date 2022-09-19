import { Link } from 'react-router-dom'

import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

function CollapsibleExample() {
    return (
        <div className="row">
            <div className="col">
                <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                    <Navbar.Brand>Menu</Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="me-auto">
                            <Link className='links' to="/">Home</Link>
                            <Link className='links' to="#">My Profile</Link>
                            <Link className='links' to="/createrecipe">Create Recipe</Link>
                            <Link className='links' to="login" style={{position:"absolute", right:"120px"}}>Login</Link>
                            <Link className='links' to="/register" style={{position:"absolute", right:"30px"}}>Register</Link>
                            <Link className='links' to="userlist">User List</Link>
                        </Nav>
                    </Navbar.Collapse>
                </Navbar>
            </div>
        </div>
    );
}

export default CollapsibleExample;