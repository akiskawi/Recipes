import {React} from 'react'

function CreateRecipe(props) {
    return (
        <div>
            {props.changeDocTitle("Create Recipe")}
            <h1>Create Recipe</h1>
        </div>
    )
}

export default CreateRecipe