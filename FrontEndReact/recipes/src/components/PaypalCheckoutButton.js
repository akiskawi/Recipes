import { useState } from "react";
import { PayPalButtons } from "@paypal/react-paypal-js";

const PaypalCheckoutButton = (props) => {
    const { product } = props;

    const [error, setError] = useState(null);

    const handleApprove = (orderId) => {
        //request to server that order is paid for
        //if server reply ok do something
        //if server reply not ok... wtf?
        console.log(orderId);
    }

    if (error) {
        alert("You've done fucked up");
    }

    return (
        <PayPalButtons
            style={{
                color: 'silver',
                layout: 'vertical',
                shape: 'pill',
                height: 40,
                tagline: false,
            }}
            onClick={(data, actions) => {
                //validation that product is eligible for purchase
                if (true) {
                    return actions.resolve();
                } else {
                    return actions.reject();
                }
            }}
            createOrder={(data, actions) => {
                return actions.order.create({
                    purchase_units: [
                        {
                            description: product.description,
                            amount: {
                                value: 2
                            }
                        }
                    ]
                });
            }}
            onApprove={async (data, actions) => {
                const order = await actions.order.capture();
                console.log("order", order);
                handleApprove(data.orderID);
            }}
            onCancel={() => {
                //handle special case where user cancels order
            }}
            onError={(err) => {
                setError(err);
                console.error("Paypal error", err);
            }}
        />
    );
}

export default PaypalCheckoutButton;