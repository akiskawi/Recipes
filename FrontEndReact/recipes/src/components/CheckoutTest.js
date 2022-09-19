import PaypalCheckoutButton from "./PaypalCheckoutButton"

const CheckoutTest = () => {

    const dummyproduct = {
        description: "dummy product",
        price: 10
    }

    return (
        <div>
            <h1>Paypal Test</h1>
            <div className="paypal-button-container">
                <p>Get charged for a tenner mate. Just because...</p>
                <PaypalCheckoutButton product={dummyproduct} />
            </div>
        </div>
    )
}

export default CheckoutTest;