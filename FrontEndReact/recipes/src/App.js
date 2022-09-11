import { useState } from 'react'

//custom hooks
import useLocalStorage from './hooks/useLocalStorage'

// custom components
import CustomForm from './components/CustomForm';
import RecipeList from './components/RecipeList';
import EditForm from './components/EditForm';



function App() {
  const [recipes, setRecipes] = useLocalStorage(
    'react-todo.recipes',[]
  );
  const [editedRecipe, setEditedRecipe] = useState(null);
  const [isEditing, setIsEditing] = useState(false);
  const [previousFocusEl, setPreviousFocusEl] = useState(false);

  const addRecipe = (recipe) => {
    setRecipes(prevState => [...prevState, recipe])
  }

  const deleteRecipe = (id) => {
    setRecipes(prevState => prevState.filter(r =>
      r.id !== id));
  }
  const toggleRecipe = (id) => {
    setRecipes(prevState => prevState.map(r => (
      r.id === id
        ? { ...r, checked: !r.checked }
        : r
    )))
  }
  const updateRecipeFun = (recipe) => {
    setRecipes(prevState => prevState.map(r => (
      r.id === recipe.id
        ? { ...r, name: recipe.name }
        : r
    )))
    closeEditMode();
  }
  const closeEditMode=()=>{
    setIsEditing(false)
    previousFocusEl.focus();
  }

  const enterEditMode = (recipe) => {
    setEditedRecipe(recipe);
    setIsEditing(true);
    setPreviousFocusEl(document.activeElement)
  }



  return (
    <div className="container">
      <header>
        <h1>
          My Recipe List
        </h1>
      </header>
      {
        isEditing && (
          <EditForm
            editedRecipe={editedRecipe}
            updateRecipeFun={updateRecipeFun}
            closeEditMode={closeEditMode}
          />
        )
      }
      <CustomForm addRecipe={addRecipe} />
      {recipes &&
        <RecipeList
          recipes={recipes}
          deleteRecipe={deleteRecipe}
          toggleRecipe={toggleRecipe}
          enterEditMode={enterEditMode}
        />}
    </div>
  );
}

export default App;
