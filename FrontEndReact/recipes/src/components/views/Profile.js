// Routing
import { useParams } from 'react-router-dom'

function Profile(props) {
    const { profilename } = useParams();

    return (
        <div>
            {props.changeDocTitle(`${profilename}`)}
            <h1>Profile - {profilename}</h1>
        </div>
    )
}

export default Profile