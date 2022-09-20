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
  //From Profile
  const [loggedInUser, setLoggedInUser] = useState({
    name: 'Evgenia',//TODO:
    email: null,
    id: null
  });// Entity User

  const[email,setEmail]=useState('')
  const[password,setPassword]=useState('')

  const [recipe, setRecipe] = useState(null);
  const [profileUser, setProfileUser] = useState(null/*User Model*/)
  // Prosorino! TODO:
  const apirecipes = axios.create({
    baseURL: "http://localhost:8080/recipe"
  })
  const apiusers = axios.create({
    baseURL: "http://localhost:8080/users"
  })
  const showOneRecipe = (recipe) => {
    setRecipe(recipe);
  }
  const changeDocTitle = (doctitle) => {
    document.title = doctitle;
  }
  const handleLoginForm = (e)=>{
    e.preventDefault();
    

  }

  return (
    <BrowserRouter>
      <div className='container'>
        {/* ΜΕΡΟΣ ΣΕΛΙΔΑΣ ΠΟΥ ΔΕΝ ΑΛΛΑΖΕΙ */}
        {/* ΚΑΠΟΙΟΥ ΕΙΔΟΥΣ NAVBAR ΜΠΟΡΕΙ ΝΑ ΜΠΕΙ ΕΔΩ ΑΝ ΕΙΝΑΙ ΙΔΙΟ ΣΕ ΟΛΕΣ ΤΙΣ ΣΕΛΙΔΕΣ */}
        <OurNavBar
          userId={loggedInUser.id}
          profileName={loggedInUser.name}
          setLoggedInUser={setLoggedInUser} />

        {/* ΜΕΡΗ ΣΕΛΙΔΑΣ ΠΟΥ ΑΛΛΑΖΟΥΝ */}
        <Routes>
          <Route path='/' element={<Home
            changeDocTitle={changeDocTitle}
            showOneRecipe={showOneRecipe}
            apirecipes={apirecipes}
          />} />
          <Route path='login' element={<LoginPageA
            email={email}
            setEmail={setEmail}
            password={password}
            setPassword={setPassword}
            handleLoginForm={handleLoginForm}
          />}
          />
          {/* <Route path='register' element={<Register changeDocTitle={changeDocTitle} />} /> */}
          <Route path='profile/:profileName' element={<Profile
            showOneRecipe={showOneRecipe}
            profileUser={profileUser}
            apirecipes={apirecipes}
          />} />
          <Route path='recipe/:recipeid' element={<RecipeItem
            recipe={recipe}
            setProfileUser={setProfileUser}
          />} />
          <Route path='createrecipe' element={<CreateRecipe changeDocTitle={changeDocTitle} />} />
          {/* <Route path='*' element={<NoPage changeDocTitle={changeDocTitle} />} /> */}
        </Routes>

        {loggedInUser.id !== null ? <div className="row">
          <div className="col justify-content-end">
            <Chat />
          </div>
        </div> :
          <div className="row"></div>
        }
      </div>
    </BrowserRouter>
  );
}

export default App;