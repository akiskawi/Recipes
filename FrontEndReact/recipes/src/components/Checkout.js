import PaypalCheckoutButton from "./PaypalCheckoutButton"
import './Checkout.css';
const Checkout = ({ recipeID }) => {

    return (
        <div className="paypal-button-container">
            <PaypalCheckoutButton product={recipeID} />
        </div>

    )
}

export default Checkout;