import style from "./styled.module.css";
import { useState, useEffect } from "react";
import { fetchDreams } from "../pagesApi.js";
import Searchbar from "../../components/Searchbar/index.jsx";
import Notification from "../../components/Notification/index.jsx";
import Category from "../../components/Category/index.jsx";
import TopDreamList from "../../components/TopDreamList/index.jsx";


const Home = () => {
    const mockData = [
        {
            id: 0,
            organiser: "고려대학교",
            title: "백엔드 개발자 직업 체험 모집",
            place: "안암역 2번 출구",
            hashTag: "개발자",
            deadline: "5일전",
            createDate: new Date().getTime(),
        },
        {
            id: 1,
            organiser: "연세대학교",
            title: "웹 디자이너 직업 체험 모집",
            place: "강남역 2번 출구",
            hashTag: "디자이너",
            deadline: "3일전",
            createDate: new Date().getTime(),
        },
        {
            id: 2,
            organiser: "KAIST",
            title: "웹 기획자 직업 체험 모집",
            place: "논현역 2번 출구",
            hashTag: "기획자",
            deadline: "1일전",
            createDate: new Date().getTime(),
        }
    ]

    const [dreams, setDreams] = useState(mockData);


    // 추후 api 있으면 이곳 변경하기 : 이것땜에 props 데이터를 유지 못하는 에러 발생!(라이프 사이클 주의*)
    const setInitData = async () => {
        // const data = await fetchDreams();
        setDreams(mockData);
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
                <Category />
            </div>
            <div className={style.category}>
                <TopDreamList dreams={dreams}/>
            </div>
        </div>
    );
}

export default Home;