import { Link } from 'react-router-dom';
const RecipeItem = ({ recipe, setProfileUser }) => {
    return (
        <div className="container">
            <div className="recipe-info">
                <div className="recipe-title">{recipe.name}</div>
                <div className="recipe-type">{recipe.type}</div>
                <div className="recipe-type">{recipe.paid ? 'True' : 'False'}</div>
                <div className="bts">{/*TODO:*/}EDIT/SAVE</div>

                <div className="">Link</div>
                <Link to={`/profile/${recipe.ownerId.name}`} onClick={() => { setProfileUser(recipe.ownerId) }}>
                    <div className="recipe-author">{recipe.ownerId.name}</div>
                </Link>
            </div>
        </div>
    )
}

export default RecipeItem