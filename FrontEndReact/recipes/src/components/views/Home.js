import { React } from 'react'
import CheckoutTest from '../CheckoutTest'

function Home(props) {

    return (
        <div>
            {props.changeDocTitle("Home")}
            <h1>Home</h1>
            <CheckoutTest />
        </div>
    )
}

export default Home