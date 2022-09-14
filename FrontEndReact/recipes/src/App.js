// Routing
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import './App.css';
import BoughtRecipes from './components/BoughtRecipes.js';
import A from './components/A';
// import RecipeList from './components/RecipeList';

const doc=document;

function App() {

  return (
    <BrowserRouter>
      <div className='container'>
        <Routes>
          <Route path='/' element={<A doc={doc} />} />
          <Route path='/boughtrecipes' element={<BoughtRecipes doc={doc} />} />
        </Routes>
        {/* <RecipeList /> */}
      </div>
    </BrowserRouter>
  );
}

export default App;
