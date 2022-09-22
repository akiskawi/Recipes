import Form from 'react-bootstrap/Form';
import { React, useState } from 'react'


function EditRecipe({ recipe }) {
    return (
        <div>
            <div>{recipe.id}</div>
            <div>{recipe.name}</div>
            <div>{recipe.instructions}</div>
            <div>{recipe.utensils}</div>
            <div>{recipe.description}</div>
            <div>{recipe.ingredients}</div>
            <div>{recipe.photo}</div>
            <div>{recipe.video}</div>
            <div>{recipe.type}</div>
        </div>
    )
}

export default EditRecipe