import { React, useEffect, useState } from 'react';
import axios from 'axios';

// Routing
import { BrowserRouter, Route, Routes } from 'react-router-dom';

// Bootstrap
import Container from 'react-bootstrap/Container';

// CSS
import './App.css';
// import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'jquery/dist/jquery.min.js'
import 'bootstrap/dist/js/bootstrap.min.js'

// Components
// import Home from './components/views/Home';
// import Login from './components/views/Login';
// import Register from './components/views/Register';
import Profile from './components/Profile';
import Home from './components/Home';
import RecipeItem from './components/RecipeItem';
import LoginPageA from './components/LoginPageA';
import Chat from './components/chat/Chat';

// import Recipe from './components/views/Recipe';
import CreateRecipe from './components/views/CreateRecipe';
// import NoPage from './components/views/NoPage';
import OurNavBar from './components/OurNavBar'



function App() {
  const [jwtToken, setJwtToken] = useState(null);
  // loggedIn User details
  const [loggedInUser, setLoggedInUser] = useState({
    name: null,
    email: null,
    id: null
  });
  // SHowing / Editing recipe details
  const [recipe, setRecipe] = useState(null);
  // Showing profile User Details
  const [profileUser, setProfileUser] = useState({
    name: null,
    email: null,
    id: null
  })
  //TODO: go to components
  

  const showOneRecipe = (recipe) => {
    setRecipe(recipe);
  }
  const changeDocTitle = (doctitle) => {
    document.title = doctitle;
  }


  return (
    <BrowserRouter>
      <div className='container'>
        {/* ΜΕΡΟΣ ΣΕΛΙΔΑΣ ΠΟΥ ΔΕΝ ΑΛΛΑΖΕΙ */}
        {/* ΚΑΠΟΙΟΥ ΕΙΔΟΥΣ NAVBAR ΜΠΟΡΕΙ ΝΑ ΜΠΕΙ ΕΔΩ ΑΝ ΕΙΝΑΙ ΙΔΙΟ ΣΕ ΟΛΕΣ ΤΙΣ ΣΕΛΙΔΕΣ */}
        <OurNavBar
          userId={loggedInUser.id}
          profileName={loggedInUser.name}
          setLoggedInUser={setLoggedInUser}
          setJwtToken={setJwtToken} />

        {/* ΜΕΡΗ ΣΕΛΙΔΑΣ ΠΟΥ ΑΛΛΑΖΟΥΝ */}
        <Routes>
          <Route path='/' element={<Home
            changeDocTitle={changeDocTitle}
            showOneRecipe={showOneRecipe}
            jwtToken={jwtToken}
          />} />
          <Route path='login' element={<LoginPageA
            setJwtToken={setJwtToken}
            setLoggedInUser={setLoggedInUser}
          />}
          />
          {/* <Route path='register' element={<Register changeDocTitle={changeDocTitle} />} /> */}
          <Route path='profile/:profileName' element={<Profile
            showOneRecipe={showOneRecipe}
            profileUser={profileUser}
            loggedInUser={loggedInUser}
            jwtToken={jwtToken}
            changeDocTitle={changeDocTitle}
          />} />
          <Route path='recipe/:recipeid' element={<RecipeItem
            recipe={recipe}
            setProfileUser={setProfileUser}
            profileUser={profileUser}
            loggedInUser={loggedInUser}
            changeDocTitle={changeDocTitle}
          />} />
          <Route path='createrecipe' element={<CreateRecipe changeDocTitle={changeDocTitle} loggedinuser={loggedInUser} />} />
          {/* <Route path='*' element={<NoPage changeDocTitle={changeDocTitle} />} /> */}
        </Routes>

        {loggedInUser.id !== null ? <div className="row">
          <div className="col justify-content-end">
            <Chat loggedInUser={loggedInUser} />
          </div>
        </div> :
          <div className="row"></div>
        }
      </div>
    </BrowserRouter>
  );
}

export default App;