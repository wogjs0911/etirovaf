// import {useState} from "react";
import style from "./styled.module.css";
import globalStyle from "@styles/style.module.css";
import utilStyle from "@styles/utils.module.css";
import {Link} from "react-router-dom";
// import Navigation from "@components/Navigation/index";

interface Dream {
    id: number;
    title: string;
    organizer: string;
    place: string;
    content: string;
    hashTag: string;
    deadline: string;
    createDate: number;
}


// const mockData : Dream[] = [
//     {
//         id: 0,
//         title: "백엔드 개발자 직업 체험 모집",
//         organizer: "고려대학교",
//         place: "안암역 2번 출구",
//         content: "고려대학교 컴퓨터공학과에서 백엔드 개발자 체험에 참여하실 분들 모집합니다.",
//         hashTag: "개발자",
//         deadline: "5일전",
//         createDate: new Date().getTime(),
//     },
//     {
//         id: 1,
//         title: "웹 디자이너 직업 체험 모집",
//         organizer: "연세대학교",
//         place: "강남역 2번 출구",
//         content: "연세대학교에서 웹 디자인에 참여하실 분들 모집합니다.",
//         hashTag: "디자이너",
//         deadline: "3일전",
//         createDate: new Date().getTime(),
//     },
//     {
//         id: 2,
//         title: "웹 기획자 직업 체험 모집",
//         organizer: "KAIST",
//         place: "논현역 2번 출구",
//         content: "카이스트에서 웹 개발에 기획 체험에 참여하실 분들 모집합니다.",
//         hashTag: "기획자",
//         deadline: "1일전",
//         createDate: new Date().getTime(),
//     }
// ]


const Dream = () => {
    // const params = useParams();
    // const { state } = useLocation<{ id: number }>(); // Ensure the state has the expected structure
    // const id = state?.id;
    // const [dream, setDream] = useState<Dream | null>(null); // State can be null if not found

    // const setInitData = async () => {
    //     // const data = fetchDream(params.id);
    //     setDream(mockData);
    //     console.log(dream);
    // }

    // useEffect(() => {
    //     setInitData();
    // }, [id]);

    // if(!id){
    //     return <div>Loading ....</div>;
    // }

    return(
            <div className={style.detail}>
                 {/* detail _ item1  */}
                <main>
                     {/* detail_main : flex_container */}
                    <header className={style.detail_header}>
                        <Link to={"/home"} className={`${globalStyle.icon} ${globalStyle.icon_back}`}>뒤로가기</Link>

                         {/* 수정/삭제 모달 버튼 */}
                        <i className={style.icon_edit}></i>

                         {/* 모달 배경 : 컴포너트로 따로 빼기 */}
                        {/*<div>*/}
                        {/*    <div className={style.icon_edit2}>*/}
                        {/*        <div className={style.box}>*/}
                        {/*            <div className={style.icon_edit3}>*/}
                        {/*                <div className={globalStyle.icon}></div>수정 하기*/}
                        {/*            </div>*/}
                        {/*            <div className={style.icon_edit4}>*/}
                        {/*                <div className={globalStyle.icon}></div>삭제 하기*/}
                        {/*            </div>*/}
                        {/*        </div>*/}
                        {/*    </div>*/}
                        {/*    <div className={style.icon_report}>*/}
                        {/*        <div className={globalStyle.icon}></div>신고 하기*/}
                        {/*    </div>*/}
                        {/*    /!* 취소 확인 모달 *!/*/}
                        {/*    <div className={style.black_bg}>*/}
                        {/*        <div className={style.delete_box}>*/}
                        {/*            <div className={style.delete_box_1}>정말로 삭제하시겠습니까?</div>*/}
                        {/*            <div className={style.delete_box_2}>*/}
                        {/*                <div className={style.delete_box_3}>삭제</div>*/}
                        {/*                <div className={style.delete_box_4}>취소</div>*/}
                        {/*            </div>*/}
                        {/*        </div>*/}
                        {/*    </div>*/}
                        {/*</div>*/}

                        {/*<div className={style.black_bg}>*/}
                        {/*    <div className={style.report_box}>*/}
                        {/*        <div className={style.delete_box_1}>신고 하시겠습니까?</div>*/}
                        {/*        <div>사유</div>*/}
                        {/*        <textarea maxlength="100" placeholder="100자 이하"></textarea>*/}
                        {/*        <div className={style.delete_box_2}>*/}
                        {/*        <div className={style.delete_box_3}>신고</div>*/}
                        {/*        <div className={style.delete_box_4}>취소</div>*/}
                        {/*        </div>*/}
                        {/*    </div>*/}
                        {/*</div>*/}

                        {/*<div className={style.black_bg}>*/}
                        {/*    <div className={style.delete_box}>*/}
                        {/*        <div className={style.delete_box_1}>신고 완료</div>*/}
                        {/*        <div className={style.delete_box_2}>*/}
                        {/*            <div className={style.delete_box_3}>닫기</div>*/}
                        {/*        </div>*/}
                        {/*    </div>*/}
                        {/*</div>*/}
                    </header>

                    <div className={style.detail_main}>
                     {/* detail-img : detail-main - item1 */}
                        <div className={style.detail_img}>
                            <div className={style.noImg}></div>
                        </div>
                            <div className={style.detail_content_wrap}>
                             {/* detail-heading : detail-main - item2 */}
                            <section className={style.canvas}>
                                <h1 className={utilStyle.d_none}>heading</h1>
                                <div className={style.detail_edit}>
                                    <div className={style.detail_top}>
                                        <div className={style.detail_category} defaultValue={1}>기획자</div>
                                        <div className={`${style.detail_status} ${style.day_left}`}>3일전</div>
                                    </div>
                                    {/* 조회수, 북마크 : 컴포너트로 따로 빼기 */}
                                    <div className={style.detail_top_icons}>
                                        <div className={style.detail_views}>
                                            <div className={style.views}>조회수</div>
                                        </div>
                                        <div className={style.detail_heart}>
                                            <div className={style.filled_heart}>북마크</div>
                                        </div>
                                    </div>
                                </div>
                                <div className={style.detail_heading_title}>웹 기획자 직업 체험 모집</div>
                                <div className={style.detail_heading_organ}>연세대학교</div>
                            </section>
                             {/* detail_info : detail_main _ item3 */}
                            <section className={`${style.canvas} ${style.detail_info}`}>
                                    <h1 className={utilStyle.d_none}>info</h1>
                                    <div className={style.detail_in}>
                                        <div className={style.detail_info_title}>모집인원</div>
                                        <div className={style.detail_info_txt}>30명</div>
                                    </div>
                                    <div className={style.detail_in}>
                                        <div className={style.detail_info_title}>마감일자</div>
                                        <div className={style.detail_info_txt}>2023.12.31</div>
                                    </div>
                                    <div className={style.detail_in}>
                                        <div className={style.detail_info_title}>모임장소</div>
                                        <div className={style.detail_info_txt}>신촌역 3번 출구</div>
                                    </div>
                            </section>
                            {/*detail_writing : detail_main _ item4*/}
                            <section className={`${style.canvas} ${style.detail_writing} ${style.detail_info}`}>
                                <h1 className={utilStyle.d_none}>writing</h1>
                                <div className={style.detail_paragraph}>연세대학교에서 웹 개발에 기획 체험에 참여하실 분들 모집합니다..</div>
                                <div className={style.list_hashtag_testwrap}>
                                    <div className={style.list_hashtag_form}>
                                        <span className={style.list_hashtag}>
                                            개발자
                                        </span>
                                    </div>
                                    <div className={style.list_hashtag_form}>
                                        <span className={style.list_hashtag}>
                                            기확자
                                        </span>
                                    </div>
                                    <div className={style.list_hashtag_form}>
                                        <span className={style.list_hashtag}>
                                            디자이너
                                        </span>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </main>
            </div>

    )
}

export default Dream;