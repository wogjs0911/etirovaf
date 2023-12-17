import style from "./styled.module.css";
import { useState, useEffect } from "react";
import { fetchDreams } from "../pagesApi.js";
import Searchbar from "../../components/Searchbar/index.jsx";
import Notification from "../../components/Notification/index.jsx";
import Category from "../../components/Category/index.jsx";


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
        <div className={style.container}>
            <div className={style.header}>
                <div className={style.searchBox}>
                    <Searchbar />
                </div>
                <Notification />
            </div>
            <div className={style.category}>
                <Category/>
            </div>
        </div>
    );
}

export default Home;