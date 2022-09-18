import { TiTimes } from 'react-icons/ti';

// MAIN
const BoughtRecipeItem = (props) => {

    return (
        <div className="recipe">
            <h3>
                {props.brec}
                {/* <TiTimes onClick={()=>props.onDelete(props.brec.id)} style={{ color: 'red', cursor: 'pointer' }} /> */}
            </h3>
        </div>
    )
}

export default BoughtRecipeItem