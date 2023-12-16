import style from "./styled.module.css";
import { useState, useEffect } from "react";
import { fetchDreams } from "../pagesApi.js";
import Searchbar from "../../components/Searchbar/index.jsx";

const Home = () => {
    const [dreams, setDreams] = useState([]);
    const setInitData = async () => {
        const data = await fetchDreams();
        setDreams(data);
    }

    useEffect(() => {
        setInitData();
    }, []);


    return (
        <div>
            <Searchbar />
        </div>
    );
}

export default Home;