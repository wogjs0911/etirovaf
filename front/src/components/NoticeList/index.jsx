/* eslint-disable */

import React from "react";
import style from "./styled.module.css";
import NoticeItem from "../NoticeItem/index.jsx";

const NoticeList = ({ dreams }) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.map((dream) => (
                <NoticeItem
                    dream={dream}
                    key={dream.id}
                    {...dream} />
            )) }
        </div>
    );
};

export default NoticeList;