import { React } from 'react'
import CustomForm from '../CustomForm'

function CreateRecipe(props) {
    return (
        <div>
            {props.changeDocTitle("Create Recipe")}
            <h1>Create Recipe</h1>
            {/* <CustomForm /> */}
        </div>
    )
}

export default CreateRecipe