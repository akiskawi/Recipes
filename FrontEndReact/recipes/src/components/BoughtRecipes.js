import { Link } from "react-router-dom";

function changeName(doc) {
  doc.title = "Bought Recipes";
}

const BoughtRecipes = (props) => {
  return (
    <div>
      {changeName(props.doc)}
      <Link to='/'>to A</Link>
    </div>
  );
};

export default BoughtRecipes;