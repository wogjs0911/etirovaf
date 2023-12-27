import React from "react";
import style from "./styled.module.css";
import MostTopDreamItem from "../MostTopDreamItem/index.jsx";

const MostTopDreamList = ({ dreams }) => {
    return (
        <div className={style.dream_list_form}>
            {dreams.map((dream) => (
                <MostTopDreamItem
                    dream={dream}
                    key={dream.id}
                    {...dream} />
            )) }
        </div>
    );
};

export default MostTopDreamList;