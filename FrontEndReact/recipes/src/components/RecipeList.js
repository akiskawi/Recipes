import RecipeItem from './RecipeItem.js'

import styles from './RecipeList.module.css'

const RecipeList = ({ recipes,deleteRecipe,toggleRecipe,enterEditMode }) => {
    return (
        <ul className={styles.recipes}>
            {recipes.sort((a, b) => b.id - a.id).map(recipe => (
                <RecipeItem
                    key={recipe.id}
                    recipe={recipe}
                    deleteRecipe={deleteRecipe} 
                    toggleRecipe={toggleRecipe}
                    enterEditMode={enterEditMode}
                    />
            ))

            }
        </ul>
    )
}
export default RecipeList