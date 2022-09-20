// import './Profile.css';
// import './Recipes.css';
import { useState, useEffect } from 'react';
import Recipes from './Recipes'
import Pagination from './Pagination';



const Profile = ({ apirecipes, showOneRecipe, profileUser/* User Model */ }) => {
    const [recipes, setRecipes] = useState([])
    const [title, setTitle] = useState('')
    const [type, setType] = useState('Breakfast')



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

    useEffect(() => {
        apirecipes.get(`owned/${profileUser.id}/${type}/${title}`).then(res => {
            // console.log(res.data)
            setRecipes(res.data);
        }).catch(err => {
            console.log(err)
        })
    }, [title, type])
    return (
        <div className="container">
            <div className="row">
                <div className="profile-user-deteils">
                    <div className="col-2 text-danger fs-4">AVATAR TODO:</div>
                    <div className="col-10 text-center fw-bold fs-1">{profileUser.name}</div>
                </div>
                <div className="row">
                    <div className="col">
                        TODO:Thelw Logged In User na Iparxei kai na mpei edw
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