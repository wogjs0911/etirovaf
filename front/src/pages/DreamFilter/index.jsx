import style from "./styled.module.css";
import React, { useState, useEffect } from "react";
import globalStyle from "../../styles/style.module.css";
import utilStyle from "../../styles/utils.module.css";
import { Link } from "react-router-dom";


const DreamFilter = () => {

    return (
        <div className={style.wrap}>
            <header className={`${utilStyle.d_fl_ac} ${style.header}`}>
                <Link to={"/home"} className={`${globalStyle.icon} ${globalStyle.icon_back}`}>Back</Link>
                <div className={style.filter_title}>
                    필터 설정하기
                </div>
                <div className={style.filter_reset}>
                    초기화
                </div>
            </header>
            {/*<!-- ----------------------------------------------------------- -->*/}
            <main className={style.main}>
                <div className={`${style.filter_info_form}`}>
                    <label className={style.filter_info_title}>대분류</label>
                    <div className={style.filter_info_wrap}>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>산업디자인</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>컴퓨터공학</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>전기공학</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>생명공학</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>경영학</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>행정학</button>
                        </div>
                    </div>
                </div>

                <div className={`${style.filter_info_form} ${style.m_t_69}`}>
                    <label className={style.filter_info_title}>중분류</label>
                    <div className={style.filter_info_wrap}>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>디자이너</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>개발자</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>기획자</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>퍼블리셔</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>연구원</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>컨설턴트</button>
                        </div>
                    </div>
                </div>

                <div className={`${style.filter_info_form} ${style.m_t_69}`}>
                    <label className={style.filter_info_title}>소분류</label>
                    <div className={style.filter_info_wrap}>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>웹 디자이너</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>백엔드 개발자</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>프론트엔드 개발자</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>웹 개발 기획자</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>퍼블리셔</button>
                        </div>
                        <div className={style.filter_form}>
                            <button className={style.division_class}>컨설턴트</button>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    );
}

export default DreamFilter;