import { useEffect, useState } from 'react';

import { CheckIcon } from '@heroicons/react/24/solid'

const EdiForm = ({ editedRecipe, updateRecipeFun, closeEditMode }) => {
    const [updatedRecipe, setUpdatedRecipe] = useState(editedRecipe.name);

    useEffect(() => {
        const closedModalIfEscaped = (e) => {
            e.key === "Escape" && closeEditMode();
        }

        window.addEventListener('keydown', closedModalIfEscaped)
        return () => {
            window.removeEventListener('keydown', closedModalIfEscaped)
        }
    }, [closeEditMode])

    const handleFormSumbit = (e) => {
        e.preventDefault();
        updateRecipeFun({ ...editedRecipe, name: updatedRecipe });
    }

    return (
        <div
            role="dialog"
            aria-labelledby='editRecipe'
            onClick={(e)=>{e.target===e.currentTarget&&closeEditMode()} }
        >
            <form
                className="todo"
                onSubmit={handleFormSumbit}
            >
                <div className="wrapper">
                    <input
                        type="text"
                        id="editRecipeName"
                        className="input"
                        value={updatedRecipe}
                        onInput={(e) => setUpdatedRecipe(e.target.value)}
                        required
                        autoFocus
                        maxLength={60}
                        placeholder="Update Recipe Name"
                    />
                    <label
                        htmlFor="editRecipeName"
                        className="label"
                    >Update Recipe Name</label>
                </div>
                <button
                    className="btn"
                    aria-label={`Confirm edited recipe to now name${updatedRecipe}`}
                    type="submit">
                    <CheckIcon strokeWidth={2} height={24}
                        width={24} />
                </button>
            </form>
        </div>
    )
}
export default EdiForm;
