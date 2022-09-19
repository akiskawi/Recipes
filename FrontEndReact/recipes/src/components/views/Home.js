import { React } from 'react'

// Components
import RecipeList from '../RecipeList';


function Home(props) {

    return (
        <div>
            {props.changeDocTitle("Home")}
            <h1>Home</h1>
            <RecipeList />
            {/* <Chat/> */}
        </div>
    )
}

export default Home