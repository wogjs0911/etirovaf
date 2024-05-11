import style from "./styled.module.css";
import {useEffect, useState} from "react";
import globalStyle from "@styles/style.module.css";
import utilStyle from "@styles/utils.module.css";
import { Link } from "react-router-dom";
import NoticeList from "@components/NoticeList";
// import dream from "../Dream/index.tsx";
import NoticeSettingModal from "@components/NoticeSettingModal";

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

const DreamNotice = () => {
    const [dreams, setDreams] = useState(mockData);
    const [modalOpen, setModalOpen] = useState(false);

    const setInitData = async () => {
        // const data = await fetchDream(params.q);
        setDreams(mockData);
    }

    useEffect (() => {
        setInitData();
    }, []);

    return (
        <div className={style.wrap}>
            <header className={`${utilStyle.d_fl_ac} ${style.header}`}>
                <Link to={"/home"} className={`${globalStyle.icon} ${globalStyle.icon_back}`}>Back</Link>
                <div className={style.notice_title}>
                    키워드 알림
                </div>
            </header>
            {/*<!-- ----------------------------------------------------------- -->*/}
            <main className={style.main}>
                <div className= { style.category_form }>
                    <div className= { style.category_list }>
                        <div>
                            <button className={ style.all_category }>디자이너</button>
                        </div>
                        <div>
                            <button className={ style.all_category }>개발자</button>
                        </div>
                        <div>
                            <button className={ style.all_category }>기획자</button>
                        </div>
                    </div>
                    <div className={style.notice_setting_form}>
                        <button className={style.notice_setting} onClick={() => {
                            setModalOpen(
                                modalOpen === false ? true : false
                            )
                        }}>
                            설정
                        </button>
                    </div>
                </div>
                <div>{ modalOpen === true ? <NoticeSettingModal setModalOpen={ setModalOpen } /> : null }</div>
                <NoticeList dreams={ dreams } />
            </main>
        </div>
    );
}

export default DreamNotice;