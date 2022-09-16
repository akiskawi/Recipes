//Routing
import { Link } from "react-router-dom";

// State
import { useState } from 'react';

//Components
import BoughtRecipeItem from "./BoughtRecipeItem.js";

//
//
//
// MAIN
const BoughtRecipes = (props) => {

  // Delete Bought Recipe
  const deleteBoughtRecipe = (id) => {
    // console.log(id + " deleted")
    setBoughtrec(boughtrec.filter((brec) => brec.id !== id))
  }

  // Data
  const [boughtrec, setBoughtrec] = useState(
    [
      {
        id: 1,
        name: "tiropita strifti",
      },
      {
        id: 2,
        name: "tiropita xwriatiki"
      }
    ]
  )

  return (
    <div>
      {boughtrec.map((brec) => (<BoughtRecipeItem key={brec.id} brec={brec} onDelete={deleteBoughtRecipe} />))}
    </div>
  );
};

export default BoughtRecipes;