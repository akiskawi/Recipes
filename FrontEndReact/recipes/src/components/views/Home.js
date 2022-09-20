import { React } from 'react'
import Checkout from '../Checkout'

function Home(props) {

    return (
        <div>
            {props.changeDocTitle("Home")}
            <h1>Home</h1>
            <Checkout />
        </div>
    )
}

export default Home