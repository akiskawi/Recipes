import { React } from 'react';

// Routing
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';


// CSS
import './App.css';

// Components
import Home from './components/views/Home';
import Login from './components/views/Login';
import Register from './components/views/Register';
import Profile from './components/views/Profile';
import Recipe from './components/views/Recipe';
import CreateRecipe from './components/views/CreateRecipe';
import NoPage from './components/views/NoPage';
import OurNavBar from './components/OurNavBar'



function App() {

  const changeDocTitle = (doctitle) => {
    document.title = doctitle;
  }

  return (
    <BrowserRouter>
      <div className='container'>
        {/* ΜΕΡΟΣ ΣΕΛΙΔΑΣ ΠΟΥ ΔΕΝ ΑΛΛΑΖΕΙ */}
        {/* ΚΑΠΟΙΟΥ ΕΙΔΟΥΣ NAVBAR ΜΠΟΡΕΙ ΝΑ ΜΠΕΙ ΕΔΩ ΑΝ ΕΙΝΑΙ ΙΔΙΟ ΣΕ ΟΛΕΣ ΤΙΣ ΣΕΛΙΔΕΣ */}
        <OurNavBar/>


        {/* ΜΕΡΗ ΣΕΛΙΔΑΣ ΠΟΥ ΑΛΛΑΖΟΥΝ */}
        <Routes>
          <Route path='/' element={<Home changeDocTitle={changeDocTitle} />} />
          <Route path='login' element={<Login changeDocTitle={changeDocTitle} />} />
          <Route path='register' element={<Register changeDocTitle={changeDocTitle} />} />
          <Route path='profile/:profilename' element={<Profile changeDocTitle={changeDocTitle} />} />
          <Route path='recipe/:recipeid' element={<Recipe changeDocTitle={changeDocTitle} />} />
          <Route path='createrecipe' element={<CreateRecipe changeDocTitle={changeDocTitle} />} />
          <Route path='*' element={<NoPage changeDocTitle={changeDocTitle} />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;