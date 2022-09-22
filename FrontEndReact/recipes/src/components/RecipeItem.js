import { Link } from 'react-router-dom';
import axios from 'axios';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';


const RecipeItem = ({ changeDocTitle, recipe, setProfileUser, profileUser, loggedInUser, jwtToken }) => {
    changeDocTitle(`${recipe.name}`)
    const api = axios.create({
        baseURL: "http://localhost:8080/",
        headers: { Authorization: `Bearer ${jwtToken}` }
    })
    const getProfileUser = () => {
        api.get(`/users/${recipe.ownerId.id}`).then(res => setProfileUser({ ...res.data })).catch(err => console.log(err))
    }
    const handleSaveButton = () => {
        api.post(`/savedRecipes/save/${loggedInUser.id}/${recipe.id}`)
        console.log(`/savedRecipes/save/${loggedInUser.id}/${recipe.id}`)

    }



    return (
        <div className="container">
            <div className="row">
                <div className="col-4 mb-6">
                    Title
                    <div className="rounded border">
                        {recipe.name}
                    </div>
                </div>
                <div className="col-2 offset-1 mb-6">
                    Type
                    <div className="rounded border">
                        {recipe.type}
                    </div>
                </div>
                {console.log(profileUser.id)}
                {console.log(loggedInUser.id)}
                {console.log(recipe.ownerId.id)}
                <div className="col-2 offset-1 mb-6">
                    {recipe.ownerId.id == loggedInUser.id
                        ? <Button variant='warning' ><Link className='link-recipes' to={`/edit/${recipe.id}`}>Edit</Link></Button>

                        : <>
                            <Button variant='success' onClick={handleSaveButton}>Save</Button>
                            <Button variant='primary'>Buy</Button>
                        </>
                    }
                </div>

                <div className="col-2">
                    Author
                    <Link to={`/profile/${recipe.ownerId.name}`} onClick={getProfileUser}>
                        <div className="rounded border">
                            {recipe.ownerId.name}
                        </div>
                    </Link>
                </div>
            </div>
            <div className="row">
                {/* <div className="d-grid gap-2" style={{ height: '300px' }}></div> */}
                <img src={recipe.photo} alt='recipe photo' style={{ height: '300px' }}></img>
            </div>
            <div className="row">

                <div className="col-6">
                    Instructions
                    <div className="border rounded">
                        <div className="mb-6" style={{ height: '350px' }}>{recipe.instructions}</div>
                    </div>
                </div>
                <div className="col-6">
                    Description
                    <div className="row mb-6 text-muted border rounded" style={{ height: '50px' }}>{recipe.description}</div>
                    Ingredients
                    <div className="row mb-6 text-muted border rounded" style={{ height: '278px' }}>{recipe.ingredients}</div>
                </div>
            </div>
            <div className="row">
                <div className="col-6">
                    Utensils
                    <div className="d-grid gap-2 border rounded" style={{ height: '135px' }}>{recipe.utensils}</div>
                </div>
                <div className="col-6">
                    {/* <div className="d-grid gap-2" style={{ height: '135px' }}></div> */}
                    <video src={recipe.video} style={{ height: '135px' }}></video>
                </div>
            </div>
        </div>
    )
}

export default RecipeItem