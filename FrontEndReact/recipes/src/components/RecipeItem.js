import { Link } from 'react-router-dom';
import axios from 'axios';
import Button from 'react-bootstrap/Button';
const RecipeItem = ({ changeDocTitle, recipe, setProfileUser, profileUser, loggedInUser, jwtToken }) => {
    changeDocTitle(`${recipe.name}`)
    const api = axios.create({
        baseURL: "http://localhost:8080/",
        headers: { Authorization: `Bearer ${jwtToken}` }
    })
    const getProfileUser = () => {
        api.get(`/users/${recipe.ownerId.id}`).then(res => setProfileUser({...res.data})).catch(err => console.log(err))
    }
    const handleSaveButton = () => {
        api.post(`/savedRecipes/save/${loggedInUser.id}/${recipe.id}`)
        console.log(`/savedRecipes/save/${loggedInUser.id}/${recipe.id}`)

    }



    return (
        <div className="container">
            <div className="row">
                <div className="col-4 mb-6">
                    {recipe.name}
                </div>
                <div className="col text-muted mb-6">
                    {recipe.type}
                </div>

                <div className="col mb-6">
                    {profileUser.id === loggedInUser.id
                        ? <Button variant='warning' ><Link className='link-recipes' to={`/edit/${recipe.id}`}>Edit</Link></Button>

                        : <>
                            <Button variant='success' onClick={handleSaveButton}>Save</Button>
                            <Button variant='primary'>Buy</Button>
                        </>
                    }
                </div>

                <div className="col">Author:
                    <Link /*to={`/profile/${recipe.ownerId.name}`}*/ onClick={getProfileUser}>
                        {recipe.ownerId.name}
                    </Link>
                </div>
            </div>
            <div className="row">
                <div className="d-grid gap-2" style={{ height: '300px', backgroundColor: 'red' }}></div>
                {recipe.photo}
            </div>
            <div className="row">
                <div className="col">
                    <div className="mb-6" style={{ height: '350px' }}>{recipe.instructions}</div>
                </div>
                <div className="col">
                    <div className="row mb-6 text-muted" style={{ height: '50px' }}>{recipe.description}</div>
                    <div className="row mb-6 text-muted" style={{ height: '230px' }}>{recipe.ingredients}</div>
                </div>
            </div>
            <div className="row">
                <div className="col d-grid gap-2" style={{ height: '135px', backgroundColor: 'blue' }}>{recipe.video}</div>
            </div>




        </div>
    )
}

export default RecipeItem