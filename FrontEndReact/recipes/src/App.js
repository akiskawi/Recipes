import { React, useEffect, useState } from 'react';
import axios from 'axios';

// Routing
import { BrowserRouter, Route, Routes } from 'react-router-dom';

// Bootstrap
import Container from 'react-bootstrap/Container';

// custom hooks
import useLocalStorage from './hooks/useLocalStorage'

// CSS
import './App.css';
// import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/css/bootstrap.min.css'
// import 'jquery/dist/jquery.min.js'
// import 'bootstrap/dist/js/bootstrap.min.js'

// Components
// import Home from './components/views/Home';
// import Login from './components/views/Login';
import Register from './components/views/Register/Register';
import Profile from './components/Profile';
import Home from './components/Home';
import RecipeItem from './components/RecipeItem';
import LoginPageA from './components/LoginPageA';
import Chat from './components/chat/Chat';

// import Recipe from './components/views/Recipe';
import CreateRecipe from './components/views/CreateRecipe';
import EditRecipe from './components/views/EditRecipe';
// import NoPage from './components/views/NoPage';
import OurNavBar from './components/OurNavBar'



function App() {
<<<<<<< HEAD
  const [jwtToken, setJwtToken] = useLocalStorage('front-end.jwtToken', null);
  // loggedIn User details
  const [loggedInUser, setLoggedInUser] = useLocalStorage('front-end.loggedInUser',{
=======

  const [user, setUser] = useState({
    username: '',
    password: ''
  })

  const [jwtToken, setJwtToken] = useState(null);

  //From Profile
  const [loggedInUser, setLoggedInUser] = useState({
>>>>>>> parent of 03160f15 (Merge branch 'Yourwash' of https://github.com/akiskawi/Recipes into Yourwash)
    name: null,
    email: null,
    id: null
  });// Entity User


  const [recipe, setRecipe] = useState(null);
  const [profileUser, setProfileUser] = useState({
    name: null,
    email: null,
    id: null
  })
<<<<<<< HEAD
  //TODO: go to components

=======
>>>>>>> parent of 03160f15 (Merge branch 'Yourwash' of https://github.com/akiskawi/Recipes into Yourwash)
  // Prosorino! TODO:
  const apirecipes = axios.create({
    baseURL: "http://localhost:8080/recipe",
    headers: { Authorization: `Bearer ${jwtToken}` }
  })

  const showOneRecipe = (recipe) => {
    setRecipe(recipe);
  }

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
      baseURL: "http://localhost:8080/login",
      headers: { Authorization: `Bearer ${jwtToken}` }
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
    }).catch(err => console.log("errir1", err))
    console.log(jwtToken);
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
<<<<<<< HEAD
          loggedInUser={loggedInUser}
          setProfileUser={setProfileUser}
          setLoggedInUser={setLoggedInUser}
          setJwtToken={setJwtToken}
          loggedinuser={loggedInUser} />
=======
          userId={loggedInUser.id}
          profileName={loggedInUser.name}
          setLoggedInUser={setLoggedInUser} />
>>>>>>> parent of 03160f15 (Merge branch 'Yourwash' of https://github.com/akiskawi/Recipes into Yourwash)

        {/* ΜΕΡΗ ΣΕΛΙΔΑΣ ΠΟΥ ΑΛΛΑΖΟΥΝ */}
        <Routes>
          <Route path='/' element={<Home
            changeDocTitle={changeDocTitle}
            showOneRecipe={showOneRecipe}
            apirecipes={apirecipes}
          />} />
          <Route path='login' element={<LoginPageA
<<<<<<< HEAD
            setJwtToken={setJwtToken}
            setLoggedInUser={setLoggedInUser}
            changeDocTitle={changeDocTitle}
=======
            user={user}
            handleFormChange={handleFormChange}
            handleLoginForm={handleLoginForm}
>>>>>>> parent of 03160f15 (Merge branch 'Yourwash' of https://github.com/akiskawi/Recipes into Yourwash)
          />}
          />
          {<Route path='register' element={<Register changeDocTitle={changeDocTitle} />} />}
          <Route path='profile/:profileName' element={<Profile
            showOneRecipe={showOneRecipe}
            profileUser={profileUser}
            apirecipes={apirecipes}
            changeDocTitle={changeDocTitle}
            recipe={recipe}
          />} />
          <Route path='recipe/:recipeid' element={<RecipeItem
            recipe={recipe}
            setProfileUser={setProfileUser}
            profileUser={profileUser}
            loggedInUser={loggedInUser}
            changeDocTitle={changeDocTitle}
          />} />
          <Route path='edit/:recipeid' element={<EditRecipe
            recipe={recipe}
            setProfileUser={setProfileUser}
            profileUser={profileUser}
            loggedInUser={loggedInUser}
            changeDocTitle={changeDocTitle}
            jwtToken={jwtToken}
          />} />
          <Route path='createrecipe' element={<CreateRecipe
            changeDocTitle={changeDocTitle}
            loggedinuser={loggedInUser}
            jwtToken={jwtToken}
          />} />
          {/* <Route path='*' element={<NoPage changeDocTitle={changeDocTitle} />} /> */}
        </Routes>

        {loggedInUser.id !== null ? <div className="row">
          <div className="col justify-content-end">
            <Chat loggedInUser={loggedInUser} jwtToken={jwtToken} />
          </div>
        </div> :
          <div className="row"></div>
        }
      </div>
    </BrowserRouter>
  );
}

export default App;