import style from "./styled.module.css";
import globalStyle from "../../styles/style.module.css";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

const Notification = () => {
    const nav = useNavigate();

    const onClickNotification = () =>{
        nav(`/dreams/notice`);
    }

    return (
        <div className={style.container}>
            <h1 className={`${globalStyle.icon} ${style.icon_alarm}`} onClick={onClickNotification}>알림</h1>
        </div>
    );
}

export default Notification;