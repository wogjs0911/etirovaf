// import React, { useEffect, useState } from "react";
import globalStyle from "@styles/style.module.css";
import utilStyle from "@styles/utils.module.css";
import btnStyle from "@styles/button.module.css";
import {Link} from "react-router-dom"
import style from "./styled.module.css";
import useFormInput from "@hooks/_common/useFormInput.ts";
import {DreamValueType} from "@myTypes/dream/internal.ts";
import {useCreateDream} from "@hooks/queries/dream.ts";
import {FormEvent} from "react";
// import ErrorModal from "@components/ErrorModal/index";

// const mockData = [
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

const DreamCreate = () => {

    // const nav = useNavigate();

    // const onClickItem = () => {
    //     nav(`/search/${params.q}`);
    // };

    const { formState: dreamFormData, handleInputChange } =
        useFormInput<DreamValueType>({
            organizer: '',
            title: '',
            place: '',
            hashTag: [],
            deadline: '',
            content: ''
        });

    const { createDream } = useCreateDream();

    const handleSubmit = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        createDream({
            ...dreamFormData
        });
    };

    return (
        /*<!-- =================== create2 ======================= -->*/
        <section className={style.create2_form}>
            <h1 className={utilStyle.d_none}>create2</h1>

            <section className={`${globalStyle.canvas_1} ${utilStyle.d_fl_ac} ${utilStyle.fl_dir_col}`}>

                <h1 className={utilStyle.d_none}>create2</h1>

                {/* =================== create2 : header ===================== */}
                <header>
                    <Link to={"/home"} className={`${globalStyle.icon} ${globalStyle.icon_back}`}>뒤로가기</Link>

                    <div className={globalStyle.hd_title_box}>
                        <h1 className={globalStyle.hd_title}>글 등록하기</h1>
                    </div>
                </header>

                {/* =================== create2 : main ===================== */}
                <main className={`${utilStyle.d_fl_jf}`}>

                    <form onSubmit={handleSubmit}>
                        <div>
                            <input type="submit" className={style.create2_post} value="올리기"/>
                        </div>

                        {/* 파일 업로드  */}
                        <div className={style.file_box}>
                            <label htmlFor="file">
                                <div className={btnStyle.btn_file}>2/3</div>
                                {/*<div className={btnStyle.btn_uploaded_files}>*/}
                                {/*    <img className={style.uploaded_files}/>*/}
                                {/*</div>*/}
                            </label>

                            <input type="file" className={utilStyle.d_none} id="file" name="imgs" multiple accept="image/*"/>
                        </div>

                        {/*<ErrorModal />*/}
                        {/* 에러메시지 모달창 */}
                        {/*<div className={globalStyle.black_bg}>*/}
                        {/*    <div className={globalStyle.error_box}>{ valiError }*/}
                        {/*        <div className={globalStyle.error_close}></div>*/}
                        {/*    </div>*/}
                        {/*</div>*/}

                        {/* 카테고리 목록 선택 */}
                        <div className={style.category_form}>
                            <label className={style.input_info_title}>카테고리</label>
                            <div className={style.category_info_form}>
                                <select className={style.category_box} name="categoryId">
                                    <option>
                                        대분류
                                    </option>
                                </select>
                                <select className={style.category_box} name="categoryId">
                                    <option>
                                        중분류
                                    </option>
                                </select>
                                <select className={style.category_box} name="categoryId">
                                    <option>
                                        소분류
                                    </option>
                                </select>
                            </div>
                        </div>

                        <div className={style.input_info_form}>
                            <label className={style.input_info_title}>제목</label>
                            <div className={style.select_box}>
                                {/*<label htmlFor="title" className={globalStyle.input_field_txt}>제목</label>*/}
                                <input type="text" className={style.input_field} id="title" name="title"
                                       onChange={handleInputChange}
                                       placeholder="제목을 입력해주세요..."/>
                            </div>
                        </div>

                        {/* 마감일자, 모집인원 설정 */}
                        <div className={style.input_date_member}>
                            <div className={style.input_info_form2}>
                                <label className={style.input_info_title}>마감일자</label>
                                <div id="btn_date" className={`${style.select_box_date} ${utilStyle.d_fl_ac} ${utilStyle.jf_sb}`}>
                                    <input className={style.date_pic} type="datetime-local" data-placeholder="날짜를 선택해주세요." required
                                           onChange={handleInputChange}
                                           aria-required="true" name="deadline"/>
                                </div>
                            </div>

                            <div className={`${style.input_info_form2} ${utilStyle.m_l_40}`}>
                                <label className={style.input_info_title}>모집인원</label>
                                <div className={`${style.select_box_member} ${utilStyle.d_fl_ac}`}>
                                    <div className={style.people_count_box}>
                                        {/*<input className={style.btn_minus} id="people-count" type="button" value=""*/}
                                        {/*/>*/}
                                        <input type="text" className={style.people_count_num} name="numPeople" id="result"
                                               onChange={handleInputChange}/>
                                        {/*<input className={style.btn_plus} id="people-count" type="button" value=""*/}
                                        {/*/>*/}
                                    </div>
                                </div>
                            </div>
                        </div>

                        {/* 모임장소 설정 */}
                        <div className={`${style.input_info_form}`}>
                            <label className={style.input_info_title}>모임장소</label>
                            <div className={style.select_box}>
                                <input type="text" className={style.input_field} name="place" id="place"
                                       onChange={handleInputChange}
                                       placeholder="모임장소를 입력해주세요..." hidden/>
                                {/*<div className={`${globalStyle.input_field} ${style.input_address}`}>신촌역 3번 출구</div>*/}
                            </div>
                        </div>
                        {/* 내용 설정 */}
                        <div className={style.input_info_form}>
                            <label className={style.input_info_title}>내용</label>
                            <div className={`${style.select_box} ${style.select_content}`}>
                                <textarea className={`${style.input_field_textarea} ${style.input_content}`}
                                          onChange={handleInputChange}
                                          placeholder="내용을 입력해주세요..."
                                          name="content" id="content" cols={30} rows={10}/>
                            </div>
                        </div>
                    </form>
                </main>
            </section>
        </section>
    );
}

export default DreamCreate;