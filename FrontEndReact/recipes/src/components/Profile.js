// import './Profile.css';
// import './Recipes.css';
import './Recipes.css';
import { useState, useEffect } from 'react';
import Recipes from './Recipes'
import Pagination from './Pagination';
<<<<<<< HEAD
import axios from 'axios';
import Button from 'react-bootstrap/Button';
import { Link, useParams } from 'react-router-dom';

=======
>>>>>>> parent of 03160f15 (Merge branch 'Yourwash' of https://github.com/akiskawi/Recipes into Yourwash)



const Profile = ({ changeDocTitle,apirecipes, showOneRecipe, profileUser/* User Model */ }) => {
    changeDocTitle(`${profileUser.name}`)
    const [recipes, setRecipes] = useState([])
    const [title, setTitle] = useState('')
<<<<<<< HEAD
    const [type, setType] = useState(profileUser.name)
    //Axios created with JwtToken
    const api = axios.create({
        baseURL: "http://localhost:8080/",
        headers: { Authorization: `Bearer ${jwtToken}` }
    })


    // Get Recipes when the Title and Type? are Checked
    useEffect(() => {
        if (type===`${profileUser.name}`) {
            api.get(`recipe/owned/${profileUser.id}/${title}`).then(res=>{
                setRecipes(res.data);
            }).catch(err=>{
                console.log(err)
            })
        } else{
            api.get(`savedrecipes/${type}/${profileUser.id}/${title}`).then(res=>{
                setRecipes(res.data);
            }).catch(err=>{
                console.log(err)
            })
        }
        
    }, [title, type])
    

    // Paginator
=======
    const [type, setType] = useState('Breakfast')



>>>>>>> parent of 03160f15 (Merge branch 'Yourwash' of https://github.com/akiskawi/Recipes into Yourwash)
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
                <div className="col mb-6">
                    {profileUser.id != loggedInUser.id
                        && <Button variant='warning' ><Link className='link-recipes' >Friend Request</Link></Button>
                    }
                </div>
                <div className="row">
<<<<<<< HEAD
                    {loggedInUser.id === profileUser.id && <div className="col">
                        <button>Change Email</button>
                    </div>}
=======
                    <div className="col">
                        TODO:Thelw Logged In User na Iparxei kai na mpei edw
                        Change Pic
                        <br></br>
                        Email Btn
                        <br></br>
                        Saved Recipes
                    </div>
>>>>>>> parent of 03160f15 (Merge branch 'Yourwash' of https://github.com/akiskawi/Recipes into Yourwash)
                </div>
                <div className="row">
                    <div className="row">
                        <p className="h4 text-center">Browse Recipes</p>
                    </div>
                    <div className="col">

                        <select defaultValue={profileUser.name} name="option-recipe" id="option-recipe" onChange={(e) => setType(e.target.value)} className="form-select" aria-label="Default select example">
                            <option value="true">Paid Recipes</option>
                            <option value="false">Saved Recipes</option>
                            <option value={profileUser.name}>{profileUser.name} Recipes</option>
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