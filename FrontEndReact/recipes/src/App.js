// Routing
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './App.css';
import BoughtRecipes from './components/BoughtRecipes.js';
import A from './components/A';
// import RecipeList from './components/RecipeList';

//To change document title
const doc = document;

function App() {

  return (
    <BrowserRouter>
      <div className='container'>
        <Routes>
          <Route path='/asd' element={<A doc={doc} />} >
            <Route path='/asdasd' elem>

            </Route>
          </Route>

          <Route path='/boughtrecipes' element={<BoughtRecipes doc={doc} />} />
        </Routes>
        {/* <RecipeList /> */}
      </div>
    </BrowserRouter>
  );
}

export default App;

/* <Routes>
    <Route path="/">
        <Route path="{profilename}" />
        <Route path="{recipeid}" />
        <Route path="createrecipe"></Route>
        <Route path="guest">
            <Route path="/login" />
            <Route path="/register" />
        </Route>
    </Route>
</Routes> */