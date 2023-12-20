import React, { useEffect, useState } from "react";
import {useNavigate, useSearchParams} from "react-router-dom"
import Searchbar from "../../components/Searchbar/index.jsx";
import style from "./styled.module.css";
import {fetchDream} from "../pagesApi.js";
import Notification from "../../components/Notification/index.jsx";
import Category from "../../components/Category/index.jsx";
import MostTopDreamList from "../../components/MostTopDreamList/index.jsx";

const mockData = [
    {
        id: 0,
        title: "백엔드 개발자 직업 체험 모집",
        organizer: "고려대학교",
        place: "안암역 2번 출구",
        content: "고려대학교 컴퓨터공학과에서 백엔드 개발자 체험에 참여하실 분들 모집합니다.",
        hashTag: "개발자",
        deadline: "5일전",
        createDate: new Date().getTime(),
    },
    {
        id: 1,
        title: "웹 디자이너 직업 체험 모집",
        organizer: "연세대학교",
        place: "강남역 2번 출구",
        content: "연세대학교에서 웹 디자인에 참여하실 분들 모집합니다.",
        hashTag: "디자이너",
        deadline: "3일전",
        createDate: new Date().getTime(),
    },
    {
        id: 2,
        title: "웹 기획자 직업 체험 모집",
        organizer: "KAIST",
        place: "논현역 2번 출구",
        content: "카이스트에서 웹 개발에 기획 체험에 참여하실 분들 모집합니다.",
        hashTag: "기획자",
        deadline: "1일전",
        createDate: new Date().getTime(),
    }
]

const Search = () => {
    // const params = useParams();
    const [ searchParams, setSearchParams ] = useSearchParams();
    const q = searchParams.get("q");

    const [dreams, setDreams] = useState(mockData);

    const setInitData = async () => {
        // const data = await fetchDream(params.q);
        setDreams(mockData);
    }

    useEffect (() => {
        setInitData();
    }, [q]);

    // const onClickItem = () => {
    //     nav(`/search/${params.q}`);
    // };

    return (
        <div className={style.container}>
            <div className={style.header}>
                <div className={style.searchBox}>
                    <Searchbar q={q}/>
                </div>
                <Notification />
            </div>
            <div className={style.category}>
                <Category />
            </div>
            <div>
                <b>{q}</b> 검색 결과
            </div>
            <div className={style.top_list_form}>
                <div className={style.top_list_explain}>
                    <div>
                        가장 인기있는 목록
                    </div>
                </div>
                <div className={style.top_list}>
                    <MostTopDreamList dreams={dreams}/>
                </div>
            </div>
        </div>

    );
}

export default Search;