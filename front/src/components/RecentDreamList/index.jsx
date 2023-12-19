import React from "react";
import style from "./styled.module.css";
import RecentDreamItem from "../RecentDreamItem/index.jsx";

const RecentDreamList = ({ dreams }) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.map((dream) => (
                <RecentDreamItem
                    dream={dream}
                    key={dream.id}
                    {...dream} />
            )) }
        </div>
    );
};

export default RecentDreamList;