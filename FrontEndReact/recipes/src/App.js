import { React, useEffect, useState } from 'react';
import axios from 'axios';

// Routing
import { BrowserRouter, Routes, Route } from 'react-router-dom';


// CSS
// import './App.css';
// import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'jquery/dist/jquery.min.js'
import 'bootstrap/dist/js/bootstrap.min.js'

// Components
// import Home from './components/views/Home';
// import Login from './components/views/Login';
// import Register from './components/views/Register';
import Profile from './components/Profile';
import RecipeItem from './components/RecipeItem';
// import Recipe from './components/views/Recipe';
// import CreateRecipe from './components/views/CreateRecipe';
// import NoPage from './components/views/NoPage';
import OurNavBar from './components/OurNavBar'



function App() {
  //From Profile
  const [loggedInUser, setLoggedInUser] = useState(null);//user id
  const [recipe, setRecipe] = useState(null);
  const [recipes, setRecipes] = useState([]);
  const [opt, setOpt] = useState('all')
  const [title, setTitle] = useState('')


  // Prosorino! TODO:
  const apirecipes = axios.create({
    baseURL: "http://localhost:8080/recipe"
  })
  useEffect(() => {
    apirecipes.get(`type/${opt}`).then(res => {
      setRecipe(res.date)
    })
  }, [opt])
  useEffect(() => {
    apirecipes.get('/all').then(res => {
      // console.log(res.data)
      setRecipes(res.data);
    }).catch(err => {
      console.log(err)
    })
  }, [title])

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
        <OurNavBar />


        {/* ΜΕΡΗ ΣΕΛΙΔΑΣ ΠΟΥ ΑΛΛΑΖΟΥΝ */}
        <Routes>
          {/* <Route path='/' element={<Home changeDocTitle={changeDocTitle} />} />
          <Route path='login' element={<Login changeDocTitle={changeDocTitle} />} />
          <Route path='register' element={<Register changeDocTitle={changeDocTitle} />} /> */}



          <Route path='profile' element={<Profile
            title={title}
            setTitle={setTitle}
            recipes={recipes}
            setOpt={setOpt}
            showOneRecipe={showOneRecipe}
          />} />
          <Route path='recipe/:recipeid' element={<RecipeItem
            recipe={recipe}
          />} />
          {/* <Route path='createrecipe' element={<CreateRecipe changeDocTitle={changeDocTitle} />} />
          <Route path='*' element={<NoPage changeDocTitle={changeDocTitle} />} /> */}
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;