import React from "react";
import style from "./styled.module.css";
import TopDreamItem from "../TopDreamItem/index.jsx";

const TopDreamList = ({ dreams }) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.map((dream) => (
                <TopDreamItem
                    className={style.dream_list}
                    dream={dream}
                    key={dream.id}
                    {...dream} />
            )) }
        </div>
    );
};

export default TopDreamList;