import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom"
import Searchbar from "../../components/Searchbar/index.jsx";
import style from "./styled.module.css";
import {fetchDream} from "../pagesApi.js";

const Search = () => {
    const params = useParams();
    const [ dream, setDream ] = useState();

    const setInitData = async () => {
        const data = await fetchDream(params.q);
        setDream(data);
    }

    useEffect (() => {
        setInitData();
    }, [params.q]);

    // const onClickItem = () => {
    //     nav(`/search/${params.q}`);
    // };

    return (
        <div className={style.container}>
            <Searchbar q={params.q}/>
            <div>
                <b>{params.q}</b> 검색 결과
            </div>
        </div>
    );
}

export default Search;