import React from "react";
import style from "./styled.module.css";
import globalStyle from "../../styles/style.module.css";
import utilStyle from "../../styles/utils.module.css";
import {Link} from "react-router-dom";

const Navigation = () => {
    return (
        <nav className={style.navi_bar}>
            <div className={style.navi_icon}>
                <Link to={"/home"} className={`${globalStyle.icon} ${style.icon_home}`}>home</Link>
            </div>
            <div className={style.navi_icon}>
                <Link to={"/search"} className={`${globalStyle.icon} ${style.icon_dodbogi}`}>search</Link>
            </div>
            <div className={style.navi_icon}>
                <Link to={"/dream/create"} className={style.create_dream}></Link>
            </div>
            <div className={style.navi_icon}>
                <Link to={"/community"} className={`${globalStyle.icon} ${style.icon_community}`}>community</Link>
            </div>
            <div className={style.navi_icon}>
                <Link to={"/member/mypage"} className={`${globalStyle.icon} ${style.icon_myinfo}`}>mypage</Link>
            </div>
        </nav>

    );
};

export default Navigation;