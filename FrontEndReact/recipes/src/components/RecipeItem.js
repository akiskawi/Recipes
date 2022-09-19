import { useParams } from "react-router-dom";

const RecipeItem = ({recipe}) => {
    
    // const { recipeid } = useParams();
    return (
        // <div>
        //     <div>{recipe.id}</div>
        //     <div>{recipe.name}</div>
        //     <div>{recipe.instructions}</div>
        //     <div>{recipe.description}</div>
        //     <div>{recipe.ingredients}</div>
        //     <div>{recipe.type}</div>
        // </div>
        <div className="container">
            <div className="recipe-info">
                <div className="recipe-title">{recipe.name}</div>
                <div className="recipe-type">{recipe.type}</div>
                <div className="bts">{/*TODO:*/}EDIT/SAVE</div>
                <div className="recipe-author">{recipe.ownerId.name}</div>
            </div>
        </div>
    )
}

export default RecipeItem