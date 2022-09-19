// import './Recipes.css';
import { Link } from 'react-router-dom';


const Recipes = ({ recipe, showOneRecipe }) => {
  return (
    <div className="col-3">
      <Link className='link-recipes' to={`/recipe/${recipe.id}`} onClick={() => { showOneRecipe(recipe) }}>
        <div class="card">
          <div class="card-header">
          {recipe.name}
          </div>
          <div class="card-body">
            <p class="card-text">{recipe.description.substring(0, 10)}..</p>
            <p class="card-text text-muted">{recipe.type}</p>
          </div>
        </div>
      </Link>
    </div>
  )
}

export default Recipes