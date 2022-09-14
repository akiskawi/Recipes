import { TiTimes } from 'react-icons/ti';

const BoughtRecipeItem = (props) => {

    return (
        <div className="recipe">
            <h3>
                {props.brec.name}
                <TiTimes onClick={()=>props.onDelete(props.brec.id)} style={{ color: 'red', cursor: 'pointer' }} />
            </h3>
            <p>{props.brec.id}</p>

        </div>
    )
}

export default BoughtRecipeItem