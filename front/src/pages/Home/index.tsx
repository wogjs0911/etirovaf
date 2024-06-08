/* eslint-disable */

import style from "./styled.module.css";
import utilStyle from "@styles/utils.module.css";
import { useState, useEffect } from "react";
import Searchbar from "@components/Searchbar";
import Notification from "@components/Notification";
import Category from "@components/Category";
import TopDreamList from "@components/TopDreamList";
import RecentDreamList from "@components/RecentDreamList";
import { Link } from "react-router-dom";

interface Dream {
    id: number;
    title: string;
    organizer: string;
    place: string;
    content: string;
    hashTag: string;
    deadline: string;
    createDate: number; // Time in milliseconds since epoch
}

const mockData: Dream[] = [
    {
        id: 0,
        title: "백엔드 개발자 직업 체험 모집",
        organizer: "고려대학교",
        place: "안암역 2번 출구",
        content: "고려대학교 컴퓨터공학과에서 백엔드 개발자 체험에 참여하실 분들 모집합니다.",
        hashTag: "개발자",
        deadline: "5일 전",
        createDate: new Date().getTime(),
    },
    {
        id: 1,
        title: "웹 디자이너 직업 체험 모집",
        organizer: "연세대학교",
        place: "강남역 2번 출구",
        content: "연세대학교에서 웹 디자인에 참여하실 분들 모집합니다.",
        hashTag: "디자이너",
        deadline: "3일 전",
        createDate: new Date().getTime(),
    },
    {
        id: 2,
        title: "웹 기획자 직업 체험 모집",
        organizer: "KAIST",
        place: "논현역 2번 출구",
        content: "카이스트에서 웹 개발에 기획 체험에 참여하실 분들 모집합니다.",
        hashTag: "기획자",
        deadline: "1일 전",
        createDate: new Date().getTime(),
    },
];

const Home = () => {
    const [dreams, setDreams] = useState<Dream[]>(mockData);

    const setInitData = async () => {
        // Here, you could fetch data from an API if needed
        setDreams(mockData); // For now, using mock data
    };

    useEffect(() => {
        setInitData();
    }, []);

    return (
        <div className={style.container}>
            <div className={style.header}>
                <Link to="/login" className={style.login_btn_form}>
                    <input className={style.btn_login} type="submit" value="로그인" />
                </Link>
                <div className={utilStyle.d_fl_jf}>
                    <div className={style.searchBox}>
                        <Searchbar q={''}/>
                    </div>
                    <Notification />
                </div>
            </div>
            <div className={style.category}>
                <Category />
            </div>
            <div className={style.top_list_form}>
                <div className={style.top_list_explain}>
                    <div>가장 인기있는 목록</div>
                    <div className={style.f_blue}>자세히 보기</div>
                </div>
                <div className={style.top_list}>
                    <TopDreamList dreams={dreams} />
                </div>
            </div>
            <div className={style.top_list_form}>
                <div className={style.top_list_explain}>
                    <div>최근 업로드된 목록</div>
                    <div className={style.f_blue}>자세히 보기</div>
                </div>
                <div className={style.recent_list}>
                    <RecentDreamList dreams={dreams} />
                </div>
            </div>
        </div>
    );
};

export default Home;