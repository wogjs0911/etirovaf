import style from "./styled.module.css";
import globalStyle from "../../styles/style.module.css";
import { useState, useEffect } from "react";
import {Link, useNavigate} from "react-router-dom";

const Notification = () => {
    const nav = useNavigate();

    // const onClickHeader = () =>{
    //     nav(`/`);
    // }

    return (
        <div className={style.container}>
            <Link to={"/dream/create"}>
                <h1 className={`${globalStyle.icon} ${style.icon_alarm}`}>알림</h1>
            </Link>
        </div>
    );
}

export default Notification;