import { useState } from "react";
import { PayPalButtons } from "@paypal/react-paypal-js";

const PaypalCheckoutButton = (loggedInUser, recipe) => {

    const [error, setError] = useState(null);
    const api = axios.create({
        baseURL: "http://localhost:8080/friends"
    })

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
                            description: recipeID,
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

                /*Checks if recipe is saved.
                If recipe is not saved, creates a new saved_recipe object with paid value set to true.
                Else update saved_recipe's paid value to true. */
                ((() => {
                    api.get(`/check/${loggedInUser.id}/${recipe.id}`)
                        .then(function (response) {
                            console.log(response);
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                }) ? (() => {
                    api.post(`/update/${loggedInUser.id}/${recipe.id}`)
                        .then(function (response) {
                            console.log(response);
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                }) : (() => {
                    api.post(`/buy/${loggedInUser.id}/${recipe.id}`)
                        .then(function (response) {
                            console.log(response);
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                }))



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