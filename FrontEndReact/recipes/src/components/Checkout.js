import PaypalCheckoutButton from "./PaypalCheckoutButton"
import './Checkout.css';
const Checkout = () => {

    const dummyproduct = {
        description: "dummy product",
        price: 10
    }

    return (
        <div className="paypal-button-container">
            <PaypalCheckoutButton product={dummyproduct} />
        </div>

    )
}

export default Checkout;