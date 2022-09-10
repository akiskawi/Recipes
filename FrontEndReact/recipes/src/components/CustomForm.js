import { useState } from 'react';

import { PlusIcon } from '@heroicons/react/24/solid'

const CustomForm = ({addRecipe}) => {
    const [recipe, setRecipe] = useState("");

    const handleFormSumbit = (e) => {
        e.preventDefault();
        addRecipe({
            name:recipe,
            checked:false,
            id:Date.now()
        })
        setRecipe("");
    }

    return (
        <form
            className="todo"
            onSubmit={handleFormSumbit}
        >
            <div className="wrapper">
                <input
                    type="text"
                    id="recipeName"
                    className="input"
                    value={recipe}
                    onInput={(e)=>setRecipe(e.target.value)}
                    required
                    autoFocus
                    maxLength={60}
                    placeholder="Enter Recipe Name"
                />
                <label
                    htmlFor="task"
                    className="label"
                >Enter Recipe Name</label>
            </div>
            <button
                className="btn"
                aria-label="Add Recipe"
                type="submit">
                <PlusIcon />


            </button>
        </form>
    )
}
export default CustomForm;
