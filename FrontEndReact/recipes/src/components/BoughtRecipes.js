// Axios
import axios from 'axios'

// State
import { useState } from 'react';

//Components
import BoughtRecipeItem from "./BoughtRecipeItem.js";

//
//
//
// MAIN
const BoughtRecipes = (props) => {

  // Data Manipulation
  const [boughtrec, setBoughtrec] = useState([])

  const api = axios.create({ baseURL: 'localhost:8080/' })
  const getCourses = async () => {
    let data = await api.get(`bought/${props.profileid}`).then(({ data }) => data)
    setBoughtrec(data)
  }

  return (
    <div>
      {getCourses}
      <h2>Bought Recipes</h2>
      {boughtrec.map((brec) => (<BoughtRecipeItem brec={brec} />))}
    </div>
  );
};

export default BoughtRecipes;