import { React } from 'react';

// Routing
import { BrowserRouter, Routes, Route } from 'react-router-dom';

// CSS
import './App.css';

// Components
import Chat from './components/chat/Chat';
import Home from './components/views/Home';
import Login from './components/views/Login';
import Register from './components/views/Register';
import Profile from './components/views/Profile';
import Recipe from './components/views/Recipe';
import CreateRecipe from './components/views/CreateRecipe';
import NoPage from './components/views/NoPage';
import OurNavBar from './components/OurNavBar'
import UserList from './components/UserList';

//Paypal
import { PayPalScriptProvider } from "@paypal/react-paypal-js";

function App() {

    //paypal client
    //www.sandbox.paypal.com
    //sb-y9ckh20901693@personal.example.com
    //Ce^krX6p

    const paypalOptions = {
        'client-id': 'ASzbo8xOlp4v1FoFsj-X8DsFGejkp9B48-UI1QbDdmGrJTjo8bGJgaoWA1bew1OmH9zejLscJAdI4np2'
    };

    const changeDocTitle = (doctitle) => {
        document.title = doctitle;
    }

    return (
        <PayPalScriptProvider options={paypalOptions}>
            <BrowserRouter>
                <div className='container'>
                    {/* ΜΕΡΟΣ ΣΕΛΙΔΑΣ ΠΟΥ ΔΕΝ ΑΛΛΑΖΕΙ */}
                    {/* ΚΑΠΟΙΟΥ ΕΙΔΟΥΣ NAVBAR ΜΠΟΡΕΙ ΝΑ ΜΠΕΙ ΕΔΩ ΑΝ ΕΙΝΑΙ ΙΔΙΟ ΣΕ ΟΛΕΣ ΤΙΣ ΣΕΛΙΔΕΣ */}
                    <OurNavBar />
                    <Chat />
                    {/* ΜΕΡΗ ΣΕΛΙΔΑΣ ΠΟΥ ΑΛΛΑΖΟΥΝ */}
                    <Routes>
                        <Route path='/' element={<Home changeDocTitle={changeDocTitle} />} />
                        <Route path='login' element={<Login changeDocTitle={changeDocTitle} />} />
                        <Route path='register' element={<Register changeDocTitle={changeDocTitle} />} />
                        <Route path='profile/:profileid' element={<Profile changeDocTitle={changeDocTitle} />} />
                        <Route path='recipe/:recipeid' element={<Recipe changeDocTitle={changeDocTitle} />} />
                        <Route path='createrecipe' element={<CreateRecipe changeDocTitle={changeDocTitle} />} />
                        <Route path='userlist' element={<UserList changeDocTitle={changeDocTitle} />} />
                        <Route path='*' element={<NoPage changeDocTitle={changeDocTitle} />} />
                    </Routes>
                </div>
            </BrowserRouter>
        </PayPalScriptProvider>
    );
}

export default App;