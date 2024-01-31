import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './assets/css/index.css'
import './assets/css/home.css'
import './assets/css/Aboutus.css'
import './assets/css/Navbar.css'
import './assets/css/Inquiry.css'
import './assets/css/type.css'
import './assets/css/Sidenav.css'
import 'rsuite/dist/rsuite.min.css';


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    {/* <BrowserRouter> */}
    
    <App />
    {/* <Login/>
    <Register/> */}
    {/* </BrowserRouter> */}
    
  </React.StrictMode>,
)
