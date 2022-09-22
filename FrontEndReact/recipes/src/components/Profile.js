import './Recipes.css';
import { useState, useEffect } from 'react';
import Recipes from './Recipes'
import Pagination from './Pagination';
import axios from 'axios';




const Profile = ({ changeDocTitle, jwtToken, showOneRecipe, profileUser, loggedInUser }) => {
    changeDocTitle(`${profileUser.name}`)
    // States for the Component
    const [recipes, setRecipes] = useState([])
    const [title, setTitle] = useState('')
    const [type, setType] = useState('Breakfast')
    //Axios created with JwtToken
    let apirecipes = axios.create({
        baseURL: "http://localhost:8080/recipe",
        headers: { Authorization: `Bearer ${jwtToken}` }
    })
    useEffect(() => {
        apirecipes = axios.create({
            baseURL: "http://localhost:8080/recipe",
            headers: { Authorization: `Bearer ${jwtToken}` }
        })
    }, [jwtToken])
    // Get Recipes when the Title and Type are Checked
    useEffect(() => {
        apirecipes.get(`owned/${profileUser.id}/${type}/${title}`).then(res => {
            // console.log(res.data)
            setRecipes(res.data);
        }).catch(err => {
            console.log(err)
        })
    }, [title, type])


    // Paginator
    // User is currently on this page
    const [currentPage, setCurrentPage] = useState(1);
    // No of Records to be displayed on each page   
    const [recordsPerPage] = useState(8);
    const indexOfLastRecord = currentPage * recordsPerPage;
    const indexOfFirstRecord = indexOfLastRecord - recordsPerPage;
    // Records to be displayed on the current page
    const currentRecords = recipes.slice(indexOfFirstRecord,
        indexOfLastRecord);
    //calc the Number of Pages
    const nPages = Math.ceil(recipes.length / recordsPerPage)

    return (
        <div className="container">
            <div className="row">
                <div className="profile-user-deteils">
                    <div className="col-2 text-danger fs-4">AVATAR TODO:</div>
                    <div className="col-10 text-center fw-bold fs-1">{profileUser.name}</div>
                </div>
                <div className="row">
                    {loggedInUser.id === profileUser.id && <div className="col">
                        <button>Change Email</button>
                        <br></br>
                        <button>Saved Recipes</button>
                    </div>}
                </div>
                <div className="row">
                    <div className="row">
                        <p className="h4 text-center">Browse Recipes</p>
                    </div>
                    <div className="col">

                        <select defaultValue="{profileUser.id}" name="option-recipe" id="option-recipe" onChange={(e) => setType(e.target.value)} className="form-select" aria-label="Default select example">
                            <option value="paid">Paid</option>
                            <option value="free">Free</option>
                            <option value="{profileUser.id}">{profileUser.name} Recipes</option>
                        </select>
                    </div>
                    <div className="col">
                        <input className="form-control" id="title" type="text" placeholder="Search by Title" onInput={(e) => setTitle(e.target.value)} value={title} />
                    </div>
                </div>
                <div className="row mt-3">
                    {currentRecords.map(recipe => (
                        <Recipes
                            key={recipe.id}
                            recipe={recipe}
                            showOneRecipe={showOneRecipe}
                        />
                    ))}
                    <Pagination
                        nPages={nPages}
                        currentPage={currentPage}
                        setCurrentPage={setCurrentPage}
                    />
                </div>
            </div>
        </div>
    )
}

export default Profile