import {React} from 'react'

// Routing
import { useParams } from 'react-router-dom'

function Recipe(props) {
    const { recipeid } = useParams();

    return (
        <div>
            {props.changeDocTitle(`Recipe ${recipeid}`)}
            <h1>Recipe - {recipeid}</h1>
        </div>
    )
}

export default Recipe