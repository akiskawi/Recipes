import styles from './RecipeItem.module.css'

import { CheckIcon, PencilSquareIcon, TrashIcon } from '@heroicons/react/24/outline'
import { useState } from 'react'

const RecipeItem = ({ recipe, deleteRecipe,toggleRecipe,enterEditMode }) => {
    const [isChecked, setIsChecked] = useState(recipe.checked)

    const handleCheckedboxChange = (e) => {
        setIsChecked(!isChecked);
        toggleRecipe(recipe.id)
    }

    return (
        <li className={styles.recipe}>
            <div className={styles["recipe-group"]}>
                <input
                    type="checkbox"
                    className={styles.checkbox}
                    checked={isChecked}
                    onChange={handleCheckedboxChange}
                    name={recipe.name}
                    id={recipe.id}
                />
                <label
                    htmlFor={recipe.id}
                    className={styles.label}
                >
                    {recipe.name}
                    <p className={styles.checkmark}>
                        <CheckIcon strokeWidth={2} width={24}
                            height={24} />
                    </p>
                </label>
            </div>
            <div className={styles["recipe-group"]}>
                <button
                    className='btn'
                    aria-label={`Update ${recipe.name} Recipe`}
                onClick={()=>enterEditMode(recipe)}
                >
                    <PencilSquareIcon width={24}
                        height={24} />
                </button>
                <button
                    className={`btn ${styles.delete}`}
                    aria-label={`Delete ${recipe.name} Recipe`}
                    onClick={()=>deleteRecipe(recipe.id)}
                >
                    <TrashIcon width={24}
                        height={24} />
                </button>
            </div>
        </li>
    )
}
export default RecipeItem