import './App.css'
import { Routes, Route, Link, useNavigate } from "react-router-dom";
import Home from "./pages/Home/index.jsx";
import Layout from "./components/Layout/index.jsx";
import Dream from "./pages/Dream/index.jsx";
import DreamSearch from "./pages/DreamSearch/index.jsx";
import DreamCreate from "./pages/DreamCreate/index.jsx";
import Index from "./pages/Index/index.jsx";
import Signup from "./pages/Signup/index.jsx";
import Login from "./pages/Login/index.jsx";
import DreamFilter from "./pages/DreamFilter/index.jsx";

function App() {

    return (
        <Layout>
         <Routes>
             <Route path='/' element={<Index />}/>
             <Route path='/home' element={<Home />}/>
             <Route path='/login' element={<Login />}/>
             <Route path='/signup' element={<Signup />}/>
             <Route path='/search' element={<DreamSearch />}/>
             <Route path='/dream/:id' element={<Dream />}/>
             <Route path='/dream/create' element={<DreamCreate />}/>
             <Route path='/dream/filter' element={<DreamFilter />}/>
         </Routes>
        </Layout>
    )
}

export default App
