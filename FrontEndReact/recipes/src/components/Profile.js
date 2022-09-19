// import './Profile.css';
// import './Recipes.css';
import Recipes from './Recipes'
import { MagnifyingGlassIcon } from '@heroicons/react/24/outline'
import 'react-bootstrap'


const Profile = ({ title, setTitle, recipes, setOpt, showOneRecipe,profileId }) => {
    return (
        <div className="container">
            {/* <div className="row">
                <div className="col">Home</div>
                <div className="col">Create Recipe</div>
            </div> */}
            <div className="row">
                <div className="profile-user-deteils">
                    <div className="col-2 text-danger fs-4">AVATAR TODO:</div>
                    <div className="col-10 text-center fw-bold fs-1">Egi Gabrielatou</div>
                </div>
                <div className="row">
                    <div className="col">
                        TODO:Mono gia profile=ME
                        Change Pic
                        <br></br>
                        Email Btn
                        <br></br>
                        Saved Recipes
                    </div>
                </div>
                <div className="row">
                    <div className="row">
                        <p className="h4 text-center">Browse Recipes</p>
                    </div>
                    <div className="col">

                        <select name="option-recipe" id="option-recipe" onChange={(e) => setOpt(e.target.value)} className="form-select" aria-label="Default select example">
                            {/* <option value="my_recipes">My Recipes</option> */}
                            {/* TODO:Owner ID*/}
                            <option value="paid">Paid</option>
                            <option value="free">Free</option>
                            <option selected value="all">TODO:recipe.ownerId.name Recipes</option>
                        </select>
                    </div>
                    <div className="col">

                        {/* <div className="mb-3"> */}
                        {/* <label htmlFor='title' class="form-label">Recipe Title</label> */}
                        <input className="form-control" id="title" type="text" placeholder="Search by Title" onInput={(e) => setTitle(e.target.value)} value={title} />
                        {/* <button id=''><MagnifyingGlassIcon width={10} height={10} /> </button> */}
                        {/* </div> */}
                    </div>
                </div>
                <div className="row mt-3">
                    {recipes.map(recipe => (
                        <Recipes
                            key={recipe.id}
                            recipe={recipe}
                            showOneRecipe={showOneRecipe}
                        />
                    ))}
                </div>
            </div>
            <div className="web-chat-wrapper">Web Chat Component</div>
        </div>
    )
}

export default Profile