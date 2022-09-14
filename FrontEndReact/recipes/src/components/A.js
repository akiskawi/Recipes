import { Link } from "react-router-dom";

function changeName(doc) {
    doc.title = "A";
}

const A = (props) => {
    return (
        < div >
            {changeName(props.doc)}
            <Link to='/boughtrecipes'>to Bought Recipes</Link>
        </div >
    )
}

export default A