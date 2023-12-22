import './App.css'
import { Routes, Route, Link, useNavigate } from "react-router-dom";
import Home from "./pages/Home/index.jsx";
import Search from "./pages/Search/index.jsx";
import Layout from "./components/Layout/index.jsx";
import Dream from "./pages/Dream/index.jsx";

function App() {

    return (
        <Layout>
         <Routes>
             <Route path='/' element={<Home />}/>
             <Route path='/search' element={<Search />}/>
             <Route path='/dream/:id' element={<Dream />}/>
         </Routes>
        </Layout>
    )
}

export default App
