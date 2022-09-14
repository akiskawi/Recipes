//Routing
import { Link } from "react-router-dom";

// State
import { useState } from 'react';

//Components
import BoughtRecipeItem from "./BoughtRecipeItem.js";

// Change Document Title
const changeName = (doc) => {
  doc.title = "Bought Recipes";
}

// Delete Task
const deleteBoughtRecipe=(id)=>{
  console.log(id+" deleted")
}

const BoughtRecipes = (props) => {

  // Data
  const [boughtrec, setboughtrec] = useState(
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
      {changeName(props.doc)}
      {boughtrec.map((brec) => (<BoughtRecipeItem key={brec.id} brec={brec} onDelete={deleteBoughtRecipe} />))}
      <Link to='/'>to A</Link>
    </div>
  );
};

export default BoughtRecipes;